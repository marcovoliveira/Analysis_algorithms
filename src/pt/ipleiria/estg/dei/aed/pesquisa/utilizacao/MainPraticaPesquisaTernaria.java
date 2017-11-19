package pt.ipleiria.estg.dei.aed.pesquisa.utilizacao;

import pt.ipleiria.estg.dei.aed.ComparacaoInteiros;
import pt.ipleiria.estg.dei.aed.pesquisa.algoritmos.PesquisaTernariaIterativa;

public class MainPraticaPesquisaTernaria {
    public MainPraticaPesquisaTernaria() {

        PesquisaTernariaIterativa<Integer> pesquisaTernariaIterativa = new PesquisaTernariaIterativa<>(ComparacaoInteiros.CRITERIO);
        pesquisaTernariaIterativa.getEstatistica(7, 1, 2, 4, 5, 6, 7, 8, 9);
    }

    public static void main(String[] args) {
        new MainPraticaPesquisaTernaria();
    }
}




