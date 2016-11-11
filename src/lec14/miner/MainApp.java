package lec14.miner;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

public class MainApp extends Application {
    private Game game = new Game();

    public Game getGame() {
        return game;
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Scene scene = new Scene(game.createScene());
        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                game.addKey(event.getCode(), true);
            }
        });
        scene.setOnKeyReleased(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                game.addKey(event.getCode(), false);
            }
        });
        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                game.update();
                game.bonus();
                game.createMobs();
            }
        };
        timer.start();
        primaryStage.setTitle("Game");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
