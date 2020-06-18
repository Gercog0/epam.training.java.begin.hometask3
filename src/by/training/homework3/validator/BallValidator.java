package by.training.homework3.validator;


public class BallValidator {
    private static final double MAXIMUM_WEIGHT_BALL = 90;

    public boolean validateBall(double weight) {
        return weight > 0 && weight <= MAXIMUM_WEIGHT_BALL;
    }

}
