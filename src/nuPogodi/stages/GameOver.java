package nuPogodi.stages;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Modality;
import javafx.stage.Stage;
import nuPogodi.models.HighScore;

public class GameOver {
    private static final String title = "Game Over | Nu Pogodi!";
    private static final int width = 480, height = 325;

    public static void display(int score) {
        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setTitle(title);

        VBox layout = new VBox();
        Scene scene = new Scene(layout, width, height);
        BackgroundImage backgroundImage = new BackgroundImage(
                new Image("file:assets/images/gameover.png", width, height, false, true),
                BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT
        );
        layout.setPadding(new Insets(10, 0, 0, 20));
        layout.setAlignment(Pos.BASELINE_LEFT);
        layout.setBackground(new Background(backgroundImage));
        Font bigFont = Font.font("Futura", FontWeight.BOLD, 28);
        Font font = Font.font("Futura", FontWeight.BOLD, 18);

        Label label1 = new Label("Game Over!");
        Label label2 = new Label("Your score: " + score);
        label1.setFont(bigFont);
        label2.setFont(font);

        TextField textField = new TextField();
        textField.setMaxWidth(125);
        textField.setPromptText("Your Name");
        textField.setFont(font);

        Button button = new Button("Add Score");
        button.setFont(font);
        button.setMaxWidth(125);

        button.setOnAction(e -> {
            String name = textField.getText();
            if (name.isBlank()) return;
            HighScore.writeScore(name, score);
            ((Node) (e.getSource())).getScene().getWindow().hide();
        });

        layout.getChildren().add(label1);
        layout.getChildren().add(label2);
        layout.getChildren().add(textField);
        layout.getChildren().add(button);

        stage.setScene(scene);
        stage.showAndWait();
    }
}
