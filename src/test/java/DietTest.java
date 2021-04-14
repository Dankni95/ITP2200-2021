import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DietTest {
    private Person veganPerson;
    Diet veganDiet;
    Diet hypercaloricDiet;
    List<Food> veganDietFood;
    List<Food> notVeganDietFood;
    Food veganFood1, veganFood2, veganFood3, veganFood4, veganFood5;
    Food notVeganFood1, notVeganFood2, notVeganFood3, notVeganFood4, notVeganFood5;

    @BeforeEach
    public void setupAll() {


        //Vegan diet
        veganFood1 = new Food("Vegan-lasagne", 100, true, FoodType.RECIPE);
        veganFood2 = new Food("Falafel", 100, true, FoodType.CARB);
        veganFood3 = new Food("Chickpea", 100, true, FoodType.PROTEIN);
        veganFood4 = new Food("Meat-mince", 100, true, FoodType.PROTEIN);
        veganFood5 = new Food("Soy-Milk", 50, true, FoodType.PROTEIN);

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
    public void hasOnlyVeganFood() {

        assertEquals(true, veganDiet.isVegan());


    }
    @Test
    public void shouldPassDueToDietNotVegan() {

        assertEquals(false, hypercaloricDiet.isVegan());
    }

    @Test
    public void shouldWriteOutStringCorrectly(){
        assertAll("Should write out duration correctly",
                () -> assertEquals("This " + veganDiet.getClass().getName() + " lasts for " +
                        veganDiet.calculateDuration().getYears() + " years, " +
                        veganDiet.calculateDuration().getMonths() + " months and " +
                        veganDiet.calculateDuration().getDays() +" days",   veganDiet.writeDuration()),
                () -> assertEquals("This " + hypercaloricDiet.getClass().getName() + " lasts for " +
                        hypercaloricDiet.calculateDuration().getYears() + " years, " +
                        hypercaloricDiet.calculateDuration().getMonths() + " months and " +
                        hypercaloricDiet.calculateDuration().getDays() +" days",   hypercaloricDiet.writeDuration())
        );

    }
    @Test
    public void shouldCalculateDurationCorrectly(){
        assertAll("Should calculate duration correctly",
                () -> assertEquals(Integer.valueOf(0),   veganDiet.calculateDuration().getYears()),
                () -> assertEquals(Integer.valueOf(7),   veganDiet.calculateDuration().getMonths()),
                () -> assertEquals(Integer.valueOf(6),   veganDiet.calculateDuration().getDays())
        );
    }

    @Test
    public void shouldWriteDurationCorrectlyToString(){
        assertAll("Should be correct String when writing out duration",
                () -> assertEquals("This VeganDiet lasts for 0 years, 7 months and 6 days",   veganDiet.writeDuration()),
                () -> assertEquals("This HypercaloricDiet lasts for 0 years, 3 months and 29 days",  hypercaloricDiet.writeDuration())
        );
    }

}