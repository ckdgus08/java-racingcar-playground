package carRacing;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Game {

    private List<Car> cars = new ArrayList<>();

    private int repeatCount;
    private double movePercentage = 0.8;

    public Game(List<Car> cars, int repeatCount) {
        this.cars.addAll(cars);
        this.repeatCount = repeatCount;
    }

    public int getMaxDistance() {
        return cars.stream()
                .map(Car::getDistance)
                .max(Integer::compareTo)
                .orElse(0);

    }

    public List<Car> getWinner() {
        return cars.stream()
                .filter(car -> car.getDistance() == getMaxDistance())
                .collect(Collectors.toList());
    }

    public int getRepeatCount() {
        return repeatCount;
    }

    public double getMovePercentage() {
        return movePercentage;
    }
}
