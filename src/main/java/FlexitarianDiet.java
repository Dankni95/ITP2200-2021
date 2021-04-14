import java.util.List;

public class FlexitarianDiet extends Diet {
    private float maxMeatGrams;
    private Food preferredMeat;

    public FlexitarianDiet(int daysDuration, String purpose, List<Food> allowedFood, boolean isVegan, float maxMeatGrams, Food preferredMeat) {
        super(daysDuration, purpose, allowedFood, isVegan);
        this.maxMeatGrams = maxMeatGrams;
        this.preferredMeat = preferredMeat;
        checkPreferredMeat();
    }

    public void checkPreferredMeat(){

            if (preferredMeat.isVegan() || !preferredMeat.getType().equals(FoodType.PROTEIN)) {
                throw new IllegalArgumentException("The preferred meat in a FlexitarianDiet MUST be non-vegan food of protein type.");

        }
    }

    public float getMaxMeatGrams() {
        return maxMeatGrams;
    }

    public void setMaxMeatGrams(float maxMeatGrams) {
        this.maxMeatGrams = maxMeatGrams;
    }

    public Food getPreferredMeat() {
        return preferredMeat;
    }

    public void setPreferredMeat(Food preferredMeat) {
        this.preferredMeat = preferredMeat;
    }
}
