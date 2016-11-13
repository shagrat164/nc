package lec14.miner;

import javafx.geometry.Point2D;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

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

    public Bullet(Personage personage) {
        this.personage = personage;
        this.velocity = new Point2D(0, 0);
        this.circle = new Circle(radius, color);
        getChildren().add(circle);
        if (this.personage.isMoveRight() == true) {
            setTranslateX(this.personage.getTranslateX() + 23);
            setTranslateY(this.personage.getTranslateY() + 30);
            return;
        }
        if (this.personage.isMoveRight() == false) {
            setTranslateX(this.personage.getTranslateX() + 10);
            setTranslateY(this.personage.getTranslateY() + 30);
            return;
        }
        if (this.personage.isMoveDown()) {
            setTranslateX(this.personage.getTranslateX() );
            setTranslateY(this.personage.getTranslateY() + 50);
        } else {
            setTranslateX(this.personage.getTranslateX() - 50);
            setTranslateY(this.personage.getTranslateY() + 20);
        }
    }

    public void update() {
        setTranslateY(getTranslateY() - speed);
    }
}
