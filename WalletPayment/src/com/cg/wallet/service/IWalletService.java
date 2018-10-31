package com.cg.wallet.service;

import com.cg.wallet.bean.BalanceDetailsBean;
import com.cg.wallet.bean.CustomerBean;
import com.cg.wallet.exception.WalletException;

public interface IWalletService {

	public boolean createAccount(CustomerBean cb) throws WalletException;
	
	boolean withdraw(BalanceDetailsBean balbean, double amount) throws WalletException;
	
	boolean deposit(BalanceDetailsBean balbean, double amount) throws WalletException;
	
	public void printTransaction();
	
	public double showBalance(BalanceDetailsBean cb);
	
	public boolean fundTransfer( String toNum , double amount) throws WalletException;
	
	public boolean validate(BalanceDetailsBean balbean) throws WalletException;

}
