package pt.ipleiria.estg.dei.aed.analisecomplexidade.algoritmos;

import pt.ipleiria.estg.dei.aed.utils.EstatisticaChamadas;
import pt.ipleiria.estg.dei.aed.utils.EstatisticaDeComparacoes;

import java.awt.geom.Point2D;
import java.util.Arrays;

public class ProximoMinimo {

    public void executar(EstatisticaDeComparacoes estatistica, Point2D... equipas) {
        int Ponto1 = 0;
        int Ponto2 = 1;
        double distance = Double.POSITIVE_INFINITY;

        for (int i = 0; i < equipas.length; i++) {
            estatistica.incrementarComparacoes();
            for (int j = i + 1; j < equipas.length; j++) {
                estatistica.incrementarComparacoes();
                System.out.println(equipas[i] + " vs " + equipas[j] +
                        "Distancia:" + equipas[i].distance(equipas[j]));

                if (equipas[i].distance(equipas[j]) < distance) {
                    Ponto1 = i;
                    Ponto2 = j;
                    distance = equipas[Ponto1].distance(equipas[Ponto2]);
                }
            }
        }
        System.out.println("Resultado: \n" + equipas[Ponto1] + " com " + equipas[Ponto2] + " Distancia: " + distance);
    }

    public EstatisticaDeComparacoes getEstatistica(Point2D... valores) {
        try {
            EstatisticaDeComparacoes estatistica = new EstatisticaDeComparacoes(valores.length);

            executar(estatistica, valores);
            estatistica.parar();

            estatistica.apresentar();

            return estatistica;
        }
        catch (IllegalArgumentException ex) {
            System.out.println("Não foi possivel calcular o maximo de " + Arrays.toString(valores));
            return null;
        }
    }
}



