import utils.StringUtils;

import java.util.Objects;

public class Name {

    private String name;

    public Name(String name) {
        if (StringUtils.isBlank(name))
            throw new IllegalArgumentException("자동차 이름은 공백이 될 수 없습니다.");
        if (name.length() > 5)
            throw new IllegalArgumentException("자동차 이름은 6글자를 초과할 수 없습니다.");
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Name)) return false;
        Name name1 = (Name) o;
        return Objects.equals(name, name1.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
