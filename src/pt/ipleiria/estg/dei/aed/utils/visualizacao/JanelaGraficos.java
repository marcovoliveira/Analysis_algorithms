package pt.ipleiria.estg.dei.aed.utils.visualizacao;

import org.knowm.xchart.XChartPanel;

import javax.swing.*;
import java.awt.*;

/**
 * @author Actual code:
 * Carlos Urbano<carlos.urbano@ipleiria.pt>
 * Catarina Reis<catarina.reis@ipleiria.pt>
 * Marco Ferreira<marco.ferreira@ipleiria.pt>
 * João Ramos<joao.f.ramos@ipleiria.pt>
 * Original code: José Magno<jose.magno@ipleiria.pt>
 */
public class JanelaGraficos {
    private final Grafico[] graficos;
    private final String titulo;
    private final int linhas;
    private final int colunas;

    public JanelaGraficos(String titulo, int linhas, int colunas, Grafico... graficos) {
        this.graficos = graficos;
        this.titulo = titulo;
        this.linhas = linhas;
        this.colunas = colunas;
    }

    public void apresentar() {
        // Create and set up the window.
        JFrame frame = new JFrame(titulo);
        frame.setLayout(new GridLayout(linhas, colunas));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        // chart
        for (Grafico g : graficos) {
            JPanel chartPanel = new XChartPanel<>(g.gerarChart());
            frame.add(chartPanel);
        }

        // Display the window.
        frame.pack();
        frame.setVisible(true);
    }
}
