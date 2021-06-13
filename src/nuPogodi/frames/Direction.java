package nuPogodi.frames;

public enum Direction {
    TOP_LEFT(0),
    BOTTOM_LEFT(1),
    TOP_RIGHT(2),
    BOTTOM_RIGHT(3);

    public final int value;

    Direction(int value) {
        this.value = value;
    }

    public static Direction random() {
        Direction[] directions = {TOP_LEFT, TOP_RIGHT, BOTTOM_LEFT, BOTTOM_RIGHT};
        int randIndex = (int) (Math.random() * 4);

        return directions[randIndex];
    }
}
