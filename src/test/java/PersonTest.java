import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {

    Person pV1, pNV1, pNV2;
    Food fV1, fV2, fV3, fNV1, fNV2, fNV3;
    Diet veganDiet1;
    Diet lowCarbDiet1;
    Diet hypercaloricDate1;

    List<Food> veganDietFood;
    List<Food> dietFood;
    List<Food> allergies;

    @BeforeEach
    public void init(){
        fV1 = new Food("Oat", 100, true, FoodType.CARB);
        fV2 = new Food("Vegan-lasagne", 100, true, FoodType.RECIPE);
        fV3 = new Food("Falafel", 100, true, FoodType.CARB);
        fNV1 = new Food("Chicken", 100, false, FoodType.PROTEIN);
        fNV2 = new Food("Meat-mince", 100, true, FoodType.PROTEIN);
        fNV3 = new Food("Milk", 50, false, FoodType.PROTEIN);
        veganDiet1 = new VeganDiet(30, "weight-loss", veganDietFood, true, 50);
        lowCarbDiet1 = new LowCarbDiet(50, "Weight-loss", dietFood, false, 50);
        hypercaloricDate1 = new HypercaloricDiet(60, "Weight-gain", dietFood, false, 50, 4000);


        pV1 = new Person(fV1, null, lowCarbDiet1, 50);
        pNV1 = new Person(fNV1, allergies, lowCarbDiet1, 75);
        pNV2 = new Person(fV1, null, hypercaloricDate1, 40);

        veganDietFood = new ArrayList<>();
        dietFood = new ArrayList<>();

        veganDietFood = List.of(fV1, fV2, fV3);
        dietFood = List.of(fNV1, fNV2);

    }

    @Test // Vegan favoritefood and vegan-diet
    public void testIsVeganDietCompatible_1a(){
        assertTrue(pV1.isVeganDietCompatible(veganDiet1));
    }
    @Test // Vegan favoritefood and non-vegan-diet
    public void testIsVeganDietCompatible_1b(){
        assertTrue(pV1.isVeganDietCompatible(lowCarbDiet1));
    }
    @Test // Non-vegan favoritefood and vegan-diet
    public void testIsVeganDietCompatible_1c(){
        assertFalse(pNV1.isVeganDietCompatible(veganDiet1));
    }
    @Test // Non-vegan favoritefood and non-vegan-diet
    public void testIsVeganDietCompatible_1d(){
        assertTrue(pNV1.isVeganDietCompatible(lowCarbDiet1));
    }

    @Test // Person weight under min-weight low-carb-diet
    public void testMinPersonWeight_1a(){
        assertFalse(pNV2.minPersonWeight(lowCarbDiet1));
    }
    @Test // Person weight under min-weight vegan-diet
    public void testMinPersonWeight_1b(){
        assertFalse(pNV2.minPersonWeight(veganDiet1));
    }
    @Test // Person over min-weight low-carb-diet
    public void testMinPersonWeight_1c(){
        assertTrue(pNV1.minPersonWeight(lowCarbDiet1));
    }
    @Test // Person over min-weight vegan-diet
    public void testMinPersonWeight_1d(){
        assertTrue(pNV1.minPersonWeight(veganDiet1));
    }
    @Test // Person same weight as vegan-diet
    public void testMinPersonWeight_1e(){
        assertTrue(pV1.minPersonWeight(veganDiet1));
    }

    @Test // Person weight over max-weight hypercaloric-diet
    public void testMaxPersonWeight_1a(){
        assertFalse(pNV1.maxPersonWeight(hypercaloricDate1));
    }
    @Test // person under max-weight hypercaloric-diet
    public void testMaxPersonWeight_1b(){
        assertTrue(pNV2.maxPersonWeight(hypercaloricDate1));
    }






}