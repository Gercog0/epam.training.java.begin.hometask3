package service;

import by.training.homework3.entity.Ball;
import by.training.homework3.entity.Basket;
import by.training.homework3.exception.UserException;
import by.training.homework3.service.BasketService;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class BasketServiceTest {
    BasketService service;

    @BeforeClass
    public void setUp() {
        service = new BasketService();
    }

    @DataProvider(name = "validBasketWithBallsData")
    public static Object[] createBasketWithBallsValid() throws UserException {
        Basket basket = new Basket(200, 5, 200);
        basket.putBall(new Ball(Ball.Color.BLUE, Ball.Size.MEDIUM, 50));
        basket.putBall(new Ball(Ball.Color.BLACK, Ball.Size.MEDIUM, 60));
        basket.putBall(new Ball(Ball.Color.BLUE, Ball.Size.SMALL, 20));
        basket.putBall(new Ball(Ball.Color.WHITE, Ball.Size.SMALL, 10));

        return new Object[]{basket};
    }

    @DataProvider(name = "loadBasketBallsData")
    public static Object[][] createDataToLoadBasket() {
        return new Object[][]{
                {new Basket(100, 5, 300),
                        new Ball[]{new Ball(Ball.Color.BLUE, Ball.Size.SMALL, 80),
                                new Ball(Ball.Color.BLACK, Ball.Size.MEDIUM, 80),
                                new Ball(Ball.Color.GREEN, Ball.Size.LARGE, 80),
                                new Ball(Ball.Color.WHITE, Ball.Size.MEDIUM, 80)}}
        };
    }


    @Test(dataProvider = "validBasketWithBallsData")
    public void calculateQuantityBallsByColorValid(Basket basket) {
        try {
            int expected = 2;
            int actual = service.calculateQuantityBallsByColor(basket, Ball.Color.BLUE);
            assertEquals(expected, actual);
        } catch (UserException exp) {
            fail("Exception...");
        }
    }

    @Test(dataProvider = "validBasketWithBallsData")
    public void calculateQuantityBallsByColorInvalid(Basket basket) {
        try {
            int expected = -20;
            int actual = service.calculateQuantityBallsByColor(basket, Ball.Color.BLUE);
            assertNotEquals(expected, actual);
        } catch (UserException exp) {
            fail("Exception...");
        }
    }

    @Test(expectedExceptions = UserException.class)
    public void calculateQuantityBallsByColorException()
            throws UserException {
        service.calculateQuantityBallsByColor(null, Ball.Color.BLUE);
    }

    @Test(dataProvider = "validBasketWithBallsData")
    public void calculateQuantityBallsBySizeValid(Basket basket) {
        try {
            int expected = 2;
            int actual = service.calculateQuantityBallsBySize(basket, Ball.Size.MEDIUM);
            assertEquals(expected, actual);
        } catch (UserException exp) {
            fail("Exception...");
        }
    }

    @Test(dataProvider = "validBasketWithBallsData")
    public void calculateQuantityBallsBySizeInvalid(Basket basket) {
        try {
            int expected = -5;
            int actual = service.calculateQuantityBallsBySize(basket, Ball.Size.MEDIUM);
            assertNotEquals(expected, actual);
        } catch (UserException exp) {
            fail("Exception...");
        }
    }

    @Test(expectedExceptions = UserException.class)
    public void calculateQuantityBallsBySizeException() throws UserException {
        service.calculateQuantityBallsBySize(null, Ball.Size.MEDIUM);
    }

    @Test(dataProvider = "validBasketWithBallsData")
    public void calculateCurrentVolumeValid(Basket basket) {
        try {
            int expected = 100;
            int actual = service.calculateCurrentVolume(basket);
            assertEquals(expected, actual);
        } catch (UserException exp) {
            fail("Exception...");
        }
    }

    @Test(dataProvider = "validBasketWithBallsData")
    public void calculateCurrentVolumeInvalid(Basket basket) {
        try {
            int expected = -20;
            int actual = service.calculateCurrentVolume(basket);
            assertNotEquals(expected, actual);
        } catch (UserException exp) {
            fail("Exception...");
        }
    }

    @Test(expectedExceptions = UserException.class)
    public void calculateCurrentVolumeException() throws UserException {
        service.calculateCurrentVolume(null);
    }

    @Test(dataProvider = "loadBasketBallsData")
    public void loadBasketValid(Basket basket, Ball[] balls) {
        try {
            int expected = 3;
            int actual = service.loadBasket(basket, balls);
            assertEquals(expected, actual);
        } catch (UserException exp) {
            fail("Exception...");
        }
    }

    @Test(dataProvider = "loadBasketBallsData")
    public void loadBasketInvalid(Basket basket, Ball[] balls) {
        try {
            int expected = 4;
            int actual = service.loadBasket(basket, balls);
            assertNotEquals(expected, actual);
        } catch (UserException exp) {
            fail("Exception...");
        }
    }

    @Test(expectedExceptions = UserException.class)
        public void loadBasketException() throws UserException {
            service.loadBasket(null);
        }

    @AfterClass
    public void tierDown() {
        service = null;
    }
}
