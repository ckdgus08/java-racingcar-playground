import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PositionTest {

    @Test
    void create() {
        Position zero = new Position();
        Position one = new Position(1);
        assertThat(zero).isEqualTo(new Position(0));
        assertThat(one).isEqualTo(new Position(1));
    }

    @Test
    @DisplayName("거리는 음수가 될 수 없다.")
    void validMinus() {
        assertThatThrownBy(
                () -> new Position(-1))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("move함수의 매개변수가 4이상 일때 position이 1 증가한다.")
    void moveMoreThan4() {
        Position position = new Position();
        assertThat(position.addWithRandom(4)).isEqualTo(new Position(1));
    }

    @Test
    @DisplayName("move함수의 매개변수가 3이하 일때 position 유지된다.")
    void moveLessThan4() {
        Position position = new Position();
        assertThat(position.addWithRandom(3)).isEqualTo(new Position(0));
    }
}
