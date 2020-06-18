package by.training.homework3.creator;

import by.training.homework3.entity.Ball;
import by.training.homework3.exception.UserException;
import by.training.homework3.validator.BallValidator;

import java.util.Random;


public class BallCreator {
    private static final double MAXIMUM_WEIGHT_BALL = 90;
    private static final double MINIMAL_WEIGHT_BALL = 1;

    public Ball createBall(Ball.Color color, Ball.Size size, double weight)
            throws UserException {
        BallValidator validator = new BallValidator();

        if (!validator.validateBall(weight)) {
            throw new UserException("Incorrect data...");
        }
        return new Ball(color, size, weight);
    }

    public Ball generateRandomBall() throws UserException {
        Ball.Color color = Ball.Color.values()[
                new Random().nextInt(Ball.Color.values().length)];
        Ball.Size size = Ball.Size.values()[
                new Random().nextInt(Ball.Size.values().length)];
        double weight = MINIMAL_WEIGHT_BALL + (int) (Math.random() * MAXIMUM_WEIGHT_BALL);

        return createBall(color, size, weight);
    }

    public Ball[] generateBallArray(int quantityBalls) throws UserException {
        if (quantityBalls < 0) {
            throw new UserException("Incorrect data...");
        }
        Ball[] ballArray = new Ball[quantityBalls];

        for (int i = 0; i < ballArray.length; i++) {
            ballArray[i] = generateRandomBall();
        }
        return ballArray;
    }
}
