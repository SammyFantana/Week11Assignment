package plugs;

public class FoodInfo {

	private int ID;
	private String food_name;
	private String type;
	private String ethnicity;
	private String meat;
	private String veggies;
	private String fruits;
	private String sweets;
	
	public FoodInfo(int iD, String food_name, String type, String ethnicity, String meat, String veggies, String fruits,
			String sweets) {
		super();
		ID = iD;
		this.food_name = food_name;
		this.type = type;
		this.ethnicity = ethnicity;
		this.meat = meat;
		this.veggies = veggies;
		this.fruits = fruits;
		this.sweets = sweets;
	}
	
	
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getFood_name() {
		return food_name;
	}
	public void setFood_name(String food_name) {
		this.food_name = food_name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getEthnicity() {
		return ethnicity;
	}
	public void setEthnicity(String ethnicity) {
		this.ethnicity = ethnicity;
	}
	public String getMeat() {
		return meat;
	}
	public void setMeat(String meat) {
		this.meat = meat;
	}
	public String getVeggies() {
		return veggies;
	}
	public void setVeggies(String veggies) {
		this.veggies = veggies;
	}
	public String getFruits() {
		return fruits;
	}
	public void setFruits(String fruits) {
		this.fruits = fruits;
	}
	public String getSweets() {
		return sweets;
	}
	public void setSweets(String sweets) {
		this.sweets = sweets;
	}
	
}
