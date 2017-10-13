package pt.ipleiria.estg.dei.aed.analisecomplexidade.algoritmos;

import pt.ipleiria.estg.dei.aed.utils.Estatistica;
import pt.ipleiria.estg.dei.aed.utils.EstatisticaDeComparacoes;

import java.util.Arrays;

public class Maximo {

    //... reticencias é quase a mesma coisa do que int[], so muda a sua forma de chamada
    public int executar(EstatisticaDeComparacoes estatistica, int... valores){
       if(valores.length == 0) { //Validar Dados!!!
           throw new IllegalArgumentException("Não é possivel calcular o maximo sem valores!");
       }
        int max = 0;

        for (int i = 1; i<valores.length; i++) {
            estatistica.incrementarComparacoes();
            if (valores[i] > valores[max]) {
                max = i;
            }
        }
        return valores[max];
    }
    public EstatisticaDeComparacoes getEstatistica(int... valores) {
        try {
            EstatisticaDeComparacoes estatistica = new EstatisticaDeComparacoes(valores.length);

            int max = executar(estatistica, valores);
            estatistica.parar();

            System.out.println("Maximo(" + Arrays.toString(valores) + ") =" + max);
            estatistica.apresentar();

            return estatistica;
        }
        catch (IllegalArgumentException ex) {
            System.out.println("Não foi possivel calcular o maximo de " + Arrays.toString(valores));
            return null;
            }
        }
    }

