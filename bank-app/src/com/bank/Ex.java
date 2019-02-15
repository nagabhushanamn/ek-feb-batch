package com.bank;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Predicate;

public class Ex {

	public static boolean isNonVeg(String item) {
		return item.equals("nveg") ? true : false;
	}

	public static void main(String[] args) {

		List<String> list = new ArrayList<>();
		list.add("veg");
		list.add("veg");
		list.add("nveg");
		list.add("veg");
		list.add("veg");
		list.add("nveg");
		list.add("veg");
		list.add("nveg");

//		// ------------------------------------
//
		//
//		Iterator<String> iterator = list.iterator();
//		while (iterator.hasNext()) {
//			String string = (String) iterator.next();
//			if (string.equals("nveg"))
//				iterator.remove();
//
//		}
//		System.out.println(list);

		// -------------------------------------

//		list.removeIf(new Predicate<String>() {
//			@Override
//			public boolean test(String t) {
//				if (t.equals("nveg"))
//					return true;
//				return false;
//			}
//		});

		// -------------------------------------

//		list.removeIf(item -> item.equals("nveg"));
//		System.out.println(list);

		// ---------------------------------------

		list.removeIf(item -> Ex.isNonVeg(item)); // Lambda syntax
		// or
		list.removeIf(Ex::isNonVeg); // Method Reference

	}

}
