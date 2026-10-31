package Aula02b;

public class Lista01 {
    public static void main(String args []){
        int[] idades = {16, 25, 30, 18, 19};
        String[] nomes = new String[5];
        nomes[0] = "Gaspar";
        nomes[1] = "Jorge";
        nomes[2] = "Luiza";
        nomes[3] = "Anabela";
        nomes[4] = "Bruce";

        for (int i = 0; i < 5; i++){
            System.out.println("Aluno: " + nomes[i] + " | Idade: " + idades[i]);
        }
    }
}
