import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorTest {
    @Test
    void testAddition() {
        Calculator calculator = new Calculator();

        assertEquals(15, calculator.add(10, 5));
    }
    @Test
    void testSubtraction() {
        Calculator calculator = new Calculator();

        assertEquals(5, calculator.subtract(10, 5));
    }
    @Test
    void testMultiplecation() {
        Calculator calculator = new calculator();

        assertEquals(25, calculator.multiply);

    }



}





