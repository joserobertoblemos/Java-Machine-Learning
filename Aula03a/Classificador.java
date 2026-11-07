package Aula03a;

public class Classificador {
    public static String prever(int horas) {
        if (horas >= 6) {
            return "Aprovado";
        } else {
            return "Reprovado";
        }
    }
    public static void main(String args[]){
        String resultado = prever(8);
        System.out.println(resultado);
    }

}

