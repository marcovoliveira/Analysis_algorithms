package pt.ipleiria.estg.dei.aed.analisecomplexidade.utilizacao;

import pt.ipleiria.estg.dei.aed.analisecomplexidade.algoritmos.ParPontos;
import pt.ipleiria.estg.dei.aed.utils.VetorDePoint2D;

public class MainPraticaParPontos {

    public  MainPraticaParPontos() {
       ParPontos parPontos = new ParPontos();

       parPontos.executar(VetorDePoint2D.criarAleatorio(4));
    }

    public static void main (String[] args) {

        new MainPraticaParPontos();
    }
}

