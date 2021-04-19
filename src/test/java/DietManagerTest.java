import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DietManagerTest {
    List<Food> allowedFoods,allergies;
    Food favorteFood, food1, food2, food3, food4, food5, food6;
    Person randomPerson;
    DietManager manager;

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

        randomPerson = new Person(favorteFood, allergies, 50);
        manager = new DietManager();
        randomPerson.setDiet(manager.randomDiet(randomPerson, allowedFoods));
    }


    @Test
    public void shouldNotThrowErrorWhenSettingDiet() {
       assertDoesNotThrow(() ->  randomPerson.setDiet(manager.randomDiet(randomPerson, allowedFoods)));
   }

    @Test
    public void randomWeightShouldBeInRange(){

        assertTrue(50 <= ( (HypercaloricDiet) randomPerson.getDiet()).getMaxWeightKg() &&  ( (HypercaloricDiet) randomPerson.getDiet()).getMaxWeightKg() < 70);
        System.out.println("Max weight: " +( (HypercaloricDiet) randomPerson.getDiet()).getMaxWeightKg());
    }
    @Test
    public void randomCaloriesShouldBeInRange(){

        assertTrue(2000 < ( (HypercaloricDiet) randomPerson.getDiet()).getMinCaloriesPerDay() &&  ( (HypercaloricDiet) randomPerson.getDiet()).getMinCaloriesPerDay() < 4000);
        System.out.println("Calories: " +( (HypercaloricDiet) randomPerson.getDiet()).getMinCaloriesPerDay());
    }
    @Test
    public void randomDurationShouldBeInRange(){

        assertTrue(0 <= ( (HypercaloricDiet) randomPerson.getDiet()).getDaysDuration() &&  ( (HypercaloricDiet) randomPerson.getDiet()).getDaysDuration() < 100);
        System.out.println("Duration: " + ( (HypercaloricDiet) randomPerson.getDiet()).getDaysDuration());
    }
}