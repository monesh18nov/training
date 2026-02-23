import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class TemperatureConverterTest {

    TemperatureConverter tempConv = new TemperatureConverter();

    @Test
    void verifyCelsiusToFahrenheit() {
        assertEquals(98.6, tempConv.celsiusToFahrenheit(37), 0.001);
        assertEquals(14.0, tempConv.celsiusToFahrenheit(-10), 0.001);
    }

    @Test
    void verifyFahrenheitToCelsius() {
        assertEquals(37.0, tempConv.fahrenheitToCelsius(98.6), 0.001);
        assertEquals(-10.0, tempConv.fahrenheitToCelsius(14), 0.001);
    }

    @Test
    void verifyZeroCelsius() {
        assertEquals(32.0, tempConv.celsiusToFahrenheit(0), 0.001);
    }

    @Test
    void verifyHighFahrenheitValue() {
        assertEquals(260.0, tempConv.fahrenheitToCelsius(500), 0.01);
    }

    @Test
    void verifyBoilingPoint() {
        assertEquals(212.0, tempConv.celsiusToFahrenheit(100), 0.001);
    }
}
