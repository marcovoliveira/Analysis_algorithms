package pt.ipleiria.estg.dei.aed.colecoes.iteraveis.lineares.naoordenadas.estruturas;

import pt.ipleiria.estg.dei.aed.colecoes.iteraveis.IteradorIteravel;
import pt.ipleiria.estg.dei.aed.colecoes.iteraveis.lineares.naoordenadas.ColecaoIteravelLinearNaoOrdenada;

import java.io.Serializable;
import java.util.NoSuchElementException;

public class ListaDuplaNaoOrdenada<T> implements ColecaoIteravelLinearNaoOrdenada<T> {
    private static final long serialVersionUID = 1L;
    private No noInicial;
    private No noFinal;
    private int numeroElementos;

    @Override
    public void inserirNoInicio(T elem) {
        // 2 casos: Lista vazia (noInicial e noFinal alterado)
        //          Lista não esta vazia (noInicial)

        if (numeroElementos++ == 0) { //1º CASO
            noInicial = noFinal = new No(elem);
        } else { // 2º CASO
            noInicial = new No(elem, noInicial);
        }
    }



    @Override
    public void inserirNoFim(T elem) {
        // 2 casos: Lista vazia (inserirNoInicio)
        //          Lista não esta vazia (noFinal)

        if (numeroElementos == 0) {
            inserirNoInicio(elem);
        } else {
            No novo = new No(elem);
            novo.anterior = noFinal;   // 1
            noFinal.seguinte = novo; // 2
            noFinal = novo;            // 3
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

    protected No getNo(int indice) {
        int meio = numeroElementos / 2;
        No novo;


        if (indice < meio) {
            int i = 0;
            novo = noInicial;
                while (indice != i++)
                {
                    novo = novo.seguinte;
                }
        } else {
            int j = numeroElementos-1;
            novo = noFinal;
                while (indice != j--)
                {
                    novo = novo.anterior;

                }
            //novo = novo.seguinte;
        }
            return novo;
        }

        @Override
        public boolean removerDoInicio () {
            if (numeroElementos == 0) {
                return false;
            }
            if (--numeroElementos == 0) {
                noInicial = noFinal = null;

            } else {
                noInicial.seguinte.anterior = null;
                noInicial = noInicial.seguinte;
            }
            return true;
        }

        @Override
        public boolean removerDoFim () {
            if (numeroElementos == 0) {
                return  false;
            }
            if(--numeroElementos == 0){
                noInicial = noFinal = null;
            } else {
            noFinal = noFinal.anterior;
            noFinal.seguinte.anterior = null;
            noFinal.seguinte = null;

            }
            return true;
        }

        //Remover um elemento
        @Override
        public boolean remover (Object elem){
          No novo = getNo(elem);
             if(novo.elemento.equals(elem)){
                 removerNo(novo);
                 return true;
             }else{
                 return false;
             }
        }

        //Remover um elemento por referencia
        @Override
        public boolean removerPorReferencia (Object elem){
            No novo = getNoReferencia(elem);
            if(novo.elemento == elem){
                removerNo(novo);
                return true;
            }else{
                return false;
            }
        }

        //Recebe um no e remove da lista
        private No removerNo (No aRemover){
            if (aRemover == noInicial) {
                 removerDoInicio();

            }
            if (aRemover == noFinal) {
                 removerDoFim();

            } else {
                aRemover.anterior.seguinte = aRemover.seguinte;
                aRemover.seguinte.anterior = aRemover.anterior;
                numeroElementos--;
            }
            return(aRemover);
        }

        //Recebe um elemento e devolve o no que contem o elemento
        protected No getNo(Object elem){
            No procurar = noInicial;
            while (!procurar.elemento.equals(elem)){
                procurar = procurar.seguinte;
                if(procurar == null){
                    throw new IndexOutOfBoundsException();
                }
            }
            return procurar;
        }

        //Recebe um elemento e devolve o no que contem a mesma referencia
        protected No getNoReferencia(Object elem){
            No procurar = noInicial;
                while (procurar.elemento != elem) {
                    procurar = procurar.seguinte;

                    if(procurar == null){
                        throw new IndexOutOfBoundsException();
                    }
            }
            return procurar;
        }

        @Override
        public boolean remover (int indice) {
            No remover = getNo(indice);
            if (remover == noInicial) {
                return removerDoInicio();
            }
            if (remover == noFinal) {
                return removerDoFim();
            } else {
                remover.anterior.seguinte = remover.seguinte;
                remover.seguinte.anterior = remover.anterior;
                numeroElementos--;
            }
            return  true;
        }


        @Override
        public T consultar ( int indice){
            return null;
        }

        @Override
        public boolean contem (Object elem){

            return false;
        }

        @Override
        public boolean contemReferencia (Object elem){

            return false;
        }

        @Override
        public IteradorIteravel iterador () {
            return null;
        }

        @Override
        public int getNumeroElementos () {
            return 0;
        }

        protected class No implements Serializable {
            private static final long serialVersionUID = 1L;

            protected T elemento;
            protected No seguinte;
            protected No anterior;


            public No(T elemento) {
                this.elemento = elemento;
                this.anterior = null;
                this.seguinte = null;
            }

            public No(T elemento, No seg) {
                this.elemento = elemento;
                anterior = seg.anterior; //1
                seguinte = seg;          //2
                seg.anterior = this;     //3
                if (anterior != null) {
                    anterior.seguinte = this; //4
                }
            }
        }
    }

