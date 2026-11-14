package Aula04b;

/**
 * Classe responsável por armazenar e fornecer os dados de treinamento.
 * Separa a camada de dados da lógica matemática do modelo.
 */
public class DatasetImoveis {
    
    // Arrays para armazenar a variável independente (X) e a dependente (Y)
    private double[] areas;  // X: Área do imóvel em m²
    private double[] precos; // Y: Preço do imóvel em R$

    /**
     * Construtor que recebe os arrays de áreas e preços.
     * Valida se a quantidade de amostras de X e Y é idêntica.
     */
    public DatasetImoveis(double[] areas, double[] precos) {
        if (areas.length != precos.length || areas.length == 0) {
            throw new IllegalArgumentException("Os arrays de áreas e preços devem ter o mesmo tamanho e não podem estar vazios.");
        }
        this.areas = areas;
        this.precos = precos;
    }

    // Métodos getters para acessar os dados durante o treinamento
    public double[] getAreas() {
        return areas;
    }

    public double[] getPrecos() {
        return precos;
    }

    public int getTamanhoAmostra() {
        return areas.length;
    }
}

