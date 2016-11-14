package lec14.miner.component;

import javafx.geometry.Rectangle2D;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;
import lec14.miner.Bullet;
import lec14.miner.Game;

import java.util.function.Consumer;

public class Player extends Pane {
    ImageView imageView;
    private int count = 3;
    private int columns = 3;
    private int offsetX = 0;
    private int offsetY = 0;
    private int width = 32;
    private int height = 32;
    private int scoreBonus = 0;
    private int scoreMobs = 0;
    private byte direction;
    private Rectangle removeRect = null;
    public SpriteAnimation animation;

    public Player(ImageView imageView) {
        this.imageView = imageView;
        this.imageView.setViewport(new Rectangle2D(offsetX,offsetY,width,height));
        animation = new SpriteAnimation(imageView,Duration.millis(200),count,columns,offsetX,offsetY,width,height);
        getChildren().addAll(imageView);
    }

    public void moveX(int value) {
        boolean moveRight;
        if (value > 0) {
            moveRight = true;
            direction = 0;
        } else {
            moveRight = false;
            direction = 1;
        }
        for(int i = 0; i < Math.abs(value); i++) {
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

    public void moveY(int value) {
        boolean moveDown;
        if (value > 0) {
            moveDown = true;
            direction = 2;
        } else {
            moveDown = false;
            direction = 3;
        }
        for (int i = 0; i < Math.abs(value); i++) {
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

    public byte getDirection() {
        return direction;
    }

    public void isBonuseEat() {
        Game.bonuses.forEach(new Consumer<Rectangle>() {
            @Override
            public void accept(Rectangle rect) {
                if (Player.this.getBoundsInParent().intersects(rect.getBoundsInParent())) {
                    removeRect = rect;
                    scoreBonus++;
                }
            }
        });
        Game.bonuses.remove(removeRect);
        Game.root.getChildren().remove(removeRect);
    }

    public int getScoreBonus() {
        return scoreBonus;
    }

    public int getScoreMobs() {
        return scoreMobs;
    }

    public void setScoreMobs(int scoreMobs) {
        this.scoreMobs = scoreMobs;
    }

    public void shooting() {
        Bullet bullet = new Bullet(this);
        Game.bullets.add(bullet);
        Game.root.getChildren().add(bullet);
    }
}