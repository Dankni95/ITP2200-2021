import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


class PersonTest {
    //  constructors with all attributes
    @Test //
    public void testPersonConstructor_a(){
        List<Food> allergies = new ArrayList<>();
        List<Food> allowedFood = new ArrayList<>();
        Food veganFood = new Food("Raw-cake", 100, true, FoodType.FAT);
        allowedFood.add(veganFood);
        Diet veganDiet = new VeganDiet(50, "Weight-loss", allowedFood, true, 50);

        Person person = new Person(veganFood, allergies, veganDiet, 60);

        assertEquals(allergies, person.getAllergies());
        assertEquals(veganDiet, person.getDiet());
        assertEquals(veganFood, person.getFavoriteFood());
        assertEquals(60, person.getWeightKg());
    }

    @Test // constructors without diet-attribute
    public void testPersonConstructor_b(){
        List<Food> allergies = new ArrayList<>();
        Food veganFood = new Food("Raw-cake", 100, true, FoodType.FAT);

        Person person = new Person(veganFood, allergies, 60);

        assertEquals(allergies, person.getAllergies());
        assertNull(person.getDiet());
        assertEquals(veganFood, person.getFavoriteFood());
        assertEquals(60, person.getWeightKg());
    }

    // Setter for Diet
    @Test //
    public void testSetDiet(){
        List<Food> allergies = new ArrayList<>();
        List<Food> allowedFood = new ArrayList<>();
        Food veganFood = new Food("Raw-cake", 100, true, FoodType.FAT);
        allowedFood.add(veganFood);
        Diet veganDiet = new VeganDiet(50, "Weight-loss", allowedFood, true, 50);
        Person person = new Person(veganFood, allergies, 60);

        person.setDiet(veganDiet);

        assertEquals(veganDiet, person.getDiet());
    }

    // Req 2a
    @Test // Vegan favoritefood and vegan-diet
    public void testIsVeganDietCompatible_1a(){
        List<Food> allergies = new ArrayList<>();
        List<Food> allowedFood = new ArrayList<>();
        Food veganFood = new Food("Raw-cake", 100, true, FoodType.FAT);
        allowedFood.add(veganFood);
        Diet veganDiet = new VeganDiet(50, "Weight-loss", allowedFood, true, 50);
        Person person = new Person(veganFood, allergies, veganDiet, 60);

        assertTrue(person.isVeganDietCompatible(veganDiet));
    }

    @Test // Vegan favoritefood and non-vegan-diet
    public void testIsVeganDietCompatible_1b(){
        List<Food> allergies = new ArrayList<>();
        List<Food> allowedFood = new ArrayList<>();
        Food veganFood = new Food("Raw-cake", 100, true, FoodType.FAT);
        Food nonVeganFood = new Food("Meat-mince", 100, false, FoodType.PROTEIN);
        allowedFood.add(nonVeganFood);
        Diet lowCarbDiet = new LowCarbDiet(50, "Weight-loss", allowedFood, false, 50);
        Person person = new Person(veganFood, allergies, lowCarbDiet, 50);

        assertTrue(person.isVeganDietCompatible(lowCarbDiet));
    }

    @Test // Non-vegan favoritefood and vegan-diet
    public void testIsVeganDietCompatible_1c(){
        List<Food> allergies = new ArrayList<>();
        List<Food> allowedFood = new ArrayList<>();
        Food veganFood = new Food("Raw-cake", 100, true, FoodType.FAT);
        Food nonVeganFood = new Food("Meat-mince", 100, false, FoodType.PROTEIN);
        allowedFood.add(veganFood);
        Diet veganDiet = new LowCarbDiet(50, "Weight-loss", allowedFood, false, 50);
        Person person = new Person(nonVeganFood, allergies, veganDiet, 50);

        assertTrue(person.isVeganDietCompatible(veganDiet));
    }
    @Test // Non-vegan favoritefood and non-vegan-diet
    public void testIsVeganDietCompatible_1d(){
        ArrayList<Food> allergies = new ArrayList<>();
        ArrayList<Food> allowedFood = new ArrayList<>();
        Food nonVeganFood = new Food("Meat-mince", 100, false, FoodType.PROTEIN);
        allowedFood.add(nonVeganFood);
        Diet lowCarbDiet = new LowCarbDiet(50, "Weight-loss", allowedFood, false, 50);
        Person person = new Person(nonVeganFood, allergies, lowCarbDiet, 50);

        assertTrue(person.isVeganDietCompatible(lowCarbDiet));
    }

    // Req 2b
    @Test // Person allergic to more than 50% of the allowed foods
    void testIsNotTooAllergic_1a(){
        Food food1 = new Food("Mais", 150, true, FoodType.PROTEIN);
        Food food2 = new Food("Brokkoli", 150, true, FoodType.PROTEIN);
        Food food3 = new Food("Gulrøtter", 150, true, FoodType.PROTEIN);
        Food food4 = new Food("Agurk", 150, true, FoodType.PROTEIN);
        Food food5 = new Food("Tomater", 150, true, FoodType.PROTEIN);
        Food food6 = new Food("Suppe", 150, true, FoodType.PROTEIN);

        ArrayList<Food> allergies = new ArrayList<>(List.of(food1, food2, food3));
        ArrayList<Food> allowedFoods = new ArrayList<>(List.of(food1, food2, food4));
        ArrayList<Food> listOfVeganFood = new ArrayList<>(List.of(food5, food6));

        Diet lowcarbDiet = new LowCarbDiet(11, "hh", allowedFoods, true, 80);
        Diet veganDiet = new VeganDiet(30, "Healthy-lifestyle", listOfVeganFood, true, 80);
        Person person = new Person(food1, allergies, veganDiet, 80);


        assertFalse(person.isNotTooAllergic(lowcarbDiet));

    }

    @Test // Person allergic to 50% of the allowed foods
    void testIsNotTooAllergic_1b(){
        Food food1 = new Food("Mais", 150, true, FoodType.PROTEIN);
        Food food2 = new Food("Brokkoli", 150, true, FoodType.PROTEIN);
        Food food3 = new Food("Gulrøtter", 150, true, FoodType.PROTEIN);
        Food food4 = new Food("Agurk", 150, true, FoodType.PROTEIN);
        Food food5 = new Food("Tomater", 150, true, FoodType.PROTEIN);
        Food food6 = new Food("Suppe", 150, true, FoodType.PROTEIN);

        ArrayList<Food> allergies = new ArrayList<>(List.of(food1, food2));
        ArrayList<Food> allowedFoods = new ArrayList<>(List.of(food1, food3));
        ArrayList<Food> listOfVeganFood = new ArrayList<>(List.of(food5, food6));

        Diet lowcarbDiet = new LowCarbDiet(11, "hh", allowedFoods, true, 80);
        Diet veganDiet = new VeganDiet(30, "Healthy-lifestyle", listOfVeganFood, true, 80);
        Person person = new Person(food1, allergies, veganDiet, 80);

        assertFalse(person.isNotTooAllergic(lowcarbDiet));
    }

    @Test // Person allergic to less than 50% of the dietFoods
    void testIsNotTooAllergic_1c(){
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

        assertTrue(person1.isNotTooAllergic(diet));
    }

    //Req 2c
    @Test // Person weight under min-weight low-carb-diet
    public void testMinPersonWeight_1a(){
        ArrayList<Food> allergies = new ArrayList<>();
        ArrayList<Food> allowedFood = new ArrayList<>();
        Food food = new Food("Meat-mince", 100, false, FoodType.PROTEIN);
        allowedFood.add(food);
        Diet lowCarbDiet = new LowCarbDiet(50, "Weight-loss", allowedFood, false, 50);

        try {
            Person person = new Person(food, allergies, lowCarbDiet, 40);
        }catch (IllegalArgumentException e){
            assertEquals("Cannot follow the diet(VeganDiet or LowCarbDiet), because the persons weight is too low", e.getMessage());
        }

    }

    @Test // Person weight under min-weight vegan-diet
    public void testMinPersonWeight_1b(){
        ArrayList<Food> allergies = new ArrayList<>();
        ArrayList<Food> allowedFood = new ArrayList<>();
        Food food = new Food("Raw-cake", 100, true, FoodType.FAT);
        allowedFood.add(food);
        Diet veganDiet = new VeganDiet(50, "Weight-loss", allowedFood, true, 50);

        try {
            Person person = new Person(food, allergies, veganDiet, 40);
        }catch (IllegalArgumentException e){
            assertEquals("Cannot follow the diet(VeganDiet or LowCarbDiet), because the persons weight is too low", e.getMessage());
        }

    }

    @Test // Person over min-weight low-carb-diet
    public void testMinPersonWeight_1c(){
        ArrayList<Food> allergies = new ArrayList<>();
        ArrayList<Food> allowedFood = new ArrayList<>();
        Food food = new Food("Meat-mince", 100, false, FoodType.PROTEIN);
        allowedFood.add(food);
        Diet lowCarbDiet = new LowCarbDiet(50, "Weight-loss", allowedFood, false, 50);
        Person person = new Person(food, allergies, lowCarbDiet, 60);

        assertTrue(person.isMinWeightCompatible(lowCarbDiet));
    }

    @Test // Person over min-weight vegan-diet
    public void testMinPersonWeight_1d(){
        ArrayList<Food> allergies = new ArrayList<>();
        ArrayList<Food> allowedFood = new ArrayList<>();
        Food food = new Food("Raw-cake", 100, true, FoodType.FAT);
        allowedFood.add(food);
        Diet veganDiet = new VeganDiet(50, "Weight-loss", allowedFood, true, 50);
        Person person = new Person(food, allergies, veganDiet, 60);

        assertTrue(person.isMinWeightCompatible(veganDiet));
    }

    @Test // Person same weight as vegan-diet
    public void testMinPersonWeight_1e(){
        ArrayList<Food> allergies = new ArrayList<>();
        ArrayList<Food> allowedFood = new ArrayList<>();
        Food food = new Food("Raw-cake", 100, true, FoodType.FAT);
        allowedFood.add(food);
        Diet veganDiet = new VeganDiet(50, "Weight-loss", allowedFood, true, 50);
        Person person = new Person(food, allergies, veganDiet, 50);

        assertTrue(person.isMinWeightCompatible(veganDiet));
    }


    // Req 2d
    @Test // Person weigh less than maxWeight
    void testIsMaxWeightCompatible_1a(){
        ArrayList<Food> allergies = new ArrayList<>();
        ArrayList<Food> allowedFood = new ArrayList<>();
        Food food = new Food("Raw-cake", 100, true, FoodType.FAT);
        allowedFood.add(food);
        Diet hypercaloricDiet = new HypercaloricDiet(50, "Gain-weight", allowedFood, true, 75, 3000);
        Person person = new Person(food, allergies, hypercaloricDiet, 40);

        assertTrue(person.isMaxWeightCompatible(hypercaloricDiet));
    }

    @Test // Person weigh same as maxWeight
    void testIsMaxWeightCompatible_1b(){
        ArrayList<Food> allergies = new ArrayList<>();
        ArrayList<Food> allowedFood = new ArrayList<>();
        Food food = new Food("Raw-cake", 100, true, FoodType.FAT);
        allowedFood.add(food);
        Diet hypercaloricDiet = new HypercaloricDiet(50, "Gain-weight", allowedFood, true, 75, 3000);
        Person person = new Person(food, allergies, hypercaloricDiet, 75);

        assertTrue(person.isMaxWeightCompatible(hypercaloricDiet));
    }

    @Test // Person weigh more than maxWeight
    void testIsMaxWeightCompatible_1c(){
        ArrayList<Food> allergies = new ArrayList<>();
        ArrayList<Food> allowedFood = new ArrayList<>();
        Food food = new Food("Raw-cake", 100, true, FoodType.FAT);
        allowedFood.add(food);
        Diet hypercaloricDiet = new HypercaloricDiet(50, "Gain-weight", allowedFood, true, 75, 3000);

        try {
            Person person = new Person(food, allergies, hypercaloricDiet, 80);
        }catch (IllegalArgumentException e){
            assertEquals("Cannot follow the HypercaloricDiet, because the persons weight is too high", e.getMessage());
        }
    }


    @Test //CompatibleValidator
    //Person with non-vegan favoritefood and veganDiet
    void testCompatibilityValidator_1a(){
        ArrayList<Food> allergies = new ArrayList<>();
        ArrayList<Food> allowedFood = new ArrayList<>();
        Food food = new Food("Raw-cake", 100, true, FoodType.FAT);
        Food nonVeganFood = new Food("Meat-mince", 100, false, FoodType.FAT);
        Food veganFood = new Food("Vegan-sausage", 100, true, FoodType.FAT);
        allowedFood.add(veganFood);
        Diet veganDiet = new VeganDiet(30, "Healthy-lifestyle", allowedFood, true, 50);
        Diet lowcarbDiet = new LowCarbDiet(50, "Loose-weight", allowedFood, false, 50);

        try {
            Person person = new Person(nonVeganFood, allergies, veganDiet, 20);
        }catch (IllegalArgumentException e){
            assertEquals("Cannot follow the VeganDiet, because favorite foods is non-vegan", e.getMessage());
        }
    }

    @Test //CompatibleValidator
        //Person with too many allergies
    void testCompatibilityValidator_1b(){
        Food food1 = new Food("Mais", 150, true, FoodType.PROTEIN);
        Food food2 = new Food("Brokkoli", 150, true, FoodType.PROTEIN);
        Food food3 = new Food("Gulrøtter", 150, true, FoodType.PROTEIN);

        ArrayList<Food> allergies = new ArrayList<>(List.of(food1, food2, food3));
        ArrayList<Food> allowedFood = new ArrayList<>(List.of(food1, food2, food3));
        Diet lowcarbDiet = new LowCarbDiet(50, "Loose-weight", allowedFood, false, 50);

        try {
            Person person = new Person(food1, allergies, lowcarbDiet, 20);
        }catch (IllegalArgumentException e){
            assertEquals("Cannot follow the diet, because allergic to 50% or more of the food allowed by the diet", e.getMessage());
        }
    }

    @Test //CompatibleValidator
        //Person with weight under min-weight
    void testCompatibilityValidator_1c(){
        ArrayList<Food> allergies = new ArrayList<>();
        ArrayList<Food> allowedFood = new ArrayList<>();
        Food food = new Food("Raw-cake", 100, true, FoodType.FAT);
        allowedFood.add(food);
        Diet veganDiet = new VeganDiet(30, "Healthy-lifestyle", allowedFood, true, 50);

        try {
            Person person = new Person(food, allergies, veganDiet, 40);
        }catch (IllegalArgumentException e){
            assertEquals("Cannot follow the diet(VeganDiet or LowCarbDiet), because the persons weight is too low", e.getMessage());
        }
    }

    @Test //CompatibleValidator
        //Person with weight over max-weight
    void testCompatibilityValidator_1d(){
        ArrayList<Food> allergies = new ArrayList<>();
        ArrayList<Food> allowedFood = new ArrayList<>();
        Food food = new Food("Raw-cake", 100, true, FoodType.FAT);
        allowedFood.add(food);
        Diet hypercaloricDiet = new HypercaloricDiet(30, "Healthy-lifestyle", allowedFood, true, 80, 3000);

        try {
            Person person = new Person(food, allergies, hypercaloricDiet, 100);
        }catch (IllegalArgumentException e){
            assertEquals("Cannot follow the HypercaloricDiet, because the persons weight is too high", e.getMessage());
        }
    }

    @Test //CompatibleValidator
        //Person compatible with diet/ meets the req for the diet
    void testCompatibilityValidator_1e(){
        ArrayList<Food> allergies = new ArrayList<>();
        ArrayList<Food> allowedFood = new ArrayList<>();
        Food food = new Food("Raw-cake", 100, true, FoodType.FAT);
        allowedFood.add(food);
        Diet veganDiet = new VeganDiet(30, "Healthy-lifestyle", allowedFood, true, 80);
        Person person = new Person(food, allergies, veganDiet, 80);

        assertEquals(veganDiet, person.getDiet());

    }
}