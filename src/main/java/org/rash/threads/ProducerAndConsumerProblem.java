/**
 * 
 */
package org.rash.threads;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;


/**
 * @author Ammi 22-Apr-2016
 */
public class ProducerAndConsumerProblem {

	public static void main(String args[]) {
		BlockingQueue<Text> queue = new ArrayBlockingQueue<Text>(100);
		Producer producer = new Producer(queue);
		Consumer consumer = new Consumer(queue);

		Thread t1 = new Thread(producer, "producer");
		Thread t2 = new Thread(consumer, "consumer");

		t1.start();

		t2.start();

	}
}

class Text {
	private String txt;

	public Text(String txt) {
		super();
		this.txt = txt;
	}

	/**
	 * @return the txt
	 */
	public String getTxt() {
		return txt;
	}

	/**
	 * @param txt
	 *            the txt to set
	 */
	public void setTxt(String txt) {
		this.txt = txt;
	}

}

class Producer implements Runnable {

	private BlockingQueue<Text> queue;

	public Producer(BlockingQueue<Text> queue) {
		super();
		this.queue = queue;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		for (int i = 0; i <= 100; i++) {
			Text t = new Text("text " + i);
			try {
				Thread.sleep(100);
				queue.put(t);
				System.out.println("Producer produce" + t.getTxt());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}

		Text t = new Text("exit");
		try {
			queue.put(t);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

class Consumer implements Runnable {

	private BlockingQueue<Text> queue;

	public Consumer(BlockingQueue<Text> queue) {
		super();
		this.queue = queue;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		Text txt;
		try {
			while ((txt = queue.take()).getTxt() != "exit") {
				Thread.sleep(10);
				System.out.println("consuer consumes " + txt.getTxt());
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
