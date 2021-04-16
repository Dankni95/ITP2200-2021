import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DietManagerTest {
    @Test
    void HypercaloricDiet(){
        int randomNumbBetween1And100 = (int) Math.floor( Math.random() * 100);
        System.out.println(randomNumbBetween1And100);

        float randomMinCaloriesPerDay = (float) Math.floor( Math.random()  * ((4000-2000)+1) + 2000);
        System.out.println(randomMinCaloriesPerDay);
    }

    @Test
    void areCompatible() {
    }

    @Test
    void randomDiet() {
        Food food1 = new Food("Mais", 150, true, FoodType.PROTEIN);
        Food food2 = new Food("Brokkoli", 150, true, FoodType.PROTEIN);
        Food food3 = new Food("Gulrøtter", 150, true, FoodType.PROTEIN);
        Food food4 = new Food("Agurk", 150, true, FoodType.PROTEIN);
        Food food5 = new Food("Kjøttkaker", 150, false, FoodType.PROTEIN);
        Food food6 = new Food("Ribbe", 150, false, FoodType.PROTEIN);

        ArrayList<Food> allergies = new ArrayList<>(List.of(food1, food2, food3));
        ArrayList<Food> allowedFoods = new ArrayList<>(List.of(food1, food4, food5));
        Food food = new Food("Raw-cake", 100, false, FoodType.FAT);
        Diet veganDiet = new LowCarbDiet(30, "Healthy-lifestyle", allowedFoods, false, 80);
        Person person = new Person(food, allergies, 80);


    }
}