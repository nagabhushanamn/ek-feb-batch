package com.bank;

import java.util.function.Predicate;

//------------------------------------------------------
//FP - Principles
//------------------------------------------------------

/*
//in FP-language, functions are first-class values/citizens
  - A function can be stored in a variable
  - A parameter of a function can be a function
  - The return value of a function can be a function
  
  // HOP
   
    
    A higher-order component (HOC) is an advanced technique in FP for reusing functions.
    They are a pattern that emerges  compositional nature.
   
  
*/

public class FP_Principles {

	// FP ==> Higher-Order-Programming
	public static Predicate<Integer> and(Predicate<Integer> p1, Predicate<Integer> p2) {

		// ------------------------------------------------------
		// #3 - The return value of a function can be a function
		// ------------------------------------------------------

		return n -> p1.test(n) && p2.test(n);

	}

	public static void main(String[] args) {

		// ------------------------------------------------------
		// #1 - A function can be stored in a variable
		// ------------------------------------------------------

		Predicate<Integer> min = n -> n >= 100;
		Predicate<Integer> max = n -> n < 1000;

		// ------------------------------------------------------
		// #2 - A parameter of a function can be a function
		// ------------------------------------------------------x

		Predicate<Integer> minAndMax = and(min, max);

		System.out.println(minAndMax.test(500));

		// ----------------------------------------------------------

	}

}
