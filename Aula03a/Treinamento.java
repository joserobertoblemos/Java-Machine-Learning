package Aula03a;
public class Treinamento {
    
    public static void main (String args[]){
        int[] horas = {10,8,2,1};
        String[] resultado = {
            "Aprovado",
            "Aprovado",
            "Reprovado",
            "Reprovado"
        };
        for (int i = 0; i < horas.length; i++){
            System.out.println(horas[i] + " Horas = " + resultado[i]);
        } 
    }
}
