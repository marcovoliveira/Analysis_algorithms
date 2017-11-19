package pt.ipleiria.estg.dei.aed.ordenacao.algoritmos;

import pt.ipleiria.estg.dei.aed.Comparacao;
import pt.ipleiria.estg.dei.aed.utils.EstatisticaDeComparacoesETrocas;

public class InsertionSort<T> extends AlgoritmoOrdenacao<T> {

    public InsertionSort(Comparacao<T> criterio) {

        super(criterio);
    }

/*   Algoritmo feito em aula pouco optimizado
    public void ordernar(EstatisticaDeComparacoesETrocas estatistica, T... elementos) {
        //Implementação do algoritmo insertionSort

        T elementoSelecionado;

        for (int i = 1; i < elementos.length; i++){
            for (int k = i ; k > 0 ; k--){

                estatistica.incrementarComparacoes();

                final int resultadocomparacao = criterio.comparar(elementos[k], elementos[k - 1]);
                if (resultadocomparacao < 0) {

                    elementoSelecionado = elementos[k];
                    elementos[k] = elementos[k - 1];
                    elementos[k-1] = elementoSelecionado;

                    estatistica.incrementarTrocas();
                  }
            }
        }

    }
*/



    @Override
    public void ordenar(EstatisticaDeComparacoesETrocas estatistica, T... elementos) {
        //Implementação do algoritmo insertionSort

            //percorrer a parte desordenada do vetor

       for (int parteDesordenada = 1 ; parteDesordenada<elementos.length; parteDesordenada++) {
           T elementoSelecionado = elementos[parteDesordenada];

           int elementosSequenciaOrdenada = parteDesordenada-1;
         
           while (elementosSequenciaOrdenada>=0 &&
                   criterio.comparar(elementos[elementosSequenciaOrdenada], elementoSelecionado) > 0){

               elementos[elementosSequenciaOrdenada+1] = elementos[elementosSequenciaOrdenada];
               
               elementosSequenciaOrdenada--;
           }
           elementos[elementosSequenciaOrdenada+1] = elementoSelecionado;
       }

    }

}
