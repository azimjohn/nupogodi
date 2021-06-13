package nuPogodi.frames;

import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class ScoreFrame {
    private int score = 0;
    private final Label label;

    public ScoreFrame() {
        Font bigFont = Font.font("Futura", FontWeight.BOLD, 42);
        label = new Label("Score: " + score);
        label.setTextFill(Color.color(68/255.f, 151/255.f, 180/255.f));
        label.setPadding(new Insets(16, 0, 0 , 128));
        label.setAlignment(Pos.TOP_LEFT);
        label.setFont(bigFont);
    }

    public void incrementScore() {
        Platform.runLater(() -> label.setText("Score: " + ++score));
    }

    public int getScore() {
        return score;
    }

    public Label getLabel() {
        return label;
    }
}
