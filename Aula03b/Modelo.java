// Nessa Classe vamos armazenar o conhecimento encontrado pelo algoritmo depois do treinamento.
// Nesse Exemplo o conhecimento aprendido é o valor do limiar. A classe modelo será responsável por guardar
// esse valor e utiliza-lo para clasificar novos alunos. 

package Aula03b;

public class Modelo {
    private double limiar; 

    public Modelo (double limiar){
        this.limiar = limiar;
    }

    //Método responsável por classificar um novo aluno
    public String prever (int horasEstudo){
        if (horasEstudo >= limiar){
            return Aluno.APROVADO;
        }else{
            return Aluno.REPROVADO;
        }
    }

    public double getLimiar(){
        return limiar;
    }
}
