import java.util.Random;

public class App {
    public static void main(String[] args) {
        Random random = new Random();

        Fazenda fazenda1[] = new Fazenda[50];
        for (int i = 0; i < fazenda1.length; i++) {
            // Criação de arrays do tipo Fazenda e cadastro de bovinos com valores aleatórios
            fazenda1[i] = new Fazenda();
            fazenda1[i].cadastrarBovino(random.nextInt(900000) + 100000, random.nextInt(340) + 160);
        }

        Fazenda fazenda2[] = new Fazenda[50];
        int transferCount = 0;

        Truck caminhao = new Truck();

        while (!isFazenda1Empty(fazenda1)) {
            // Transferência de bovinos de fazenda1 para fazenda2 com base na capacidade do caminhão
            double soma = 0;
            int bovinosTransferidos = 0;

            for (int j = 0; j < fazenda1.length; j++) {
                if (fazenda1[j] != null) {
                    soma += fazenda1[j].getBovino().getPeso();
                    bovinosTransferidos++;

                    if (bovinosTransferidos <= caminhao.getCarregamento()) {
                        fazenda2[j] = fazenda1[j];
                        fazenda1[j] = null;
                    }
                }
            }

            System.out.println("Quantidade de vacas transferidas: " + bovinosTransferidos);

            double media = soma / bovinosTransferidos;

            caminhao.transporte(media);

            transferCount++;
        }

        System.out.println("Quantidade de vezes que a transferência foi feita: " + transferCount);
    }

    private static boolean isFazenda1Empty(Fazenda[] fazenda) {
        // Verifica se a fazenda1 está vazia, ou seja, se todos os elementos são nulos
        for (Fazenda bovino : fazenda) {
            if (bovino != null) {
                return false;
            }
        }
        return true;
    }
}
