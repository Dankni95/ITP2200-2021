import java.time.LocalDate;
import java.time.Period;
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
        hasOnlyVeganFood();
    }

    public String writeDuration(){
        return "This " + getClass().getName() + " lasts for " +
                calculateDuration().getYears() + " years, " +
                calculateDuration().getMonths() + " months and " +
                calculateDuration().getDays() +" days";
    }
    public String writeAllowedFood(){
        checkAllowedFood(allowedFood);
        return "return allowed food as string";
    }

    public  void checkAllowedFood(List<Food> allowedFood){}

    public Period calculateDuration(){
        LocalDate parsedDuration = LocalDate.now().plusDays(daysDuration);
        return LocalDate.now().until(parsedDuration);
    }


    public void hasOnlyVeganFood(){
        for (Food food: allowedFood) {
            if (!food.isVegan()) {
                isVegan = false;
                break;
            }
            else isVegan = true;
        }
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
