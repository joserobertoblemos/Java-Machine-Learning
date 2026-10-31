package Aula02b;

public class Principal {
    public static void main (String args []){
        
        // Construtor
        Produto produto1 = new Produto("Mouse", "Periféricos", 59.90, 3 );
        produto1.estoqueMinimo = 10; 

        produto1.exibirDados();
        System.out.println(produto1.verificarEstoque());

        Produto produto2 = new Produto("Teclado", "Periféricos", 89.90, 50);
        produto2.estoqueMinimo = 25;
        System.out.println("=".repeat(40));
        produto2.exibirDados();
        System.out.println(produto2.verificarEstoque()); 

    }
}
