public class Main {
    public static void main(String[] args) throws Exception {
        int amount = 5;
        Forks[] forks = new Forks[amount];
        for(int i = 0; i < forks.length; i++){
            forks[i] = new Forks();
        }

        Asymetric[] asymetrics = new Asymetric[amount];
        for(int i = 0; i < asymetrics.length; i++){
            asymetrics[i] = new Asymetric(i, forks[i], forks[((i + 1) % asymetrics.length)]);
        }
        for(Asymetric asym : asymetrics){
            asym.start();
        }

    }
}
