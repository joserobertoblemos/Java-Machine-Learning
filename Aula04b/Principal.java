package Aula04b;

/**
 * Classe principal para execução do programa, treinamento e exibição dos resultados.
 */
public class Principal {

    public static void main(String[] args) {
        // 1. Definição dos dados históricos de treinamento
        // X: Área em metros quadrados (m²)
        double[] areasTreinamento = {50.0, 60.0, 75.0, 90.0, 110.0, 130.0, 150.0};
        // Y: Preço correspondente em Reais (R$)
        double[] precosTreinamento = {200000.0, 235000.0, 290000.0, 345000.0, 415000.0, 490000.0, 560000.0};

        // Instancia a camada de dados
        DatasetImoveis dataset = new DatasetImoveis(areasTreinamento, precosTreinamento);

        // 2. Criação e treinamento do modelo de regressão linear
        ModeloRegressaoLinear modelo = new ModeloRegressaoLinear();
        modelo.treinar(dataset);

        // 3. Exibição dos parâmetros calculados (b0 e b1)
        System.out.println("=== RESULTADOS DO TREINAMENTO ===");
        System.out.printf("Intercepto (b0): R$ %.2f%n", modelo.getIntercepto());
        System.out.printf("Inclinação (b1): R$ %.2f por m²%n", modelo.getInclinacao());
        System.out.printf("Equação da reta: Preço = %.2f + (%.2f * Área)%n", 
                          modelo.getIntercepto(), modelo.getInclinacao());

        // 4. Realização de previsões para novos imóveis
        System.out.println("\n=== PREVISÕES DE PREÇOS ===");
        double[] novasAreas = {80.0, 100.0, 140.0};

        for (int i = 0; i < novasAreas.length; i++) {
            double areaTeste = novasAreas[i];
            double precoPrevisto = modelo.prever(areaTeste);
            System.out.printf("Imóvel de %.1f m² -> Preço estimado: R$ %.2f%n", areaTeste, precoPrevisto);
        }
    }
}

