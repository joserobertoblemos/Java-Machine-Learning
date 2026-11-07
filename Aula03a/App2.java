package Aula03a;

import java.util.ArrayList;

public class App2 {
    public static void main(String[] args) {
        
        ArrayList<Aluno> dados = new ArrayList<>();

        dados.add(new Aluno(10, "Aprovado"));
        dados.add(new Aluno(8, "Aprovado"));
        dados.add(new Aluno(2, "Reprovado"));
        dados.add(new Aluno(1, "Reprovado"));

        for (Aluno aluno: dados) {
            System.out.println(aluno.horasEstudo + " horas = " + aluno.resultado);
        }
    }
}
