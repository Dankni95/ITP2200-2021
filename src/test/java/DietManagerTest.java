import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DietManagerTest {
    List<Food> allowedFoods, allergies, nonAllergicAllowedFoods;
    Food favorteFood, food1, food2, food3, food4, food5, food6;
    Person randomPerson;
    DietManager manager;
    Diet diet1;
    Diet diet2;
    HypercaloricDiet randomDiet;

    @BeforeEach
    public void setupAll() {
        favorteFood = new Food("Raw-cake", 100, false, FoodType.FAT);
        food1 = new Food("Mais", 150, true, FoodType.PROTEIN);
        food2 = new Food("Brokkoli", 150, true, FoodType.PROTEIN);
        food3 = new Food("Gulrøtter", 150, true, FoodType.PROTEIN);
        food4 = new Food("Agurk", 150, true, FoodType.PROTEIN);
        food5 = new Food("Kjøttkaker", 150, false, FoodType.PROTEIN);
        food6 = new Food("Ribbe", 150, false, FoodType.PROTEIN);

        allergies = new ArrayList<>(List.of(food1, food2, food3));
        allowedFoods = new ArrayList<>(List.of(food1, food4, food5));
        nonAllergicAllowedFoods = new ArrayList<>(List.of(food4, food5));


        randomPerson = new Person(favorteFood, allergies, 50);
        manager = new DietManager();
        randomDiet = manager.randomDiet(randomPerson, allowedFoods);

        diet1 = new LowCarbDiet(30, "something", allowedFoods, false, 50);
        diet2 = new LowCarbDiet(30, "something", allowedFoods, false, 60);
    }

    //Person and diet is compatible
    @Test
    public void testAreCompatible_1a() {
        assertTrue(manager.areCompatible(randomPerson, diet1));
    }

    //Person and diet is not compatible
    @Test
    public void testAreCompatible_1b() {
        assertFalse(manager.areCompatible(randomPerson, diet2));
    }

    @Test
    public void testRandomDiet(){
            assertTrue(randomDiet instanceof HypercaloricDiet);
            assertTrue(1 <= randomDiet.getDaysDuration() && randomDiet.getDaysDuration() <= 100);
            assertEquals("Random diet", randomDiet.getPurpose());
            assertFalse(randomDiet.isVegan());
            assertEquals(nonAllergicAllowedFoods, randomDiet.getAllowedFood());
            assertTrue(50 <= randomDiet.getMaxWeightKg() && randomDiet.getMaxWeightKg() <= 70);
            assertTrue(2000 <= randomDiet.getMinCaloriesPerDay() && randomDiet.getMinCaloriesPerDay() <= 4000);
    }
}