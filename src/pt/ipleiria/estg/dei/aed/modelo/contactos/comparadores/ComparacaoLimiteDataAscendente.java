package pt.ipleiria.estg.dei.aed.modelo.contactos.comparadores;

import pt.ipleiria.estg.dei.aed.ComparacaoLimite;
import pt.ipleiria.estg.dei.aed.modelo.contactos.Data;

public enum ComparacaoLimiteDataAscendente implements ComparacaoLimite<Data>{
    CRITERIO;
    private static final Data LIMITE = new Data(1,1,Integer.MAX_VALUE);

    @Override
    public Data getLimite() {
        return LIMITE;
    }

    @Override
    public int comparar(Data o1, Data o2) {
        return o1.comparar(o2);
    }
}
