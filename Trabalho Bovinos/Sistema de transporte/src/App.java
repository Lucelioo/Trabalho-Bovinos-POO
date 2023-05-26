import java.util.Scanner;
import java.util.Random;

public class App {

	public static void main(String[] args) {

		Random random = new Random();
		Scanner entrada = new Scanner(System.in);
		Fazenda fazendaOrigem[] = new Fazenda[50];
		Fazenda fazendaDestino[] = new Fazenda[50];
		Truck caminhao[] = new Truck[40];
		int viagem = 0;
		int bovinosTransferidos = 0;
		int escolha;
		double media = 0;
		double soma = 0;

        do {
    		
            System.out.println("-------------------------------------------------");
            System.out.println("          Sistema transporte de bovinos          ");
            System.out.println("\n\t1 - Transporte de bovino");
            System.out.println("\n\t2 - Receber em destino");
            System.out.println("\n\t3 - Saldo");
            System.out.println("\n\t0 - Sair");
            System.out.print("\n\n\tEscolha uma opção: ");
             
            escolha = entrada.nextInt();
            

    		// Criação de arrays do tipo Fazenda e cadastro de bovinos com valores
    		// aleatórios
    		for (int i = 0; i < fazendaOrigem.length; i++) {
    			fazendaOrigem[i] = new Fazenda(); // Inicializa um novo objeto na fazenda1 a cada interação
    			fazendaOrigem[i].cadastrarBovino(random.nextInt(900000) + 100000, random.nextDouble(340) + 160);
    			// System.out.println("FAZENDA ORIGEM - ID: " +
    			// fazendaOrigem[i].getBovino().getId() + " - PESO: "
    			// + fazendaOrigem[i].getBovino().getPeso());
    		}
    		// Declarando um novo array caminho para classe Truck
    		// Inicializa um novo objeto no Truck a cada interação
    		for (int j = 0; j < caminhao.length; j++) {
    			caminhao[j] = new Truck();
    		}            
             
            switch (escolha) { 
                case 1:
                	System.out.println("-------------------------------------------------");
                    System.out.println("          Sistema transporte de bovinos          ");
                    System.out.println("          Lista dos bovinos no caminhao            \n");
                    
//            		Transferência de bovinos de fazendaOrigem para caminhão
            		for (var k = 0; k < caminhao.length; k++) {
                        double resultado = 0;
                        var carregamento = caminhao[viagem].getCarregamento();
            			if (k == 0) {
                            caminhao[viagem].transporte(fazendaOrigem[k].getBovino().getPeso());
            				caminhao[k].cadTruckBovino(fazendaOrigem[k].getBovino().getId(),
            						fazendaOrigem[k].getBovino().getPeso());
            				fazendaOrigem[k] = null;
            				bovinosTransferidos++;
            			}

            			// Calculo da média
            			else if (k > 0 && carregamento > bovinosTransferidos) {
            				for (var j = 0; j < bovinosTransferidos; j++) {
                                if(caminhao[j].getBovino() != null){
            					resultado += caminhao[j].getBovino().getPeso();
            				}
                        }
            				media = (resultado + fazendaOrigem[k].getBovino().getPeso()) / (k + 1);
            				caminhao[viagem].transporte(media);

                            caminhao[k].cadTruckBovino(fazendaOrigem[k].getBovino().getId(),
            						fazendaOrigem[k].getBovino().getPeso());
            				fazendaOrigem[k] = null;
            				bovinosTransferidos++;
            			}

            			else {
                            for (var j = 0; j < bovinosTransferidos; j++) {
                                if(caminhao[j].getBovino() != null){
            					resultado += caminhao[j].getBovino().getPeso();
            				}
                        }
                            caminhao[viagem].setCarga(resultado);
                            caminhao[viagem].setViagem(viagem);
            				viagem++;
                            break;
            			}
            		}
            		
    				for (var j = 0; j < bovinosTransferidos; j++) {
                        if(caminhao[j].getBovino() != null){
    					System.out.println("   ID: " +caminhao[j].getBovino().getId() + " - Peso: " +  caminhao[j].getBovino().getPeso());
    				}
                }
    				System.out.printf("\n   Carga: %.2f Kg", caminhao[viagem-1].getCarga());
    				System.out.println("\n   Quantidade de Bovino: " + bovinosTransferidos);
    				System.out.println("   Carregamento: "  + caminhao[viagem-1].getCarregamento());
    				System.out.printf("   Media: %.2f Kg", media);
    				System.out.println("\n-------------------------------------------------");
                    
    				for (var i = 0; i < bovinosTransferidos; i++) {
    					if(caminhao[i].getBovino() != null){
                        fazendaDestino[i] = new Fazenda();
                        fazendaDestino[i].cadastrarBovino(caminhao[i].getBovino().getId(), caminhao[i].getBovino().getPeso());
                    }
                }
                break; 
                case 2:                    
                    System.out.println("-------------------------------------------------");
                    System.out.println("          Sistema transporte de bovinos          \n");
                    System.out.println("           Receber Fazenda de Destino            \n");
                    System.out.println("\n   Quantidade de Bovino: " + bovinosTransferidos);
                    System.out.printf("\n\n   Lista dos bovinos:\n\n");
                    
                    for (var i = 0; i < bovinosTransferidos; i++) {
                        if (fazendaDestino[i] != null && fazendaDestino[i].getBovino() != null) {
                            System.out.println("   ID: " + fazendaDestino[i].getBovino().getId() + " - Peso: " + fazendaDestino[i].getBovino().getPeso());
                            caminhao[i] = null;
                        }
                    }
                    
                    
                    System.out.println("\n-------------------------------------------------\n");
                    System.out.println("\n\tBovinos recebidos com sucesso!!");
                    System.out.println("\n-------------------------------------------------");
                    break;
                    
                case 3: System.out.println("Opção 3 selecionada");
                
                break; 
                case 0: System.out.println("Saindo...");
                
                break; 
                default: System.out.println("Opção inválida. Tente novamente."); }
            
            }while (escolha != 0);
	}
}
