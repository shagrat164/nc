package lec19.app02;

class Pong implements Runnable {
    private final CommonRes commonRes;

    Pong(CommonRes commonRes) {
        this.commonRes = commonRes;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            synchronized (commonRes) {
                commonRes.say(i+" Pong");
                commonRes.notify();
                try {
                    commonRes.wait(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
