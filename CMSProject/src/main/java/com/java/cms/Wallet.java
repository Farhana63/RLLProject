package com.java.cms;

public class Wallet {
	private int walletid;
	private int customerid;
	private String walletType;
	private int amount;
	
	public int  getwalletid() {
		return walletid;
	}

	public int getWalletid() {
		return walletid;
	}

	public void setWalletid(int walletid) {
		this.walletid = walletid;
	}

	public int getCustomerid() {
		return customerid;
	}

	public void setCustomerid(int customerid) {
		this.customerid = customerid;
	}

	public String getWalletType() {
		return walletType;
	}

	public void setWalletType(String walletType) {
		this.walletType = walletType;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "Wallet [walletid=" + walletid + ", customerid=" + customerid + ", walletType=" + walletType
				+ ", amount=" + amount + "]";
	}
	
	

}
