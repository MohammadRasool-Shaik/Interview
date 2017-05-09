/**
 * 
 */
package org.rash.threads.ef;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.Collectors;

/**
 * @author Rasool.Shaik
 *
 */
public class ExecutorServiceCallable {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ExecutorService executorService = Executors.newFixedThreadPool(2);

		Future<Integer> sumOfNumbers = executorService.submit(new CallableWorker(2, 4));

		try {
			System.out.println(sumOfNumbers.get());
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}

		List<Future<Integer>> futureList = new ArrayList<>();

		for (int start = 1; start <= 4; start++) {
			int end = (int) Math.pow(start, 2);
			Future<Integer> result = executorService.submit(new CallableWorker(start, end));
			futureList.add(result);
		}

		int totalSum = 0;
		for (Future<Integer> result : futureList) {
			try {
				totalSum += result.get();
			} catch (InterruptedException | ExecutionException e) {
				e.printStackTrace();
			}
		}
		System.out.println(totalSum);
		executorService.shutdown();
	}

	void invokeAllExample() {
		ExecutorService executorService = Executors.newFixedThreadPool(2);
		List<Callable<Integer>> tasks = new ArrayList<>();
		for (int start = 1; start <= 4; start++) {
			int end = (int) Math.pow(start, 2);
			tasks.add(new CallableWorker(start, end));
		}
		try {
			int totalSum = 0;
			List<Future<Integer>> futureList = executorService.invokeAll(tasks);
			for (Future<Integer> result : futureList) {
				totalSum += result.get();
			}
			System.out.println(totalSum);
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		} finally {
			executorService.shutdown();
		}
	}

	void invokeAllExampleJava8() {
		ExecutorService executorService = Executors.newFixedThreadPool(2);
		List<Callable<Integer>> tasks = new ArrayList<>();
		for (int start = 1; start <= 4; start++) {
			int end = (int) Math.pow(start, 2);
			tasks.add(new CallableWorker(start, end));
		}
		try {
			List<Future<Integer>> futureList = executorService.invokeAll(tasks);
			// when we get an exception inside lambda, can't we handle in our class instead in lambda itself
			Integer totalSum = futureList.stream().map(e -> {
				try {
					return e.get();
				} catch (InterruptedException | ExecutionException e1) {
					e1.printStackTrace();
				}
				return null;
			}).collect(Collectors.summingInt(Integer::intValue));
			System.out.println(totalSum);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			executorService.shutdown();
		}
	}

}

class CallableWorker implements Callable<Integer> {

	private int start;
	private int end;

	/**
	 * 
	 */
	public CallableWorker() {
		super();
	}

	/**
	 * @param start
	 * @param end
	 */
	public CallableWorker(int start, int end) {
		super();
		this.start = start;
		this.end = end;
	}

	@Override
	public Integer call() throws Exception {
		int sum = 0;
		for (int i = start; i < end; i++) {
			sum += i;
		}
		Thread.sleep(1000);
		return sum;
	}
}
