package lec16.app01;

public class App01 {

    public static void main(String[] args) throws Throwable {
        Singleton sing1 = Singleton.getInstance();
        System.out.println(sing1);
        Singleton sing2 = Singleton.getInstance();
        System.out.println(sing2);
        Singleton sing3 = Singleton.getInstance();
        System.out.println(sing3);
        Singleton sing4 = Singleton.getInstance();
        System.out.println(sing4);
        Singleton sing5 = Singleton.getInstance();
        System.out.println(sing5);
        Singleton sing6 = Singleton.getInstance();
        System.out.println(sing6);
        Singleton sing7 = Singleton.getInstance();
        System.out.println(sing7);
    }
}
