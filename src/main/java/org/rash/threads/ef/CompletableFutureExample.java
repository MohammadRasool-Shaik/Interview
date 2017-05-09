/**
 * 
 */
package org.rash.threads.ef;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;

/**
 * @author Rasool.Shaik
 *
 */
public class CompletableFutureExample {
	private static final Executor EXECUTOR = Executors.newCachedThreadPool();

	@Test
	public void testCompletedFuture() throws InterruptedException, ExecutionException {
		String expectedValue = "the expected value";
		CompletableFuture<String> future = CompletableFuture.<String> completedFuture(expectedValue);
		assertThat(future.get(), is(expectedValue));

	}

	@Test
	public void test_runAsync() {
		CompletableFuture<Void> runAsync = CompletableFuture.runAsync(() -> System.out.println("Running async Task"), EXECUTOR);
		assertThat(runAsync.isDone(), is(true));
	}

	@Test
	public void test_supplyAsync() throws InterruptedException, ExecutionException {
		CompletableFuture<String> supplyAsync = CompletableFuture.supplyAsync(() -> "Final Result", EXECUTOR);
		assertThat(supplyAsync.get(), is("Final Result"));
	}

	@Test
	public void test_then_runAsync() throws InterruptedException, ExecutionException {
		Map<String, String> myMap = new HashMap<>();
		myMap.put("key", "value");
		CompletableFuture<String> supplyAsync = CompletableFuture.supplyAsync(() -> myMap.get("key"), EXECUTOR);
		CompletableFuture<Void> thenRunAsync = supplyAsync.thenRunAsync(myMap::clear, EXECUTOR);
		thenRunAsync.get();
		assertThat(supplyAsync.get(), is("value"));

		assertThat(myMap.isEmpty(), is(true));

	}

	private List<String> results = new ArrayList<>();

	@Test
	public void test_thenAccept() {
		CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> "First Value", EXECUTOR);
		future.thenAccept(results::add);
		assertEquals(results.size(), 1);

		CompletableFuture.supplyAsync(() -> "", EXECUTOR);
	}

	@Test
	public void test_then_compose() throws Exception {
		Function<Integer, Supplier<List<Integer>>> getFirstTenMultiples = num -> () -> Stream.iterate(num, i -> i + num).limit(10).collect(Collectors.toList());
		Supplier<List<Integer>> multiplesSupplier = getFirstTenMultiples.apply(13);

		// Original CompletionStage
		CompletableFuture<List<Integer>> getMultiples = CompletableFuture.supplyAsync(multiplesSupplier, EXECUTOR);

		// Function that takes input from orignal CompletionStage
		Function<List<Integer>, CompletableFuture<Integer>> sumNumbers = multiples -> CompletableFuture.supplyAsync(() -> multiples.stream().mapToInt(Integer::intValue).sum());

		// The final CompletableFuture composed of previous two.
		CompletableFuture<Integer> summedMultiples = getMultiples.thenComposeAsync(sumNumbers, EXECUTOR);

		assertThat(summedMultiples.get(), is(715));
	}
}
