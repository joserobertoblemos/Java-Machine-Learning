// Nessa classe o algoritmo responsável por analisar os dados e encontrar o melhor limiar

package Aula03b;

import java.util.ArrayList;
import java.util.Collections;

public class Treinador {

    // Método responsável por treinar o modelo utilizando os dados fornecidos

    public Modelo treinar(ArrayList<Aluno> alunos) {
        // Verifica se a lista existe e possui pelo menos dois registro
        if (alunos == null || alunos.size() < 2) {
            throw new IllegalArgumentException("São necessários pelo menos dois alunos");
        }

        // Cria uma lista para armazenar as horas de estudo sem repetição
        ArrayList<Integer> horas = new ArrayList<>();

        // Percorre todos os alunos do conjunto de treinamento
        for (Aluno aluno : alunos) {
            int valor = aluno.getHorasEstudo();

            // Verifica se esse valor ainda não foi adicionada a lista
            if (!horas.contains(valor)) {
                horas.add(valor);
            }
        }

        // Organizar as horas em ordem crescente
        Collections.sort(horas);

        // Verifica se existe pelo menos dois valores e se eles são diferentes
        if (horas.size() < 2) {
            throw new IllegalArgumentException("São necessários valores diferentes de horas.");
        }

        double melhorLimiar = 0;
        int melhorQuantidadeAcertos = -1;

        // Percorre os valores para calcular os possiveis limiares
        for (int i = 0; i < horas.size()-1; i++) {
            // Calcula o ponto médio entre duas horas consecutivas
            double limiar = (horas.get(i) + horas.get(i + 1)) / 2.0;
            int acertos = 0;

            // Percorre todos os alunos para avaliar o limiar atual
            for (Aluno aluno : alunos) {
                // Verifica se a previsão seria aprovação
                boolean previsao = aluno.getHorasEstudo() >= limiar;

                // Verifica se o resultado conhecido é aprovação
                boolean resultadoReal = aluno.getResultado().equalsIgnoreCase(Aluno.APROVADO);

                // Compara a previsão com o resultado
                if (previsao == resultadoReal) {
                    acertos++;
                }
            }

            // Apresenta o Resultado do teste do limiar atual
            System.out.printf("Limiar: %.2f | Acertos: %d/%d%n", limiar, acertos, alunos.size());

            // Verifica se o limiar atual superou o melhor resultado anterior

            if (acertos > melhorQuantidadeAcertos){
                melhorQuantidadeAcertos = acertos;

                melhorLimiar = limiar;
            }

        }

        // Apresenta o resultado final do processo de treinamento
        System.out.println("\nTreinamento Concluído");
        System.out.println("Melhor limiar: " + melhorLimiar);
        System.out.println("Acertos no treinamento: " + melhorQuantidadeAcertos + "/" + alunos.size());

        // Cria e retorna um modelo contendo o limiar aprendido
        return new Modelo(melhorLimiar);
    
    }
}