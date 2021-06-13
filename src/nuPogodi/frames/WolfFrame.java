package nuPogodi.frames;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.ArrayList;

public class WolfFrame extends BaseFrame {
    private Direction direction = Direction.BOTTOM_LEFT;

    public WolfFrame() {
        images = new ArrayList<>();
        images.add(new Image("file:assets/frames/wolf-0.png"));
        images.add(new Image("file:assets/frames/wolf-1.png"));
        images.add(new Image("file:assets/frames/wolf-2.png"));
        images.add(new Image("file:assets/frames/wolf-3.png"));

        imageView = new ImageView(images.get(direction.value));
    }

    public Direction getDirection() {
        return direction;
    }

    public void lookRight() {
        if (direction == Direction.TOP_LEFT) direction = Direction.TOP_RIGHT;
        if (direction == Direction.BOTTOM_LEFT) direction = Direction.BOTTOM_RIGHT;
        updateImageView(direction.value);
    }

    public void lookLeft() {
        if (direction == Direction.TOP_RIGHT) direction = Direction.TOP_LEFT;
        if (direction == Direction.BOTTOM_RIGHT) direction = Direction.BOTTOM_LEFT;
        updateImageView(direction.value);
    }

    public void lookUp() {
        if (direction == Direction.BOTTOM_LEFT) direction = Direction.TOP_LEFT;
        if (direction == Direction.BOTTOM_RIGHT) direction = Direction.TOP_RIGHT;
        updateImageView(direction.value);
    }

    public void lookDown() {
        if (direction == Direction.TOP_LEFT) direction = Direction.BOTTOM_LEFT;
        if (direction == Direction.TOP_RIGHT) direction = Direction.BOTTOM_RIGHT;
        updateImageView(direction.value);
    }
}

