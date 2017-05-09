/**
 * 
 */
package org.rash.threads;

/**
 * @author Rasool.Shaik
 *
 */
public class PrintNumberUsing2Threads {
	public static void main(String[] args) {
		Counter counter = new Counter();
		Thread evenThread = new Thread(new EvenTask(counter), "Even Thread");
		Thread oddThread = new Thread(new OddTask(counter), "Odd Thread");
		evenThread.start();
		oddThread.start();
	}
}

class Counter {
	public int count = 1;
}

class EvenTask implements Runnable {
	private Counter counter;

	/**
	 * @param counter
	 */
	public EvenTask(Counter counter) {
		super();
		this.counter = counter;
	}

	@Override
	public void run() {
		while (true) {
			synchronized (counter) {
				if (counter.count % 2 != 0) {
					try {
						counter.notify();
						counter.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				System.out.println(Thread.currentThread().getName() + " " + counter.count);
				counter.count++;
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
}

class OddTask implements Runnable {
	private Counter counter;

	/**
	 * @param counter
	 */
	public OddTask(Counter counter) {
		super();
		this.counter = counter;
	}

	@Override
	public void run() {
		while (true) {
			synchronized (counter) {
				if (counter.count % 2 == 0) {
					try {
						counter.notify();
						counter.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				System.out.println(Thread.currentThread().getName() + " " + counter.count);
				counter.count++;
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

			}
		}
	}
}
