package Aula03b;

public class Aluno {
    public static final String APROVADO = "Aprovado";

    public static final String REPROVADO = "Reprovado";

    private int horasEstudo;
    private String resultado;

    public Aluno (int horasEstudo, String resultado){

        // Verifica se p resultado informado é uma das categorias permitidas

        if (!resultado.equalsIgnoreCase(APROVADO) && !resultado.equalsIgnoreCase(REPROVADO)){
            
            // Interrompe a criação do objeto se a categoria for inválida
            throw new IllegalArgumentException("resultado inválido");
        }

        this.horasEstudo = horasEstudo;
        this.resultado = resultado;
    }

    public int getHorasEstudo(){
        return this.horasEstudo;
    }
    public String getResultado(){
        return this.resultado;
    }

    
}
