import java.util.List;

public class Person {
    private Food favoriteFood;
    private List<Food> allergies;
    private Diet diet;
    private float weight;

    public Person(Food favoriteFood, List<Food> allergies, Diet diet, float weight) {
        this.favoriteFood = favoriteFood;
        this.allergies = allergies;
        this.diet = diet;
        this.weight = weight;
        checkCompatibility();
    }
    public void checkCompatibility(){}

    public boolean minPersonWeight(Diet d){
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

    public boolean isPersonTooAllergic(Diet diet, List<Food> allergies){return true;}

    public boolean isVeganDietCompatible(Diet d){
        if (!favoriteFood.isVegan() && d instanceof VeganDiet)
            return false;
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

