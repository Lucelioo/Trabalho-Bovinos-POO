import java.util.Random;

public class App {
    public static void main(String[] args) {
        Random random = new Random();

        Fazenda fazenda1[] = new Fazenda[50];
        for(int i = 0; i<fazenda1.length; i++){
            fazenda1[i] = new Fazenda();
            fazenda1[i].cadastrarBovino(random.nextInt(900000)+100000, random.nextInt(341)+160);
        }

        double soma = 0;
        for(int j = 0; j < fazenda1.length; j++) {
            if(fazenda1[j] != null) {
                soma += fazenda1[j].getBovino().getPeso();
            }
        }

        System.out.println(soma);
        double media = soma / fazenda1.length;
        System.out.println(media);

        Truck caminhao = new Truck();
        caminhao.transporte(media);
        System.out.println("a quantidade de vacas a serem transportadas e: " + caminhao.getCarregamento());
    }
}
