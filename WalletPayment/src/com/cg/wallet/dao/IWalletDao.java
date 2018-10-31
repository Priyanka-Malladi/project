package com.cg.wallet.dao;

import com.cg.wallet.bean.BalanceDetailsBean;
import com.cg.wallet.bean.CustomerBean;
import com.cg.wallet.exception.WalletException;

public interface IWalletDao {

	public boolean createAccount(CustomerBean cb);

	boolean deposit(BalanceDetailsBean balbean, double amount) throws WalletException;

	public void printTransaction();

	public double showBalance(BalanceDetailsBean cb);

	public boolean fundTransfer( String toNum, double amount) throws WalletException;
	
	boolean withdraw(BalanceDetailsBean balbean, double amount) throws WalletException;

	

	
}
