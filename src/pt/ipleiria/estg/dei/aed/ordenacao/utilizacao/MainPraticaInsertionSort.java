package pt.ipleiria.estg.dei.aed.ordenacao.utilizacao;

import pt.ipleiria.estg.dei.aed.ComparacaoInteiros;
import pt.ipleiria.estg.dei.aed.ordenacao.algoritmos.InsertionSort;
import pt.ipleiria.estg.dei.aed.ordenacao.algoritmos.SelectionSort;
import pt.ipleiria.estg.dei.aed.utils.VetorDeInteiros;
import pt.ipleiria.estg.dei.aed.utils.visualizacao.VisualizadorEstatisticas;

public class MainPraticaInsertionSort {
    public MainPraticaInsertionSort() {

        InsertionSort<Integer> insertionSort = new InsertionSort<>(ComparacaoInteiros.CRITERIO);
        insertionSort.getEstatistica(VetorDeInteiros.criarAleatorioInteger(
                100, -100, 100, false));
        insertionSort.getEstatistica(VetorDeInteiros.criarAleatorioInteger(
                1_000, -1_000, 1_000, false));
        insertionSort.getEstatistica(VetorDeInteiros.criarAleatorioInteger(
                10_000, -10_000, 10_000, false));
        insertionSort.getEstatistica(VetorDeInteiros.criarAleatorioInteger(
                100_000, -100_000, 100_000, false));
        insertionSort.getEstatistica(VetorDeInteiros.criarAleatorioInteger(
                1000_000, -1000_000, 1000_000, false));
    }



    public static void main(String[] args) {
        new MainPraticaInsertionSort();
    }
}

