package pt.ipleiria.estg.dei.aed.utils.visualizacao;

import pt.ipleiria.estg.dei.aed.utils.Estatistica;
import pt.ipleiria.estg.dei.aed.utils.Par;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Actual code:
 * Carlos Urbano<carlos.urbano@ipleiria.pt>
 * Catarina Reis<catarina.reis@ipleiria.pt>
 * Marco Ferreira<marco.ferreira@ipleiria.pt>
 * João Ramos<joao.f.ramos@ipleiria.pt>
 * Original code: José Magno<jose.magno@ipleiria.pt>
 */
public class VisualizadorEstatisticas {
    private List<Par<String, List<Estatistica>>> algoritmosEstatisticas;

    public VisualizadorEstatisticas() {
        this.algoritmosEstatisticas = new ArrayList<>();
    }

    public void adicionarEstatisticas(String algoritmo, List<Estatistica> estatisticas) {
        if (algoritmosEstatisticas.size() > 0) {
            List<Estatistica> estatisticasExistentes = algoritmosEstatisticas.get(0).getSegundo();
            if (estatisticasExistentes.size() != estatisticas.size()) {
                throw new IllegalArgumentException("Número de estatísticas diferente");
            }
            for (int i = 0; i < estatisticasExistentes.size(); i++) {
                if (estatisticasExistentes.get(i).getTamanho() != estatisticas.get(i).getTamanho()) {
                    throw new IllegalArgumentException("Indices X não coincidentes");
                }
            }
        }
        algoritmosEstatisticas.add(new Par<>(algoritmo, estatisticas));
    }

    public void visualizar() {
        String[] algoritmos = new String[algoritmosEstatisticas.size()];
        for (int i = 0; i < algoritmos.length; i++) {
            algoritmos[i] = algoritmosEstatisticas.get(i).getPrimeiro();
        }

        Par<String, List<Estatistica>> primeiroPar = algoritmosEstatisticas.get(0);
        List<Estatistica> estatisticasDoPrimeiro = primeiroPar.getSegundo();
        Estatistica primeiraEstatisticaDoPrimeiro = estatisticasDoPrimeiro.get(0);
        int numeroContadores = primeiraEstatisticaDoPrimeiro.getNumeroContadores();

        Grafico[] graficos = new Grafico[numeroContadores + 1];

        Grafico graficoTempo = new Grafico("Tempo de Execução", algoritmos);
        graficos[numeroContadores] = graficoTempo;

        for (int k = 0; k < numeroContadores; k++) {
            graficos[k] = new Grafico(primeiraEstatisticaDoPrimeiro.getNomeContador(k), algoritmos);
        }

        for (int i = 0; i < estatisticasDoPrimeiro.size(); i++) {
            Estatistica estatisticaDoPrimeiro = primeiroPar.getSegundo().get(i);
            double[] tempos = new double[algoritmosEstatisticas.size()];
            double[][] contadores = new double[numeroContadores][algoritmosEstatisticas.size()];
            for (int j = 0; j < algoritmosEstatisticas.size(); j++) {
                tempos[j] = algoritmosEstatisticas.get(j).getSegundo().get(i).getTempoTotalMicrosegundos();
                for (int k = 0; k < numeroContadores; k++) {
                    contadores[k][j] = algoritmosEstatisticas.get(j).getSegundo().get(i).getContador(k);
                }
            }

            graficoTempo.adicionarPonto(estatisticaDoPrimeiro.getTamanho(), tempos);
            for (int k = 0; k < numeroContadores; k++) {
                graficos[k].adicionarPonto(estatisticaDoPrimeiro.getTamanho(), contadores[k]);
            }
        }

        JanelaGraficos janela = new JanelaGraficos("Estatísticas", 0, 2, graficos);
        janela.apresentar();
    }
}
