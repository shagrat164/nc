package lec16.app01;

class Singleton {
    private static final int MAXIMUM = 5;
    private int id;
    private static int count;

    static synchronized Singleton getInstance() throws Throwable {
        if (count < MAXIMUM) {
            return new Singleton();
        } else {
            throw new Throwable("Превышен лимит экземпляров класса ");
        }
    }

    private Singleton() {
        this.id = count++;
    }

    @Override
    public String toString() {
        return "Singleton{" +
                "id=" + id +
                '}';
    }
}
