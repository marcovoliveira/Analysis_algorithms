package pt.ipleiria.estg.dei.aed.utils;

import java.util.Arrays;

/**
 * @author Actual code:
 * Carlos Urbano<carlos.urbano@ipleiria.pt>
 * Catarina Reis<catarina.reis@ipleiria.pt>
 * Marco Ferreira<marco.ferreira@ipleiria.pt>
 * João Ramos<joao.f.ramos@ipleiria.pt>
 * Original code: José Magno<jose.magno@ipleiria.pt>
 */
public abstract class Estatistica {
    private int tamanho;
    private String[] nomesContadores;
    private long[] contadores;
    private long tempoInicial;
    private long tempoTotal;

    public Estatistica(int tamanho, String... nomesContadores) {
        this.tamanho = tamanho;
        this.nomesContadores = nomesContadores;
        this.contadores = new long[nomesContadores.length];
        iniciar();
    }

    public void iniciar() {
        tempoInicial = System.nanoTime();
        Arrays.fill(contadores, 0);
        tempoTotal = -1;
    }

    public void parar() {
        tempoTotal = System.nanoTime() - tempoInicial;
    }

    public void incrementarContador(int indice) {
        contadores[indice]++;
    }


    public void apresentar() {
        System.out.println("Tempo de execução: " + getTempoTotalMilisegundos() + " ms");
        for (int i = 0; i < nomesContadores.length; i++) {
            System.out.println(nomesContadores[i] + ": " + getContador(i));
        }
        System.out.println();
    }

    public int getTamanho() {
        return tamanho;
    }

    public int getNumeroContadores() {
        return nomesContadores.length;
    }

    public String getNomeContador(int indice) {
        return nomesContadores[indice];
    }

    public String[] getNomesContadores() {
        return nomesContadores;
    }

    public long getContador(int indice) {
        return contadores[indice];
    }

    public double getTempoTotalMilisegundos() {
        return (tempoTotal / 1000000d);
    }

    public double getTempoTotalMicrosegundos() {
        return (tempoTotal / 1000d);
    }
}
