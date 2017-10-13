package pt.ipleiria.estg.dei.aed.analisecomplexidade.algoritmos;

import java.awt.geom.Point2D;

public class Equipas {

    public void executar (Point2D... equipas){
        int min = 0;
        int out = 1;
        double distance = 999999999;
        for (int i = 0; i < equipas.length; i++ )
        {

          for (int j = i+1; j < equipas.length; j++)
          {
                      System.out.println(equipas[i] + " vs " + equipas[j] +
                      "Distancia:" + equipas[i].distance(equipas[j]) );

                  if (equipas[i].distance(equipas[j]) < distance)
                  {
                        min = i;
                        out = j;
                        distance = equipas[min].distance(equipas[out]);
                  }
                }
             }
                System.out.println("Resultado: \n" + equipas[min] + " com " + equipas[out] + " Distancia: " + distance);
            }
        }


