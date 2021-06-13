package nuPogodi.frames;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import nuPogodi.exceptions.GameOverException;

import java.util.ArrayList;

public class LivesFrame extends BaseFrame {
    private int lives = 3;

    public LivesFrame() {
        images = new ArrayList<>();
        images.add(new Image("file:assets/frames/egg-live-0.png"));
        images.add(new Image("file:assets/frames/egg-live-1.png"));
        images.add(new Image("file:assets/frames/egg-live-2.png"));

        imageView = new ImageView(images.get(0));
    }

    public int getLives() {
        return lives;
    }

    public void decrementLive(){
        lives--;
        if(lives == 0){
            throw new GameOverException();
        }
        updateImageView(3-lives);
    }
}
