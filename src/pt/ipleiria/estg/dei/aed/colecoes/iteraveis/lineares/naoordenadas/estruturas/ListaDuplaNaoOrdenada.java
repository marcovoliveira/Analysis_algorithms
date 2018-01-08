package pt.ipleiria.estg.dei.aed.colecoes.iteraveis.lineares.naoordenadas.estruturas;

import pt.ipleiria.estg.dei.aed.colecoes.iteraveis.ColecaoIteravel;
import pt.ipleiria.estg.dei.aed.colecoes.iteraveis.IteradorIteravel;
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

@Deprecated
public class ListaDuplaNaoOrdenada<T> implements ColecaoIteravelLinearNaoOrdenada<T> {
    private static final long serialVersionUID = 1L;
    protected No noInicial;
    protected No noFinal;
    protected int numeroElementos;

    public ListaDuplaNaoOrdenada() {
        noInicial = null;
        noFinal = null;
        numeroElementos = 0;
    }

    public ListaDuplaNaoOrdenada(ColecaoIteravel<T> colecao) {
        this();

        IteradorIteravel<T> iterador = colecao.iterador();
        if (iterador.podeAvancar()) {
            noFinal = noInicial = new No(iterador.avancar());
        }
        while (iterador.podeAvancar()) {
            No novo = new No(iterador.avancar());
            noFinal.seguinte = novo;
            noFinal = novo;
        }
        numeroElementos = colecao.getNumeroElementos();
    }

    protected No getNo(T elem) {
        No cor = noInicial;
        while (cor != null && !cor.elemento.equals(elem)) {
            cor = cor.seguinte;
        }

        return cor;
    }

    protected No getNoPorReferencia(T elem) {
        No cor = noInicial;
        while (cor != null && cor.elemento != elem) {
            cor = cor.seguinte;
        }

        return cor;
    }

    private No getNo(int indice) {
        if (indice < 0 || indice >= numeroElementos) {
            throw new IndexOutOfBoundsException();
        }

        No cor;
        if (indice < numeroElementos / 2) {
            cor = noInicial;
            while (indice-- > 0) {
                cor = cor.seguinte;
            }
        } else {
            cor = noFinal;
            while (++indice < numeroElementos) {
                cor = cor.anterior;
            }
        }

        return cor;
    }

    @Override
    public void inserirNoInicio(T elem) {
        if (++numeroElementos == 1) {
            noInicial = noFinal = new No(elem);
        } else {
            noInicial = new No(elem, noInicial);
        }
    }

    @Override
    public void inserirNoFim(T elem) {
        if (numeroElementos == 0) {
            inserirNoInicio(elem);
        } else {
            noFinal = noFinal.seguinte = new No(elem);
            numeroElementos++;
        }
    }

    @Override
    public void inserir(int indice, T elem) {
        if (indice == 0) {
            inserirNoInicio(elem);
        } else if (indice == numeroElementos) {
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
    public T remover(T elem) {
        if (numeroElementos == 0) {
            return null;
        }

        if (noInicial.elemento.equals(elem)) {
            return removerDoInicio();
        }

        if (noFinal.elemento.equals(elem)) {
            return removerDoFim();
        }

        No no = getNo(elem);

        return no != null ? removerNo(no).elemento : null;
    }

    @Override
    public T removerPorReferencia(T elem) {
        if (numeroElementos == 0) {
            return null;
        }

        if (noInicial.elemento == elem) {
            return removerDoInicio();
        }

        if (noFinal.elemento == elem) {
            return removerDoFim();
        }

        No no = getNoPorReferencia(elem);

        return no != null ? removerNo(no).elemento : null;
    }

    @Override
    public T remover(int indice) {
        if (indice == 0) {
            return removerDoInicio();
        }
        if (indice == numeroElementos - 1) {
            return removerDoFim();
        }

        return removerNo(getNo(indice)).elemento;
    }

    @Override
    public T removerDoInicio() {
        if (numeroElementos == 0) {
            return null;
        }

        No aux = noInicial;
        noInicial = noInicial.seguinte;
        if (--numeroElementos == 0) {
            noFinal = null;
        } else {
            noInicial.anterior = null;
        }

        return aux.elemento;
    }

    @Override
    public T removerDoFim() {
        if (numeroElementos == 0) {
            return null;
        }

        if (numeroElementos == 1) {
            return removerDoInicio();
        }

        No aux = noFinal;
        noFinal = noFinal.anterior;
        noFinal.seguinte = null;
        numeroElementos--;

        return aux.elemento;
    }

    @Override
    public T consultar(int indice) {
        return getNo(indice).elemento;
    }

    @Override
    public int getNumeroElementos() {
        return numeroElementos;
    }

    @Override
    public boolean contem(T elem) {
        return getNo(elem) != null;
    }

    @Override
    public boolean contemReferencia(T elem) {
        return getNoPorReferencia(elem) != null;
    }

    @Override
    public IteradorIteravelDuplo<T> iterador() {
        return new Iterador();
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append("Lista Dupla Não Ordenada = {\n");
        No aux = noInicial;
        while (aux != null) {
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

        protected No(T elem) {
            elemento = elem;
            anterior = noFinal;
            seguinte = null;
        }

        protected No(T elem, No seg) {
            elemento = elem;
            anterior = seg.anterior;
            seguinte = seg;
            seg.anterior = this;

            if (anterior != null) {
                anterior.seguinte = this;
            }
        }
    }

    protected class Iterador implements IteradorIteravelDuplo<T> {
        protected No anterior;
        protected No corrente;
        protected No seguinte;

        public Iterador() {
            reiniciar();
        }

        @Override
        public void reiniciar() {
            anterior = noFinal;
            corrente = null;
            seguinte = noInicial;
        }

        @Override
        public T corrente() {
            if (corrente == null) {
                throw new NoSuchElementException();
            }
            return corrente.elemento;
        }

        @Override
        public boolean podeAvancar() {
            return seguinte != null;
        }

        @Override
        public T avancar() {
            if (!podeAvancar()) {
                throw new NoSuchElementException();
            }

            anterior = corrente;
            corrente = seguinte;
            seguinte = seguinte.seguinte;
            return corrente.elemento;
        }


        @Override
        public boolean podeRecuar() {
            return anterior != null;
        }

        @Override
        public T recuar() {
            if (!podeRecuar()) {
                throw new NoSuchElementException();
            }

            seguinte = corrente;
            corrente = anterior;
            anterior = anterior.anterior;
            return corrente.elemento;
        }
    }
}
