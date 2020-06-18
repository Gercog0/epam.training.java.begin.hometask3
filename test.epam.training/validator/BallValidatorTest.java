package validator;

import by.training.homework3.validator.BallValidator;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class BallValidatorTest {
    BallValidator ballValidator;

    @BeforeClass
    public void setUp(){
        ballValidator =  new BallValidator();
    }
    @Test
    public void validateBallValid(){
        double weight = 21;
        boolean condition = ballValidator.validateBall(weight);
        assertTrue(condition);
    }

    @Test
    public void validateBallInvalid(){
        double weight = -21;
        boolean condition = ballValidator.validateBall(weight);
        assertFalse(condition);
    }

    @AfterClass
    public void tierDown(){
        ballValidator = null;
    }

}
