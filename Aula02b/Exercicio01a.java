/**
 * Crie três ArrayList para armazenar produtos, quantidade e valores.
Cadastre seis itens de cada
Exiba todos os dados usando for.
Exiba a quantidade de produtos cadastrados.
Consulte o terceiro poduto utilizando get().
Substitua o segundo valor utilizando set().
Verifique se determinado produto está cadastrado e exiba sua quantidade e valor.
Remova um produto e apresente a lista atualizada.

Desafio: Apresente o soma das quantidades dpos produtos restantes.
 */

package Aula02b;

import java.util.ArrayList;

public class Exercicio01a {
    public static void main (String args[]){

        ArrayList<String> produtos = new ArrayList<>();
        ArrayList<Integer> quantidade = new ArrayList<>();
        ArrayList<Double> valores = new ArrayList<>();

        produtos.add("Mouse");
        produtos.add("Teclado");
        produtos.add("Cadeira");
        produtos.add("Fone");
        produtos.add("Monitor");
        produtos.add("Mesa");

        quantidade.add(10);
        quantidade.add(19);
        quantidade.add(13);
        quantidade.add(14);
        quantidade.add(111);
        quantidade.add(47);

        valores.add(56.00);
        valores.add(47.00);
        valores.add(10.15);
        valores.add(22.13);
        valores.add(78.6);
        valores.add(12.5);

        for (int i = 0; i < 5; i++){
            System.out.println("Produto: " + produtos.get(i) + " | quantidade: " + quantidade.get(i) + " | valor: " + valores.get(i));
        }

        System.out.println("terceiro produto: " + produtos.get(2));

        produtos.set(1, "mouse Pad");
        quantidade.set(1, 12);
        valores.set(1, 34.00);

        System.out.println("Novo Produto: " + produtos.get(1) + " | quantidade: " + quantidade.get(1) + " | Valor: " + valores.get(1));

        produtos.remove(4);
        valores.remove(4);
        quantidade.remove(4);

        for (int i = 0; i < 5; i++){
            System.out.println("Produto: " + produtos.get(i) + " | quantidade: " + quantidade.get(i) + " | valor: " + valores.get(i));
        }

        // --- DESAFIO: Apresente a soma das quantidades dos produtos restantes ---
        int soma = 0;

        // Usamos produtos.size() para garantir que o laço percorra exatamente o tamanho atual da lista
        for (int i = 0; i < produtos.size(); i++) {
        soma += quantidade.get(i); // Acumula a quantidade de cada produto restante
        }

    System.out.println("Soma total das quantidades dos produtos restantes: " + soma);
    } 
}
