import java.util.List;

public class VeganDiet extends Diet{
    private float minWeightKg;

    public VeganDiet(int daysDuration, String purpose, List<Food> allowedFood, boolean isVegan, float minWeightKg) {
        super(daysDuration, purpose, allowedFood, isVegan);
        this.minWeightKg = minWeightKg;
        restrictOnlyVeganFood(allowedFood);
    }

    public void restrictOnlyVeganFood(List<Food> allowedFood){
        for (Food food: allowedFood) {
            if (!food.isVegan()) {
                throw new IllegalArgumentException("You can not include non-vegan food in veganDiet");
            }
        }
    }

    public float getMinWeightKg() {
        return minWeightKg;
    }
}
