package com.bank;

import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class Ex2 {

	public static void main(String[] args) {

		BiFunction<Integer, Integer, Integer> biFunction = (n1, n2) -> Integer.compare(n1, n2);
		biFunction = Integer::compare;

		Supplier<Thread> supplier = () -> Thread.currentThread();

		Consumer<String> consumer = log -> System.out.println(log);
		consumer.accept("started");

	}

}
