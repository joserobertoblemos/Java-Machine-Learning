/**
 * Nesse Programa vamos simular a detecção de um email classificado como SPAN
 * 
 */

public class RegraSpan{
    public static void main (String args[]){
        String assunto = "Ganhe um prêmio agora";

        // Regra explicita definida pelo programador
        if (assunto.toLowerCase().contains("ganhe")) {
            System.out.println("Mensagem suspeita");
        } else {
            System.out.println("Mensagem sem alerta para essa regra");
        }
    }
}