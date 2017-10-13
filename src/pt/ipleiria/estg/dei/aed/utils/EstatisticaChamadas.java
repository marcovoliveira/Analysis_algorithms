package pt.ipleiria.estg.dei.aed.utils;

public class EstatisticaChamadas extends Estatistica {
    public EstatisticaChamadas(int tamanho) {
        super(tamanho, "Numero de chamadas");
    }

    public void incrementarChamadas()
    {
        incrementarContador(0);
    }

    public long getChamadas()
    {
        return getContador(0);
    }
}
