import org.example.Main;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MainTest {


        @Test
        void testValidateUsername() {
            Assertions.assertTrue(Main.validateUsername("test@gmail.com"));
            Assertions.assertTrue(Main.validateUsername("test@ymail.com"));

            Assertions.assertFalse(Main.validateUsername("invalid_username"));
            Assertions.assertFalse(Main.validateUsername("test@"));
            Assertions.assertFalse(Main.validateUsername("@example.com"));
        }

        @Test
        void testValidatePassword() {
            Assertions.assertTrue(Main.validatePassword("password123"));

            Assertions.assertFalse(Main.validatePassword(""));
            Assertions.assertFalse(Main.validatePassword("123"));
        }

}
