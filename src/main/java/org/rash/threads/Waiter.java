/**
 * 
 */
package org.rash.threads;

/**
 * @author mshai9
 *
 */
public class Waiter implements Runnable {

	Message message;

	/**
	 * 
	 */
	public Waiter() {
	}

	/**
	 * @param message
	 */
	public Waiter(Message message) {
		super();
		this.message = message;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		synchronized (message) {
			try {
				System.out.println(Thread.currentThread().getName() + " Waiting for order");
				message.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName() + " taken an order" + message.getMsg());
		}
	}

}
