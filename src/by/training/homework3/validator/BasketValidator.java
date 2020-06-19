package by.training.homework3.validator;

import by.training.homework3.entity.Ball;
import by.training.homework3.entity.Basket;
import by.training.homework3.exception.UserException;
import by.training.homework3.service.BasketService;

public class BasketValidator {
    private static final int MAXIMUM_AVAILABLE_CAPACITY_BASKET = 20;
    private static final int MAXIMUM_AVAILABLE_VOLUME_BASKET = 600;
    private static final double MAXIMUM_AVAILABLE_WEIGHT_BASKET = 700;

    public boolean validateBasket(int capacity, int volume, double weight) {
        return isCapacityValid(capacity) && isVolumeValid(volume) && isWeightValid(weight);
    }

    public boolean isPossibleAddBall(Basket basket, Ball ball) throws UserException {
        BasketService service = new BasketService();
        if (basket.getQuantityBallsInBasket() < basket.getCapacity()) {
            if (service.calculateCurrentVolume(basket) + ball.getSize().getVolume() <=
                    basket.getVolume()) {
                if (service.calculateCurrentWeight(basket) + ball.getWeight() <=
                        basket.getWeight()) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean isVolumeValid(int volume) {
        return volume > 0 && volume <= MAXIMUM_AVAILABLE_VOLUME_BASKET;
    }

    private boolean isCapacityValid(int capacity) {
        return capacity > 0 && capacity <= MAXIMUM_AVAILABLE_CAPACITY_BASKET;
    }

    private boolean isWeightValid(double weight) {
        return weight > 0 && weight <= MAXIMUM_AVAILABLE_WEIGHT_BASKET;
    }
}
