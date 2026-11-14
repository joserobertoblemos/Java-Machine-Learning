package Aula04b;

/**
 * Classe que implementa o algoritmo de Regressão Linear Simples.
 * Armazena os parâmetros treinados (b0 e b1) e realiza previsões.
 */
public class ModeloRegressaoLinear {

    private double b0; // Intercepto (valor base quando X = 0)
    private double b1; // Inclinação da reta (quanto o preço sobe a cada 1 m²)
    private boolean treinado;

    public ModeloRegressaoLinear() {
        this.b0 = 0.0;
        this.b1 = 0.0;
        this.treinado = false;
    }

    /**
     * Método auxiliar privado para calcular a média aritmética de um array.
     */
    private double calcularMedia(double[] valores) {
        double soma = 0.0;
        for (int i = 0; i < valores.length; i++) {
            soma += valores[i];
        }
        return soma / valores.length;
    }

    /**
     * Treina o modelo utilizando o Método dos Mínimos Quadrados Ordinários.
     */
    public void treinar(DatasetImoveis dataset) {
        double[] x = dataset.getAreas();
        double[] y = dataset.getPrecos();
        int n = dataset.getTamanhoAmostra();

        // Passo 1: Calcular as médias de X (área) e Y (preço)
        double mediaX = calcularMedia(x);
        double mediaY = calcularMedia(y);

        // Passo 2: Calcular o numerador (covariância) e o denominador (variância) para b1
        double numerador = 0.0;
        double denominador = 0.0;

        for (int i = 0; i < n; i++) {
            double diferencaX = x[i] - mediaX;
            double diferencaY = y[i] - mediaY;

            numerador += diferencaX * diferencaY;
            denominador += diferencaX * diferencaX;
        }

        // Evita divisão por zero caso todos os imóveis tenham exatamente a mesma área
        if (denominador == 0) {
            throw new ArithmeticException("Variância de X é zero. Não é possível calcular a inclinação.");
        }

        // Passo 3: Calcular e armazenar a inclinação (b1) e o intercepto (b0)
        this.b1 = numerador / denominador;
        this.b0 = mediaY - (this.b1 * mediaX);
        this.treinado = true;
    }

    /**
     * Realiza a previsão do preço (Y) a partir de uma nova área (X).
     * Aplica a equação da reta: Y = b0 + b1 * X
     */
    public double prever(double area) {
        if (!treinado) {
            throw new IllegalStateException("O modelo precisa ser treinado antes de realizar previsões.");
        }
        return this.b0 + (this.b1 * area);
    }

    // Getters para inspecionar os parâmetros aprendidos pelo modelo
    public double getIntercepto() {
        return b0;
    }

    public double getInclinacao() {
        return b1;
    }
}

