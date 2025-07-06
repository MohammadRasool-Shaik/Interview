/*package org.rash.threads;

 *//**
 * @author Ammi 23-Apr-2016
 * @return the msg
 * @param msg
 * the msg to set
 *//*
public class WaiterAndNotiferExample {
	public static void main(String args[]) {
		Message msg = new Message();

		Waiter w1 = new Waiter(msg);
		Waiter w2 = new Waiter(msg);

		Thread t1 = new Thread(w1, "waiter1 ");
		Thread t2 = new Thread(w2, "waiter2 ");

		Notifier n1 = new Notifier(msg);
		Thread t3 = new Thread(n1, "Notifer ");
		t1.start();
		t2.start();
		t3.start();

	}

}

class Message {
	private String msg;

	*//**
 * @return the msg
 *//*
	public String getMsg() {
		return msg;
	}

	*//**
 * @param msg
 *            the msg to set
 *//*
	public void setMsg(String msg) {
		this.msg = msg;
	}

}

class Waiter implements Runnable {
	private Message msg;

	public Waiter(Message msg) {
		super();
		this.msg = msg;
	}

	
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Runnable#run()
	 
	@Override
	public void run() {
		String name = Thread.currentThread().getName();
		synchronized (msg) {
			try {
				System.out.println(name + " waiting since " + System.currentTimeMillis());
				msg.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(name + " processed " + msg.getMsg());
		}

	}

}

class Notifier implements Runnable {
	private Message msg;

	public Notifier(Message msg) {
		super();
		this.msg = msg;
	}

	
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Runnable#run()
	 
	@Override
	public void run() {
		String name = Thread.currentThread().getName();
		synchronized (msg) {
			try {
				Thread.sleep(1000);
				System.out.println(name + " order plate samosa at " + System.currentTimeMillis());
				msg.setMsg(name + " order plate samosa");
				msg.notifyAll();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}*/