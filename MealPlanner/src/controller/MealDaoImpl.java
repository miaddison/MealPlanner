package controller;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.Connection;

import model.Meal;
import model.MealDAO;


public class MealDaoImpl implements MealDAO {
	Connection connection = null;
	PreparedStatement statement = null;
	PreparedStatement statementId = null;
	PreparedStatement statementIng = null;
	PreparedStatement statementDir = null;
	ResultSet rs = null;
	ResultSet rsId = null;
	ResultSet rsIng = null;
	ResultSet rsDir = null;
	
	
	public MealDaoImpl() {
		
	}
	
	private Connection getConnection() throws SQLException{
		Connection conn;
		conn = DBConn.getInstance().getConnection();
		return conn;
	}
	
	@Override
	public ArrayList<Meal> findAll() {
		/*create empty array list of meal objects*/
		ArrayList<Meal> mealList = new ArrayList<>();
		
		try{	
			/*get meal id's and names from meals table*/				
			String sql = "select * from meals";
			connection=getConnection();
			statement = connection.prepareStatement(sql);
			rs = statement.executeQuery();
			
			/*fill array list of meal objects*/
			while (rs.next()){
				/*VARIABLES FOR MEAL OBJECT*/					
				int id;
				String mealname;
				
				ArrayList<String> ingredientList = new ArrayList<String>();
				ArrayList<String> directionList = new ArrayList<String>();
				
				/*obtain id and meal name of meal object*/
				id = rs.getInt("id");
				mealname = rs.getString("mealname");
				//System.out.println("MealName:");
				//System.out.println(mealname);
				/*get ingredients from ingredients table*/
				String sqlIng = "select ingredient from ingredients where id = ?";
				statementIng = connection.prepareStatement(sqlIng);
				statementIng.setInt(1,rs.getInt("id"));
				rsIng = statementIng.executeQuery();
				
				/*place ingredients in array list*/
				while(rsIng.next()){
					String ingredient = rsIng.getString("ingredient");
					ingredientList.add(ingredient);
				}
					
				/*get directions from directions table*/
				String sqlDir = "select direction from directions where id = ?";
				statementDir = connection.prepareStatement(sqlDir);
				statementDir.setInt(1, rs.getInt("id"));
				rsDir = statementDir.executeQuery();
				
				/*place directions in array list*/
				while(rsDir.next()){
					String direction =rsDir.getString("direction");
					directionList.add(direction);
				}
					
				/*create meal object and place in array list*/
				Meal meal = new Meal(id, mealname, ingredientList, directionList);
				mealList.add(meal);
			}
		}catch (SQLException e){
			e.printStackTrace();	
		}
		//System.out.println("find all toString");
		//System.out.println(mealList.toString());
		return mealList;
	}
	
	@Override
	public ArrayList<Meal> findSpecNumByRandm(int mealnum) {
		ArrayList<Meal> rdmMealList = new ArrayList<Meal>();
		ArrayList<Meal> mealList = this.findAll();
		ArrayList<Integer> rdmList = new ArrayList<Integer>();
		for(int i = 0; i < mealnum && i < mealList.size(); i++){
			int rdm;
			do{
				rdm = (int) (Math.random() * mealList.size());
				//out.println("<p>" + rdm + "*</p>");
			}while(rdmList.contains(rdm));
			rdmList.add(rdm);
			Meal meal = new Meal();
			meal = mealList.get(rdm);
			rdmMealList.add(meal);
		}
		return rdmMealList;
	}
	
	@Override
	public Meal findById(int id) {
		ArrayList<Meal> mealList = this.findAll();
		Meal meal = new Meal();
		for(int i = 0; i < mealList.size(); i++){
			if(mealList.get(i).getId() == id){
				meal = mealList.get(i);
			}//else
				// This will print out if meals are deleted
				//System.out.println("no meal found by id");		
		}
		return meal;
	}

	@Override
	public ArrayList<Meal> createMealListByIds(int[] idArray) {
		ArrayList<Meal> selectedMeals = new ArrayList<Meal>();
		Meal meal = new Meal();
		for(int i = 0; i < idArray.length; i++){
			int ID = idArray[i];
			meal = this.findById(ID);
			selectedMeals.add(meal);
		}
		return selectedMeals;	
	}

	@Override
	public void enterMealInDatabase(String mealName, ArrayList<String> ingredients, ArrayList<String> directions) {
		
		try{	
			/*insert meal name into meals table*/				
			String sql = "INSERT INTO meals (mealname) VALUES (?)";
			connection = getConnection();
			statement = connection.prepareStatement(sql);
			statement.setString(1, mealName);
			statement.executeUpdate();
			
			
			// other code //
			//String sqlIng = "select ingredient from ingredients where id = ?";
			//statementIng = connection.prepareStatement(sqlIng);
			//statementIng.setInt(1,rs.getInt("id"));
			//rsIng = statementIng.executeQuery();
			
			
			
			/*obtain id of meal object*/
			String sqlId = "select * from meals where mealname = ?";
			statementId = connection.prepareStatement(sqlId);
			statementId.setString(1, mealName);
			rsId = statementId.executeQuery();
			
			while (rsId.next()){
				int id = rsId.getInt("id");
				
				//System.out.println(id);
				
				/*insert ingredients array in ingredients table*/
				String sqlIng = "INSERT INTO ingredients (id, num, ingredient) VALUES (?, ?, ?)";
				statementIng = connection.prepareStatement(sqlIng);
				statementIng.setInt(1,id);
				
				for(int i = 0; i < ingredients.size(); i++){
					statementIng.setInt(2, (i + 1));
					statementIng.setString(3, ingredients.get(i));
					statementIng.executeUpdate();
				}
				
				/*insert directions array in directions table*/
				String sqlDir = "INSERT INTO directions (id, step, direction) VALUES (?, ?, ?)";
				statementDir = connection.prepareStatement(sqlDir);
				statementDir.setInt(1, id);
				
				for(int i = 0; i < directions.size(); i++){
					statementDir.setInt(2, (i + 1));
					statementDir.setString(3, directions.get(i));
					statementDir.executeUpdate();
				}
			}
		}catch (SQLException e){
			e.printStackTrace();	
		}
	}
}
