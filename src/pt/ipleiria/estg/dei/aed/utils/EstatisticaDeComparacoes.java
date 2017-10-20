package pt.ipleiria.estg.dei.aed.utils;

public class EstatisticaDeComparacoes extends Estatistica {

    public EstatisticaDeComparacoes(int tamanho) {
        super(tamanho, "Número de Comparações");
    }

    protected EstatisticaDeComparacoes(int tamanho, String... nomesContadores) {
        super(tamanho, nomesContadores);
    }

    public void incrementarComparacoes() {
        incrementarContador(0);
    }

    public long getComparacoes() {
        return getContador(0);
    }
}
