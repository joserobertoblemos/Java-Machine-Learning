package Aula03a;
public class App {
    
    public static void main(String[] args) {
        Aluno a1 = new Aluno(10, "Aprovado");
        Aluno a2 = new Aluno(8, "Aprovado");
        Aluno a3 = new Aluno(2, "Reprovado");
        Aluno a4 = new Aluno(1, "Reprovado");

        System.out.println(
            a1.horasEstudo + " horas = " + a1.resultado
        );
        System.out.println(
            a2.horasEstudo + " horas = " + a2.resultado
        );
        System.out.println(
            a3.horasEstudo + " horas = " + a3.resultado
        );
        System.out.println(
            a4.horasEstudo + " horas = " + a4.resultado
        );
    }
}
