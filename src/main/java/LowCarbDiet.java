import java.util.List;

public class LowCarbDiet extends Diet{
    private float minWeightKg;

    public LowCarbDiet(int daysDuration, String purpose, List<Food> allowedFood, boolean isVegan, float minWeightKg) {
        super(daysDuration, purpose, allowedFood, isVegan);
        checkCarbCount();
        this.minWeightKg = minWeightKg;

    }

    public void checkCarbCount(){
        if (getAllowedFood().stream().filter(e -> e.getType().equals(FoodType.CARB)).count() > 2)
            throw new IllegalArgumentException("Cannot exeed more than 2 foods that are of carb types");
    }

    public float getMinWeightKg() {
        return minWeightKg;
    }

    public void setMinWeightKg(float minWeightKg) {
        this.minWeightKg = minWeightKg;
    }
}
