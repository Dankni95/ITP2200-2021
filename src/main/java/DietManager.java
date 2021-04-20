import java.util.List;
import java.util.Random;

public class DietManager {

    public boolean areCompatible(Person person, Diet diet) {
        if (person.isVeganDietCompatible(diet) && person.isMinWeightCompatible(diet) && person.isMaxWeightCompatible(diet) && person.isNotTooAllergic(diet))
            return true;
        return false;
    }

    public HypercaloricDiet randomDiet(Person person, List<Food> foods) {
        int randomNumbBetween1And100 = getRandomNumber(0,100);
        String purpose = "Random diet";
        List<Food> allowedFood = person.getListOfNonAllergicAllowedFood(foods);
        boolean isVegan = true;
        int personWeightKg = (int) person.getWeightKg();
        float maxWeightFinal = getRandomNumber(personWeightKg,(personWeightKg + 20));
        float randomMinCaloriesPerDay = getRandomNumber(2000,4000);

        return new HypercaloricDiet(randomNumbBetween1And100, purpose, allowedFood, isVegan, maxWeightFinal, randomMinCaloriesPerDay);
    }

    public int getRandomNumber(int min, int max) {
        Random random = new Random();
        return random.ints(min, max)
                .findFirst()
                .getAsInt();
    }

}
