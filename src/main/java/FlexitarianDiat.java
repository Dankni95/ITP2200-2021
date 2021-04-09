import java.util.List;

public class FlexitarianDiat extends Diet {
    private float maxMeatGrams;
    private Food preferredMeat;

    public FlexitarianDiat(int daysDuration, String purpose, List<Food> allowedFood, boolean isVegan, float maxMeatGrams, Food preferredMeat) {
        super(daysDuration, purpose, allowedFood, isVegan);
        this.maxMeatGrams = maxMeatGrams;
        this.preferredMeat = preferredMeat;
    }

    public float getMaxMeatGrams() {
        return maxMeatGrams;
    }

    public void setMaxMeatGrams(float maxMeatGrams) {
        this.maxMeatGrams = maxMeatGrams;
    }

    public Food getpreferredMeat() {
        return preferredMeat;
    }

    public void setpreferredMeat(Food preferredMeat) {
        this.preferredMeat = preferredMeat;
    }
}
