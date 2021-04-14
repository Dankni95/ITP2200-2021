import java.util.List;

public class Person {
    private Food favoriteFood;
    private List<Food> allergies;
    private Diet diet;
    private float weight;

    /*
    Forslag:
        - to constructors:
            1. setter alle fire attributter. Diet bruker setDiet-metode
            2. setter kun tre attributter, ekskluderer Diet
        - setDiet
            skal ha en check-metode

     */

    public Person(Food favoriteFood, List<Food> allergies, Diet diet, float weight) {
        this.favoriteFood = favoriteFood;
        this.allergies = allergies;
        this.weight = weight;
        compatibilityValidator(favoriteFood, allergies, diet, weight);
        this.diet = diet;
    }

    public void compatibilityValidator(Food favoriteFood, List<Food> allergies, Diet diet, float weight){

        if (!isVeganDietCompatible(diet, favoriteFood)){
            throw new IllegalArgumentException("Cannot follow the VeganDiet, because favorite foods is non-vegan");
        }
        if(!isNotTooAllergic(diet, allergies)){
            throw new IllegalArgumentException("Cannot follow the diet, because allergic to 50% or more of the food allowed by the diet");
        }
        if (!isMinWeightCompatible(diet)){
            throw new IllegalArgumentException("Cannot follow the diet(VeganDiet or LowCarbDiet), because the persons weight is too low");
        }
        if (!isMaxWeightCompatible(diet)){
            throw new IllegalArgumentException("Cannot follow the HypercaloricDiet, because the persons weight is too high");
        }
    }

    public boolean isVeganDietCompatible(Diet d, Food favoriteFood){
        if (!favoriteFood.isVegan() && d instanceof VeganDiet)
            return false;
        return true;
    }

    public boolean isNotTooAllergic(Diet diet, List<Food> allergies ){
        double numberOfAllergicMatch = 0;
        double numberOfAllowedFood = diet.getAllowedFood().size();

        for (Food allergyFood : allergies) {
            for (Food dietFood: diet.getAllowedFood()) {
                if(allergyFood.getName().equals(dietFood.getName()))
                    numberOfAllergicMatch++;
            }
        }
        return !(numberOfAllergicMatch / numberOfAllowedFood * 100 >= 50);
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

    public boolean maxPersonWeight(Diet d){
        if (d instanceof HypercaloricDiet){
            HypercaloricDiet h = (HypercaloricDiet)d;
            if (h.getMaxWeightKg() < weight){
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

    public void setDiet(Diet diet) {
        this.diet = diet;
    }

    public float getWeightKg() {
        return weight;
    }

    public void setWeightKg(float weight) {
        this.weight = weight;
    }


}