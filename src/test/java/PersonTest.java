import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {
    Food food1;
    Food food2;
    Food food3;
    Food food4;
    Food food5;
    Food food6;
    Food food7;
    Food food8;
    Person person1;
    Diet diet1;

    Person pV1, pNV1, pNV2;
    Food fV1, fV2, fV3, fNV1, fNV2, fNV3;
    Diet veganDiet1;
    Diet lowCarbDiet1;
    Diet hypercaloricDate1;

    List<Food> veganDietFood = new ArrayList<>();
    List<Food> dietFoods = new ArrayList<>();
    List<Food> allergies = new ArrayList<>();


    @BeforeEach
    public void init(){
        // Food:
        fV1 = new Food("Oat", 100, true, FoodType.CARB);
        fV2 = new Food("Vegan-lasagne", 100, true, FoodType.RECIPE);
        fV3 = new Food("Falafel", 100, true, FoodType.CARB);
        fNV1 = new Food("Chicken", 100, false, FoodType.PROTEIN);
        fNV2 = new Food("Meat-mince", 100, true, FoodType.PROTEIN);
        fNV3 = new Food("Milk", 50, false, FoodType.PROTEIN);

        food1 = new Food("Mais", 150, true, FoodType.PROTEIN);
        food2 = new Food("Brokkoli", 150, true, FoodType.PROTEIN);
        food3 = new Food("Gulrøtter", 150, true, FoodType.PROTEIN);
        food4 = new Food("Agurk", 150, true, FoodType.PROTEIN);
        food5 = new Food("Kjøttkaker", 150, false, FoodType.PROTEIN);
        food6 = new Food("Ribbe", 150, false, FoodType.PROTEIN);
        food7 = new Food("Pølser", 150, false, FoodType.PROTEIN);
        food8 = new Food("Kylling", 150, false, FoodType.PROTEIN);

        // Diet:
        veganDiet1 = new VeganDiet(30, "weight-loss", veganDietFood, true, 50);
        lowCarbDiet1 = new LowCarbDiet(50, "Weight-loss", dietFoods, false, 50);
        hypercaloricDate1 = new HypercaloricDiet(60, "Weight-gain", dietFoods, false, 50, 4000);

        // Person:
        pV1 = new Person(fV1, allergies, lowCarbDiet1, 50);
        pNV1 = new Person(fNV1, allergies, lowCarbDiet1, 75);
        pNV2 = new Person(fV1, allergies, hypercaloricDate1, 40);

        // FoodArray:
        veganDietFood = new ArrayList<>();
        dietFoods = new ArrayList<>();

        veganDietFood = List.of(fV1, fV2, fV3);
        dietFoods = List.of(fNV1, fNV2);
    }

    // Req 2a
    @Test // Vegan favoritefood and vegan-diet
    public void testIsVeganDietCompatible_1a(){
        Food food = new Food("Oat", 100, true, FoodType.CARB);
        Diet veganDiet = new VeganDiet(30, "weight-loss", null, true, 50);

        Person person = new Person(food, null, lowCarbDiet1, 50);
        assertTrue(pV1.isVeganDietCompatible(veganDiet, person.getFavoriteFood()));
    }

    @Test // Vegan favoritefood and non-vegan-diet
    public void testIsVeganDietCompatible_1b(){
        assertTrue(pV1.isVeganDietCompatible(lowCarbDiet1, pV1.getFavoriteFood()));
    }

    @Test // Non-vegan favoritefood and vegan-diet
    public void testIsVeganDietCompatible_1c(){
        assertFalse(pNV1.isVeganDietCompatible(veganDiet1, pNV1.getFavoriteFood()));
    }
    @Test // Non-vegan favoritefood and non-vegan-diet
    public void testIsVeganDietCompatible_1d(){
        assertTrue(pNV1.isVeganDietCompatible(lowCarbDiet1, pNV1.getFavoriteFood()));
    }

    // Req 2b
    @Test // Person allergic to more than 50% of the allowed foods
    void testIsNotTooAllergic_b1(){
        Food food1 = new Food("Mais", 150, true, FoodType.PROTEIN);
        Food food2 = new Food("Brokkoli", 150, true, FoodType.PROTEIN);
        Food food3 = new Food("Gulrøtter", 150, true, FoodType.PROTEIN);
        Food food4 = new Food("Agurk", 150, true, FoodType.PROTEIN);
        Food food5 = new Food("Kjøttkaker", 150, false, FoodType.PROTEIN);
        Food food6 = new Food("Ribbe", 150, false, FoodType.PROTEIN);

        ArrayList<Food> allergies = new ArrayList<>(List.of(food1, food2, food3));
        ArrayList<Food> allowedFoods = new ArrayList<>(List.of(food1, food2, food4));

        Diet diet = new LowCarbDiet(11, "hh", allowedFoods, true, 75);
        Person person1 = new Person(food1, allergies, diet, 75);

        assertFalse(person1.isNotTooAllergic(diet, person1.getAllergies()));
    }

    @Test // Person allergic to 50% of the allowed foods
    void testIsNotTooAllergic_b2(){
        Food food1 = new Food("Mais", 150, true, FoodType.PROTEIN);
        Food food2 = new Food("Brokkoli", 150, true, FoodType.PROTEIN);
        Food food3 = new Food("Gulrøtter", 150, true, FoodType.PROTEIN);
        Food food4 = new Food("Agurk", 150, true, FoodType.PROTEIN);
        Food food5 = new Food("Kjøttkaker", 150, false, FoodType.PROTEIN);
        Food food6 = new Food("Ribbe", 150, false, FoodType.PROTEIN);

        ArrayList<Food> allergies = new ArrayList<>(List.of(food1, food2));
        ArrayList<Food> allowedFoods = new ArrayList<>(List.of(food1, food3));

        Diet diet = new LowCarbDiet(11, "hh", allowedFoods, true, 75);
        Person person1 = new Person(food1, allergies, diet, 75);

        assertFalse(person1.isNotTooAllergic(diet, person1.getAllergies()));
    }

    @Test // Person allergic to less than 50% of the dietFoods
    void testIsNotTooAllergic_b3(){
        Food food1 = new Food("Mais", 150, true, FoodType.PROTEIN);
        Food food2 = new Food("Brokkoli", 150, true, FoodType.PROTEIN);
        Food food3 = new Food("Gulrøtter", 150, true, FoodType.PROTEIN);
        Food food4 = new Food("Agurk", 150, true, FoodType.PROTEIN);
        Food food5 = new Food("Kjøttkaker", 150, false, FoodType.PROTEIN);
        Food food6 = new Food("Ribbe", 150, false, FoodType.PROTEIN);

        ArrayList<Food> allergies = new ArrayList<>(List.of(food1, food2, food3));
        ArrayList<Food> allowedFoods = new ArrayList<>(List.of(food1, food4, food5));

        Diet diet = new LowCarbDiet(11, "hh", allowedFoods, true, 75);
        Person person1 = new Person(food1, allergies, diet, 75);

        assertTrue(person1.isNotTooAllergic(diet, person1.getAllergies()));
    }


    @Test // Person weight under min-weight low-carb-diet
    public void testMinPersonWeight_1a(){
        assertFalse(pNV2.isMinWeightCompatible(lowCarbDiet1));
    }

    @Test // Person weight under min-weight vegan-diet
    public void testMinPersonWeight_1b(){
        assertFalse(pNV2.isMinWeightCompatible(veganDiet1));
    }

    @Test // Person over min-weight low-carb-diet
    public void testMinPersonWeight_1c(){
        assertTrue(pNV1.isMinWeightCompatible(lowCarbDiet1));
    }

    @Test // Person over min-weight vegan-diet
    public void testMinPersonWeight_1d(){
        assertTrue(pNV1.isMinWeightCompatible(veganDiet1));
    }

    @Test // Person same weight as vegan-diet
    public void testMinPersonWeight_1e(){
        assertTrue(pV1.isMinWeightCompatible(veganDiet1));
    }


    // Req 2b
    @Test // Person weigh less than maxWeight
    void testIsMaxWeightCompatible_1(){
        List<Food> allergies = new ArrayList<>();
        allergies = List.of(food1, food2, food3);

        List<Food> dietFoods = new ArrayList<>();
        allergies = List.of(food8, food4, food5);


        veganDietFood = List.of(fV1, fV2, fV3);
        dietFoods = List.of(fNV1, fNV2);

        diet1 = new LowCarbDiet(11, "hh", dietFoods, true, 75);
        person1 = new Person(food1, allergies, diet1, 60);

        assertTrue(person1.isMaxWeightCompatible(diet1));
    }

    @Test // Person weigh same as maxWeight
    void testIsMaxWeightCompatible_2(){
        ArrayList<Food> allergies = new ArrayList<>();
        allergies.add(food1);
        allergies.add(food2);
        allergies.add(food3);

        ArrayList<Food> dietFoods = new ArrayList<>();
        dietFoods.add(food8);
        dietFoods.add(food4);
        dietFoods.add(food5);

        diet1 = new LowCarbDiet(11, "hh", dietFoods, true, 75);
        person1 = new Person(food1, allergies, diet1, 75);

        assertTrue(person1.isMaxWeightCompatible(diet1));
    }

    @Test // Person weigh more than maxWeight
    void testIsMaxWeightCompatible_3(){
        ArrayList<Food> allergies = new ArrayList<>();
        allergies.add(food1);
        allergies.add(food2);
        allergies.add(food3);

        ArrayList<Food> dietFoods = new ArrayList<>();
        dietFoods.add(food8);
        dietFoods.add(food4);
        dietFoods.add(food5);

        diet1 = new LowCarbDiet(11, "hh", dietFoods, true, 75);
        person1 = new Person(food1, allergies, diet1, 80);

        assertTrue(person1.isMaxWeightCompatible(diet1));
    }

    @Test // Validate VeganDiet when favoritt Foo
    void testCompatibilityValidator(){

    }

}