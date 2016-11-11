package lec14.miner;

import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.util.ArrayList;
import java.util.HashMap;

public class Game {
    private ImageView imageView = new ImageView(new Image(getClass().getResourceAsStream("res/1.png")));
    private Character player = new Character(imageView);
    private Label scoreLabel = new Label("Score: " + player.getScore());
    private HashMap<KeyCode, Boolean> keys = new HashMap<>();

    static ArrayList<Rectangle> bonuses = new ArrayList<>();
    static ArrayList<Mob> mobs = new ArrayList<>();
    static Pane root = new Pane();

    public Character getPlayer() {
        return player;
    }

    public void addKey(KeyCode keyCode, boolean flag) {
        this.keys.put(keyCode, flag);
    }

    public void createMobs() {
        int random = (int)Math.floor(Math.random()*500);
        int x = (int)Math.floor(Math.random()*550+20);
        int y = (int)Math.floor(Math.random()*550+20);
        if (random == 5) {
            ImageView imageView = new ImageView(new Image(getClass().getResourceAsStream("res/soldat13.png")));
            Mob mob = new Mob(imageView);
            mob.setTranslateX(x);
            mob.setTranslateY(y);
            mobs.add(mob);
            root.getChildren().addAll(mob);
        }
    }

    public void bonus() {
        int random = (int)Math.floor(Math.random()*200);
        int x = (int)Math.floor(Math.random()*550+20);
        int y = (int)Math.floor(Math.random()*550+20);
        if (random == 5) {
            Rectangle rect = new Rectangle(20,20, Color.RED);
            rect.setX(x);
            rect.setY(y);
            bonuses.add(rect);
            root.getChildren().addAll(rect);
        }
    }

    public void update() {
        if (isPressed(KeyCode.UP)) {
            player.animation.play();
            player.animation.setOffsetY(96);
            player.moveY(-2);
        } else if (isPressed(KeyCode.DOWN)) {
            player.animation.play();
            player.animation.setOffsetY(0);
            player.moveY(2);
        } else if (isPressed(KeyCode.RIGHT)) {
            player.animation.play();
            player.animation.setOffsetY(64);
            player.moveX(2);
        } else if (isPressed(KeyCode.LEFT)) {
            player.animation.play();
            player.animation.setOffsetY(32);
            player.moveX(-2);
        } else {
            player.animation.stop();
        }
        scoreLabel.setText("Score: " + player.getScore());

        for (Mob mob : mobs) {
            mob.animation.play();
            mob.animation.setOffsetY(69);
            mob.moveX(2);
        }
    }

    public boolean isPressed(KeyCode key) {
        return keys.getOrDefault(key, false);
    }

    public Parent createScene() {
        root.setPrefSize(600,600);
        root.getChildren().addAll(player, scoreLabel);
        return root;
    }
}
