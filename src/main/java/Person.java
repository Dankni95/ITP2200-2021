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

    public boolean minPersonWeight(Diet diet, float weight){return false;}
    public boolean maxPersonWeight(Diet diet, float weight){return false;}

    public boolean isPersonTooAllergic(Diet diet, List<Food> allergies){return true;}

    public boolean isPersonFavoriteFoodVegan(Diet diet, Food favoriteFoods){return false;}

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

