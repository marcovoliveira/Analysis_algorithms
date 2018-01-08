package pt.ipleiria.estg.dei.aed.modelo.contactos;

import pt.ipleiria.estg.dei.aed.colecoes.iteraveis.IteradorIteravel;
import pt.ipleiria.estg.dei.aed.colecoes.iteraveis.IteradorIteravelDuplo;
import pt.ipleiria.estg.dei.aed.colecoes.iteraveis.lineares.ordenadas.estruturas.ListaDuplaCircularBaseLimiteOrdenada;
import pt.ipleiria.estg.dei.aed.colecoes.iteraveis.lineares.ordenadas.estruturas.ListaDuplaCircularBaseLimiteOrdenadaDistinta;
import pt.ipleiria.estg.dei.aed.modelo.contactos.comparadores.ComparacaoLimiteContactosPorPrimeiroNomeAscedenteSeguidoPorUltimoNomeAscendente;
import pt.ipleiria.estg.dei.aed.modelo.contactos.comparadores.ComparacaoLimiteParesDataListaContactosPorDataAscendente;
import pt.ipleiria.estg.dei.aed.utils.Par;

import java.util.NoSuchElementException;

public enum GestorContactos {
    INSTANCIA;

    public static final IteradorIteravelDuplo<Contacto> ITERADOR_VAZIO = new ListaDuplaCircularBaseLimiteOrdenada<>
            (ComparacaoLimiteContactosPorPrimeiroNomeAscedenteSeguidoPorUltimoNomeAscendente.CRITERIO).iterador();
    private ListaDuplaCircularBaseLimiteOrdenadaDistinta<Par<Data, ListaDuplaCircularBaseLimiteOrdenada<Contacto>>> contactosPorData;

    GestorContactos(){
        contactosPorData = new ListaDuplaCircularBaseLimiteOrdenadaDistinta<>(
                ComparacaoLimiteParesDataListaContactosPorDataAscendente.CRITERIO);
    }

    public void inserirContacto(Contacto contacto){
        Par<Data, ListaDuplaCircularBaseLimiteOrdenada<Contacto>> parEncontrado =
                getPar(contacto.getDataNascimento());

        if(parEncontrado == null) { // Ainda não existe esta data na lista
            parEncontrado = new Par<>(contacto.getDataNascimento(),
                    new ListaDuplaCircularBaseLimiteOrdenada<Contacto>
                            (ComparacaoLimiteContactosPorPrimeiroNomeAscedenteSeguidoPorUltimoNomeAscendente.CRITERIO));
            contactosPorData.inserir(parEncontrado);
        }
        parEncontrado.getSegundo().inserir(contacto);
    }

    public Contacto remover(Contacto contactoARemover) {
        Par<Data, ListaDuplaCircularBaseLimiteOrdenada<Contacto>> parEncontrado =
                getPar(contactoARemover.getDataNascimento());

        if (parEncontrado == null){
            return null;
        }
        Contacto removido = parEncontrado.getSegundo().remover(contactoARemover);

        if (parEncontrado.getSegundo().isVazia()) {
            contactosPorData.remover(parEncontrado);
        }

        return removido;
    }

    public IteradorIteravelDuplo<Contacto> remover(Data dataNascimento) {
        Par<Data, ListaDuplaCircularBaseLimiteOrdenada<Contacto>> parEncontrado =
                getPar(dataNascimento);

        if(parEncontrado != null){
            return contactosPorData.remover(parEncontrado).getSegundo().iterador();
        }

        // Não encontrou nehum com a data data
        // devolve um "saco vazio"

        return ITERADOR_VAZIO;

    }

    public Par<Data, ListaDuplaCircularBaseLimiteOrdenada<Contacto>> getPar(Data dataNascimento) {
        Par<Data, ListaDuplaCircularBaseLimiteOrdenada<Contacto>> parConsulta =
                new Par<>(dataNascimento, null);

        return contactosPorData.consultarDistintos(parConsulta);
    }

    public  IteradorIteravelDuplo<Contacto> consultar(Data dataNascimento){
        Par<Data, ListaDuplaCircularBaseLimiteOrdenada<Contacto>> parEncontrado
                = getPar(dataNascimento);

        if(parEncontrado != null){
            return parEncontrado.getSegundo().iterador();
        }
        return ITERADOR_VAZIO;
    }

    public IteradorIteravelDuplo<Contacto> consultar(Data dataInicio, Data dataFim){

        // IMPLEMENTAR UMA SOLUÇÃO O(N) DA 0!!!!!!!
        // IMPLEMENTAR UMA SOLUÇÃO O(N) DA 0!!!!!!!
        // IMPLEMENTAR UMA SOLUÇÃO O(N) DA 0!!!!!!!
        // Codigo correto em AED
        return new Iterador(dataInicio, dataFim);

    }

    private class Iterador implements IteradorIteravelDuplo<Contacto>{

        private IteradorIteravelDuplo<Par <Data, ListaDuplaCircularBaseLimiteOrdenada<Contacto>>> iteradorPares;
        private IteradorIteravelDuplo<Contacto> iteradorContactosDoPar;

        public Iterador(Data dataInicio, Data dataFim){
            iteradorPares = contactosPorData.consultar(
                    new Par<>(dataInicio, null), new Par<>(dataFim, null)
            );
            iteradorContactosDoPar = ITERADOR_VAZIO;
        }

        @Override
        public void reiniciar() {
            iteradorPares.reiniciar();
            iteradorContactosDoPar = ITERADOR_VAZIO;
        }

        @Override
        public Contacto corrente() {
            return iteradorContactosDoPar.corrente();
        }

        @Override
        public boolean podeAvancar() {
            return iteradorContactosDoPar.podeAvancar() || iteradorPares.podeAvancar();
        }

        @Override
        public Contacto avancar() {
            if(!podeAvancar()){
                throw new NoSuchElementException();
            }

            if (!iteradorContactosDoPar.podeAvancar()) {
                Par<Data, ListaDuplaCircularBaseLimiteOrdenada<Contacto>> proximoPar = iteradorPares.avancar();
                iteradorContactosDoPar = proximoPar.getSegundo().iterador();

            } // Tenho a certeza que posso avançar no iteradorContactosDoPar
            return iteradorContactosDoPar.avancar();
        }

        @Override
        public boolean podeRecuar() {
            return iteradorContactosDoPar.podeRecuar() || iteradorPares.podeRecuar();
        }

        @Override
        public Contacto recuar() {
            if(!podeRecuar()){
                throw new NoSuchElementException();
            }
            if (!iteradorContactosDoPar.podeRecuar()) {
                Par<Data, ListaDuplaCircularBaseLimiteOrdenada<Contacto>> proximoPar = iteradorPares.recuar();
                iteradorContactosDoPar = proximoPar.getSegundo().iterador();

            } // Tenho a certeza que posso recuar no iteradorContactosDoPar
            return iteradorContactosDoPar.recuar();

        }

    }

}
