package carRacing;

import java.util.List;

public class Main {

    static InputService input = new InputService();
    static OutputService output = new OutputService();
    static CarRacingService carRacingService = new CarRacingService();

    public static void main(String[] args) {

        String carNames = input.inputCarNames();
        int repeatCount = input.inputRepeatCount();

        List<Car> cars = carRacingService.parseCarsFromNames(carNames);

        Game game = new Game(cars, repeatCount);

        System.out.println();
        System.out.println("실행결과");
        for (int i = 0; i < game.getRepeatCount(); i++) {

            for (Car car : cars) {
                double random = Math.random();
                car.controllWithTwoValue(random, game.getMovePercentage());
                output.printCarNameAndDistance(car);
            }
            System.out.println();
        }

        List<Car> winner = game.getWinner();
        output.printWinnerList(winner);
    }
}
