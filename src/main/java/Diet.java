import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.stream.Collectors;

public abstract class Diet {
    private int daysDuration;
    private String purpose;
    private List<Food> allowedFood;
    private boolean isVegan;

    public Diet(int daysDuration, String purpose, List<Food> allowedFood, boolean isVegan) {
        this.daysDuration = daysDuration;
        this.purpose = purpose;
        this.allowedFood = allowedFood;
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
         return "The following food is allowed in this " + getClass().getName() + ": " + formatAllowedFood();
    }

    public String formatAllowedFood(){

        List<String> allowedFoodNames = allowedFood.stream().map(Food::getName).collect(Collectors.toList());

       return allowedFoodNames.stream()
                .map(foodName -> Character.toUpperCase(foodName.charAt(0)) + foodName.substring(1))
                .collect(Collectors.toList()).toString().substring(1, allowedFoodNames.toString().length() - 1);
    }

    public Period calculateDuration(){
        LocalDate parsedDuration = LocalDate.now().plusDays(daysDuration);
        return LocalDate.now().until(parsedDuration);
    }

    public void hasOnlyVeganFood(){
        for (Food food: allowedFood) {
            if (!food.isVegan()) {
                setVegan(false);
                break;
            }
            else setVegan(true);
        }
    }

    public String getPurpose() {
        return purpose;
    }

    public int getDaysDuration() {
        return daysDuration;
    }

    public List<Food> getAllowedFood() {
        return allowedFood;
    }

    public boolean isVegan() {
        return isVegan;
    }

    public void setVegan(boolean vegan) {
        isVegan = vegan;
    }
}
