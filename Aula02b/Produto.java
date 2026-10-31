package Aula02b;

public class Produto {
    String nome;
    String categoria;
    double preco;
    int estoque;
    boolean repor;
    int estoqueMinimo;
    
    //Construtor
    public Produto (String nomeProduto, String categoriaProduto, double precoProduto, int estoqueProduto){
        nome = nomeProduto;
        categoria = categoriaProduto;
        preco = precoProduto;
        estoque = estoqueProduto;
    }

    public void exibirDados(){
        System.out.println("Produto: " + nome);
        System.out.println("Categoria: " + categoria);
        System.out.println("Preço: " + preco);
        System.out.println("Estoque: " + estoque);

    }

    public String verificarEstoque(){
        if (estoque < estoqueMinimo){
            return "Repor estoque";
        }
        return "Não Repor estoque";
    }


}
