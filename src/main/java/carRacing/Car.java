package carRacing;

public class Car {

    private String carName;
    private int distance;

    public Car(String carName) {
        if (carName.length() > 5)
            throw new RuntimeException("자동차 이름은 6글자를 초과 할 수 없습니다.");
        this.carName = carName;
    }

    public String getCarName() {
        return carName;
    }

    public int move() {
        return ++distance;
    }
}
