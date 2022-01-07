package com.java.cms;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RestaurantDAO {
	Connection connection;
	PreparedStatement pst;
	public List<Restaurant> showRestaurant() throws ClassNotFoundException, SQLException {
		connection = ConnectionHelper.getConnection();
		String cmd = "select * from RESTAURANT";
		pst = connection.prepareStatement(cmd);
		ResultSet rs = pst.executeQuery();
		List<Restaurant> restaurantList = new ArrayList<Restaurant>();
		Restaurant restaurant = null;
		while(rs.next()) {
			restaurant = new Restaurant();
			restaurant.setRestaurantId(rs.getInt("restaurantid"));
			restaurant.setRestaurantname(rs.getString("restaurantname"));
			restaurant.setRestaurantcity(rs.getString("restaurantcity"));
			restaurant.setRestaurantbranch(rs.getString("restaurantbranch"));
		    restaurant.setRestaurantemail(rs.getString("restaurantemail"));
			restaurant.setRestaurantcontactno(rs.getString("restaurantcontactno"));
			restaurantList.add(restaurant);
		}
		return restaurantList;
	}
	
	public Restaurant searchRestaurant(int restaurantId) throws ClassNotFoundException, SQLException {
		connection = ConnectionHelper.getConnection();
		String cmd = "select * from Restaraunt where restaurantid=?";
		pst = connection.prepareStatement(cmd);
		pst.setInt(1, restaurantId);
		ResultSet rs = pst.executeQuery();
		Restaurant restaurant = null;
		if(rs.next()) {
			restaurant = new Restaurant();
			restaurant.setRestaurantId(rs.getInt("restaurantId"));
			restaurant.setRestaurantname(rs.getString("restaurantname"));
			restaurant.setRestaurantcity(rs.getString("restaurantcity"));
			restaurant.setRestaurantemail(rs.getString("restaurantemail"));
			restaurant.setRestaurantbranch(rs.getString("restaurantbranch"));
			restaurant.setRestaurantcontactno(rs.getString("restaurantcontactno"));
		}
		return restaurant;
	}
}