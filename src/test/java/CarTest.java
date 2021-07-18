import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    Car pobi;
    Car crong;

    @BeforeEach
    void setUp() {
        pobi = new Car("pobi");
        crong = new Car("crong", 3);
    }

    @Test
    void create() {
        assertThat(pobi).isEqualTo(new Car("pobi", 0));
        assertThat(crong).isEqualTo(new Car("crong", 3));
    }

    @Test
    @DisplayName("move함수의 매개변수가 4이상 일때 position이 1 증가한다.")
    void moveMoreThan4() {
        assertThat(pobi.move(4)).isEqualTo(new Car("pobi", 1));
        assertThat(crong.move(4)).isEqualTo(new Car("crong", 4));
    }

    @Test
    @DisplayName("move함수의 매개변수가 3이하 일때 position 유지된다.")
    void moveLessThan4() {
        assertThat(pobi.move(3)).isEqualTo(new Car("pobi", 0));
        assertThat(crong.move(3)).isEqualTo(new Car("crong", 3));
    }
}
