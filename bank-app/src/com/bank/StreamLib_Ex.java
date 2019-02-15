package com.bank;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class StreamLib_Ex {
	
	public static boolean isEven(int n) {
		System.out.println(Thread.currentThread() +" : "+n);
		return n%2==0;
	}

	public static void main(String[] args) {

		List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

//		// -------------------------
//		int sum = 0;
//		for (Integer i : integers) {
//			if (i % 2 == 0)
//				sum += i;
//		}
//		System.out.println(sum);
//		// -------------------------
		
		
		Optional<Integer> optional=integers
		.stream()
		.parallel()
		.filter(StreamLib_Ex::isEven)
		.reduce((acc, n) -> acc + n);

		System.out.println(optional.orElse(0));

	}

}
