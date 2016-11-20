package lec16.app01;


class Singleton {
    private static final int MAXIMUM = 5;
    private int id;
    private static int count;
//    private static Singleton ourInstance;

    static synchronized Singleton getInstance() {

//        if (ourInstance == null) {
//             ourInstance = new Singleton();
//        }
//        return ourInstance;
    }

    private Singleton() {
        this.id++;
    }
}
