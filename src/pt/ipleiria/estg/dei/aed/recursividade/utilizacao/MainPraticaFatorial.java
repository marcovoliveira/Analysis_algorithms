package pt.ipleiria.estg.dei.aed.recursividade.utilizacao;

import pt.ipleiria.estg.dei.aed.recursividade.algoritmos.Fatorial;
import pt.ipleiria.estg.dei.aed.recursividade.algoritmos.Fibonacci;
import pt.ipleiria.estg.dei.aed.recursividade.algoritmos.Hanoi;
import pt.ipleiria.estg.dei.aed.utils.Estatistica;
import pt.ipleiria.estg.dei.aed.utils.visualizacao.VisualizadorEstatisticas;

import java.util.ArrayList;
import java.util.List;

public class MainPraticaFatorial {
    public static void main(String[] args)
    {
        new MainPraticaFatorial();
    }

    public MainPraticaFatorial()
    {
        Fatorial fatorial = new Fatorial();
        Fibonacci fibonacci = new Fibonacci();



        fibonacci.executar(5);
        fibonacci.executar(0);
        fibonacci.executar(-10);
        fibonacci.executar(40);
        fibonacci.executar(45);


        fatorial.estatisticaChamadas(5);
        fatorial.estatisticaChamadas(0);
        fatorial.estatisticaChamadas(-5);
        fatorial.estatisticaChamadas(21);



        List<Estatistica> lista = new ArrayList<>();
        for (int i=1; i<21; i++)
            lista.add(fatorial.estatisticaChamadas(i));

        VisualizadorEstatisticas visualizador = new VisualizadorEstatisticas();
        visualizador.adicionarEstatisticas("fatorial", lista);
        visualizador.visualizar();
    }

    }

