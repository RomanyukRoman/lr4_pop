import java.util.concurrent.Semaphore;

public class Forks {
    public final int id;
    private static int amount = 0;
    private final Semaphore semaphore;

    public Forks() {
        id = amount++;
        this.semaphore = new Semaphore(1);
    }
    public void take() throws InterruptedException{
        semaphore.acquire();
    }
    public void put() throws InterruptedException{
        semaphore.release();
    }
}
