import java.util.Random;

/**
 * Created by student on 23.11.16.
 */
public class Robot implements Runnable {
    private int health;
    private String name;
    private Robot enemy;
    private Random random;

    public Robot(String name) {
        this.name = name;
        random = new Random();
        health = 10000;
    }

    public void attack() {
        int random = this.random.nextInt(1000);
        if (random == 5) {
            health+=10;
            enemy.setHealth(enemy.getHealth() - 5);
            System.out.println("Робот " + name + " атаковал " + enemy.getName());
        }
    }

    public void setEnemy(Robot enemy) {
        this.enemy = enemy;
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    @Override
    public void run() {
        while (health > 0 && enemy.getHealth() > 0) {
            attack();
        }
    }
}