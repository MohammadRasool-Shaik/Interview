/**
 * 
 */
package org.rash.threads;

/**
 * @author mshai9
 *
 */
public class Notifier implements Runnable {

	private Message message;

	/**
	 * 
	 */
	public Notifier() {
	}

	/**
	 * @param message
	 */
	public Notifier(Message message) {
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
				Thread.sleep(5000);
				message.notify();
				
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
