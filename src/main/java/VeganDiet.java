import java.util.List;

public class VeganDiet extends Diet{
    private float minWeightKg;

    public VeganDiet(int daysDuration, String purpose, List<Food> allowedFood, boolean isVegan, float minWeightKg) {
        super(daysDuration, purpose, allowedFood, isVegan);
        this.minWeightKg = minWeightKg;
        DietManager.hasOnlyVeganFood(allowedFood);
    }

    public float getMinWeightKg() {
        return minWeightKg;
    }

    public void setMinWeightKg(float minWeightKg) {
        this.minWeightKg = minWeightKg;
    }
}


// wondering if min/max weight should be set by developer in code, not when init object