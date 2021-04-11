import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DietManagerTest {

    @BeforeEach
    void setup(){}


    @Nested
     class Req1_Test{
        @Test
       public void hasOnlyVeganFood() {
        }
        @Test
        void checkPreferredMeat() {
        }

        @Test
        void checkCarbCount() {
        }
    }
    @Nested
     class Req2_Test{
        @Test
        void isPersonFavoriteFoodVegan() {
        }

        @Test
        void isPersonTooAllergic() {
        }

        @Test
        void checkPersonWeight() {
        }
    }
    @Nested
     class Req3_Test{
        @Test
        void calculateDuration() {
    }

        @Test
        void calculateAllowedFood() {
        }
    }
    @Nested
     class Req4_Test{
        @Test
        void areCompatible() {
        }

        @Test
        void randomDiet() {
        }
    }
}