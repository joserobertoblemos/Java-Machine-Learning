// Nessa classe o algoritmo vai procurar o limiar que proporciona a maior quantidade de classificações corretas


package Aula04a;
import java.util.ArrayList;
import java.util.Collections;

public class Treinador {
    
    public Modelo treinar(ArrayList<Cliente> clientes){
        
        if (clientes == null || clientes.size() < 2){
            throw new IllegalArgumentException("São Necessários pelo menos dois clientes.");
        }

        ArrayList<Integer> visitas = new ArrayList<>();

        for (Cliente cliente : clientes){

            int valor = cliente.getVisitas();

            if (!visitas.contains(valor)){
                visitas.add(valor);
            }
        }

        Collections.sort(visitas);

        if (visitas.size() < 2){
            throw new IllegalArgumentException("São necessários valores diferentes de visitas.");
        }

        double melhorLimiar = 0;

        int melhorQuantidadedeAcertos = -1;

        for (int i = 0; i < visitas.size() - 1; i++){

            double limiar = (visitas.get(i) + visitas.get(i + 1)) / 2;

            int acertos = 0;

            for (Cliente cliente : clientes){
                boolean previsao = cliente.getVisitas() >= limiar;

                boolean resultadoReal = cliente.isCompra();

                if (previsao == resultadoReal){
                    acertos++;
                }
            }
            System.out.printf("Limiar: %.1f | Acertos: %d/%d%n", limiar, acertos, clientes.size());

            if (acertos > melhorQuantidadedeAcertos){
                melhorQuantidadedeAcertos = acertos;
                melhorLimiar = limiar;
            }
        }

        System.out.println("\nTreinamento concluido");
        System.out.println("Melhor limiar: " + melhorLimiar);
        System.out.println("Acertos no treinamento: " + melhorQuantidadedeAcertos + " / " + clientes.size());

        return new Modelo(melhorLimiar);
    }
}
