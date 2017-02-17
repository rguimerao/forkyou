package backend;

/**
 * Class ingredient.
 * An ingredient is a food, a dish is composed by foods, mostly ingredients.
 * An apple is an ingredient, a fruit salad a dish.
 * @author rguimerao
 *
 */
public class Ingredient extends Food {
	
    /**
     * Constructor of ingredient
     * @param name name of the ingredient
     * @param category category of the ingredient
     * @param forSell is this ingredient for sell?
     * @param price price of the ingredient
     * @param creator creator of the ingredient
     */
    public Ingredient(
            final String name, 
            final Category category, 
            final boolean forSell, 
            final float price, 
            final FoodCreator creator) {

        super(name, category, forSell, price, creator);
	}
}
