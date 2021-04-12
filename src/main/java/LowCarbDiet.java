import java.util.List;

public class LowCarbDiet extends Diet{
    private float minWeightKg;

    public LowCarbDiet(int daysDuration, String purpose, List<Food> allowedFood, boolean isVegan, float minWeightKg) {
        super(daysDuration, purpose, allowedFood, isVegan);
        checkCarbCount(allowedFood);
        this.minWeightKg = minWeightKg;

    }

    public static void checkCarbCount(List<Food> foods){}

    public float getMinWeightKg() {
        return minWeightKg;
    }

    public void setMinWeightKg(float minWeightKg) {
        this.minWeightKg = minWeightKg;
    }
}
