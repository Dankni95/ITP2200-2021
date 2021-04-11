import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DietManager {

    // 1. A + B
    public static void hasOnlyVeganFood(List<Food> foods){}
    //1. C
    public static void restrictOnlyVeganFood(List<Food> foods){}
    //1. D
    public static void checkPreferredMeat(Food preferredMeat){}
    //1. E
    public static void checkCarbCount(List<Food> foods){}
    //2. A
    public static void isPersonFavoriteFoodVegan(Diet diet, Food favoriteFoods){} // set diet to vegan/not vegan
    //2. B
    public static void isPersonTooAllergic(Diet diet, List<Food> allergies){}
    //2. C
    public static void checkPersonWeight(Diet diet, float weight){}
    //3. A
    public static LocalDate calculateDuration(int daysDuration){ return LocalDate.now(); }
    //3. B
    public static void checkAllowedFood(List<Food> allowedFood){}
    //4. A
    public boolean areCompatible(Person person, Diet diet) { return true; }
    //4. B
    public boolean randomDiet(Person person, List<Food> foods) {
        return false;
    }

}
