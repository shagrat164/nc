package lec19.app02;

class Ping implements Runnable {
    private final CommonRes commonRes;

    Ping(CommonRes commonRes) {
        this.commonRes = commonRes;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            synchronized (commonRes) {
                commonRes.say(i+" Ping");
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
