import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ContactManagerTest {

    ContactManager manager; // setup, initiate objects before each ... for setup
    Contact contact;

    @Test
    @DisplayName("ContactManager creation")
    @BeforeEach
    public void SetupManager() {
        manager = new ContactManager();

    }
    @Test
    @DisplayName("Contact creation")
    @BeforeEach
    public void SetupContact() {
         contact = new Contact("Daniel", "Lysak", "0226291301");
    }

    @Test
    public void ShouldCreateContactManager() {
        manager.addContact("Daniel", "Lysak", "0226291301");
        Assertions.assertFalse(manager.getAllContacts().isEmpty());
    }

    @Test
    public void ShouldNotCreateWhenFirstNameNull() {
        Assertions.assertThrows(RuntimeException.class, () -> {
            manager.addContact(null, "Lysak", "0226291301");
        });
    }

    @Test
    public void testing() {
        Assertions.assertThrows(RuntimeException.class, () ->
                manager.addContact("Daniel", null, "0226291301"), "Expected null values to throw, but it didn't"
        );

    }
    @Test
    public void ShouldNotCreateWhenAnyNull() {
        Assertions.assertAll("Should return correct details",
                () -> Assertions.assertThrows(RuntimeException.class, () -> manager.addContact("Daniel", null, "0226291301"), "Expected lastName null value to throw, but it didnt"),
                () -> Assertions.assertThrows(RuntimeException.class, () -> manager.addContact(null, "Lysak", "0226291301"), "Expected firstName null value to throw, but it didnt"),
                () -> Assertions.assertThrows(RuntimeException.class, () -> manager.addContact("Daniel", "Lysak", null), "Expected phoneNumber null value to throw, but it didnt")
        );


    }


    @Test
    public void ShouldAllContactDetailsBeEqual() {
        Assertions.assertAll("Should return correct details",
                () -> Assertions.assertEquals("Daniel", contact.getFirstName()),
                () -> Assertions.assertEquals("Lysa", contact.getLastName()),
                () -> Assertions.assertEquals("0226291301", contact.getPhoneNumber())
        );


    }

}