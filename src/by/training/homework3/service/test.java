package by.training.homework3.service;

import by.training.homework3.creator.BallCreator;
import by.training.homework3.entity.Ball;
import by.training.homework3.entity.Basket;
import by.training.homework3.exception.UserException;
import by.training.homework3.validator.BasketValidator;


public class test {
    public static void main(String[] args) throws UserException {
        Basket basket = new Basket(900, 21, 700);
        BasketService service = new BasketService();
        BallCreator creator = new BallCreator();
        BasketValidator validator = new BasketValidator();

        System.out.println("________________");


        service.loadBasket(basket,creator.createBall(Ball.Color.BLUE, Ball.Size.MEDIUM, 30),
                creator.generateRandomBall());

        System.out.println(basket.toString());
        System.out.println(service.calculateCurrentWeight(basket));
        System.out.println(service.calculateCurrentVolume(basket));

        System.out.println("-----");


        service.loadBasket(basket, creator.generateBallArray(3));
       System.out.println(validator.validateBasket(20, 900, 701));
       System.out.println(basket.toString());
       System.out.println(service.calculateCurrentWeight(basket));
       System.out.println(service.calculateCurrentVolume(basket));

        System.out.println(service.calculateQuantityBallsByColor(basket, Ball.Color.BLUE));
    }
}
