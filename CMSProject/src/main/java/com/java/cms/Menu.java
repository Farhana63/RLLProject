package com.java.cms;

public class Menu {
private int MenuId;
private int RestaurantId;
private String itemname;
private String menuTypes;
private int calories;
private int price;

public int getMenuId() {
	return MenuId;
}

public int getRestaurantId() {
	return RestaurantId;
}

public void setRestaurantId(int restaurantId) {
	RestaurantId = restaurantId;
}

public String getItemname() {
	return itemname;
}

public void setItemname(String itemname) {
	this.itemname = itemname;
}

public String getMenuTypes() {
	return menuTypes;
}

public void setMenuTypes(String menuTypes) {
	this.menuTypes = menuTypes;
}

public int getCalories() {
	return calories;
}

public void setCalories(int calories) {
	this.calories = calories;
}

public int getPrice() {
	return price;
}

public void setPrice(int price) {
	this.price = price;
}

public void setMenuId(int menuId) {
	MenuId = menuId;
}

@Override
public String toString() {
	return "Menu [MenuId=" + MenuId + ", RestaurantId=" + RestaurantId + ", itemname=" + itemname + ", menuTypes="
			+ menuTypes + ", calories=" + calories + ", price=" + price + "]";
}

}
