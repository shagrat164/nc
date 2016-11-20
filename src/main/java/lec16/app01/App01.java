package lec16.app01;

public class App01 {

    public static void main(String[] args) {
        Singleton sing = Singleton.getInstance();
        Singleton sing2 = Singleton.getInstance();
        Singleton sing3 = Singleton.getInstance();
        Singleton sing4 = Singleton.getInstance();

        System.out.println(sing);
        System.out.println(sing2);
        System.out.println(sing3);
        System.out.println(sing4);
    }
}
