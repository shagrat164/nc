package lec14.miner;

import javafx.geometry.Rectangle2D;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

import java.util.function.Consumer;

public class Personage extends Pane {
    private ImageView imageView;
    private int count = 3;
    private int columns = 3;
    private int offsetX = 0;
    private int offsetY = 0;
    private int width = 32;
    private int height = 32;
    private int score = 0;
    private boolean moveRight;
    private boolean moveDown;
    Rectangle removeRect = null;
    SpriteAnimation animation;

    public Personage(ImageView imageView) {
        this.imageView = imageView;
        this.imageView.setViewport(new Rectangle2D(offsetX,offsetY,width,height));
        animation = new SpriteAnimation(imageView,Duration.millis(200),count,columns,offsetX,offsetY,width,height);
        getChildren().addAll(imageView);
    }

    public void moveX(int x) {
        if (x > 0) {
            moveRight = true;
            moveDown = false;
        } else {
            moveRight = false;
            moveDown = false;
        }
        for(int i = 0; i < Math.abs(x); i++) {
            for (Mob mob : Game.mobs) {
                if (this.getBoundsInParent().intersects(mob.getBoundsInParent())) {
                    if (moveRight) {
                        this.setTranslateX(this.getTranslateX() - 1);
                        return;
                    } else {
                        this.setTranslateX(this.getTranslateX() + 1);
                        return;
                    }
                }
            }
            if (moveRight) {
                this.setTranslateX(this.getTranslateX() + 1);
            } else {
                this.setTranslateX(this.getTranslateX() - 1);
            }
            isBonuseEat();
            if (getTranslateX() < 0) {
                setTranslateX(0);
            }
            if (getTranslateX() > Game.WIDTH - width) {
                setTranslateX(Game.WIDTH - width);
            }
        }
    }

    public void moveY(int y) {
        if (y > 0) {
            moveDown = true;
            moveRight = false;
        } else {
            moveDown = false;
            moveRight = false;
        }
        for (int i = 0; i < Math.abs(y); i++) {
            for (Mob mob : Game.mobs) {
                if (this.getBoundsInParent().intersects(mob.getBoundsInParent())) {
                    if (moveDown) {
                        this.setTranslateY(this.getTranslateY() - 1);
                        return;
                    } else {
                        this.setTranslateY(this.getTranslateY() + 1);
                        return;
                    }
                }
            }
            if (moveDown) {
                this.setTranslateY(this.getTranslateY() + 1);
            } else {
                this.setTranslateY(this.getTranslateY() - 1);
            }
            isBonuseEat();
            if (getTranslateY() < 0) {
                setTranslateY(0);
            }
            if (getTranslateY() > Game.HEIGHT - width) {
                setTranslateY(Game.HEIGHT - width);
            }
        }
    }

    public boolean isMoveRight() {
        return moveRight;
    }

    public boolean isMoveDown() {
        return moveDown;
    }

    public void isBonuseEat() {
        Game.bonuses.forEach(new Consumer<Rectangle>() {
            @Override
            public void accept(Rectangle rect) {
                if (Personage.this.getBoundsInParent().intersects(rect.getBoundsInParent())) {
                    removeRect = rect;
                    score++;
                }
            }
        });
        Game.bonuses.remove(removeRect);
        Game.root.getChildren().remove(removeRect);
    }

    public int getScore() {
        return score;
    }

    void shooting() {
        Bullet bullet = new Bullet(this);
        Game.bullets.add(bullet);
        Game.root.getChildren().add(bullet);
    }
}