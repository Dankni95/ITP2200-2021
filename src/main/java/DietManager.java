import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DietManager {


    //4. A
    public boolean areCompatible(Person person, Diet diet) {
        if (person.isVeganDietCompatible(diet) && person.isMinWeightCompatible(diet) && person.isMaxWeightCompatible(diet) && person.isNotTooAllergic(diet))
            return true;
        return false;
    }

    //4. B
    public HypercaloricDiet randomDiet(Person person, List<Food> foods) {
        int randomNumbBetween1And100 = (int) Math.floor( Math.random() * 100);
        String purpose = "Random diet";
        List<Food> allowedFood = person.getListOfNonAllergicAllowedFood(foods);
        boolean isVegan = true;
        float randomMaxWeightKg = (float) Math.floor( Math.random() + person.getWeightKg() * 20);
        float randomMinCaloriesPerDay = (float) Math.floor( Math.random()  * ((4000-2000)+1) + 2000);

        return new HypercaloricDiet(randomNumbBetween1And100, purpose, allowedFood, isVegan, randomMaxWeightKg, randomMinCaloriesPerDay);


    }


}
