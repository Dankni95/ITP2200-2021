import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {
    Person person1;

    @BeforeEach
    public void init(){

        person1 = new Person("Harry", 32);

    }


    @Test
    public void getNameTest() {

        assertEquals("Harry", person1.getName());

    }


    @Test
    void setNameTest() {

        person1.setName("Daniel");

        assertEquals("Daniel", person1.getName());

    }

    @Test
    void getAgeTest() {

        assertEquals(32, person1.getAge());

    }

    @Test

    void setAgeTest() {

        person1.setAge(12);

        assertEquals(12, person1.getAge());

    }

}