package lec19;

public class Arena {
    private Thread threadPlayer1;
    private Thread threadPlayer2;
    private Robot player1;
    private Robot player2;

    public static void main(String[] args) throws InterruptedException {
        Arena arena = new Arena(new Robot("Иван"), new Robot("Василий"));
        arena.startFight();
        arena.waitWinner();
        System.out.println("Игра окончена.");
    }

    public Arena(Robot player1, Robot player2) {
        this.player1 = player1;
        this.player2 = player2;
        this.player1.setEnemy(player2);
        this.player2.setEnemy(player1);

        this.threadPlayer1 = new Thread(this.player1);
        this.threadPlayer2 = new Thread(this.player2);
    }

    private void startFight() {
        this.threadPlayer1.start();
        this.threadPlayer2.start();
    }

    private void waitWinner() throws InterruptedException {
        this.threadPlayer1.join();
        this.threadPlayer2.join();

        System.out.println(getWinner());
    }

    private String getWinner() {
        if (this.player1.getHealth() > 0) {
            return this.player1.getName() + " победил. Осталось " + this.player1.getHealth() + "hp";
        }
        if (this.player2.getHealth() > 0) {
            return this.player2.getName() + " победил. Осталось " + this.player2.getHealth() + "hp";
        }
        return null;
    }
}