public class Asymetric extends Thread {
    static int amount = 0;
    private final int id;
    public final Forks leftfForks;
    public final Forks rightForks;

    public Asymetric(int id, Forks fork1, Forks fork2){
        this.id = id;
        this.leftfForks = (this.id % 2 == 0) ? fork2 : fork1;
        this.rightForks = (this.id % 2 == 0) ? fork1 : fork2;
        Asymetric.amount++;
    }

    @Override
    public void run(){
        try {

            for(int i = 0; i <= 3; i++){
                System.out.println("Philosopher " + id + " is trying take forks");
                leftfForks.take();
                rightForks.take();
                System.out.println("Philosopher " + id + " is eating");
                leftfForks.put();
                rightForks.put();
                System.out.println("Philosopher " + id + " finished eating");
            }
            
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
