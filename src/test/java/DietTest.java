import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class DietTest {
    Diet veganDiet,hypercaloricDiet;
    List<Food> veganDietFood,notVeganDietFood;
    Food veganFood1, veganFood2, veganFood3, veganFood4, veganFood5;
    Food notVeganFood1, notVeganFood2, notVeganFood3, notVeganFood4, notVeganFood5;

    @BeforeEach
    public void setupAll() {

        //Vegan diet
        veganFood1 = new Food("Vegan-lasagne", 100, true, FoodType.RECIPE);
        veganFood2 = new Food("Falafel", 100, true, FoodType.CARB);
        veganFood3 = new Food("Chickpea", 100, true, FoodType.PROTEIN);
        veganFood4 = new Food("Meat-mince", 100, true, FoodType.PROTEIN);
        veganFood5 = new Food("Soy-milk", 50, true, FoodType.PROTEIN);

        veganDietFood = List.of(veganFood1, veganFood2, veganFood3, veganFood4, veganFood5);
        veganDiet = new VeganDiet(220, "weight-loss", veganDietFood, false, 50);

        //Hypercaloric diet/Non-vegan
        notVeganFood1 = new Food("lasagna", 100, false, FoodType.RECIPE);
        notVeganFood2= new Food("pork-chop", 100, false, FoodType.CARB);
        notVeganFood3 = new Food("Chicken-nuggets", 100, false, FoodType.PROTEIN);
        notVeganFood4 = new Food("Beef-mince", 100, false, FoodType.PROTEIN);
        notVeganFood5 = new Food("Milk", 50, false, FoodType.PROTEIN);

        notVeganDietFood = List.of(notVeganFood1, notVeganFood2, notVeganFood3, notVeganFood4, notVeganFood5);
        hypercaloricDiet = new HypercaloricDiet(120, "weight-loss", notVeganDietFood, true, 50, 2000);

        }

    @Test
    public void shouldPassDietIsVegan() {
        assertTrue(veganDiet.isVegan());
    }
    @Test
    public void shouldPassDueToDietNotVegan() {
        assertFalse(hypercaloricDiet.isVegan());
    }

    @Test
    public void shouldCalculateDurationCorrectly(){
        assertAll("Should calculate duration correctly",
                () -> assertEquals(0,   veganDiet.calculateDuration().getYears()),
                () -> assertEquals(7,   veganDiet.calculateDuration().getMonths()),
                () -> assertEquals(6,   veganDiet.calculateDuration().getDays())
        );
    }
    @Test
    public void shouldWriteDurationCorrectlyToString(){
        assertAll("Should be correct String when writing out duration",
                () -> assertEquals("This VeganDiet lasts for 0 years, 7 months and 6 days",   veganDiet.writeDuration()),
                () -> assertEquals("This HypercaloricDiet lasts for 0 years, 3 months and 29 days",  hypercaloricDiet.writeDuration())
        );
    }
    @Test
    public void shouldWriteAllowedFoodCorrectly(){
        assertAll("Should be correct String output when writing out allowedFood",
                () -> assertEquals("The following food is allowed in this VeganDiet: Vegan-lasagne, Falafel, Chickpea, Meat-mince, Soy-milk",   veganDiet.writeAllowedFood()),
                () -> assertEquals("The following food is allowed in this HypercaloricDiet: Lasagna, Pork-chop, Chicken-nuggets, Beef-mince, Milk",  hypercaloricDiet.writeAllowedFood())
        );
    }

    @Test
    public void shouldFormatAllowedFoodCorrectly(){
        assertAll("Should format allowedFood correct, uppercase first letter + , + space",
                () -> assertEquals("Vegan-lasagne, Falafel, Chickpea, Meat-mince, Soy-milk",   veganDiet.formatAllowedFood()),
                () -> assertEquals("Lasagna, Pork-chop, Chicken-nuggets, Beef-mince, Milk",  hypercaloricDiet.formatAllowedFood())
        );
    }

    @Test
    public void shouldNotThrowErrorWhenVeganDietDoesNotIncludeNonVeganFood() {
        assertDoesNotThrow(() ->  new VeganDiet(30, "weight-loss", veganDietFood, false, 50));
    }

}