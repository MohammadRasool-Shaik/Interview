/**
 * 
 */
package org.rash.threads.ef;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author Rasool.Shaik
 *
 */
public class ExecutorRunnable {
	public static void main(String[] args) {
		// returns ThreadPoolExecutor instance with an initialized and unbounded queue with 2 threads
		Executor service = Executors.newFixedThreadPool(2);
		service.execute(new WorkerRunnable()); // Only method there in Executor interface

		ExecutorService executorService = (ExecutorService) service;
		// when we submit/execute a task/worker it starts processing that particular task immediately
		executorService.submit(new WorkerRunnable());

		// we can execute/submit multiple tasks/runnables, first Executorservice will put all those tasks inside a queue.
		// Based on thread capacity, those many workers will pic from worker queue as they have submitted sequence
		for (int i = 1; i <= 5; i++)
			executorService.execute(new WorkerRunnable());

		executorService.shutdown();
		System.out.println(executorService.isTerminated());
	}
}

class WorkerRunnable implements Runnable {

	@Override
	public void run() {
		try {
			System.out.println(Thread.currentThread().getName());
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
