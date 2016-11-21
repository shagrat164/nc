package lec14.flappyBurd;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Администратор on 10.11.2016.
 */
public class MainApp extends Application {
//    private final Image IMAGE = new Image(getClass().getResourceAsStream("res/post-1609954-1339553256.png"));
//    private static final int COLUMNS  =   4; //столбцы
//    private static final int COUNT    =  4;  //кадры
//    private static final int OFFSET_X =  0;
//    private static final int OFFSET_Y =  80;
//    private static final int WIDTH    = 40;
//    private static final int HEIGHT   = 35;
    private static final int WIDTH_SCENE = 600;
    private static final int HEIGHT_SCENE = 700;
    public static Pane appRoot = new Pane();
    public static Pane gameRoot = new Pane();

    public static ArrayList<Wall> walls = new ArrayList<>();
    Bird bird = new Bird();
    public static int score = 0;
    public Label scoreLabel = new Label("Score : " + score);

    public static int getWidthScene() {
        return WIDTH_SCENE;
    }

    public static int getHeightScene() {
        return HEIGHT_SCENE;
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Scene scene = new Scene(createContent());
        scene.setOnMouseClicked(event->bird.jump());
        primaryStage.setScene(scene);
        primaryStage.show();

        AnimationTimer animationTimer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                update();
            }
        };
        animationTimer.start();
//        final ImageView imageView = new ImageView(IMAGE);
//        imageView.setViewport(new Rectangle2D(OFFSET_X, OFFSET_Y, WIDTH, HEIGHT));
//        final Animation animation = new SpriteAnimation(imageView, COUNT, COLUMNS, OFFSET_X, OFFSET_Y, WIDTH, HEIGHT, Duration.millis(600));
//        animation.setCycleCount(Animation.INDEFINITE);
//        animation.play();
//        primaryStage.setScene(new Scene(new Group(imageView),300,300));
//        primaryStage.show();
    }

    private Parent createContent() {
        gameRoot.setPrefSize(WIDTH_SCENE, HEIGHT_SCENE);
        for (int i = 0; i < 100; i++) {
            int enter = (int) (Math.random() * 200) + 80; //ширина проёма 80-280
            int height = new Random().nextInt(HEIGHT_SCENE - enter);

            Wall wall = new Wall(height);
            wall.setTranslateX(i * 350 + HEIGHT_SCENE);
            wall.setTranslateY(0);
            walls.add(wall);

            Wall wall2 = new Wall(HEIGHT_SCENE - height - enter);
            wall2.setTranslateX(i * 350 + HEIGHT_SCENE);
            wall2.setTranslateY(height + enter);
            walls.add(wall2);

            gameRoot.getChildren().addAll(wall, wall2);
        }
        gameRoot.getChildren().add(bird);
        appRoot.getChildren().addAll(gameRoot);
        appRoot.getChildren().add(scoreLabel);
        return appRoot;
    }

    private void update() {
        if (bird.velocity.getY() < 5) {
            bird.velocity = bird.velocity.add(0, 1);
        }
        bird.moveX((int)bird.velocity.getX());
        bird.moveY((int)bird.velocity.getY());
        scoreLabel.setText("Score : " + score);

        bird.translateXProperty().addListener((observable, oldValue, newValue) -> {
            int offset = newValue.intValue();
            if (offset > 200) {
                gameRoot.setLayoutX( -(offset - 200));
            }
        });
    }

    public static void main(String[] args) {
        launch(args);
    }
}
