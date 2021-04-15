import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class FlexitarianDietTest {
    Diet flexitarianDiet;
    List<Food> flexitarianDietFood;
    Food flexitarianFood1, flexitarianFood2, flexitarianFood3, flexitarianFood4, flexitarianFood5;

    @BeforeEach
    public void setupAll() {
        //Flexitarian diet
        flexitarianFood1 = new Food("Vegan-lasagne", 100, true, FoodType.RECIPE);
        flexitarianFood2= new Food("Falafel", 100, true, FoodType.CARB);
        flexitarianFood3 = new Food("Chicken", 100, false, FoodType.PROTEIN);
        flexitarianFood4 = new Food("Meat-mince", 100, true, FoodType.PROTEIN);
        flexitarianFood5 = new Food("Soy-Milk", 50, true, FoodType.PROTEIN);

        flexitarianDietFood = List.of(flexitarianFood1, flexitarianFood2, flexitarianFood3, flexitarianFood4, flexitarianFood5);
    }
    @Test
    public void shouldThrowErrorNotVeganFoodInDiet(){
        assertThrows(RuntimeException.class, () -> {
            flexitarianDiet = new FlexitarianDiet(30, "Less-Meat", flexitarianDietFood, false, 200, flexitarianFood4);
        });
    }
    @Test
    public void shouldPass() {
        assertDoesNotThrow(() -> flexitarianDiet = new FlexitarianDiet(30, "Less-Meat", flexitarianDietFood, false, 200, flexitarianFood3));
    }
}




