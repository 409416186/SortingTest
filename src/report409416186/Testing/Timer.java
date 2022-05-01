package report409416186.Testing;

public class Timer {
    private long start;

    public Timer() {
    }

    public Timer start() {
        start = System.currentTimeMillis();
        return this;
    }


    public long end() {
        return System.currentTimeMillis() - start;
    }
}
