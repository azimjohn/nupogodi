package nuPogodi.frames;


import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.ArrayList;

public class EggFrame extends BaseFrame {
    private final Direction direction;
    private final int numOfFrames = 7;
    private int currentFrame = 0;

    public EggFrame(Direction d) {
        direction = d;
        images = new ArrayList<>();

        for (int i = 0; i < numOfFrames; ++i) {
            images.add(new Image("file:assets/frames/rolling-egg/" + d.value + "-" + i + ".png"));
        }

        imageView = new ImageView(images.get(currentFrame));
    }

    public boolean hasNextFrame() {
        return currentFrame < numOfFrames - 1;
    }

    public void nextFrame() {
        updateImageView(++currentFrame);
    }

    public Direction getDirection() {
        return direction;
    }
}
