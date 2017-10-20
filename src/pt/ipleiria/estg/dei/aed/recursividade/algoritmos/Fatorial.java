package pt.ipleiria.estg.dei.aed.recursividade.algoritmos;

import pt.ipleiria.estg.dei.aed.utils.EstatisticaDeChamadas;

public class Fatorial {
    public long executar(EstatisticaDeChamadas estatisticas, int n) {
        estatisticas.incrementarChamadas();
        if (n < 0) {
            throw new IllegalArgumentException("fatorial(" + n + ")= argumento inválido : deve ser >= 0");
        }
        if (n < 2) {
            return 1;
        }
        return n * executar(estatisticas, n - 1);
    }

    public EstatisticaDeChamadas getEstatistica(int n) {
        try {
            EstatisticaDeChamadas estatistica = new EstatisticaDeChamadas(n);
            long result = executar(estatistica, n);
            estatistica.parar();

            System.out.println("fatorial(" + n + ") = " + result);
            estatistica.apresentar();
            return estatistica;
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage() + "\n");
            return null;
        }
    }
}
