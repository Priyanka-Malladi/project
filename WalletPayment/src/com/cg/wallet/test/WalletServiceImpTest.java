package com.cg.wallet.test;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import com.cg.wallet.bean.BalanceDetailsBean;
import com.cg.wallet.bean.CustomerBean;
import com.cg.wallet.exception.WalletException;
import com.cg.wallet.service.IWalletService;
import com.cg.wallet.service.WalletServiceImp;

public class WalletServiceImpTest {
	
	private static IWalletService service = null;
	private static CustomerBean custbean = null;
	private static BalanceDetailsBean balbean = null;
	@BeforeClass
	public static void creatInstance(){
		
		service = new WalletServiceImp();
		custbean = new CustomerBean();
		balbean = new BalanceDetailsBean();
	}
	//phone number
	@Test
	public void testPhoneNum() throws WalletException
	{
		
		balbean.setPhoneNum("9949698104");
		balbean.setBalance(5000);
		boolean valid = service.withdraw(balbean,2000);
		assertTrue(valid);
	}
	
	@Test(expected = WalletException.class)
	public void testPhoneNumForFirstDigit() throws WalletException
	{
		balbean.setPhoneNum("0949698104");
		balbean.setBalance(5000.00);
		boolean valid = service.withdraw(balbean,2000);
		assertFalse(valid);
	}
	
	@Test(expected = WalletException.class)
	public void testPhoneNumForSize() throws WalletException
	{
		
		balbean.setPhoneNum("78999");
		balbean.setBalance(5000.00);
		boolean valid = service.withdraw(balbean,2000);
		assertFalse(valid);
	}
	
	@Test(expected = WalletException.class)
	public void testPhoneNumOnlyDigits() throws WalletException
	{
		
		balbean.setPhoneNum("78915df235");
		balbean.setBalance(5000.00);
		boolean valid = service.withdraw(balbean,2000);
		assertFalse(valid);
	}
	//balance
	@Test(expected = WalletException.class)
	public void testBalance()throws WalletException
	{
		
		balbean.setPhoneNum("9949596910");
		balbean.setBalance(0);
		boolean valid = service.withdraw(balbean,2000);
		assertFalse(valid);
	}
	
	@Test(expected = WalletException.class)
	public void testBalanceForNotNegative()throws WalletException
	{
		
		balbean.setPhoneNum("9949596910");
		balbean.setBalance(-1000);
		boolean valid = service.withdraw(balbean,2000);
		assertFalse(valid);
	}


	@Test(expected = WalletException.class)
	public void testBalanceMorethanMinBalance()throws WalletException
	{
		
		balbean.setPhoneNum("9949596910");
		balbean.setBalance(400);
		boolean valid = service.withdraw(balbean,2000);
		assertFalse(valid);
	}

}
