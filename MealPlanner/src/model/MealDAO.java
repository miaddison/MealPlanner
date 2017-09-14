package model;


import java.util.ArrayList;

public interface MealDAO {
	ArrayList<Meal> findAll();
	Meal findById(int id);
	ArrayList<Meal> createMealListByIds(int[] id);
	ArrayList<Meal> findSpecNumByRandm(int mealnum);
	void enterMealInDatabase(String mealName, ArrayList<String> ingredients, ArrayList<String> directions);
}
