package lec14.miner;

import javafx.geometry.Rectangle2D;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

public class Mob extends Pane {
    private ImageView imageView;
    private int count = 3;
    private int columns = 3;
    private int offsetX = 0;
    private int offsetY = 0;
    private int width = 32;
    private int height = 34;
    SpriteAnimation animation;

    public Mob(ImageView imageView) {
        this.imageView = imageView;
        this.imageView.setViewport(new Rectangle2D(offsetX,offsetY,width,height));
        animation = new SpriteAnimation(imageView, Duration.millis(200),count,columns,offsetX,offsetY,width,height);
        getChildren().addAll(imageView);
    }

    public void moveX(int x) {
        boolean right = x > 0;
        for(int i = 0; i < Math.abs(x); i++) {

            if (right) {
                this.setTranslateX(this.getTranslateX() + 1);
            } else {
                this.setTranslateX(this.getTranslateX() - 1);
            }
//            isBonuseEat();
            if (getTranslateX() < 0) {
                setTranslateX(0);
            }
            if (getTranslateX() > 600 - width) {
                setTranslateX(600 - width);
            }
        }
    }

    public void moveY(int value) {
        boolean moveDown;
        if (value > 0) {
            moveDown = true;
        } else {
            moveDown = false;
        }
        for (int i = 0; i < Math.abs(value); i++) {

            if (moveDown) {
                this.setTranslateY(this.getTranslateY() + 1);
            } else {
                this.setTranslateY(this.getTranslateY() - 1);
            }
//            isBonuseEat();
            if (getTranslateY() < 0) {
                setTranslateY(0);
            }
            if (getTranslateY() > 600 - width) {
                setTranslateY(600 - width);
            }
        }
    }
}
