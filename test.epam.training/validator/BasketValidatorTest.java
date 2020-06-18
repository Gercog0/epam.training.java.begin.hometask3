package validator;

import by.training.homework3.validator.BasketValidator;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class BasketValidatorTest {
    BasketValidator basketValidator;

    @BeforeClass
    public void setUp() {
        basketValidator = new BasketValidator();
    }

    @Test
    public void validateBasketValid() {
        int volume = 100;
        int capacity = 15;
        double weight = 200;
        boolean condition = basketValidator.validateBasket(capacity, volume, weight);
        assertTrue(condition);
    }

    @Test
    public void validateBasketInvalid() {
        int volume = -20;
        int capacity = 0;
        double weight = 5555;
        boolean condition = basketValidator.validateBasket(capacity, volume, weight);
        assertFalse(condition);
    }

    @Test
    public void isPossibleAddBallValid(){

    }

    @Test
    public void isPossibleAddBallInvalid(){

    }

    @Test
    public void isPossibleAddBallException(){

    }

    @AfterClass
    public void tierDown() {
        basketValidator = null;
    }
}
