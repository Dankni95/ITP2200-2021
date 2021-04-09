
public class Food {
    String name;
    float caloriesPer100g;
    boolean isVegan;
    FoodType type;

    public Food(String name, float caloriesPer100g, boolean isVegan, FoodType type) {
        this.name = name;
        this.caloriesPer100g = caloriesPer100g;
        this.isVegan = isVegan;
        this.type = type;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getCaloriesPer100g() {
        return caloriesPer100g;
    }

    public void setCaloriesPer100g(float caloriesPer100g) {
        this.caloriesPer100g = caloriesPer100g;
    }

    public boolean isVegan() {
        return isVegan;
    }

    public void setVegan(boolean vegan) {
        isVegan = vegan;
    }

    public FoodType getType() {
        return type;
    }

    public void setType(FoodType type) {
        this.type = type;
    }


}
