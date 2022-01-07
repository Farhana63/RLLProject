package com.java.cms;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
public class MenuDAO {
Connection connection;
PreparedStatement pst;
public List<Menu> showMenu() throws ClassNotFoundException,SQLException{
	connection = ConnectionHelper.getConnection();
	String cmd = "select * from Menu";
	pst = connection.prepareStatement(cmd);
	ResultSet rs = pst.executeQuery();
	List<Menu> menuList = new ArrayList<Menu>();
	Menu menu = null;
	while(rs.next()) {
		menu = new Menu();
		menu.setMenuId(rs.getInt("MENUID"));
		menu.setRestaurantId(rs.getInt("RESTAURANTID"));
		menu.setMenuTypes(rs.getString("MENUTYPE"));
		menu.setItemname(rs.getString("ITEMNAME"));
	    menu.setCalories(rs.getInt("CALORIES"));
	    menu.setPrice(rs.getInt("PRICE"));
		menuList.add(menu);
	}
	return menuList;
}

public Menu searchMenu(int menuId) throws ClassNotFoundException, SQLException {
	connection = ConnectionHelper.getConnection();
	String cmd = "select * from Menu where menuid=?";
	pst = connection.prepareStatement(cmd);
	pst.setInt(1, menuId);
	ResultSet rs = pst.executeQuery();
	Menu menu = null;
	if(rs.next()) {
		menu = new Menu();
	    menu.setMenuId(rs.getInt("MENUID"));
	    menu.setRestaurantId(rs.getInt("RESTAURANTID"));
		menu.setMenuTypes(rs.getString("MENUTYPE"));
		menu.setItemname(rs.getString("ITEMNAME"));
	    menu.setCalories(rs.getInt("CALORIES"));
		menu.setPrice(rs.getInt("PRICE"));
	}
	return menu;
}
}	


