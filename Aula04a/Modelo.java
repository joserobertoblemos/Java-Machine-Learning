// Essa classe armazena o conhecimento aprendido durante o treinamento. O modelo guardara o limiar encontrado pelo algoritmo.


package Aula04a;

public class Modelo {
    private double limiar;

    public Modelo(double limiar){
        this.limiar = limiar;
    }

    // Método para prever se o cliente realiza a compra 
    public boolean prever (int visitas){
        if (visitas >= limiar){
            return true;
        } else{
            return false;
        }
    }

    public double gateLimiar(){
        return limiar;
    }

}
