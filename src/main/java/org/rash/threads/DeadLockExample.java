/**
 * 
 */
package org.rash.threads;

/**
 * @author Ammi 23-Apr-2016
 */
public class DeadLockExample {

	public static void main(String args[]) {
		Object obj1 = new Object();
		Object obj2 = new Object();
		SyncThread s1 = new SyncThread(obj1, obj2);
		SyncThread s2 = new SyncThread(obj2, obj1);
		Thread t1 = new Thread(s1, "t1");
		t1.start();
		Thread t2 = new Thread(s2, "t2");
		t2.start();
	}
}

class SyncThread implements Runnable {
	Object obj1;
	Object obj2;

	SyncThread(Object obj1, Object obj2) {
		this.obj1 = obj1;
		this.obj2 = obj2;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		String name = Thread.currentThread().getName();
		System.out.println(name + " Acquiring lock on "+obj1);
		synchronized (obj1) {
			System.out.println(name + " Acquired lock on "+obj1);
			work();
			System.out.println(name + " Acquiring lock on "+obj2);
			synchronized (obj2) {
				work();
				System.out.println(name + " Acquired lock on  "+obj2);
			}
			System.out.println(name + " Released lock on  "+obj2);
		}
		System.out.println(name + " Released lock on  "+obj1);
	}

	private void work() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
