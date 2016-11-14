package lec14.miner;

import javafx.geometry.Point2D;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import lec14.miner.component.Mob;
import lec14.miner.component.Player;

import java.util.function.Consumer;

/**
 * Created by danila on 13.11.2016.
 */

public class Bullet extends Pane {
    public Point2D velocity;
    private int radius = 2;
    private int speed = 10;
    private Color color = Color.BLACK;
    private Circle circle;
    private Player player;
    private byte direction;
    private Mob removeMob = null;

    public Bullet(Player player) {
        this.player = player;
        this.velocity = new Point2D(0, 0);
        this.circle = new Circle(radius, color);
        getChildren().add(circle);
        this.direction = this.player.getDirection();
        if (this.direction == 0) { //right
            setTranslateX(this.player.getTranslateX() + 23);
            setTranslateY(this.player.getTranslateY() + 23);
        }
        if (this.direction == 1) { //left
            setTranslateX(this.player.getTranslateX() + 10);
            setTranslateY(this.player.getTranslateY() + 23);
        }
        if (this.direction == 2) { //down
            setTranslateX(this.player.getTranslateX() + 18);
            setTranslateY(this.player.getTranslateY() + 23);
        }
        if (this.direction == 3) { //up
            setTranslateX(this.player.getTranslateX() + 18);
            setTranslateY(this.player.getTranslateY());
        }
    }

    public void update() {
        if (this.direction == 0) {
            setTranslateX(getTranslateX() + speed);
        }
        if (this.direction == 1) {
            setTranslateX(getTranslateX() - speed);
        }
        if (this.direction == 2) {
            setTranslateY(getTranslateY() + speed);
        }
        if (this.direction == 3) {
            setTranslateY(getTranslateY() - speed);
        }
        isMobsDead();
    }

    private void isMobsDead() {
        Game.mobs.forEach(new Consumer<Mob>() {
            @Override
            public void accept(Mob mob) {
                if (Bullet.this.getBoundsInParent().intersects(mob.getBoundsInParent())) {
                    removeMob = mob;
                    player.setScoreMobs(player.getScoreMobs() + 1);
                }
            }
        });
        Game.mobs.remove(removeMob);
        Game.root.getChildren().remove(removeMob);
    }
}
