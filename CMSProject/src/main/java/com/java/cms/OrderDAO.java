package com.java.cms;

import java.sql.Connection;
import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class OrderDAO {
	Connection connection;
	PreparedStatement pst;
	public Order searchOrder(int orderId) throws ClassNotFoundException, SQLException {
		connection = ConnectionHelper.getConnection();
		String cmd = "select * from orders where  ORDERID=?";
		pst = connection.prepareStatement(cmd);
		pst.setInt(1, orderId);
		ResultSet rs = pst.executeQuery();
		Order orderFound = null;
		if (rs.next()) {
			orderFound = new Order();
			orderFound.setOrderId(rs.getInt("ORDERID"));
			orderFound.setMenuId(rs.getInt("MENUID"));
			orderFound.setVendorId(rs.getInt("VendorID"));
			orderFound.setCustomerId(rs.getInt("CustomerID"));
			orderFound.setWalletId(rs.getInt("WALLETID"));
			orderFound.setBillAmount(rs.getInt("BILLAMOUNT"));
			orderFound.setOrderComments(rs.getString("COMMENTS"));
			orderFound.setOrderDate(rs.getDate("ORDERDATE"));
			orderFound.setOrderStatus(rs.getString("ORDERSTATUS"));
			orderFound.setQuantityOrdered(rs.getInt("QUANTITYORDERED"));
		}
		return orderFound;
	}
	public String acceptOrRejectOrder(int orderId, int vendorId, String status) throws ClassNotFoundException, SQLException {
		connection = ConnectionHelper.getConnection();
		Order order = searchOrder(orderId);
		if (order.getVendorId()==vendorId) {
			if (status.toUpperCase().equals("YES")) {
				String cmd = "Update orders set OrderStatus='ACCEPTED' "
						+ " WHERE OrderID=?";
				pst = connection.prepareStatement(cmd);
				pst.setInt(1, orderId);
				pst.executeUpdate();
				return "Order Approved Successfully...";
			} else {
				String cmd = "Update orders set OrderStatus='REJECTED' "
						+ " WHERE OrderID=?";
				pst = connection.prepareStatement(cmd);
				pst.setInt(1, orderId);
				pst.executeUpdate();
				cmd = "Update Wallet set Amount=Amount+? where walletId=?";
				pst = connection.prepareStatement(cmd);
				pst.setInt(1, order.getBillAmount());
				pst.setInt(2, order.getWalletId());
				pst.executeUpdate();
				return "Order Rejected Amount Refunded...";
			}
		} 
		return "You are unauthorized vendor...";
	}

	public String pendingOrconformedorder(int orderId, int vendorId, int customerId,String status) throws ClassNotFoundException, SQLException {
		connection = ConnectionHelper.getConnection();
		Order order = searchOrder(orderId);
		if (order.getVendorId()==vendorId) {
			if (status.toUpperCase().equals("YES")) {
				String cmd = "Update orders set OrderStatus='PENDING' "
						+ " WHERE OrderID=?";
				pst = connection.prepareStatement(cmd);
				pst.setInt(1, orderId);
				pst.setInt(2, customerId);
				pst.executeUpdate();
				return " customer Order pending...";
			} else {
				String cmd = "Update orders set OrderStatus='CONFORMED' "
						+ " WHERE OrderID=?";
				pst = connection.prepareStatement(cmd);
				pst.setInt(1, orderId);
				pst.executeUpdate();
				cmd = "Update Wallet set Amount=Amount+? where walletId=?";
				pst = connection.prepareStatement(cmd);
				pst.setInt(1, order.getBillAmount());
				pst.setInt(2, order.getWalletId());
				pst.executeUpdate();
				return " customer Order Conformed...";
			}
		} 
		return "You are unauthorized vendor...";
	}
	
	public String placeOrder(Order order) throws SQLException, ClassNotFoundException {
		int oid = generateOrderId();
		order.setOrderStatus("PENDING");
		java.util.Date today = new Date();
		java.sql.Date dbDate = new java.sql.Date(today.getTime());
		order.setOrderDate(dbDate);
		Menu menu = new MenuDAO().searchMenu(order.getMenuId());
		int price = menu.getPrice();
		int  billAmount = order.getQuantityOrdered() * price;
		Wallet wallet = new WalletDAO().searchbyWalletid(order.getWalletId());
		int amount = wallet.getAmount();
		if (amount - billAmount > 0) {
			order.setBillAmount(billAmount);
			order.setOrderId(oid);
			String cmd = "insert into Orders(orderId,VendorId,CustomerId,MenuID,"
					+ "WalletId,OrderDate,QuantityOrdered,OrderStatus,BillAmount,Comments) "
					+ "values(?,?,?,?,?,?,?,?,?,?)";
			pst = connection.prepareStatement(cmd);
			pst.setInt(1, order.getOrderId());
			pst.setInt(2, order.getVendorId());
			pst.setInt(3, order.getCustomerId());
			pst.setInt(4, order.getMenuId());
			pst.setInt(5, order.getWalletId());
			pst.setDate(6, order.getOrderDate()); 
			pst.setInt(7, order.getQuantityOrdered());
			pst.setString(8, order.getOrderStatus());
			pst.setInt(9, order.getBillAmount());
			pst.setString(10, order.getOrderComments());
			pst.executeUpdate();
			new WalletDAO().deductBalance(order.getWalletId(), billAmount);
			return "Order Placed Successfully...Wallet Balance Deducted...";
		}
		return "Insufficient Funds...";
		//order.setBillAmount(billAmount);
	}
	
	public int generateOrderId() throws ClassNotFoundException, SQLException {
		connection = ConnectionHelper.getConnection();
		String cmd = "select case when max(ORDERID) is NULL THEN 1"
				+ " else max(ORDERID)+1 end oid from orders";
		pst = connection.prepareStatement(cmd);
		ResultSet rs = pst.executeQuery();
		rs.next();
		int id = rs.getInt("oid");
		return id;
	}
}


