package pt.ipleiria.estg.dei.aed.colecoes.iteraveis.lineares.ordenadas.estruturas;

import pt.ipleiria.estg.dei.aed.ComparacaoLimite;

public class ListaDuplaCircularBaseLimiteOrdenadaDistinta<T> extends ListaDuplaCircularBaseLimiteOrdenada<T>{

    public ListaDuplaCircularBaseLimiteOrdenadaDistinta(ComparacaoLimite<T> cpl) {
        super(cpl);
    }

    @Override
    public void inserir(T elem) {
        No seguinte = getNo(elem);

        if (criterio.comparar(elem, seguinte.elemento) == 0){
            throw new IllegalArgumentException("Ja existe");
        }

        new No(elem, getNo(elem));
        numeroElementos++;
    }

    public T consultarDistintos(T elem) {
        No seguinte = getNo(elem);
        if(criterio.comparar(elem, seguinte.elemento) == 0){
            return  seguinte.elemento;
        }
        return null;
    }
}
