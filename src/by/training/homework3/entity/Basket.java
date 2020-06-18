package by.training.homework3.entity;

import by.training.homework3.exception.UserException;

import java.util.ArrayList;
import java.util.List;

public class Basket {
    private int volume;
    private int capacity;
    private double weight;
    private List<Ball> balls;

    public Basket(int volume, int capacity, double weight) {
        this.volume = volume;
        this.capacity = capacity;
        this.weight = weight;
        this.balls = new ArrayList<>();
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public int getCapacity() {
        return capacity;
    }

    public List<Ball> getBalls() {
        return balls;
    }

    public int getQuantityBallsInBasket() {
        return balls.size();
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public Ball getBallByIndex(int index) {
        return this.balls.get(index);
    }

    public void putBall(Ball ball) throws UserException {
        this.balls.add(ball);
    }

    public void removeBall(Ball ball) throws UserException {
        this.balls.remove(ball);
    }

    public void removeBallsByColor(Ball.Color color) {
        balls.removeIf(ball -> ball.getColor() == color);
    }

    public void removeBallsBySize(Ball.Size size) {
        balls.removeIf(ball -> ball.getSize() == size);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Basket basket = (Basket) o;

        if (volume != basket.volume ||
                capacity != basket.capacity ||
                weight != basket.weight) {
            return false;
        }
        return balls != null ? balls.equals(basket.balls) : basket.balls == null;
    }

    @Override
    public int hashCode() {
        int result = volume;
        result = 31 * result + capacity;
        result = (int) (31 * result + weight);
        result = 31 * result + (balls != null ? balls.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Information about basket:\n");
        sb.append("volume: ").append(volume);
        sb.append(", capacity: ").append(capacity);
        sb.append(", weight: ").append(weight);
        sb.append(", balls: ").append(balls);
        return sb.toString();
    }
}
