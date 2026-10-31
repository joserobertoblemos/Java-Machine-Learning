package Aula02b;
import java.util.ArrayList;
public class Lista02 {
    
    public static void main (String args[]){

        ArrayList<String> nomes = new ArrayList<>();

        nomes.add("Gaspar");
        nomes.add("Luiza");
        nomes.add("Jorge");
        nomes.add("Anabela");
        nomes.add("Bruce");

        ArrayList<Integer> idades = new ArrayList<>();

        idades.add(16);
        idades.add(30);
        idades.add(25);
        idades.add(19);
        idades.add(16);

        nomes.set(2, "Camila");
        idades.set(2, 35);

        nomes.remove(4);
        idades.remove(4);

        nomes.remove("Luiza");
        idades.remove(Integer.valueOf(30)); // remover idade sem que ele procure o numero inteiro na posição da array

        // Verificar a existencia do elemento
        if (nomes.contains("Luiza")){
            System.out.println("Nome: Luiza encontrado");
        }else{
            System.out.println("Nome: luiza não encontrado");
        }
        
        if (nomes.contains("Gaspar")){
            // Seleciona a posição do elemento
            int posição = nomes.indexOf("Gaspar");
            System.out.println("A Idade do Gaspar é " + idades.get(posição));
        }

        for (int i = 0; i < nomes.size(); i++)
            System.out.println("Nome: " + nomes.get(i) + " - Idade: " + idades.get(i));

        // Limpa o conteudo do array 
        nomes.clear();

        // Verificar se a lista está vazia
        if (nomes.isEmpty()){
            System.out.println("A lista está vazia");
        }

    }
}
