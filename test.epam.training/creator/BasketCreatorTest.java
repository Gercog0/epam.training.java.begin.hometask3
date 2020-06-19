package creator;

import by.training.homework3.creator.BasketCreator;
import by.training.homework3.entity.Basket;
import by.training.homework3.exception.UserException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class BasketCreatorTest {
    BasketCreator basketCreator = new BasketCreator();

    @BeforeClass
    public void setUp() {
        basketCreator = new BasketCreator();
    }

    @Test
    public void createBasketValid() {
        try {
            Basket expected = new Basket(100, 10, 200);
            Basket actual = basketCreator.createBasket(100, 10, 200);
            assertEquals(expected, actual);
        } catch (UserException exp) {
            fail("Exception...");
        }
    }

    @Test
    public void createBasketInvalid() {
        try {
            Basket expected = new Basket(10, 3, 200);
            Basket actual = basketCreator.createBasket(100, 10, 200);
            assertNotEquals(expected, actual);
        } catch (UserException exp) {
            fail("Exception...");
        }
    }

    @Test(expectedExceptions = UserException.class)
    public void createBasketException() throws UserException {
        basketCreator.createBasket(-10, 0, 200);
    }

    @AfterClass
    public void tierDown() {
        basketCreator = null;
    }
}
