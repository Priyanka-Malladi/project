package com.cg.wallet.dao;

import java.util.ArrayList;
import java.util.List;

import com.cg.wallet.bean.BalanceDetailsBean;
import com.cg.wallet.bean.CustomerBean;
import com.cg.wallet.exception.WalletException;
import com.cg.wallet.exception.WalletExceptionMessages;

public class WalletDaoImp implements IWalletDao {
	List<CustomerBean> cList = new ArrayList<CustomerBean>();
	List<BalanceDetailsBean> tList = new ArrayList<BalanceDetailsBean>();
	CustomerBean custbean = new CustomerBean();
	BalanceDetailsBean balbean = new BalanceDetailsBean();
	@Override
	public boolean createAccount(CustomerBean balbean) {
		boolean isValid = false;
		
		if (cList.add(balbean)) {
			isValid = true;
		}
		return isValid;

	}

	@Override
	public boolean withdraw(BalanceDetailsBean balbean, double amount)
			throws WalletException {
		// TODO Auto-generated method stub
		boolean isValid = false;
		if (balbean.getBalance() > amount && amount != 0) {
			balbean.setBalance(balbean.getBalance() - amount);
			isValid = true;
		} else {
			throw new WalletException(WalletExceptionMessages.ERROR6);
		}
		return isValid;
	}

	@Override
	public boolean deposit(BalanceDetailsBean balbean, double amount) throws WalletException {
		// TODO Auto-generated method stub
		boolean isValid = false;
		if (amount > 0) {
			balbean.setBalance(balbean.getBalance() + amount);
			isValid = true;
		} else {
			throw new WalletException(WalletExceptionMessages.ERROR7);
		}
		return isValid;
	}

	@Override
	public void printTransaction() {
		// TODO Auto-generated method stub

	}

	@Override
	public double showBalance(BalanceDetailsBean balbean) {
		// TODO Auto-generated method stub
		return balbean.getBalance();
	}

	@Override
	public boolean fundTransfer(String toNum , double amount) throws WalletException {
		// TODO Auto-generated method stub
		boolean isValid = true;
		for (BalanceDetailsBean balbean : tList) {

			if (balbean.getPhoneNum() == toNum) {

				boolean valid = withdraw(tList.get(0), amount);

				if (valid) {
					deposit(balbean, amount);
				} else {
					deposit(tList.get(0), amount);
				}
			}
		}

		return isValid;
	}

	
}
