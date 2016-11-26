package lec19;

import java.util.Random;

public class Robot implements Runnable {
    private int health;
    private String name;
    private Robot enemy;
    private Random random;
    private final Arena arena;

    public Robot(String name, Arena arena) {
        this.name = name;
        random = new Random();
        health = 1000;
        this.arena = arena;
    }

    public void attack() {
        int random = this.random.nextInt(1000);
        if (random == 5) {
            enemy.setHealth(enemy.getHealth() - 5);
            System.out.println("Робот " + name + " атаковал робота " + enemy.getName() + " и отнял 5hp жизни.");
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
        while (this.health > 0 && enemy.getHealth() > 0) {
            attack();
        }
    }
}