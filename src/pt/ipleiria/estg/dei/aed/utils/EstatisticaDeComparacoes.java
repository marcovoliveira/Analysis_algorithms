package pt.ipleiria.estg.dei.aed.utils;

public class EstatisticaDeComparacoes extends Estatistica {

    public EstatisticaDeComparacoes(int tamanho) {
        super(tamanho, "Numero de comparações");
    }
    public void incrementarComparacoes() {
        incrementarContador(0);
    }
    public long getComparacoe(){
        return getContador(0);
    }
}
