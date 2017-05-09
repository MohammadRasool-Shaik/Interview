package org.rash.threads.ef;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecutorCompletionServiceCallable {

	private static final List<String> topSites = Arrays.asList("www.google.com", "www.youtube.com", "www.yahoo.com", "www.msn.com", "www.wikipedia.org", "www.baidu.com",
			"www.microsoft.com", "www.qq.com", "www.bing.com", "www.ask.com", "www.adobe.com", "www.taobao.com", "www.youku.com", "www.soso.com", "www.wordpress.com",
			"www.sohu.com", "www.windows.com", "www.tudou.com", "www.amazon.com");

	public static void executorService() {
		ExecutorService executorService = Executors.newFixedThreadPool(5);

		List<Future<String>> futureList = new ArrayList<>();

		for (String site : topSites) {
			Future<String> future = executorService.submit(new Callable<String>() {
				@Override
				public String call() throws Exception {
					// fetch all data from each site
					String crawlingEachSite = site.toString();
					Thread.sleep(1000);
					return crawlingEachSite;
				}
			});
			futureList.add(future);
		}

		// At this point we submit all the tasks. We doesn't know which one will complete first.
		// But all the future objects we added in a list, the same order as tasks are submitted.
		// The first submitted task may take more time compared remaining tasks, we can't predict at this point.
		// Instead of taking/getting first completed task we are struck at first arbitrary result in Future List that we added while submitting of task.
		for (Future<String> future : futureList) {
			try {
				String siteData = future.get();
				Thread.sleep(1000);
				System.out.println(siteData);
			} catch (InterruptedException | ExecutionException e) {
				e.printStackTrace();
			}
		}
		executorService.shutdown();
	}

	public static void executorCompletionService() {
		ExecutorService executorService = Executors.newFixedThreadPool(5);
		CompletionService<String> executorCompletionService = new ExecutorCompletionService<>(executorService);
		for (String site : topSites) {
			executorCompletionService.submit(new Callable<String>() {
				@Override
				public String call() throws Exception {
					// fetch all data from each site
					String crawlingEachSite = site.toString();
					Thread.sleep(1000);
					return crawlingEachSite;
				}
			});
		}
		// At this point we submit all the tasks. We doesn't know which one will complete first.

		for (int i = 0; i < topSites.size(); i++) {
			try {
				// taking first complete task from the queue, if not present it will wait until it will finish the task.
				Future<String> future = executorCompletionService.take();
				String siteData = future.get();
				Thread.sleep(1000);
				System.out.println(siteData);
			} catch (InterruptedException | ExecutionException e) {
				e.printStackTrace();
			}
		}
		executorService.shutdown();
	}

	public static void main(String[] args) {
		// ExecutorCompletionServiceCallable.executorService();
		ExecutorCompletionServiceCallable.executorCompletionService();
	}

}
