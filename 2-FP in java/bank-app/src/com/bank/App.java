package com.bank;

import java.util.List;

import com.bank.model.Txn;
import com.bank.service.TxnServiceImpl;

public class App {

	public static void main(String[] args) {

		TxnServiceImpl txnService = new TxnServiceImpl();

		List<Txn> txns = txnService.getTxns(1000.00,2000.00);
		for (Txn txn : txns) {
			System.out.println(txn);
		}

	}
}
