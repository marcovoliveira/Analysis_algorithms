package pt.ipleiria.estg.dei.aed.recursividade.algoritmos;

import pt.ipleiria.estg.dei.aed.utils.EstatisticaChamadas;

public class Fatorial {

    public int executar(EstatisticaChamadas estatistica, int n)
    {
        estatistica.incrementarChamadas();
        if(n<0) //validação dos parametros
        {
            throw new IllegalArgumentException("n tem de ser > 0");
        }
        if(n == 0) { //ponto base
            return 1;
        }

            return n*executar(estatistica,n-1); //chamada convergente
    }

    public EstatisticaChamadas estatisticaChamadas(int n)
    {
        try {
            EstatisticaChamadas estatistica = new EstatisticaChamadas(n);
            int resultado = executar(estatistica, n);
            estatistica.parar();

            System.out.println("Fatorial de " + n + " é: " + resultado);
            estatistica.apresentar();

            return estatistica;
        }catch (IllegalArgumentException ex)
        {
            System.out.println("Não é possivel calcular o fatorial("+n+")");
            return null;
        }
    }
}
