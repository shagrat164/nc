package lec19.app02;

/**
 * Created by danila on 25.11.2016.
 */
public class App01 {
    public static void main(String[] args) throws InterruptedException {
        Ping ping = new Ping();
        Pong pong = new Pong();
        Thread threadPing = new Thread(ping);
        Thread threadPong = new Thread(pong);

        threadPing.setName("Thread Ping");
        threadPong.setName("Thread Pong");

        threadPing.start();
        threadPong.start();

        threadPing.join();
        threadPong.join();

        System.out.println("Игра окончена.");
    }
}

