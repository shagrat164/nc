package lec14;

import javafx.geometry.Point2D;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 * Created by Администратор on 10.11.2016.
 */
public class Bird extends Pane {
    public Point2D velocity;
    private Rectangle rectangle;
    public Bird() {
        velocity = new Point2D(20, 20);
        rectangle = new Rectangle(20, 20, Color.RED);
        setTranslateY(300);
        setTranslateX(100);
        getChildren().addAll(rectangle);
    }


    public void moveY(int value) {
        boolean moveDown;
        if (value > 0) {
            moveDown = true;
        } else {
            moveDown = false;
        }
        for (int i = 0; i < Math.abs(value); i++) {
            for (Wall w : MainApp.walls) {
                if (this.getBoundsInParent().intersects(w.getBoundsInParent())) {
                    if (moveDown) {
                        setTranslateY(getTranslateY()-1);
                        return;
                    } else {
                        setTranslateY(getTranslateY()+1);
                        return;
                    }
                }
            }
            if (getTranslateY() < 0) {
                setTranslateY(0);
            }
            if (getTranslateY() > MainApp.getHeightScene() - 20) {
                setTranslateY(MainApp.getHeightScene() - 20);
            }
            setTranslateY(getTranslateY() + (moveDown?1:-1));
        }
    }

    public void moveX(int value) {
        for (int i = 0; i < value; i++) {
            for (Wall w : MainApp.walls) {
                if (this.getBoundsInParent().intersects(w.getBoundsInParent())) {
                    if (getTranslateX()+20 == w.getTranslateX()) {
                        setTranslateX(getTranslateX()-1);
                        return;
                    }
                }
                if (getTranslateX()+20 == w.getTranslateX()) {
                    MainApp.score++;
                }
            }
            setTranslateX(getTranslateX()+1);
        }
    }
}
