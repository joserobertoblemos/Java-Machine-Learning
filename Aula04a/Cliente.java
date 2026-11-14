// Essa classe representa cada cliente armazenado no arquivo csv. Cada objeto terá 3 atributos: Visitas, quantidade de visitas, resultado da compra e conjunto


package Aula04a;

public class Cliente {
    
    private int visitas;
    private boolean compra;
    private String conjunto;

    public Cliente (int visitas, boolean compra, String conjunto){
        this.visitas = visitas;
        this.compra = compra;
        this.conjunto = conjunto;
    }

    public int getVisitas(){
        return visitas;
    }

    public boolean isCompra(){
        return compra;
    }

    public String getConjunto(){
        return conjunto;
    }

    
}
