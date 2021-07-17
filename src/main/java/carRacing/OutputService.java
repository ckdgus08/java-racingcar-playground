package carRacing;

import java.util.List;

public class OutputService {

    public void printWinnerList(List<Car> cars) {
        StringBuilder sb = new StringBuilder();

        for (Car car : cars) {
            if (sb.length() > 1)
                sb.append(", ");
            sb.append(car.getCarName());
        }

        sb.append("가 최종 우승했습니다.");
        System.out.println(sb);
    }

    public void printCarNameAndDistance(Car car) {
        String moveResult = Utils.parseCarToNameAndCount(car);
        System.out.println(moveResult);
    }
}
