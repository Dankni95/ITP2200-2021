import java.util.ArrayList;
import java.util.List;

public class Person {
    private Food favoriteFood;
    private List<Food> allergies;
    private Diet diet;
    private float weight;

    public Person(Food favoriteFood, List<Food> allergies, float weight) {
        this.favoriteFood = favoriteFood;
        this.allergies = allergies;
        this.weight = weight;
    }

    public Person(Food favoriteFood, List<Food> allergies, Diet diet, float weight) {
        this.favoriteFood = favoriteFood;
        this.allergies = allergies;
        this.weight = weight;
        setDiet(diet);
    }

    public void setDiet(Diet diet) {
        compatibilityValidator(diet);
        this.diet = diet;
    }

    public void compatibilityValidator(Diet diet){
        if (!isVeganDietCompatible(diet)){
            throw new IllegalArgumentException("Cannot follow the VeganDiet, because favorite foods is non-vegan");
        }
        if(!isNotTooAllergic(diet)){
            throw new IllegalArgumentException("Cannot follow the diet, because allergic to 50% or more of the food allowed by the diet");
        }
        if (!isMinWeightCompatible(diet)){
            throw new IllegalArgumentException("Cannot follow the diet(VeganDiet or LowCarbDiet), because the persons weight is too low");
        }
        if (!isMaxWeightCompatible(diet)){
            throw new IllegalArgumentException("Cannot follow the HypercaloricDiet, because the persons weight is too high");
        }
    }

    public boolean isVeganDietCompatible(Diet d){
        if (!this.favoriteFood.isVegan() && d instanceof VeganDiet)
            return false;
        return true;
    }

    public boolean isNotTooAllergic(Diet diet){
        double numberOfAllergicMatch = 0;
        double numberOfAllowedFood = diet.getAllowedFood().size();

        for (Food allergyFood : this.allergies) {
            for (Food dietFood: diet.getAllowedFood()) {
                if(allergyFood.getName().equals(dietFood.getName()))
                    numberOfAllergicMatch++;
            }
        }
        return !(numberOfAllergicMatch / numberOfAllowedFood * 100 >= 50);
    }

    public List<Food> getListOfNonAllergicAllowedFood(List<Food> foodArray){
        ArrayList <Food> nonAllergicAllowedFoods = new ArrayList<>();
        List <Food> allowedFoodNotchanged = foodArray;

        for (Food allowedFood : foodArray){
            for (Food allergyFood : this.allergies) {
                if (allowedFood.getName().equals(allergyFood.getName()))
                    allowedFoodNotchanged.remove(allowedFood);
            }
        }
        return allowedFoodNotchanged;
    }


    // If they weigh more than the limit set by the HypercaloricDiet, they cannot be following this diet (for health reasons).
    public boolean isMaxWeightCompatible(Diet diet){
        if(diet instanceof HypercaloricDiet){
            if (this.weight > ( (HypercaloricDiet) diet).getMaxWeightKg())
                return false;
        }
        return true;
    }

    public boolean isMinWeightCompatible(Diet d){
        if (d instanceof LowCarbDiet){
            LowCarbDiet l = (LowCarbDiet)d;
            if (l.getMinWeightKg() > weight){
                return false;
            }
        } if (d instanceof VeganDiet){
            VeganDiet v = (VeganDiet)d;
            if (v.getMinWeightKg() > weight){
                return false;
            }
        }
        return true;
    }

    public List<Food> getAllergies() {
        return allergies;
    }

    public void setAllergies(List<Food> allergies) {
        this.allergies = allergies;
    }

    public Food getFavoriteFood() {
        return favoriteFood;
    }

    public void setFavoriteFood(Food favoriteFood) {
        this.favoriteFood = favoriteFood;
    }

    public Diet getDiet() { return diet; }


    public float getWeightKg() {
        return weight;
    }

    public void setWeightKg(float weight) {
        this.weight = weight;
    }


}