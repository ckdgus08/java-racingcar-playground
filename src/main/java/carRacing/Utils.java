package carRacing;

public class Utils {

    public static String parseCarToNameAndCount(Car car) {
        StringBuilder sb = new StringBuilder();
        sb.append(car.getCarName());
        sb.append(" : ");
        for (int i = 0; i < car.getDistance(); i++) {
            sb.append("-");
        }
        return sb.toString();
    }
}
