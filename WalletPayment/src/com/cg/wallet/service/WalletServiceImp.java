package com.cg.wallet.service;

import com.cg.wallet.bean.BalanceDetailsBean;
import com.cg.wallet.bean.CustomerBean;
import com.cg.wallet.dao.IWalletDao;
import com.cg.wallet.dao.WalletDaoImp;
import com.cg.wallet.exception.WalletException;
import com.cg.wallet.exception.WalletExceptionMessages;


public class WalletServiceImp implements IWalletService{
	
	IWalletDao dao = new WalletDaoImp(); 
	CustomerBean custbean = new CustomerBean();
	
	@Override
	public boolean createAccount(CustomerBean custbean) throws WalletException {
		// TODO Auto-generated method stub
		
		return dao.createAccount(custbean);
		
	}

	@Override
	public boolean withdraw(BalanceDetailsBean balbean, double amount) throws WalletException {
		// TODO Auto-generated method stub
		boolean valid = validate(balbean);
		if(valid){
		return dao.withdraw(balbean,amount);
	}
		else{
			valid = false;
		}
		return valid;
	}

	@Override
	public boolean deposit(BalanceDetailsBean balbean, double amount) throws WalletException {
		// TODO Auto-generated method stub
		boolean valid = validate(balbean);
		if(valid){
		return dao.deposit(balbean,amount);
	}
		else{
			valid = false;
		}
		return valid;
	}

	@Override
	public void printTransaction() {
		// TODO Auto-generated method stub
		dao.printTransaction();
	}

	@Override
	public double showBalance(BalanceDetailsBean custbean) {
		// TODO Auto-generated method stub
		return dao.showBalance(custbean);
	}

	@Override
	public boolean fundTransfer( String toNum , double amount) throws WalletException {
		// TODO Auto-generated method stub
		return dao.fundTransfer(toNum,amount);
	}

	@Override
	public boolean validate(BalanceDetailsBean balbean) throws WalletException {
		boolean isValid = true;
		/*if(!(custbean.getFirstName().matches("[A-Z][A-Za-z]*") && custbean.getFirstName()!=null))
		{
			throw new WalletException(WalletExceptionMessages.ERROR1);
		}
	
		if(!(custbean.getLastName().matches("[A-Z][A-Za-z]*")))
		{
			throw new WalletException(WalletExceptionMessages.ERROR2);
		}

	
			if(!(custbean.getEmailId().matches("[A-Za-z0-9]+@+[a-z]+\\.com")))
		{
			throw new WalletException(WalletExceptionMessages.ERROR3);
		}*/
		
	
		if(!(balbean.getPhoneNum().matches("^[6-9][0-9]{9}") ))
		{
			throw new WalletException(WalletExceptionMessages.ERROR4);
		}
		
		if(!(balbean.getBalance()>500 && balbean.getBalance()!=0 ))
		{
			throw new WalletException(WalletExceptionMessages.ERROR5);
		}
		
		return isValid;
	}
}

	

