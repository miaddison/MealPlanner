package model;


import java.util.ArrayList;

public interface MealDAO {
	ArrayList<Meal> findAll(); //return all meals
	Meal findById(int id);	// return meal by id
	ArrayList<Meal> createMealListByIds(int[] id); // return meals by multiple id's
	ArrayList<Meal> findSpecNumByRandm(int mealnum); // return x num meals randomly
	// add meal into database
	void enterMealInDatabase(String mealName, ArrayList<String> ingredients, ArrayList<String> directions);
}
