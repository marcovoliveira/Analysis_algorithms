package pt.ipleiria.estg.dei.aed.pesquisa.algoritmos;

import pt.ipleiria.estg.dei.aed.Comparacao;
import pt.ipleiria.estg.dei.aed.utils.EstatisticaDeComparacoes;

public class PesquisaTernariaIterativa<T> extends AlgoritmoPesquisa<T> {
    public PesquisaTernariaIterativa(Comparacao<T> criterio) {
        super(criterio);
    }

    @Override
    public int pesquisar(EstatisticaDeComparacoes estatistica, T elemento, T... elementos) {
        return 0;
    }
    public int pesquisaIterativa(EstatisticaDeComparacoes estatistica, T elemento,int esq, int dir, T... elementos) {
        while (esq <= dir) {
            estatistica.incrementarComparacoes();
            int terco = (dir-esq+1)/3;
            int terco1 = esq + terco;
            if (criterio.comparar(elemento, elementos[terco1]) == 0) {
                return terco1;
            }
            estatistica.incrementarComparacoes();
            if (criterio.comparar(elemento, elementos[terco1]) < 0){
               dir = terco1-1;
               continue;
            }

            int terco2 = terco+terco1;
            estatistica.incrementarComparacoes();
            if (criterio.comparar(elemento, elementos[terco2]) == 0){
                return terco2;
            }
            estatistica.incrementarComparacoes();
            if (criterio.comparar(elemento, elementos[terco2]) < 0){
              esq= terco1+1;
              dir= terco2+1;
              continue;
            }
           esq = terco2+1;
        }
        return NAO_ENCONTRADO;
        }
    }

