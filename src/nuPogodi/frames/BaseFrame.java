package nuPogodi.frames;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.ArrayList;


abstract public class BaseFrame {
    protected ImageView imageView;
    protected ArrayList<Image> images;

    void updateImageView(int index){
        imageView.setImage(images.get(index));
    }

    public ImageView getImageView(){
        return imageView;
    }
}
