package pt.ipleiria.estg.dei.aed.modelo.contactos.comparadores;

import pt.ipleiria.estg.dei.aed.ComparacaoLimite;
import pt.ipleiria.estg.dei.aed.colecoes.iteraveis.lineares.ordenadas.estruturas.ListaDuplaCircularBaseLimiteOrdenada;
import pt.ipleiria.estg.dei.aed.modelo.contactos.Contacto;
import pt.ipleiria.estg.dei.aed.modelo.contactos.Data;
import pt.ipleiria.estg.dei.aed.utils.Par;

public enum ComparacaoLimiteParesDataListaContactosPorDataAscendente
        implements ComparacaoLimite<Par<Data, ListaDuplaCircularBaseLimiteOrdenada<Contacto>>>{
    CRITERIO;

    private static final  Par<Data, ListaDuplaCircularBaseLimiteOrdenada<Contacto>> LIMITE =
            new Par<>(new Data(0, 0, Integer.MAX_VALUE), null);



    @Override
    public Par<Data, ListaDuplaCircularBaseLimiteOrdenada<Contacto>> getLimite() {
        return LIMITE;
    }

    @Override
    public int comparar(Par<Data, ListaDuplaCircularBaseLimiteOrdenada<Contacto>> o1, Par<Data, ListaDuplaCircularBaseLimiteOrdenada<Contacto>> o2) {

        return o1.getPrimeiro().comparar(o2.getPrimeiro());
    }
}
