import java.util.Objects;

public class Position {

    public static final int MOVE_LIMIT = 4;
    private int position;

    public Position() {
        this(0);
    }

    public Position(int position) {
        if (position < 0)
            throw new IllegalArgumentException("거리는 음수가 될 수 없습니다");
        this.position = position;
    }

    public Position move(int random) {
        if (random >= MOVE_LIMIT)
            return new Position(position + 1);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Position)) return false;
        Position position1 = (Position) o;
        return position == position1.position;
    }

    @Override
    public int hashCode() {
        return Objects.hash(position);
    }

}
