package pt.ipleiria.estg.dei.aed.pesquisa.algoritmos;

import pt.ipleiria.estg.dei.aed.Comparacao;
import pt.ipleiria.estg.dei.aed.utils.EstatisticaDeComparacoes;

public class PesquisaTernariaRecursiva<T> extends AlgoritmoPesquisa<T> {
    public PesquisaTernariaRecursiva(Comparacao<T> criterio) {
        super(criterio);
    }

    @Override
    public int pesquisar(EstatisticaDeComparacoes estatistica, T elemento, T... elementos) {
        if (elementos.length == 0) {
            return NAO_ENCONTRADO;
        }
        return pesquisaRecursiva(estatistica, elemento, 0,elementos.length-1, elementos);

    }
    private int pesquisaRecursiva(EstatisticaDeComparacoes estatistica, T elemento,int esq, int dir, T... elementos) {
        if (esq > dir) {
            return NAO_ENCONTRADO;
        }
        int terco = (dir-esq)/3;
        int terco1 = esq + terco;


        estatistica.incrementarComparacoes();
        if (criterio.comparar(elemento, elementos[terco1]) == 0) {
            return terco1;
        }
        estatistica.incrementarComparacoes();
        if (criterio.comparar(elemento, elementos[terco1]) < 0){
            pesquisaRecursiva(estatistica, elemento, esq, terco1-1, elementos);
        }

        int terco2 = terco+terco1;
        estatistica.incrementarComparacoes();
        if (criterio.comparar(elemento, elementos[terco2]) == 0){
            return terco2;
        }
        estatistica.incrementarComparacoes();
        if (criterio.comparar(elemento, elementos[terco2]) < 0){
            pesquisaRecursiva(estatistica, elemento, terco1+1, terco2-1, elementos);
        }
             return  pesquisaRecursiva(estatistica, elemento, terco2+1, dir, elementos);
    }

}
