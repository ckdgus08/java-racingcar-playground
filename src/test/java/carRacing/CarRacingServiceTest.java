package carRacing;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarRacingServiceTest {

    CarRacingService carRacingService;

    /*
- 각 자동차에 이름을 부여할 수 있다.
- 자동차 이름은 6자를 초과할 수 없다.
- 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다.
- 자동차 이름은 쉼표(,)를 기준으로 구분한다.
- 자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다. 우승자는 한명 이상일 수 있다.
    */

    @BeforeEach
    void init() {
        carRacingService = new CarRacingService();
    }

    @ParameterizedTest
    @ValueSource(strings = "pobi,crong,honux")
    void 자동차_이름을_쉼표기준으로_파싱한다(String input) {
        List<Car> cars = carRacingService.parseCarsFromNames(input);
        assertThat(cars.size()).isEqualTo(3);
        assertThat(cars.get(0).getCarName()).isEqualTo("pobi");
        assertThat(cars.get(1).getCarName()).isEqualTo("crong");
        assertThat(cars.get(2).getCarName()).isEqualTo("honux");
    }

    @ParameterizedTest
    @ValueSource(strings = {"coringA", "자동차이름123"})
    void 자동차이름은_6글자를_초과할수없다(String input) {
        assertThatThrownBy(() -> carRacingService.parseCarsFromNames(input))
                .isInstanceOf(RuntimeException.class);
    }

    @Test
    void 자동차를_이동한다() {
        Car car = new Car("pobi");
        int result = car.move();
        int result2 = car.move();
        int result3 = car.move();
        assertThat(result).isEqualTo(1);
        assertThat(result2).isEqualTo(2);
        assertThat(result3).isEqualTo(3);
    }

    @Test
        // pobi : -
        // honux : ---
    void 자동차이름과_이동횟수를_특정형식으로_반환한다() {
        Car car = new Car("pobi");
        car.move();
        car.move();
        String result = Utils.parseCarToNameAndCount(car);
        assertThat(result).isEqualTo("pobi : --");
    }

    @Test
    void 우승자를_구한다() {
        Car pobi = new Car("pobi");
        pobi.move();
        Car crong = new Car("crong");
        crong.move();
        crong.move();
        Car honux = new Car("honux");
        honux.move();
        honux.move();
        List<Car> cars = Arrays.asList(pobi, crong, honux);
        Game game = new Game(cars, 5);

        List<Car> result = game.getWinner();
        assertThat(result.size()).isEqualTo(2);
        assertThat(result).containsExactlyInAnyOrder(crong, honux);
    }


}
