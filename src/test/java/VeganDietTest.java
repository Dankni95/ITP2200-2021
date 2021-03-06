import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class VeganDietTest {
    List<Food> listWithNonVeganFood;
    Food failedVeganFood1, failedVeganFood2, failedVeganFood3, failedVeganFood4, failedVeganFood5;

    @BeforeEach
    public void setupAll() {
        failedVeganFood1 = new Food("Vegan-lasagne", 100, true, FoodType.RECIPE);
        failedVeganFood2 = new Food("Falafel", 100, true, FoodType.CARB);
        failedVeganFood3 = new Food("Chickpea", 100, true, FoodType.PROTEIN);
        failedVeganFood4 = new Food("Meat-mince", 100, false, FoodType.PROTEIN);
        failedVeganFood5 = new Food("Chocolate-Milk", 50, true, FoodType.PROTEIN);

        listWithNonVeganFood = List.of(failedVeganFood1, failedVeganFood2, failedVeganFood3, failedVeganFood4, failedVeganFood5);
    }
        @Test
        public void shouldThrowErrorWhenVeganDietHasNonVeganFood(){
            try {
                new VeganDiet(30, "weight-loss", listWithNonVeganFood, true, 50);
            }catch (IllegalArgumentException e){
                assertEquals("You can not include non-vegan food in veganDiet", e.getMessage());
            }
        }
    }

