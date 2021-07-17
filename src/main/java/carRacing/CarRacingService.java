package carRacing;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CarRacingService {
    public List<Car> parseCarNamesFromString(String input) {
        return Arrays.stream(input.split(","))
                .map(Car::new)
                .collect(Collectors.toList());
    }
}
