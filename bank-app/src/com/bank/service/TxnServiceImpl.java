package com.bank.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.bank.model.Txn;
import com.bank.model.TxnType;
import com.bank.util.TxnUtilLib;

public class TxnServiceImpl {

	private static List<Txn> txns = Arrays.asList(new Txn(1, 1000.00, LocalDate.of(2018, 12, 25), TxnType.DEBIT),
			new Txn(2, 1000.00, LocalDate.of(2019, 1, 25), TxnType.DEBIT),
			new Txn(3, 2000.00, LocalDate.of(2019, 1, 25), TxnType.DEBIT),
			new Txn(4, 1000.00, LocalDate.of(2019, 2, 15), TxnType.DEBIT),
			new Txn(5, 4000.00, LocalDate.of(2019, 2, 5), TxnType.DEBIT),
			new Txn(6, 5000.00, LocalDate.of(2019, 2, 2), TxnType.DEBIT)

	);

	public List<Txn> getTxns(double amount) {

		// ------------------------------------------
		// imperative style ==> what + how
		// ------------------------------------------
//		List<Txn> out = new ArrayList<>();
//		for (Txn txn : txns) {
//			if (txn.getAmount() == amount)
//				out.add(txn);
//		}
//		return out;
		// ------------------------------------------

//		// ------------------------------------------
//		// declarative style ==> what + how  : way-1 : local inner class
//		// ------------------------------------------
//
//		class ByAmount implements Predicate {
//			@Override
//			public boolean test(Txn txn) {
//				return txn.getAmount() == amount;
//			}
//		}
//		Predicate predicate = new ByAmount();
//
//		return TxnUtilLib.filter(txns, predicate);

//		// ------------------------------------------
//		// declarative style ==> what  : way-2 : anonymous inner class
//		// ------------------------------------------
//
//		Predicate predicate = new Predicate() {
//			@Override
//			public boolean test(Txn txn) {
//				return txn.getAmount() == amount;
//			}
//		};
//
//		return TxnUtilLib.filter(txns, predicate);

		// ------------------------------------------
		// declarative style ==> what : way-3 : function
		// ------------------------------------------

		return TxnUtilLib.filter(txns, txn -> txn.getAmount() == amount);
		

	}

	public List<Txn> getTxns(double minAmount, double maxAmount) {

		// imperative style ==> what + how
		List<Txn> out = new ArrayList<>();
		for (Txn txn : txns) {
			if (txn.getAmount() >= minAmount && txn.getAmount() <= maxAmount)
				out.add(txn);
		}
		return out;
	}

}
