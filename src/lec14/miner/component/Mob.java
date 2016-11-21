package lec14.miner.component;

import javafx.geometry.Rectangle2D;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.util.Duration;
import lec14.miner.Bullet;
import lec14.miner.Game;

public class Mob extends Pane {
    ImageView imageView;
    private int count = 3;
    private int columns = 3;
    private int offsetX = 0;
    private int offsetY = 0;
    private int width = 32;
    private int height = 34;
    private Player player;
    private int targetX;
    private int targetY;
    SpriteAnimation animation;

    public Mob(ImageView imageView) {
        this.imageView = imageView;
        this.imageView.setViewport(new Rectangle2D(offsetX,offsetY,width,height));
        animation = new SpriteAnimation(imageView, Duration.millis(200),count,columns,offsetX,offsetY,width,height);
        getChildren().addAll(imageView);
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public void moveX(int value) {
        boolean moveRight;
        if (value > 0) {
            moveRight = true;
        } else {
            moveRight = false;
        }
        for(int i = 0; i < Math.abs(value); i++) {
            if (this.getBoundsInParent().intersects(this.player.getBoundsInParent())) {
                if (moveRight) {
                    this.setTranslateX(this.getTranslateX() - 1);
                    return;
                } else {
                    this.setTranslateX(this.getTranslateX() + 1);
                    return;
                }
            }
            if (moveRight) {
                this.setTranslateX(this.getTranslateX() + 1);
            } else {
                this.setTranslateX(this.getTranslateX() - 1);
            }
            if (getTranslateX() < 0) {
                setTranslateX(0);
            }
            if (getTranslateX() > Game.WIDTH - width) {
                setTranslateX(Game.WIDTH - width);
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
            if (this.getBoundsInParent().intersects(this.player.getBoundsInParent())) {
                if (moveDown) {
                    this.setTranslateY(this.getTranslateY() - 1);
                    return;
                } else {
                    this.setTranslateY(this.getTranslateY() + 1);
                    return;
                }
            }
            if (moveDown) {
                this.setTranslateY(this.getTranslateY() + 1);
            } else {
                this.setTranslateY(this.getTranslateY() - 1);
            }
            if (this.getTranslateY() < 0) {
                this.setTranslateY(0);
            }
            if (this.getTranslateY() > Game.HEIGHT - width) {
                this.setTranslateY(Game.HEIGHT - width);
            }
        }
    }

    public boolean updateTarget(int targetX, int targetY) {
        if (this.targetX != targetX || this.targetY != targetY) {
            this.targetX = targetX;
            this.targetY = targetY;
            return true;
        }
        return false;
    }
}
