package nuPogodi.stages;

import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.*;
import javafx.stage.Modality;
import javafx.stage.Stage;
import nuPogodi.exceptions.GameOverException;
import nuPogodi.frames.*;

import java.util.ArrayList;

public class Game {
    private static Stage stage;
    private static StackPane layout;
    private static boolean gameOver = false;
    private static final int updateInterval = 300;
    private static final int addEggStartInterval = 2000;
    private static final int addEggMinInterval = 700;
    private static final int width = 720, height = 441;
    private static final String title = "Collect Eggs | Nu Pogodi!";
    private static final WolfFrame wolf = new WolfFrame();
    private static final LivesFrame lives = new LivesFrame();
    private static final ScoreFrame score = new ScoreFrame();
    private static final ArrayList<EggFrame> eggs = new ArrayList<>();

    public static void start() {
        stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setTitle(title);

        layout = new StackPane();
        layout.setAlignment(Pos.TOP_LEFT);
        Scene scene = new Scene(layout, width, height);
        BackgroundImage backgroundImage = new BackgroundImage(
                new Image("file:assets/frames/background.png", width, height, false, true),
                BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT
        );
        layout.setBackground(new Background(backgroundImage));

        layout.getChildren().add(wolf.getImageView());
        layout.getChildren().add(lives.getImageView());
        layout.getChildren().add(score.getLabel());

        scene.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.UP) wolf.lookUp();
            if (e.getCode() == KeyCode.DOWN) wolf.lookDown();
            if (e.getCode() == KeyCode.LEFT) wolf.lookLeft();
            if (e.getCode() == KeyCode.RIGHT) wolf.lookRight();
        });

        // Add New Eggs
        new Thread(Game::addNewEggs).start();
        new Thread(Game::updateFrames).start();

        stage.setScene(scene);
        stage.showAndWait();
    }

    private static void addNewEggs() {
        int interval = addEggStartInterval;
        while (!gameOver) {
            if (interval > addEggMinInterval) interval -= 60;
            EggFrame egg = new EggFrame(Direction.random());
            Platform.runLater(() -> layout.getChildren().add(egg.getImageView()));
            eggs.add(egg);

            try {
                Thread.sleep(interval);
            } catch (InterruptedException e) {
                e.printStackTrace();
                break;
            }
        }
    }

    private static void updateFrames() {
        while(!gameOver) {
            ArrayList<EggFrame> toDelete = new ArrayList<>();

            for (EggFrame egg : eggs) {
                if (egg.hasNextFrame()) {
                    egg.nextFrame();
                    continue;
                }

                if (wolf.getDirection() == egg.getDirection()) {
                    score.incrementScore();
                } else {
                    try {
                        lives.decrementLive();
                    } catch (GameOverException e){
                        gameOver = true;
                        stopGame();
                        return;
                    }
                }

                toDelete.add(egg);
                Platform.runLater(() -> layout.getChildren().remove(egg.getImageView()));
            }

            eggs.removeAll(toDelete);

            try {
                Thread.sleep(updateInterval);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private static void stopGame() {
        Platform.runLater(() -> {
            GameOver.display(score.getScore());
            stage.close();
        });
    }
}
