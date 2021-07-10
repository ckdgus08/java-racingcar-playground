import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringCalculatorTest {

    StringCalculator stringCalculator;

    @BeforeEach
    public void init() {
        stringCalculator = new StringCalculator();
    }

    @ParameterizedTest
    @CsvSource(value = {"@0", "''@0", "1,2@3", "1,2,3@6", "1,2:3@6"}, delimiter = '@')
    void 쉼표_또는_콜론을_기준으로_분리된_숫자의_합을_반환한다(String input, int expected) {
        //when
        int result = stringCalculator.splitAndSum(input);
        //then
        assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @ValueSource(strings = {"//;\n1;2;3"})
    void 커스텀구분자를_활용하여_계산(String input) {
        //when
        int result = stringCalculator.splitAndSum(input);
        //then
        assertThat(result).isEqualTo(6);
    }

    @ParameterizedTest
    @ValueSource(strings = {"-1,2,3", "@,1,3,//;\n-1;2;3"})
    void 음수_또는_숫자가_아닌_입력을_받으면_에러가_발생한다(String input) {
        //when
        assertThatThrownBy(() -> stringCalculator.splitAndSum(input))
                .isInstanceOf(RuntimeException.class);
    }


}
