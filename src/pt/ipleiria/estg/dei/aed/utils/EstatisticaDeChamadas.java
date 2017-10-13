package pt.ipleiria.estg.dei.aed.utils;

public class EstatisticaDeChamadas extends Estatistica {

    public EstatisticaDeChamadas(int tamanho) {
        super(tamanho, "Numero de Chamadas");

    }

    public void incrementarChamadas() {
        incrementarContador(0);
    }

    public long getChamadas(){
        return getContador(0);
    }
}
