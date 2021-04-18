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
