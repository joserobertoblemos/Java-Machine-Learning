// Essa Classe será responsável por executar o processo 
// Ela deve lero arquivo csv
// Separar os registros de treinamento e teste
// Executar o treinamento
// Avaliar o modelo
// Realizar com uma nova precisão


package Aula04a;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        
        try {

            // Criar um objeto responsável pela leitura do arquivo CSV
            LeitorCSV leitor = new LeitorCSV();

            // Carrega os registros do arquivo CSV
            ArrayList<Cliente> clientes = leitor.carregar("dados/clientes.csv");

            ArrayList<Cliente> dadosTreinamento = new ArrayList<>();

            ArrayList<Cliente> dadosTeste = new ArrayList<>();

            // Percorre todos os clientes carregados no arquivo
            for (Cliente cliente : clientes){
                
                //Verifica se  o registro é treino
                if (cliente.getConjunto().equalsIgnoreCase("Treino")){
                    dadosTreinamento.add(cliente);
                }else if (cliente.getConjunto().equalsIgnoreCase("Teste")){
                    dadosTeste.add(cliente);
                }
            }

            if(dadosTreinamento.size() < 2){
                throw new IllegalArgumentException("O Arquivo não possui dados suficiente para o treinamento.");
            }

            if(dadosTeste.isEmpty()){
                throw new IllegalArgumentException("O Arquivo não possio registros para teste");
            }

            System.out.println("\n=== Dados Carregados ===");
            System.out.println("Dados de treinamento: " + dadosTreinamento.size());
            System.out.println("Dados de Teste: " + dadosTeste.size());
            System.out.println("\n=== Treinamento do Modelo === ");
            Treinador treinador = new Treinador();
            Modelo modelo = treinador.treinar(dadosTreinamento);
            System.out.println("\n=== Teste do modelo ===");
            int acertos = 0;

            for (Cliente cliente : dadosTeste){
                
                int visitas = cliente.getVisitas();

                boolean previsao = modelo.prever(visitas);

                boolean resultadoReal = cliente.isCompra();

                System.out.println("\n Visitas ao site: " + visitas);

                if (previsao){
                    System.out.println("Previsão: Sim!");
                } else {
                    System.out.println("Previsão: Não");
                }

                if (resultadoReal){
                    System.out.println("Resultado real: Sim");
                } else{
                    System.out.println("Resultado real: Não");
                }

                if (previsao == resultadoReal){
                    acertos++;
                    System.out.println("Classificação Correta");
                } else {
                    System.out.println("Classificação Incorreta");
                }
            }

            // Calcula o percentual de acertos

            double percentualAcertos = (double) acertos / dadosTeste.size() * 100;

            System.out.println("\n=== Resultado da avaliação ===");

            System.out.println("Acertos: " + acertos + " / " + dadosTeste.size());

            System.out.printf("Percentual de acertos: %.1f%%%n", percentualAcertos);

            Scanner sc = new Scanner(System.in);
            System.out.println("=".repeat(40));

            System.out.print("\nDigite as visitas do cliente: ");
            int novasVisitas = sc.nextInt();

            boolean novaPrevisao = modelo.prever(novasVisitas);

            if (novaPrevisao) {
                System.out.println("Previsão de compra: SIM");
            } else {
                System.out.println("Previsão de compra: NÂO");
            }

        } catch (IOException e){
            System.out.println("ERRO AO LER O ARQUIVO CSV: " + e.getMessage());
        } catch (IllegalArgumentException e){
            System.out.println("Erro no processamento: " + e.getMessage());
        }

    }


}
