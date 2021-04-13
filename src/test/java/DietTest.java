import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DietTest {
    private Person veganPerson;
    Diet veganDiet;
    Diet hypercaloricDiet;
    List<Food> veganDietFood;
    List<Food> notVeganDietFood;
    Food veganFood1, veganFood2, veganFood3, veganFood4, veganFood5;
    Food notVeganFood1, notVeganFood2, notVeganFood3, notVeganFood4, notVeganFood5;

    @BeforeEach
    public void setupAll() {


        //Vegan diet
        veganFood1 = new Food("Vegan-lasagne", 100, true, FoodType.RECIPE);
        veganFood2= new Food("Falafel", 100, true, FoodType.CARB);
        veganFood3 = new Food("Chickpea", 100, true, FoodType.PROTEIN);
        veganFood4 = new Food("Meat-mince", 100, true, FoodType.PROTEIN);
        veganFood5 = new Food("Soy-Milk", 50, true, FoodType.PROTEIN);

        veganDietFood = List.of(veganFood1, veganFood2, veganFood3, veganFood4, veganFood5);
        veganDiet = new VeganDiet(30, "weight-loss", veganDietFood, false, 50);
        //Hypercaloric diet/Non-vegan
        notVeganFood1 = new Food("lasagna", 100, false, FoodType.RECIPE);
        notVeganFood2= new Food("pork-chop", 100, false, FoodType.CARB);
        notVeganFood3 = new Food("Chicken-nuggets", 100, false, FoodType.PROTEIN);
        notVeganFood4 = new Food("Beef-mince", 100, false, FoodType.PROTEIN);
        notVeganFood5 = new Food("Milk", 50, false, FoodType.PROTEIN);

        notVeganDietFood = List.of(notVeganFood1, notVeganFood2, notVeganFood3, notVeganFood4, notVeganFood5);
        hypercaloricDiet = new HypercaloricDiet(30, "weight-loss", notVeganDietFood, true, 50, 2000);

        /*
        Food favoriteFood = new Food("Cake", 400, true, FoodType.RECIPE);
        allergy1 = new Food("Cake", 400, true, FoodType.CARB);
        allergy2 = new Food("Nuts", 600, true, FoodType.FAT);
        allergy3 = new Food("Steak", 300, false, FoodType.PROTEIN);
        allergy4 = new Food("Kale", 100, true, FoodType.CARB);

        allergies = List.of(allergy1, allergy2, allergy3, allergy4);

        veganPerson = new Person(favoriteFood, allergies, veganDiet, 70);

         */

        }

    @Test
    public void hasOnlyVeganFood() {

        assertEquals(true, veganDiet.isVegan());


    }
    @Test
    public void shouldPassDueToDietNotVegan() {

        assertEquals(false, hypercaloricDiet.isVegan());
//FAILS EVEN THOUGH IS.VEGAN FOOD IS SET TO FALSE. FAULTY CODE.
    }


}