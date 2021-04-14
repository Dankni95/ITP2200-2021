import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class VeganDietTest {
    Diet failedVeganDiet;
    List<Food> failedVeganDietFood;
    Food failedVeganFood1, failedVeganFood2, failedVeganFood3, failedVeganFood4, failedVeganFood5;


    @BeforeEach
    public void setupAll() {
        failedVeganFood1 = new Food("Vegan-lasagne", 100, true, FoodType.RECIPE);
        failedVeganFood2 = new Food("Falafel", 100, true, FoodType.CARB);
        failedVeganFood3 = new Food("Chickpea", 100, true, FoodType.PROTEIN);
        failedVeganFood4 = new Food("Meat-mince", 100, false, FoodType.PROTEIN);
        failedVeganFood5 = new Food("Chocolate-Milk", 50, true, FoodType.PROTEIN);

        failedVeganDietFood = List.of(failedVeganFood1, failedVeganFood2, failedVeganFood3, failedVeganFood4, failedVeganFood5);
    }
        @Test
        public void shouldThrowErrorNotVeganFoodInDiet(){

            assertThrows(RuntimeException.class, () -> {
                failedVeganDiet = new VeganDiet(30, "weight-loss", failedVeganDietFood, true, 50);
            });

        }


    }

