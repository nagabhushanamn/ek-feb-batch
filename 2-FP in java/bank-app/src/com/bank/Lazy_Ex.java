package com.bank;

import java.time.LocalDateTime;
import java.util.Objects;

public class Lazy_Ex {

	public static String collectSystemLog() {
		System.out.println(".........");
		return LocalDateTime.now().toString();
	}

	public static void main(String[] args) {

		String s1 = "dubai";

//		Objects.requireNonNull(s1, collectSystemLog());
		Objects.requireNonNull(s1, () -> collectSystemLog());

	}

}
