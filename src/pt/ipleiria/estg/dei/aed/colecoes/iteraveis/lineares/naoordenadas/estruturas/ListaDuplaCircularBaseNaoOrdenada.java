package pt.ipleiria.estg.dei.aed.colecoes.iteraveis.lineares.naoordenadas.estruturas;

import pt.ipleiria.estg.dei.aed.colecoes.iteraveis.ColecaoIteravel;
import pt.ipleiria.estg.dei.aed.colecoes.iteraveis.IteradorIteravelDuplo;
import pt.ipleiria.estg.dei.aed.colecoes.iteraveis.lineares.naoordenadas.ColecaoIteravelLinearNaoOrdenada;

import java.io.Serializable;
import java.util.NoSuchElementException;

/**
 * @author Actual code:
 * Carlos Urbano<carlos.urbano@ipleiria.pt>
 * Catarina Reis<catarina.reis@ipleiria.pt>
 * Marco Ferreira<marco.ferreira@ipleiria.pt>
 * João Ramos<joao.f.ramos@ipleiria.pt>
 * Original code: José Magno<jose.magno@ipleiria.pt>
 */
public class ListaDuplaCircularBaseNaoOrdenada<T> implements ColecaoIteravelLinearNaoOrdenada<T> {
    private static final long serialVersionUID = 1L;

    protected No base;
    protected int numeroElementos;

    public ListaDuplaCircularBaseNaoOrdenada() {
        base = new No();
        numeroElementos = 0;
    }

    public ListaDuplaCircularBaseNaoOrdenada(ColecaoIteravel<T> colecao) {
        this();
        for (T elem : colecao) {
            new No(elem, base);
        }
        numeroElementos = colecao.getNumeroElementos();
    }

    protected No getNo(T elem) {
        No cor = base.seguinte;
        while (cor != base && !cor.elemento.equals(elem)) {
            cor = cor.seguinte;
        }

        return cor;
    }

    protected No getNoPorReferencia(T elem) {
        No cor = base.seguinte;
        while (cor != base && cor.elemento != elem) {
            cor = cor.seguinte;
        }

        return cor;
    }

    protected No getNo(int indice) {
        if (indice < 0 || indice >= numeroElementos) {
            throw new IndexOutOfBoundsException();
        }

        No cor;
        if (indice < numeroElementos / 2) {
            cor = base.seguinte;

            while (indice-- > 0) {
                cor = cor.seguinte;
            }
        } else {
            cor = base.anterior;

            while (++indice < numeroElementos) {
                cor = cor.anterior;
            }
        }

        return cor;
    }

    @Override
    public void inserirNoInicio(T elem) {
        new No(elem, base.seguinte);
        numeroElementos++;
    }

    @Override
    public void inserirNoFim(T elem) {
        new No(elem, base);
        numeroElementos++;
    }

    @Override
    public void inserir(int indice, T elem) {
        if (indice == numeroElementos) {
            inserirNoFim(elem);
        } else {
            new No(elem, getNo(indice));
            numeroElementos++;
        }
    }

    private No removerNo(No aRemover) {
        aRemover.anterior.seguinte = aRemover.seguinte;
        aRemover.seguinte.anterior = aRemover.anterior;
        numeroElementos--;

        return aRemover;
    }

    @Override
    public T removerDoInicio() {
        return numeroElementos > 0 ? removerNo(base.seguinte).elemento : null;
    }

    @Override
    public T removerDoFim() {
        return numeroElementos > 0 ? removerNo(base.anterior).elemento : null;
    }

    @Override
    public T remover(T elem) {
        No no = getNo(elem);

        return no != base ? removerNo(no).elemento : null;
    }

    @Override
    public T removerPorReferencia(T elem) {
        No no = getNoPorReferencia(elem);

        return no != base ? removerNo(no).elemento : null;
    }

    @Override
    public T remover(int indice) {
        return removerNo(getNo(indice)).elemento;
    }

    @Override
    public T consultar(int indice) {
        return getNo(indice).elemento;
    }

    @Override
    public boolean contem(T elem) {
        return getNo(elem) != base;
    }

    @Override
    public boolean contemReferencia(T elem) {
        return getNoPorReferencia(elem) != base;
    }

    @Override
    public int getNumeroElementos() {
        return numeroElementos;
    }

    @Override
    public IteradorIteravelDuplo<T> iterador() {
        return new Iterador();
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append("Lista Dupla Circular Base Não Ordenada = {\n");
        No aux = base.seguinte;
        while (aux != base) {
            s.append(aux.elemento).append("\n");
            aux = aux.seguinte;
        }
        s.append("}\n");
        return s.toString();
    }


    protected class No implements Serializable {
        private static final long serialVersionUID = 1L;

        protected T elemento;
        protected No anterior;
        protected No seguinte;

        // Criação do nó base
        public No() {
            elemento = null;
            seguinte = anterior = this;
        }

        // Criação de nó com elemento elem e inserção antes do nó seg
        public No(T elem, No seg) {
            elemento = elem;
            anterior = seg.anterior;
            seguinte = seg;
            anterior.seguinte = seg.anterior = this;
        }
    }


    protected class Iterador implements IteradorIteravelDuplo<T> {
        protected No corrente;

        public Iterador() {
            reiniciar();
        }

        @Override
        public void reiniciar() {
            corrente = base;
        }

        @Override
        public T corrente() {
            if (corrente == base) {
                throw new NoSuchElementException();
            }
            return corrente.elemento;
        }

        @Override
        public boolean podeAvancar() {
            return corrente.seguinte != base;
        }

        @Override
        public T avancar() {
            if (!podeAvancar()) {
                throw new NoSuchElementException();
            }
            corrente = corrente.seguinte;
            return corrente.elemento;
        }

        @Override
        public boolean podeRecuar() {
            return corrente.anterior != base;
        }

        @Override
        public T recuar() {
            if (!podeRecuar()) {
                throw new NoSuchElementException();
            }
            corrente = corrente.anterior;
            return corrente.elemento;
        }
    }
}
