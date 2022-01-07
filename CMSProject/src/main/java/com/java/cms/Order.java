package com.java.cms;

import java.sql.Date;

public class Order {
private int orderId;
private int vendorId;
private int customerId;
private int menuId;
private int walletId;
private Date orderDate;
private int quantityOrdered;
private String orderStatus;
private int billAmount;
private String orderComments;
private int getorderId() {
return orderId;

}
public int getOrderId() {
	return orderId;
}
public void setOrderId(int orderId) {
	this.orderId = orderId;
}
public int getVendorId() {
	return vendorId;
}
public void setVendorId(int vendorId) {
	this.vendorId = vendorId;
}
public int getCustomerId() {
	return customerId;
}
public void setCustomerId(int customerId) {
	this.customerId = customerId;
}
public int getMenuId() {
	return menuId;
}
public void setMenuId(int menuId) {
	this.menuId = menuId;
}
public int getWalletId() {
	return walletId;
}
public void setWalletId(int walletId) {
	this.walletId = walletId;
}
public Date getOrderDate() {
	return orderDate;
}
public void setOrderDate(Date orderDate) {
	this.orderDate = orderDate;
}
public int getQuantityOrdered() {
	return quantityOrdered;
}
public void setQuantityOrdered(int quantityOrdered) {
	this.quantityOrdered = quantityOrdered;
}
public String getOrderStatus() {
	return orderStatus;
}
public void setOrderStatus(String orderStatus) {
	this.orderStatus = orderStatus;
}
public int getBillAmount() {
	return billAmount;
}
public void setBillAmount(int billAmount) {
	this.billAmount = billAmount;
}
public String getOrderComments() {
	return orderComments;
}
public void setOrderComments(String orderComments) {
	this.orderComments = orderComments;
}
@Override
public String toString() {
	return "Order [orderId=" + orderId + ", vendorId=" + vendorId + ", customerId=" + customerId + ", menuId=" + menuId
			+ ", walletId=" + walletId + ", orderDate=" + orderDate + ", quantityOrdered=" + quantityOrdered
			+ ", orderStatus=" + orderStatus + ", billAmount=" + billAmount + ", orderComments=" + orderComments + "]";
}
}