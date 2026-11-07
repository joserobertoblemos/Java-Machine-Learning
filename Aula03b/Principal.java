// Nessa classe vai coordenar todo o processo. Ela tera quatro responsabilidades
// 1. Criar os dados de treinamento.
// 2. Criar os dados de Teste.
// 3. Executar o treinamento.
// 4. Avaliar o modelo utilizando os dados de teste.

package Aula03b;
import java.util.ArrayList;
public class Principal {
 public static void main(String[] args) {
    
    // Cria uma lista para armazenar os dados de treinamento
    ArrayList<Aluno> dadosTreinamento = new ArrayList<>();

    dadosTreinamento.add(new Aluno(1, Aluno.REPROVADO));
    dadosTreinamento.add(new Aluno(2, Aluno.REPROVADO));
    dadosTreinamento.add(new Aluno(3, Aluno.REPROVADO));
    dadosTreinamento.add(new Aluno(7, Aluno.APROVADO));
    dadosTreinamento.add(new Aluno(8, Aluno.APROVADO));
    dadosTreinamento.add(new Aluno(10, Aluno.APROVADO));
    
    // Cria uma lista separada para armazenar os dados de teste
    ArrayList<Aluno> dadosTeste = new ArrayList<>();

    dadosTeste.add(new Aluno(4, Aluno.REPROVADO));
    dadosTeste.add(new Aluno(6, Aluno.APROVADO));

    System.out.println("--- TREINAMENTO DO MODELO ---");

    // Cria um objeto responsável por executar o treinamento
    Treinador treinador = new Treinador();

    // Envia os dados de treinamento para o algoritmo
    Modelo modelo = treinador.treinar(dadosTreinamento);

    System.out.println("\n--- Teste do Modelo ---");

    // Inicializa o contador de previsões corretas
    int acertos = 0;

    // Percorre todas os registros reservados para o teste

    for (Aluno aluno: dadosTeste){
        int horas = aluno.getHorasEstudo();

        // Obtem a classificação realizada pelo modelo

        String previsao = modelo.prever(horas);

        String resultadoReal = aluno.getResultado();

        System.out.println("\nHoras estudadas: " + horas);
        System.out.println("Previsão: " + previsao);
        System.out.println("Resultado Real: " + resultadoReal);

        if (previsao.equalsIgnoreCase(resultadoReal)){
            acertos++;
            System.out.println("Classificação Correta");
        }else{
            System.out.println("Classificação Incorreta");
        }
    }

    // Calcular o percentual de acertos no conjunto de teste
    double percentualAcertos = (double) acertos / dadosTeste.size() * 100;

    System.out.println("\n--- Resultado da avaliação ---");
    System.out.println("Acertos: " + acertos + "/" + dadosTeste.size());
    System.out.printf("Percentual de acertos: %.1f%% %n", percentualAcertos);
    System.out.println("\n--- Nova Previsão ---");
    int novasHoras = 5;
    String novaPrevisao = modelo.prever(novasHoras);
    System.out.println("Horas estudadas: " + novasHoras);
    System.out.println("Resultado Previsto: " + novaPrevisao);
 }   
}
