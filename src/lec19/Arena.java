package lec19;

public class Arena {
    public static void main(String[] args) throws InterruptedException {
        final Arena arena = new Arena();
        Robot player1 = new Robot("Иван", arena);
        Robot player2 = new Robot("Василий", arena);

        player1.setEnemy(player2);
        player2.setEnemy(player1);

        Thread threadPlayer1 = new Thread(player1);
        Thread threadPlayer2 = new Thread(player2);

        threadPlayer1.start();
        threadPlayer2.start();

//        arena.waitWinner();
    }

    private void waitWinner() throws InterruptedException {

    }
}