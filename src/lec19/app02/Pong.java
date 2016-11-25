package lec19.app02;

/**
 * Created by danila on 25.11.2016.
 */
class Pong implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                say();
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private synchronized void say() throws InterruptedException {
        System.out.println("1.Pong");
//        this.notify();
//        this.wait();
    }
}
