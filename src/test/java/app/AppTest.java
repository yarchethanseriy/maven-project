package app;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AppTest {
    @Test
    void greetShouldReturnGreeting() {
        assertEquals("Привет, Сережа!", App.greet("Сережа"));
    }

    @Test
    void greetShouldThrowExceptionForBlank() {
        assertThrows(IllegalArgumentException.class, () -> {
            App.greet("");
        });
    }

    @Test
    void greetShouldThrowExceptionForNull() {
        assertThrows(NullPointerException.class, () -> {
            App.greet(null);
        });
    }
}