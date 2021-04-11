import java.util.List;

public abstract class Diet {
    private int daysDuration;
    private String purpose;
    private List<Food> allowedFood;
    private boolean isVegan;

    public Diet(int daysDuration, String purpose, List<Food> allowedFood, boolean isVegan) {
        this.daysDuration = daysDuration;
        this.purpose = purpose;
        this.allowedFood = allowedFood; // this.allowedFood.add(allowedFood) maybe?
        this.isVegan = isVegan;
        DietManager.hasOnlyVeganFood(allowedFood);
    }

    public String writeDuration(){
        DietManager.calculateDuration(daysDuration);
        return "Duration in string";
    }
    public String writeAllowedFood(){
        DietManager.checkAllowedFood(allowedFood);
        return "return allowed food as string";
    }

    public int getDaysDuration() {
        return daysDuration;
    }

    public void setDaysDuration(int daysDuration) {
        this.daysDuration = daysDuration;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    public List<Food> getAllowedFood() {
        return allowedFood;
    }

    public void setAllowedFood(List<Food> allowedFood) {
        this.allowedFood = allowedFood;
    }

    public boolean isVegan() {
        return isVegan;
    }

    public void setVegan(boolean vegan) {
        isVegan = vegan;
    }
}
