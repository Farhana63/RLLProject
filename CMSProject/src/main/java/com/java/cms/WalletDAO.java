package com.java.cms;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class WalletDAO {
	Connection connection;
	PreparedStatement pst;
	public List<Wallet> searchByCustomerId(int customerId) throws ClassNotFoundException, SQLException {
		connection = ConnectionHelper.getConnection();
		String cmd = "select * from wallet where customerid=?";
		pst = connection.prepareStatement(cmd);
		pst.setInt(1, customerId);
		ResultSet rs = pst.executeQuery();
		List<Wallet> walletList = new ArrayList<Wallet>();
		Wallet wallet = null;
		while(rs.next()) {
		wallet.setWalletid(rs.getInt("WALLETID"));
		wallet.setCustomerid(rs.getInt("CUSTOMERID"));
		wallet.setWalletType(rs.getString("WALLETTYPE"));
		wallet.setAmount(rs.getInt(" AMOUNT"));
		walletList.add(wallet);
	}
	return walletList;
	}
	public String deductBalance(int walletId, int billAmount) throws ClassNotFoundException, SQLException {
		connection = ConnectionHelper.getConnection();
		String cmd = "update wallet set amount=amount-? where walletId=?";
		pst = connection.prepareStatement(cmd);
		pst.setInt(1, billAmount);
		pst.setInt(2, walletId);
		pst.executeUpdate();
		return "Amount Deducted...";
	}
	public Wallet searchbyWalletid(int walletid) throws ClassNotFoundException,SQLException{
		connection=ConnectionHelper.getConnection();
		String cmd ="select * from Wallet where walletid=?";
		pst = connection.prepareStatement(cmd);
		pst.setInt(1, walletid);
		Wallet wallet=null;
		ResultSet rs = pst.executeQuery();
		if(rs.next()) {
			wallet.setWalletid(rs.getInt("WALLETID"));
			wallet.setCustomerid(rs.getInt("CUSTOMERID"));
			wallet.setWalletType(rs.getString("WALLETTYPE"));
			wallet.setAmount(rs.getInt("AMOUNT"));
		}
    	return wallet;
}

}
	
	
	