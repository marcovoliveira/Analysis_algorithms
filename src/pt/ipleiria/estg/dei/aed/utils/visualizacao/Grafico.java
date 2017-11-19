package pt.ipleiria.estg.dei.aed.utils.visualizacao;

import org.knowm.xchart.XYChart;
import org.knowm.xchart.XYChartBuilder;
import org.knowm.xchart.XYSeries;
import org.knowm.xchart.style.Styler;
import org.knowm.xchart.style.XYStyler;

import java.util.LinkedList;
import java.util.List;

/**
 * @author Actual code:
 * Carlos Urbano<carlos.urbano@ipleiria.pt>
 * Catarina Reis<catarina.reis@ipleiria.pt>
 * Marco Ferreira<marco.ferreira@ipleiria.pt>
 * João Ramos<joao.f.ramos@ipleiria.pt>
 * Original code: José Magno<jose.magno@ipleiria.pt>
 */
public class Grafico {
    private final String titulo;
    private final String[] series;

    private List<Integer> listaX;
    private List<double[]> listaY;

    public Grafico(String titulo, String... series) {
        this.titulo = titulo;
        this.series = series;
        listaX = new LinkedList<>();
        listaY = new LinkedList<>();
    }

    public void adicionarPonto(int x, double... y) {
        listaX.add(x);
        listaY.add(y);
    }

    public XYChart gerarChart() {
        double max = 0;

        double[] xData = new double[listaX.size()];

        for (int i = 0; i < listaX.size(); i++) {
            xData[i] = listaX.get(i);
            if (xData[i] > max) {
                max = xData[i];
            }
        }

        final XYChart chart = new XYChartBuilder().width(400).height(400).title(titulo)/*.xAxisTitle("X").yAxisTitle("Y")*/.build();

        // Customize Chart
        XYStyler styler = chart.getStyler();
        styler.setLegendPosition(Styler.LegendPosition.InsideNE);
        styler.setDefaultSeriesRenderStyle(XYSeries.XYSeriesRenderStyle.Line);

        // Series
        int numeroContadores = series.length;

        for (int i = 0; i < numeroContadores; i++) {
            double[] yData = new double[listaX.size()];
            for (int j = 0; j < listaX.size(); j++) {
                yData[j] = listaY.get(j)[i];
                if (yData[j] > max) {
                    max = yData[j];
                }
            }
            chart.addSeries(series[i], xData, yData);
        }

        styler.setXAxisMax(max);
        styler.setYAxisMax(max);

        return chart;
    }
}
