package nuPogodi;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import nuPogodi.stages.Game;
import nuPogodi.stages.LeaderBoard;


public class Main extends Application {
    final String title = "Nu Pogodi | Collect Eggs | The Game";

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        int width = 512, height = 303;
        stage.setTitle(title);

        Button playButton = buildMenuButton("Play️");
        Button leaderBoardButton = buildMenuButton("Leaderboard");
        Button exitButton = buildMenuButton("Exit");

        playButton.setOnAction(e -> {
            Game.start();
        });

        leaderBoardButton.setOnAction(e -> {
            LeaderBoard.display();
        });

        exitButton.setOnAction(e -> {
            stage.close();
        });

        VBox layout = new VBox();
        layout.setPadding(new Insets(80, 0, 0, 0));
        layout.getChildren().add(playButton);
        layout.getChildren().add(leaderBoardButton);
        layout.getChildren().add(exitButton);
        layout.setAlignment(Pos.CENTER);

        BackgroundImage backgroundImage = new BackgroundImage(
                new Image("file:assets/images/main.png", width, height, false, true),
                BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT
        );
        layout.setBackground(new Background(backgroundImage));

        Scene scene = new Scene(layout, width, height);
        stage.setScene(scene);

        stage.show();
    }

    private Button buildMenuButton(String text) {
        Button button = new Button();
        button.setText(text);
        button.setMinWidth(180);
        button.setFont(new Font("Futura", 20));
        return button;
    }
}
