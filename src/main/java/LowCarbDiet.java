import java.util.List;

public class LowCarbDiet extends Diet{
    private float minWeightKg;

    public LowCarbDiet(int daysDuration, String purpose, List<Food> allowedFood, boolean isVegan, float minWeightKg) {
        super(daysDuration, purpose, allowedFood, isVegan);
        checkCarbCount(allowedFood);
        this.minWeightKg = minWeightKg;
    }

    public void checkCarbCount(List<Food> allowedFood){
        if (allowedFood.stream().filter(food -> food.getType().equals(FoodType.CARB)).count() > 2)
            throw new IllegalArgumentException("Cannot exceed more than 2 foods that are of carb type");
    }

    public float getMinWeightKg() {
        return minWeightKg;
    }

}
