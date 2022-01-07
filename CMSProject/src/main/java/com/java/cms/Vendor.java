package com.java.cms;

public class Vendor {
private int vendorId;
private String vendorname;
private String vendorstate;
private String vendorcity;
private String vendoremail;
private String vendormobile;

public String getVendorname() {
	return vendorname;
}

public int getVendorId() {
	return vendorId;
}

public void setVendorId(int vendorId) {
	this.vendorId = vendorId;
}

public String getVendorstate() {
	return vendorstate;
}

public void setVendorstate(String vendorstate) {
	this.vendorstate = vendorstate;
}

public String getVendorcity() {
	return vendorcity;
}

public void setVendorcity(String vendorcity) {
	this.vendorcity = vendorcity;
}

public String getVendoremail() {
	return vendoremail;
}

public void setVendoremail(String vendoremail) {
	this.vendoremail = vendoremail;
}

public String getVendormobile() {
	return vendormobile;
}

public void setVendormobile(String vendormobile) {
	this.vendormobile = vendormobile;
}

public void setVendorname(String vendorname) {
	this.vendorname = vendorname;
}

@Override
public String toString() {
	return "Vendor [vendorId=" + vendorId + ", vendorname=" + vendorname + ", vendorstate=" + vendorstate
			+ ", vendorcity=" + vendorcity + ", vendoremail=" + vendoremail + ", vendormobile=" + vendormobile + "]";
}


}
