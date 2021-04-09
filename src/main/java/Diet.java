public abstract class Diet {
    private int daysDuration;
    private String purpose;
    private Food[] allowedFood;
    private boolean isVegan;

    public String writeDuration(int daysDuration){
        return "Duration in string";
    }
    public String writeAllowedFood(int allowedFood){
        return "return allowed food as string";
    }
}
