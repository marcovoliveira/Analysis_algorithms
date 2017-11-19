package pt.ipleiria.estg.dei.aed.utils;

import java.awt.geom.Point2D;
import java.util.Random;

/**
 * @author Actual code:
 * Carlos Urbano<carlos.urbano@ipleiria.pt>
 * Catarina Reis<catarina.reis@ipleiria.pt>
 * Marco Ferreira<marco.ferreira@ipleiria.pt>
 * João Ramos<joao.f.ramos@ipleiria.pt>
 * Original code: José Magno<jose.magno@ipleiria.pt>
 */
public class VetorDePoint2D {
    public static Point2D[] criarAleatorio(int tamanho) {
        Point2D[] resultado = new Point2D[tamanho];
        Random rnd = new Random(1);
        for (int i = 0; i < tamanho; i++) {
            resultado[i] = new Point2D.Double(rnd.nextInt(10000), rnd.nextInt(10000));
        }
        return resultado;
    }
}
