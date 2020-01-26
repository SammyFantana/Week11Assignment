package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import plugs.FoodInfo;

public class FoodDao {
	
	private static Connection connection = DBConnector.getConnection();
	
	private final static String NEW_FOOD = "Insert into food(food_name, type, ethnicity, meat, veggies, fruits, sweets)" +
	"values(?,?,?,?,?,?,?)";
	
	private final static String All_Food = "Select * from food";
	private final static String Deserts = "Select * from food where type = 'desert'";
	private final static String Dinner = "Select * from food where type = 'dinner'";
	private final static String Lunch = "Select * from food where type = 'lunch'";
	private final static String Breakfast = "Select * from food where type = 'breakfast'";
	private final static String Remove_Meal = "delete from food where ID = ?";
	private final static String Update_Name = "update food set food_name = ? where ID = ?";
	
	
	
	
	public static void createNewFood(String food_name, String type, String ethnicity, String meat, String veggies, String fruits, String sweets) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(NEW_FOOD);
		ps.setString(1, food_name);
		ps.setString(2, type);
		ps.setString(3, ethnicity);
		ps.setString(4, meat);
		ps.setString(5, veggies);
		ps.setString(6, fruits);
		ps.setString(7, sweets);
		ps.executeUpdate();
	}
	
	public static List<FoodInfo> getAllFoods() throws SQLException {
		ResultSet rs = connection.prepareStatement(All_Food).executeQuery();
		List<FoodInfo> foods = new ArrayList<FoodInfo>();
		
		while (rs.next()) {
			foods.add(createFoods(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8)));
		}
		return foods;
		
	}
	
	private static FoodInfo createFoods(int ID, String food_name, String type, String ethnicity, String meat,
			String veggies, String fruits, String sweets) {
		
		return new FoodInfo(ID, food_name, type, ethnicity, meat, veggies, fruits, sweets);
	}

	public static List<FoodInfo> getDeserts() throws SQLException {
		ResultSet rs = connection.prepareStatement(Deserts).executeQuery();
		List<FoodInfo> foods = new ArrayList<FoodInfo>();
		
		while (rs.next()) {
			foods.add(createFoods(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8)));
		}
		return foods;
		
	}
	
	public static List<FoodInfo> getBreakfast() throws SQLException {
		ResultSet rs = connection.prepareStatement(Breakfast).executeQuery();
		List<FoodInfo> foods = new ArrayList<FoodInfo>();
		
		while (rs.next()) {
			foods.add(createFoods(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8)));
		}
		return foods;
		
	}

	public static List<FoodInfo> getLunch() throws SQLException {
		ResultSet rs = connection.prepareStatement(Lunch).executeQuery();
		List<FoodInfo> foods = new ArrayList<FoodInfo>();
		
		while (rs.next()) {
			foods.add(createFoods(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8)));
		}
		return foods;
		
	}
	
	public static List<FoodInfo> getDinner() throws SQLException {
		ResultSet rs = connection.prepareStatement(Dinner).executeQuery();
		List<FoodInfo> foods = new ArrayList<FoodInfo>();
		
		while (rs.next()) {
			foods.add(createFoods(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8)));
		}
		return foods;
		
	}
	
	public static void removeMeal(int foodID) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(Remove_Meal);
		ps.setInt(1, foodID);
		ps.executeUpdate();
	}
	
	public static void updateName(String newName, int foodID) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(Update_Name);
		ps.setString(1, newName);
		ps.setInt(2, foodID);
		ps.executeUpdate();
	}
}
