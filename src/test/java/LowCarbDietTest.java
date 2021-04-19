import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

class LowCarbDietTest {
    List<Food> lowCarbDietFoodTooManyCarbs, lowCarbDietFoodInRangeForCarbs;
    Food lowCarbFood1, lowCarbFood2, lowCarbFood3, lowCarbFood4, lowCarbFood5, lowCarbFood6;

    @BeforeEach
    public void setupAll() {
        lowCarbFood1 = new Food("Vegan-lasagne", 100, true, FoodType.RECIPE);
        lowCarbFood2 = new Food("Falafel", 100, true, FoodType.CARB);
        lowCarbFood3 = new Food("Chicken", 100, false, FoodType.PROTEIN);
        lowCarbFood4 = new Food("Meat-mince", 100, true, FoodType.CARB);
        lowCarbFood5 = new Food("Soy-Milk", 50, true, FoodType.CARB);
        lowCarbFood6 = new Food("Chickenwings", 50, true, FoodType.PROTEIN);

        lowCarbDietFoodTooManyCarbs = List.of(lowCarbFood1, lowCarbFood2, lowCarbFood3, lowCarbFood4, lowCarbFood5);
    }
    @Test
    public void shouldThrowErrorIfTooManyCarbFoodTypes(){
        assertThrows(RuntimeException.class, () -> new LowCarbDiet(12, "Restrict-carbs", lowCarbDietFoodTooManyCarbs, false, 50));
    }
    @Test
    public void shouldNotThrowErrorIsInRangeForFoodTypeCarb() {
        lowCarbDietFoodInRangeForCarbs = List.of(lowCarbFood1, lowCarbFood3,lowCarbFood5, lowCarbFood6);
        assertDoesNotThrow(() -> new LowCarbDiet(12, "Restrict-carbs", lowCarbDietFoodInRangeForCarbs, false, 50));
    }
}