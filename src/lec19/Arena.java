
/**
 * Created by student on 23.11.16.
 */
public class Arena {
    public static void main(String... args) throws InterruptedException {
        Arena arena = new Arena();
        Robot player1 = new Robot("Вася");
        Robot player2 = new Robot("Джон");

        player1.setEnemy(player2);
        player2.setEnemy(player1);

        player1.run();
        player2.run();

        arena.waitWinner();
    }

    void waitWinner() throws InterruptedException {
        while (true) {
            super.wait(1000);
        }
    }
}