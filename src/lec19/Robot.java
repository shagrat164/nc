package lec19;

import java.util.Random;

public class Robot implements Runnable {
    private int health;
    private String name;
    private Robot enemy;
    private Random random;

    Robot(String name) {
        this.name = name;
        random = new Random();
        health = 50;
    }

    private void attack() {
        int random = this.random.nextInt(1000);
        if (random == 5) {
            enemy.health = enemy.health - 5;
            System.out.println("Робот " + name + " атаковал робота " + enemy.name + " и отнял 5hp жизни.");
        }
    }

    void setEnemy(Robot enemy) {
        this.enemy = enemy;
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    @Override
    public void run() {
        while (this.health > 0 && enemy.health > 0) {
            attack();
        }
    }
}