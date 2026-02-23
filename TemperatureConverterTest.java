import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class TemperatureConverterTest {

    TemperatureConverter converter = new TemperatureConverter();

    // 1️⃣ Verify Celsius → Fahrenheit
    @Test
    void testCelsiusToFahrenheit() {
        assertEquals(212.0, converter.celsiusToFahrenheit(100), 0.001);
        assertEquals(32.0, converter.celsiusToFahrenheit(0), 0.001);
    }

    // 2️⃣ Verify Fahrenheit → Celsius
    @Test
    void testFahrenheitToCelsius() {
        assertEquals(100.0, converter.fahrenheitToCelsius(212), 0.001);
        assertEquals(0.0, converter.fahrenheitToCelsius(32), 0.001);
    }

    // 3️⃣ Negative Celsius values
    @Test
    void testNegativeCelsius() {
        assertEquals(14.0, converter.celsiusToFahrenheit(-10), 0.001);
    }

    // 4️⃣ Large Fahrenheit values
    @Test
    void testLargeFahrenheit() {
        assertEquals(537.78, converter.fahrenheitToCelsius(1000), 0.01);
    }

    // 5️⃣ Verify 0°C equals 32°F
    @Test
    void testZeroCelsiusEquals32Fahrenheit() {
        assertEquals(32.0, converter.celsiusToFahrenheit(0), 0.001);
    }
}