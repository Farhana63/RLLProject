package com.java.cms;

public class Restaurant {
private int RestaurantId;
private String Restaurantname;
private String Restaurantcity;
private String Restaurantbranch;
private String Restaurantemail;
private String Restaurantcontactno;

public int getRestaurantId() {
	return RestaurantId;
}

public String getRestaurantname() {
	return Restaurantname;
}

public void setRestaurantname(String restaurantname) {
	Restaurantname = restaurantname;
}

public String getRestaurantcity() {
	return Restaurantcity;
}

public void setRestaurantcity(String restaurantcity) {
	Restaurantcity = restaurantcity;
}

public String getRestaurantbranch() {
	return Restaurantbranch;
}

public void setRestaurantbranch(String restaurantbranch) {
	Restaurantbranch = restaurantbranch;
}

public String getRestaurantemail() {
	return Restaurantemail;
}

public void setRestaurantemail(String restaurantemail) {
	Restaurantemail = restaurantemail;
}

public String getRestaurantcontactno() {
	return Restaurantcontactno;
}

public void setRestaurantcontactno(String restaurantcontactno) {
	Restaurantcontactno = restaurantcontactno;
}

public void setRestaurantId(int restaurantId) {
	RestaurantId = restaurantId;
}

@Override
public String toString() {
	return "Restaurant [RestaurantId=" + RestaurantId + ", Restaurantname=" + Restaurantname + ", Restaurantcity="
			+ Restaurantcity + ", Restaurantbranch=" + Restaurantbranch + ", Restaurantemail=" + Restaurantemail
			+ ", Restaurantcontactno=" + Restaurantcontactno + "]";
}


}

