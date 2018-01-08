package pt.ipleiria.estg.dei.aed.modelo.contactos;

import pt.ipleiria.estg.dei.aed.colecoes.iteraveis.IteradorIteravel;
import pt.ipleiria.estg.dei.aed.colecoes.iteraveis.IteradorIteravelDuplo;
import pt.ipleiria.estg.dei.aed.colecoes.iteraveis.associativas.estruturas.TabelaHashPorSondagem;
import pt.ipleiria.estg.dei.aed.colecoes.iteraveis.associativas.estruturas.TabelaHashPorSondagemComIncrementoQuadratico;
import pt.ipleiria.estg.dei.aed.colecoes.iteraveis.lineares.ordenadas.estruturas.ListaDuplaCircularBaseLimiteOrdenada;
import pt.ipleiria.estg.dei.aed.colecoes.iteraveis.lineares.ordenadas.estruturas.ListaDuplaCircularBaseLimiteOrdenadaDistinta;
import pt.ipleiria.estg.dei.aed.colecoes.iteraveis.lineares.ordenadas.estruturas.ListaSimplesCircularBaseLimiteOrdenada;
import pt.ipleiria.estg.dei.aed.modelo.contactos.comparadores.ComparacaoLimiteContactosPorPrimeiroNomeAscedenteSeguidoPorUltimoNomeAscendente;
import pt.ipleiria.estg.dei.aed.modelo.contactos.comparadores.ComparacaoLimiteDataAscendente;
import pt.ipleiria.estg.dei.aed.utils.Par;

import java.util.NoSuchElementException;


public enum GestorContactosOtimizado  {
    INSTANCIA;

    //Tabela de hash em que a chave é a data e o valor é uma lista de contactos
    // TabelaHash<Data,Lista<Contacto>> é melhor que Lista<Par<Data, Lista>Contacto>>>
    // Tabela de Hash melhor que lista porque Hash -> O(1) e Lista -> O(N)
    // Uma lista tem que percorrer todos os elementos ate chegar ao elemento pretendido
    // Uma tabela de hash aplica a cada chave uma funcão de hash
        //E atraves do hash chegamos ao elemento que pretende
        //Ao pesquisar utilizamos a função que utilizamos para inserir Exemplo hash(data) -> resultado = posição na tabela

    //Sondagem Linear: Elemento a elemento
    //Sondagem Quadratica: Avança elemento^2
    //Sondagem hash duplo: Utiliza um segundo hash

    private TabelaHashPorSondagem<Data, ListaDuplaCircularBaseLimiteOrdenada<Contacto>> contactosPorData;
    private static final IteradorIteravelDuplo<Contacto> ITERADOR_VAZIO = new ListaDuplaCircularBaseLimiteOrdenada<>(
            ComparacaoLimiteContactosPorPrimeiroNomeAscedenteSeguidoPorUltimoNomeAscendente
                    .CRITERIO).iterador();

    private ListaDuplaCircularBaseLimiteOrdenadaDistinta<Data> datasExistentes;

    //Construtores
    GestorContactosOtimizado() {
        contactosPorData = new TabelaHashPorSondagemComIncrementoQuadratico<>(100);
        datasExistentes = new ListaDuplaCircularBaseLimiteOrdenadaDistinta<>(ComparacaoLimiteDataAscendente.CRITERIO);
    }


    public void inserir(Contacto contacto) {
        Data dataNascimento = contacto.getDataNascimento();

        ListaDuplaCircularBaseLimiteOrdenada<Contacto> listaContactos
                = contactosPorData.consultar(dataNascimento);
            if(listaContactos == null) {
                listaContactos = new ListaDuplaCircularBaseLimiteOrdenada<Contacto>(
                        ComparacaoLimiteContactosPorPrimeiroNomeAscedenteSeguidoPorUltimoNomeAscendente.CRITERIO
                );
                contactosPorData.inserir(dataNascimento, listaContactos);
                datasExistentes.inserir(dataNascimento);
            }
            listaContactos.inserir(contacto);

            // Para inserir numa estrutura com sub-estrutura:
            // 1º obter sub.estrutura
            // 2º Se não existir criá-la e adiciona-la á esturutra principal
            // 3º Inserir o elemento na sub-esturutura

    }


    public Contacto remover(Contacto contactoARemover) {

        Data dataNascimento = contactoARemover.getDataNascimento();

        ListaDuplaCircularBaseLimiteOrdenada<Contacto> listaContactos
                = contactosPorData.consultar(dataNascimento);

        if(listaContactos == null){
            return null;
        }

        Contacto contactoRemovido = listaContactos.remover(contactoARemover);

        if(listaContactos.isVazia()) {
            contactosPorData.remover(dataNascimento);
            datasExistentes.remover(dataNascimento);
        }

        return contactoRemovido;

        // Passos para remover um elemento de uma estrutura com sub-estrutura
        // 1º Obter a sub-estrutura
        // 2º Se a sub-estrutura existir,
        // 3º        remover o elemento dela
        // 3ª Se a sub-estrutura ficou vazia
        // 4º         remover a sub-estrutura da estrutura principal

    }


    public IteradorIteravelDuplo<Contacto> remover(Data dataNascimento){
        ListaDuplaCircularBaseLimiteOrdenada<Contacto> removido
                = contactosPorData.remover(dataNascimento);
        if (removido != null) {
            datasExistentes.remover(dataNascimento);
            return removido.iterador();
        }
        return ITERADOR_VAZIO;
    }


    public  IteradorIteravelDuplo<Contacto> consultar(Data dataNascimento) {
        ListaDuplaCircularBaseLimiteOrdenada<Contacto> listaDecontactos
                = contactosPorData.consultar(dataNascimento);
        if(listaDecontactos != null){
            return listaDecontactos.iterador();
        }
        return  ITERADOR_VAZIO;
    }

    public IteradorIteravelDuplo<Contacto> consultar(Data dataInicio, Data dataFim){

        // IMPLEMENTAR UMA SOLUÇÃO O(N) DA 0!!!!!!!
        // IMPLEMENTAR UMA SOLUÇÃO O(N) DA 0!!!!!!!
        // IMPLEMENTAR UMA SOLUÇÃO O(N) DA 0!!!!!!!

        return new Iterador(dataInicio, dataFim);
    }

    public class Iterador implements IteradorIteravelDuplo<Contacto> {

        private IteradorIteravelDuplo<Data> iteradorDatas;
        private IteradorIteravelDuplo<Contacto> iteradorContactosNaData;

        public Iterador(Data dataInicio, Data dataFim){
            iteradorDatas = datasExistentes.consultar(dataInicio, dataFim); // Data de inicio e data de fim define os limites
            iteradorContactosNaData = ITERADOR_VAZIO;
        }

        @Override
        public void reiniciar() {
            iteradorDatas.reiniciar();
            iteradorContactosNaData = ITERADOR_VAZIO;
        }

        @Override
        public boolean podeRecuar() {
            return iteradorContactosNaData.podeRecuar() || iteradorDatas.podeRecuar();
        }

        @Override
        public Contacto recuar() {
            if(!podeRecuar()){
                throw new NoSuchElementException();
            }
            if(!iteradorContactosNaData.podeRecuar()){
                iteradorContactosNaData = contactosPorData.consultar(iteradorDatas.recuar()).iterador();
            }
            return iteradorContactosNaData.recuar();
        }

        @Override
        public Contacto corrente() {
            return iteradorContactosNaData.corrente();
        }

        @Override
        public boolean podeAvancar() {
            return iteradorContactosNaData.podeAvancar() || iteradorDatas.podeAvancar();
        }

        @Override
        public Contacto avancar() {
            if(!podeAvancar()) {
                throw new NoSuchElementException();
            }

            if(!iteradorContactosNaData.podeAvancar()){
                iteradorContactosNaData =
                        contactosPorData.consultar(iteradorDatas.avancar()).iterador();

            }
            return iteradorContactosNaData.avancar();
        }
    }


}


