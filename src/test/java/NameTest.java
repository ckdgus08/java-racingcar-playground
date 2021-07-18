import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class NameTest {

    @ParameterizedTest
    @ValueSource(strings = {"pobi", "crong"})
    void create(String input) {
        Name name = new Name(input);
        assertThat(name).isEqualTo(new Name(input));
    }

    @ParameterizedTest
    @ValueSource(strings = {"", " "})
    @DisplayName("자동차이름은 공백이 올 수 없다.")
    void validEmpty(String input) {
        assertThatThrownBy(
                () -> new Name(input)
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"123456", "crongc"})
    @DisplayName("6글자 이상 되는 단어는 자동차이름이 될 수 없다.")
    void validLength(String input) {
        assertThatThrownBy(
                () -> new Name(input)
        ).isInstanceOf(IllegalArgumentException.class);
    }
}
