package lec16.app01;


public class Singleton {
    private static Singleton ourInstance;

    public static Singleton getInstance() {
        if (ourInstance == null) {
             ourInstance = new Singleton();
        }
        return ourInstance;
    }

    private Singleton() {
    }
}
