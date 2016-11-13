package lec14.miner;

import javafx.geometry.Point2D;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

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
    private Personage personage;
    private byte direction;

    public Bullet(Personage personage) {
        this.personage = personage;
        this.velocity = new Point2D(0, 0);
        this.circle = new Circle(radius, color);
        getChildren().add(circle);
        this.direction = this.personage.getDirection();
        if (this.direction == 0) { //right
            setTranslateX(this.personage.getTranslateX() + 23);
            setTranslateY(this.personage.getTranslateY() + 23);
        }
        if (this.direction == 1) { //left
            setTranslateX(this.personage.getTranslateX() + 10);
            setTranslateY(this.personage.getTranslateY() + 23);
        }
        if (this.direction == 2) { //down
            setTranslateX(this.personage.getTranslateX() + 18);
            setTranslateY(this.personage.getTranslateY() + 23);
        }
        if (this.direction == 3) { //up
            setTranslateX(this.personage.getTranslateX() + 18);
            setTranslateY(this.personage.getTranslateY());
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
    }
}
