package pt.ipleiria.estg.dei.aed.recursividade.algoritmos;

public class Hanoi {

    public void executar(int numDiscos, char origem, char aux, char destino){ //aux é o auxiliar
      if (numDiscos <= 0)  { // validação do input
          throw new IllegalArgumentException("O numero de discos tem de ser positivo");
      }
        if (numDiscos == 1)
        {
            System.out.println("Mover disco de " + origem + " para o  "  + destino);
        }
        else {
            executar(numDiscos - 1, origem, destino, aux); //Chamada convergente
            executar(1, origem, aux, destino);             //Chamada convergente
            executar(numDiscos - 1, aux, origem, destino); //Chamada convergente
        }
    }
}
