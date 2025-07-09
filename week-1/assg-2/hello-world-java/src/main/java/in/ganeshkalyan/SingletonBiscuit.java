package in.ganeshkalyan;

public class SingletonBiscuit {
    private static SingletonBiscuit instance;

    private SingletonBiscuit() {}

    public static synchronized SingletonBiscuit getInstance() {
        if (instance == null) {
            instance = new SingletonBiscuit();
        }
        return instance;
    }
}
