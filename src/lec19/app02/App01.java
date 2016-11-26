package lec19.app02;

public class App01 {
    private static final CommonRes commRes = new CommonRes();

    public static void main(String[] args) throws InterruptedException {
        Ping ping = new Ping(commRes);
        Pong pong = new Pong(commRes);

        Thread threadPing = new Thread(ping);
        Thread threadPong = new Thread(pong);

        System.out.println("Игра начинается.");

        threadPing.start();
        threadPong.start();

        threadPing.join();
        threadPong.join();

        System.out.println("Игра окончена.");
    }
}
