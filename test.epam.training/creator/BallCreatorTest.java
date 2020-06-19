package creator;

import by.training.homework3.creator.BallCreator;
import by.training.homework3.entity.Ball;
import by.training.homework3.exception.UserException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class BallCreatorTest {
    BallCreator ballCreator;

    @BeforeClass
    public void setUp() {
        ballCreator = new BallCreator();
    }

    @Test
    public void createBallValid() {
        try {
            Ball expected = new Ball(Ball.Color.BLUE, Ball.Size.SMALL, 80);
            Ball actual = ballCreator.createBall(Ball.Color.BLUE, Ball.Size.SMALL, 80);
            assertEquals(expected, actual);
        } catch (UserException exp) {
            fail("Exception...");
        }
    }

    @Test
    public void createBallInvalid() {
        try {
            Ball expected = new Ball(Ball.Color.BLUE, Ball.Size.MEDIUM, 20);
            Ball actual = ballCreator.createBall(Ball.Color.BLUE, Ball.Size.SMALL, 80);
            assertNotEquals(expected, actual);
        } catch (UserException exp) {
            fail("Exception...");
        }
    }

    @Test(expectedExceptions = UserException.class)
    public void createBallException() throws UserException {
        ballCreator.createBall(Ball.Color.BLUE, Ball.Size.SMALL, -20);
    }

    @AfterClass
    public void tierDown() {
        ballCreator = null;
    }
}
