package model;


import java.util.ArrayList;

public class Meal {
	// variables
	private int id;
	private String mealname;
	private ArrayList<String> ingredients;	// list of ingredients
	private ArrayList<String> directions;	// steps of directions
	
	// Constructors
	public Meal() {
		
	}
	
	public Meal(int id, String mealname) {
		this.id = id;
		this.mealname = mealname;
	}
	
	public Meal(int id, String mealname, ArrayList<String> directions) {
		this.id = id;
		this.mealname = mealname;
		this.directions = directions;
	}
	public Meal(int id, String mealname, ArrayList <String> ingredients, ArrayList<String> directions) {
		this.id = id;
		this.mealname = mealname;
		this.ingredients = ingredients;
		this.directions = directions;
	}
	
	public Meal(String mealname, ArrayList<String> ingredients, ArrayList<String> directions) {
		this.mealname = mealname;
		this.ingredients = ingredients;
		this.directions = directions;
	}
	// getters and setters
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMealname() {
		return mealname;
	}
	public void setMealname(String mealname) {
		this.mealname = mealname;
	}
	public ArrayList<String> getIngredients() {
		return ingredients;
	}
	public void setIngredients(ArrayList<String> ingredients) {
		this.ingredients = ingredients;
	}

	public ArrayList<String> getDirections() {
		return directions;
	}
	public void setDirections(ArrayList<String> directions) {
		this.directions = directions;
	}
		
}
