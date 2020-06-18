package by.training.homework3.creator;

import by.training.homework3.entity.Basket;
import by.training.homework3.exception.UserException;
import by.training.homework3.validator.BasketValidator;

public class BasketCreator {
    public Basket createBasket(int volume, int capacity, double weight) throws UserException {
        BasketValidator validator = new BasketValidator();

        if (!validator.validateBasket(capacity, volume, weight)) {
            throw new UserException("Incorrect data ...");
        }
        return new Basket(volume, capacity, weight);
    }
}
