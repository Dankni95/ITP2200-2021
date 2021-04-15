import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

class LowCarbDietTest {
    Diet lowCarbDiet;
    List<Food> lowCarbDietFood, lowCarbDietFood2;
    Food lowCarbFood1, lowCarbFood2, lowCarbFood3, lowCarbFood4, lowCarbFood5, lowCarbFood6;

    @BeforeEach
    public void setupAll() {
        lowCarbFood1 = new Food("Vegan-lasagne", 100, true, FoodType.RECIPE);
        lowCarbFood2 = new Food("Falafel", 100, true, FoodType.CARB);
        lowCarbFood3 = new Food("Chicken", 100, false, FoodType.PROTEIN);
        lowCarbFood4 = new Food("Meat-mince", 100, true, FoodType.CARB);
        lowCarbFood5 = new Food("Soy-Milk", 50, true, FoodType.CARB);
        lowCarbFood6 = new Food("Chickenwings", 50, true, FoodType.PROTEIN);

        lowCarbDietFood = List.of(lowCarbFood1, lowCarbFood2, lowCarbFood3, lowCarbFood4, lowCarbFood5);
    }
    @Test
    public void shouldThrowErrorNotVeganFoodInDiet(){
        assertThrows(RuntimeException.class, () -> {
            lowCarbDiet = new LowCarbDiet(12, "Restrict-carbs", lowCarbDietFood, false, 50);
        });
    }
    @Test
    public void shouldFail() {
        lowCarbDietFood2 = List.of(lowCarbFood1, lowCarbFood3,lowCarbFood5, lowCarbFood6);
        assertDoesNotThrow(() -> lowCarbDiet = new LowCarbDiet(12, "Restrict-carbs", lowCarbDietFood2, false, 50));
    }
}