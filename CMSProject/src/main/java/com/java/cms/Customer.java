package com.java.cms;

public class Customer {
private int customerId;
private String customername;
private String customercity;
private String customerstate;
private String customeremail;
private String customermobile;
 
public int getcustomerId() {
	return customerId;
}

public int getCustomerId() {
	return customerId;
}

public void setCustomerId(int customerId) {
	this.customerId = customerId;
}

public String getCustomername() {
	return customername;
}

public void setCustomername(String customername) {
	this.customername = customername;
}

public String getCustomercity() {
	return customercity;
}

public void setCustomercity(String customercity) {
	this.customercity = customercity;
}

public String getCustomerstate() {
	return customerstate;
}

public void setCustomerstate(String customerstate) {
	this.customerstate = customerstate;
}

public String getCustomeremail() {
	return customeremail;
}

public void setCustomeremail(String customeremail) {
	this.customeremail = customeremail;
}

public String getCustomermobile() {
	return customermobile;
}

public void setCustomermobile(String customermobile) {
	this.customermobile = customermobile;
}

@Override
public String toString() {
	return "Customer [customerId=" + customerId + ", customername=" + customername + ", customercity=" + customercity
			+ ", customerstate=" + customerstate + ", customeremail=" + customeremail + ", customermobile="
			+ customermobile + "]";
}
}
