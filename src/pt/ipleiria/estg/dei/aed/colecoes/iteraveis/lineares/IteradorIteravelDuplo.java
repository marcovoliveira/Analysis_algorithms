package pt.ipleiria.estg.dei.aed.colecoes.iteraveis.lineares;

import pt.ipleiria.estg.dei.aed.colecoes.iteraveis.IteradorIteravel;

public interface IteradorIteravelDuplo<T> extends IteradorIteravel<T> {

    boolean podeRecuar();
    T recuar ();
}
