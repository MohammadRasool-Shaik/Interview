/**
 * 
 */
package org.rash.threads.ef;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @author Rasool.Shaik
 *
 */
public class ExecutorUsageTemp {

	/**
	 * @param args
	 * @throws ExecutionException
	 * @throws InterruptedException
	 */
	public static void mains(String[] args) throws InterruptedException, ExecutionException {
		List<Future<Integer>> futureList = new ArrayList<>();
		ExecutorService executorService = Executors.newFixedThreadPool(2);
		Random random = new Random();
		for (int i = 1; i <= 5; i++) {
			int number = random.nextInt(10);
			FactorialCalculator factorialCalculator = new FactorialCalculator(number);
			Future<Integer> future = executorService.submit(factorialCalculator);
			futureList.add(future);
		}

		futureList.stream().forEach(t -> {
			try {
				System.out.println(t.get());
			} catch (InterruptedException | ExecutionException e) {
				e.printStackTrace();
			}
		});
		executorService.shutdown();
	}

	public static void main(String[] args) {
		ExecutorService executorService = Executors.newFixedThreadPool(3);
		List<Future<String>> futures = new ArrayList<>();
		for (int i = 1; i <= 10; i++) {
			Future<String> submit = executorService.submit(new MyCallableTemp());
			futures.add(submit);
		}
		
		futures.stream().forEach(t -> {
			try {
				System.out.println(t.get());
			} catch (InterruptedException | ExecutionException e) {
				e.printStackTrace();
			}
		});
		executorService.shutdown();
		
	}

}

class FactorialCalculator implements Callable<Integer> {
	private Integer number;

	/**
	 * 
	 */
	public FactorialCalculator() {
		super();
	}

	/**
	 * @param number
	 */
	static int t;
	public  FactorialCalculator(Integer number) {
		super();
		this.t=number;
		this.number = number;
	}

	@Override
	public Integer call() {
		String name = Thread.currentThread().getName();
		int result = 1;
		if ((number == 0) || (number == 1)) {
			result = 1;
		} else {
			for (int i = 2; i <= number; i++)
				result *= i;
		}
		System.out.println(name + " thread Result for number - " + number + " -> " + result);
		return result;
	}

}

class MyCallableTemp implements Callable<String> {
	@Override
	public String call() throws Exception {
		Thread.sleep(1000);
		String name = Thread.currentThread().getName();
		return name;
	}
}

class WorkerThreadTwo implements Runnable {

	@Override
	public void run() {
		for (int i = 1; i < 10; i++) {
			try {
				String threadName = Thread.currentThread().getName();
				System.out.println(threadName + " " + i);
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}