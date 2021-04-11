import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DietManager {

    // 1. A
    public static boolean hasOnlyVeganFood(List<Food> foods){return true;}
    //1. B and C // internal methods, used for other methods... maybe not needed
    public static void setDietVegan(Diet diet){}
    public static void setDietNotVegan(Diet diet){}
    // 1. D
    public static void checkPreferredMeat(Food preferredMeat){}
    // 1. E
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
    public static void calculateAllowedFood(List<Food> allowedFood){}
    //4. A
    public boolean areCompatible(Person person, Diet diet) { return true; }
    //4. B
    public boolean randomDiet(Person person, List<Food> foods) {
        return false;
    }




    public static void main(String[] args) {

        List<Food> list = new ArrayList<>();
        list.add(new Food("Meat",1000f,true,FoodType.CARB));
        Person per1 = new Person(new Food("Meat",1000f,true, FoodType.CARB),list,new LowCarbDiet(10,"SUP",list, true,100f),100);
    }



    //        if (diet.getClass().getName().equals("LowCarbDiet")) System.out.println("found");


}
