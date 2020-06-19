package validator;

import by.training.homework3.entity.Ball;
import by.training.homework3.entity.Basket;
import by.training.homework3.exception.UserException;
import by.training.homework3.validator.BasketValidator;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class BasketValidatorTest {
    BasketValidator basketValidator;

    @BeforeClass
    public void setUp() {
        basketValidator = new BasketValidator();
    }

    @DataProvider(name = "validData")
    public static Object[][] createCorrectData() {
        return new Object[][]{{new Basket(300, 20, 500),
                new Ball(Ball.Color.BLUE, Ball.Size.MEDIUM, 70)},
                {new Basket(200, 10, 100),
                        new Ball(Ball.Color.BLACK, Ball.Size.SMALL, 30)},
                {new Basket(100, 4, 90),
                        new Ball(Ball.Color.BLUE, Ball.Size.MEDIUM, 80)}};
    }

    @DataProvider(name = "invalidData")
    public static Object[][] createIncorrectData() {
        return new Object[][]{{new Basket(5, 10, 500),
                new Ball(Ball.Color.BLUE, Ball.Size.MEDIUM, 70)},
                {new Basket(200, 1, 10),
                        new Ball(Ball.Color.BLACK, Ball.Size.SMALL, 30)},
                {new Basket(10, 4, 70),
                        new Ball(Ball.Color.BLUE, Ball.Size.MEDIUM, 80)}};
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

    @Test(dataProvider = "validData")
    public void isPossibleAddBallValid(Basket basket, Ball ball) {
        try {
            assertTrue(basketValidator.isPossibleAddBall(basket, ball));
        } catch (UserException exp) {
            fail("Exception...");
        }
    }

    @Test(dataProvider = "invalidData")
    public void isPossibleAddBallInvalid(Basket basket, Ball ball) {
        try {
            assertFalse(basketValidator.isPossibleAddBall(basket, ball));
        } catch (UserException exp) {
            fail("Exception...");
        }
    }

    @AfterClass
    public void tierDown() {
        basketValidator = null;
    }
}
