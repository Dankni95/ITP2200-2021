import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;

class LowCarbDietTest {
    Diet lowCarbDiet;
    List<Food> lowCarbDietFood;
    Food lowCarbFood1, lowCarbFood2, lowCarbFood3, lowCarbFood4, lowCarbFood5;

    @BeforeEach
    public void setupAll() {
        //lowCarb diet
        lowCarbFood1 = new Food("Vegan-lasagne", 100, true, FoodType.RECIPE);
        lowCarbFood2 = new Food("Falafel", 100, true, FoodType.CARB);
        lowCarbFood3 = new Food("Chicken", 100, false, FoodType.PROTEIN);
        lowCarbFood4 = new Food("Meat-mince", 100, true, FoodType.CARB);
        lowCarbFood5 = new Food("Soy-Milk", 50, true, FoodType.CARB);

        lowCarbDietFood = List.of(lowCarbFood1, lowCarbFood2, lowCarbFood3, lowCarbFood4, lowCarbFood5);
    }
    @Test
    public void shouldThrowErrorNotVeganFoodInDiet(){

        assertThrows(RuntimeException.class, () -> {
            lowCarbDiet = new LowCarbDiet(12, "Restrict-carbs", lowCarbDietFood, false, 50);
        });

    }
}