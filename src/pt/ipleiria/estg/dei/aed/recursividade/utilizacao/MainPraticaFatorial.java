package pt.ipleiria.estg.dei.aed.recursividade.utilizacao;

import pt.ipleiria.estg.dei.aed.recursividade.algoritmos.Fatorial;
import pt.ipleiria.estg.dei.aed.utils.Estatistica;
import pt.ipleiria.estg.dei.aed.utils.visualizacao.VisualizadorEstatisticas;

import java.util.ArrayList;
import java.util.List;

public class MainPraticaFatorial {

    public MainPraticaFatorial() {
        Fatorial fatorial = new Fatorial();

        fatorial.getEstatistica(5);
        fatorial.getEstatistica(0);
        fatorial.getEstatistica(-5);
        fatorial.getEstatistica(21);

        VisualizadorEstatisticas visualizador = new VisualizadorEstatisticas();

        List<Estatistica> estatisticas = new ArrayList<>();
        for (int i = 1; i < 21; i++) {
            estatisticas.add(fatorial.getEstatistica(i));
        }
        visualizador.adicionarEstatisticas("Fatorial", estatisticas);
        visualizador.visualizar();
    }

    public static void main(String[] args) {
        new MainPraticaFatorial();
    }
}
