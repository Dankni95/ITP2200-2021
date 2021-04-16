import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DietManager {


    //4. A
    public boolean areCompatible(Person person, Diet diet) {
        if (person.isMaxWeightCompatible(diet) && person.isMinWeightCompatible(diet) && person.isMaxWeightCompatible(diet) && person.isNotTooAllergic(diet))
            return true;
        return false;
    }
    //4. B
    public boolean randomDiet(Person person, List<Food> foods) {

        return false;
    }


}
