package pt.ipleiria.estg.dei.aed.recursividade.utilizacao;

import pt.ipleiria.estg.dei.aed.recursividade.algoritmos.Hanoi;

public class MainPraticaHanoi {

    public  MainPraticaHanoi() {
        Hanoi hanoi = new Hanoi();

        hanoi.executar(4,'A','B','C');
    }

    public static void main (String[] args) {
        new MainPraticaHanoi();
    }
}
