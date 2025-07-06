/**
 *
 */
package org.rash.threads;

import java.util.LinkedList;
import java.util.Random;

/**
 * @author Ammi 22-Apr-2016
 */
public class ProducerAndConsumerProblemWithWaitAndNotify {

    public static void main(String args[]) {
        LinkedList<Integer> queue = new LinkedList<>();
        MyProducer producer = new MyProducer(queue, 10);
        MyConsumer consumer = new MyConsumer(queue);
        Thread t1 = new Thread(producer, "producer");
        Thread t2 = new Thread(consumer, "consumer");
        t1.start();
        t2.start();
    }

}

class MyProducer implements Runnable {
    private final int MAX_SIZE;
    private LinkedList<Integer> queue;

    public MyProducer(LinkedList<Integer> queue, int max_size) {
        this.queue = queue;
        this.MAX_SIZE = max_size;
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Runnable#run()
     */
    @Override
    public void run() {

        while (true) {
            synchronized (queue) {

                while (queue.size() == MAX_SIZE) {
                    System.out.println("Queue is full " + Thread.currentThread().getName() + " waiting");
                    try {
                        queue.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                Random r = new Random();
                int nextInt = r.nextInt();
                queue.add(nextInt);
                System.out.println("Producing value " + nextInt);
                queue.notifyAll();
            }
        }
    }

}

class MyConsumer implements Runnable {
    private LinkedList<Integer> queue;

    public MyConsumer(LinkedList<Integer> queue) {
        this.queue = queue;
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Runnable#run()
     */
    @Override
    public void run() {
        while (true) {
            synchronized (queue) {
                while (queue.isEmpty()) {
                    System.out.println("queue is empty " + Thread.currentThread().getName() + " waiting");
                    try {
                        queue.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("Consuming value " + queue.getFirst());
                queue.removeFirst();
                queue.notifyAll();
            }
        }
    }
}
