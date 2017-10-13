package pt.ipleiria.estg.dei.aed.analisecomplexidade.utilizacao;

import pt.ipleiria.estg.dei.aed.analisecomplexidade.algoritmos.Equipas;
import pt.ipleiria.estg.dei.aed.utils.Estatistica;
import pt.ipleiria.estg.dei.aed.utils.VetorDeInteiros;
import pt.ipleiria.estg.dei.aed.utils.VetorDePoint2D;
import pt.ipleiria.estg.dei.aed.utils.visualizacao.VisualizadorEstatisticas;

import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.List;

public class MainPraticaEquipas {
    public  MainPraticaEquipas() {

        Equipas equipas = new Equipas();
        int j = 4;
        do {
            equipas.getEstatistica(VetorDePoint2D.criarAleatorio(50));
            j++;
        }
        while (j < 10);

        List<Estatistica> estatisticas = new ArrayList<>();

        for (int i = 10; i <= 100; i+=10){
            estatisticas.add(equipas.getEstatistica(VetorDePoint2D.criarAleatorio(5)));
        }


        VisualizadorEstatisticas visualizador = new VisualizadorEstatisticas();
        visualizador.adicionarEstatisticas("Maximo", estatisticas);
        visualizador.visualizar();
    }

    public static void main (String[] args) {

        new MainPraticaEquipas();
    }
}

