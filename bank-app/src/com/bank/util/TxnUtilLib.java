package com.bank.util;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import com.bank.model.Txn;

public class TxnUtilLib {

	public static List<Txn> filter(List<Txn> in, Predicate<Txn> predicate) {
		List<Txn> out = new ArrayList<>();
		for (Txn txn : in) {
			if (predicate.test(txn))
				out.add(txn);
		}
		return out;
	}

}
