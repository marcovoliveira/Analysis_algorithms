package pt.ipleiria.estg.dei.aed.analisecomplexidade.utilizacao;

import pt.ipleiria.estg.dei.aed.analisecomplexidade.algoritmos.Equipas;

import java.awt.geom.Point2D;

public class MainPraticaEquipas {
    public  MainPraticaEquipas() {
        Equipas equipas = new Equipas();
        equipas.executar(new Point2D.Double(0,0), new Point2D.Double(5,5),
                new Point2D.Double(10,15), new Point2D.Double(8,9));
    }

    public static void main (String[] args) {

        new MainPraticaEquipas();
    }
}

