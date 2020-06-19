package by.training.homework3.service;

import by.training.homework3.entity.Ball;
import by.training.homework3.entity.Basket;
import by.training.homework3.exception.UserException;
import by.training.homework3.validator.BasketValidator;

import java.util.List;

public class BasketService {
    public int calculateQuantityBallsByColor(Basket basket, Ball.Color color) throws UserException {
        if (basket == null) {
            throw new UserException("Incorrect data...");
        }
        int quantity = 0;
        List<Ball> balls = basket.getBalls();

        for (Ball ball : balls) {
            if (ball.getColor() == color) {
                quantity++;
            }
        }
        return quantity;
    }

    public int calculateQuantityBallsBySize(Basket basket, Ball.Size size) throws UserException {
        if (basket == null) {
            throw new UserException("Incorrect data...");
        }
        int quantity = 0;
        List<Ball> balls = basket.getBalls();

        for (Ball ball : balls) {
            if (ball.getSize() == size) {
                quantity++;
            }
        }
        return quantity;
    }

    public int calculateCurrentVolume(Basket basket) throws UserException {
        if (basket == null) {
            throw new UserException("Incorrect data...");
        }
        int currentVolume = 0;
        List<Ball> balls = basket.getBalls();

        for (Ball ball : balls) {
            currentVolume += ball.getSize().getVolume();
        }
        return currentVolume;
    }

    public double calculateCurrentWeight(Basket basket) throws UserException {
        if (basket == null) {
            throw new UserException("Incorrect data...");
        }
        double currentWeight = 0;
        List<Ball> balls = basket.getBalls();

        for (Ball ball : balls) {
            currentWeight += ball.getWeight();
        }
        return currentWeight;

    }

    public int loadBasket(Basket basket, Ball... balls) throws UserException {
        if (basket == null || balls == null) {
            throw new UserException("Incorrect data...");
        }
        BasketValidator validator = new BasketValidator();
        int quantityPlacedBalls = 0;
        for (Ball ball : balls) {
            if (validator.isPossibleAddBall(basket, ball)) {
                basket.putBall(ball);
                quantityPlacedBalls++;
            } else {
                break;
            }
        }
        return quantityPlacedBalls;
    }
}
