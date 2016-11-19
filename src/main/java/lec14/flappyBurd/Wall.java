package lec14.flappyBurd;

import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;

/**
 * Created by Администратор on 10.11.2016.
 */

public class Wall extends Pane {
    Rectangle rectangle;
    int height;

    public Wall(int height) {
        this.height = height;
        rectangle = new Rectangle(20, height);
        getChildren().add(rectangle);
    }
}
