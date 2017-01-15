package backend;

/**
 * Class drink.
 * A drink is a type of dish made of ingredients and only ingredients.
 * @author rguimerao
 *
 */
public class Drink extends Dish {
	
	/**
	 * Constructor of drink
	 * @param name name of the drink
	 * @param forSell is this drink for sell?
	 * @param price price of the drink
	 * @param creator creator of this drink
	 */
	public Drink(String name, boolean forSell, float price, FoodCreator creator) {
		
		// TODO -> controller get category drinks
		super(name, new Category("drinks"), forSell, price, creator);
		
	}

	/**
	 * Adds an ingredient to the drink
	 * If it is not an ingredient, it won't be added
	 * @param ingredientToAdd ingredient to add to the drink
	 */
	@Override
	public void addFood(Food ingredientToAdd) {
		if (ingredientToAdd instanceof Ingredient) {
			this.composedFoods.add(ingredientToAdd);
		}
	}

}
