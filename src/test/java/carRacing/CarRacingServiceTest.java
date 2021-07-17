package carRacing;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

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


}