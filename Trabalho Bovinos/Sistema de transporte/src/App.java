import java.util.Random;

public class App {
    public static void main(String[] args) {
        Random random = new Random();
        
        Fazenda fazenda1[] = new Fazenda[50];
        for(int i = 0; i<fazenda1.length;i++){
            fazenda1[i].cadastrarBovino(random.nextInt(1000), random.nextDouble(500.00));
        }

        Fazenda fazenda2[] = new Fazenda[50];
    }
}