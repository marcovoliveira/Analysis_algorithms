package pt.ipleiria.estg.dei.aed.utils;

public class EstatisticaDeChamadas extends Estatistica {

    public EstatisticaDeChamadas(int tamanho) {
        this(tamanho, "Número de Chamadas");
    }

    protected EstatisticaDeChamadas(int tamanho, String... nomesContadores) {
        super(tamanho, nomesContadores);
    }

    public void incrementarChamadas() {
        incrementarContador(0);
    }

    public long getChamadas() {
        return getContador(0);
    }
}
