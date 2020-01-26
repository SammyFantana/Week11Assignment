package app;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import dao.FoodDao;
import plugs.FoodInfo;



public class Menu {
	
	private FoodDao foodDao;
	private Scanner scanner = new Scanner(System.in);
	private List<String> options = Arrays.asList(
			"Whole Menu",
			"Breakfast Items",
			"Lunch Items",
			"Dinner Items",
			"Desert Items",
			"Remove Item",
			"Update Item Name",
			"Create Item");
	
	public void start() throws SQLException {
		String selection = " ";
		
		do {
			printMenu();
			selection = scanner.nextLine();
			
			if (selection.equals("1")) {
				displayAllFood();
			} else if (selection.equals("2")) {
				displayBreakfast();
			} else if (selection.equals("3")) {
				displayLunch();
			} else if (selection.equals("4")) {
				displayDinner();
			} else if (selection.equals("5")) {
				displayDesert();
			} else if (selection.equals("6")) {
				deleteItem();
			} else if (selection.equals("7")) {
				updateItem();
			} else if (selection.equals("8")) {
				createItem();
			}
			
		} while (!selection.equals("done"));
		
	}



	private void updateItem() throws SQLException {
		System.out.println("Please Enter the Id of the item you would like to change the name of:");
		int foodID = Integer.parseInt(scanner.nextLine());
		System.out.println("Please Enter the Name you would like to change it to:");
		String newName = scanner.nextLine();
		
		FoodDao.updateName(newName, foodID);
		
		System.out.println("Name has been updated");
	}



	private void deleteItem() throws SQLException {
		System.out.println("Please Enter the ID of the Item you would like to delete:");
		int foodID = Integer.parseInt(scanner.nextLine());
		FoodDao.removeMeal(foodID);
		System.out.println("Item has been removed.");
	}



	private void createItem() throws SQLException {
		System.out.println("Please Enter Name of Food: ");
		String food_name = scanner.nextLine();
		System.out.println("Please Enter Type of Food (Breakfast, Lunch, Dinner, Desert) :");
		String type = scanner.nextLine();
		System.out.println("Please Enter Ethnicity of Food:");
		String ethnicity = scanner.nextLine();
		System.out.println("Please Enter Meats Included in Food:");
		String meat = scanner.nextLine();
		System.out.println("Please Enter Veggies Included in Food:");
		String veggies = scanner.nextLine();
		System.out.println("Please Enter Fruits Included in Food:");
		String fruits = scanner.nextLine();
		System.out.println("Please Enter Sweets Included in Food:");
		String sweets = scanner.nextLine();
		
		FoodDao.createNewFood(food_name, type, ethnicity, meat, veggies, fruits, sweets);
		
	}



	private void displayDesert() throws SQLException {
		List<FoodInfo> foods = FoodDao.getDeserts();
		for (FoodInfo food : foods) {
			System.out.println(food.getID() + " | " + food.getFood_name() + " | " + food.getType() + " | " + food.getEthnicity() + " | " + food.getMeat() + " | " + food.getVeggies() + " | " + food.getFruits() + " | " + food.getSweets());
		}
	}


	private void displayDinner() throws SQLException {
		List<FoodInfo> foods = FoodDao.getDinner();
		for (FoodInfo food : foods) {
			System.out.println(food.getID() + " | " + food.getFood_name() + " | " + food.getType() + " | " + food.getEthnicity() + " | " + food.getMeat() + " | " + food.getVeggies() + " | " + food.getFruits() + " | " + food.getSweets());
		}
	}


	private void displayLunch() throws SQLException {
		List<FoodInfo> foods = FoodDao.getLunch();
		for (FoodInfo food : foods) {
			System.out.println(food.getID() + " | " + food.getFood_name() + " | " + food.getType() + " | " + food.getEthnicity() + " | " + food.getMeat() + " | " + food.getVeggies() + " | " + food.getFruits() + " | " + food.getSweets());
		}
	}


	private void displayBreakfast() throws SQLException {
		List<FoodInfo> foods = FoodDao.getBreakfast();
		for (FoodInfo food : foods) {
			System.out.println(food.getID() + " | " + food.getFood_name() + " | " + food.getType() + " | " + food.getEthnicity() + " | " + food.getMeat() + " | " + food.getVeggies() + " | " + food.getFruits() + " | " + food.getSweets());
		}
	}


	private void displayAllFood() throws SQLException {
		List<FoodInfo> foods = FoodDao.getAllFoods();
		for (FoodInfo food : foods) {
			System.out.println(food.getID() + " | " + food.getFood_name() + " | " + food.getType() + " | " + food.getEthnicity() + " | " + food.getMeat() + " | " + food.getVeggies() + " | " + food.getFruits() + " | " + food.getSweets());
		}
	}


	private void printMenu() {
		System.out.println("Please Select an Option: \n===========================================");
		for (int i = 0; i < options.size(); i++) {
			System.out.println(i + 1 + ") " + options.get(i));
		}
		
	}

}
