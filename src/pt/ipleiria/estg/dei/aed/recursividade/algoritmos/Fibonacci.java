package pt.ipleiria.estg.dei.aed.recursividade.algoritmos;

public class Fibonacci {

    public int executar(int n) {
        int n1 = 0;
        int n2 = 1;
        for ( int i = 0; i < n; i++ ) {

            n2 = n1 + n2 + ( n1 = n2 ) - n2;
        }
        System.out.println(n1);
        return n1;
    }

}
