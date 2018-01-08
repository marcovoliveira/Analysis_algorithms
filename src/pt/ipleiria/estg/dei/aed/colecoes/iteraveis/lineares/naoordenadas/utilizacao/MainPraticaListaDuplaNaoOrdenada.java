package pt.ipleiria.estg.dei.aed.colecoes.iteraveis.lineares.naoordenadas.utilizacao;

import pt.ipleiria.estg.dei.aed.colecoes.iteraveis.IteradorIteravelDuplo;
import pt.ipleiria.estg.dei.aed.colecoes.iteraveis.lineares.naoordenadas.estruturas.ListaDuplaNaoOrdenada;
import pt.ipleiria.estg.dei.aed.modelo.contactos.Contacto;
import pt.ipleiria.estg.dei.aed.modelo.contactos.Data;

/**
 * @author Actual code:
 * Carlos Urbano<carlos.urbano@ipleiria.pt>
 * Catarina Reis<catarina.reis@ipleiria.pt>
 * Marco Ferreira<marco.ferreira@ipleiria.pt>
 * João Ramos<joao.f.ramos@ipleiria.pt>
 * Original code: José Magno<jose.magno@ipleiria.pt>
 */
public class MainPraticaListaDuplaNaoOrdenada {

    public MainPraticaListaDuplaNaoOrdenada() {

        ListaDuplaNaoOrdenada<Contacto> lista = new ListaDuplaNaoOrdenada<>();

        lista.inserir(new Contacto("Hugo", "Santos", 971234567, "Avenida 1º de Maio", new Data(18, 3, 1994)));
        lista.inserirNoInicio(new Contacto("Ana", "Silva", 950000000, "Rua de Leiria", new Data(1, 10, 1990)));
        lista.inserirNoFim(new Contacto("Eça", "Queiroz", 100000000, "Praça do Almada", new Data(25, 11, 1845)));
        lista.inserir(2, new Contacto("Teresa", "Silva", 950000001, "Rua de Leiria", new Data(2, 10, 1990)));
        lista.inserir(new Contacto("Ana", "Rita", 990000000, "Travessa 25 de Abril", new Data(15, 6, 2000)));

        System.out.println("Lista de Contactos");
        IteradorIteravelDuplo<Contacto> iterador = lista.iterador();
        while (iterador.podeAvancar()) {
            System.out.println(iterador.avancar());
        }

        System.out.println("Lista de Contactos ao Inverso");
        iterador.reiniciar();
        while (iterador.podeRecuar()) {
            System.out.println(iterador.recuar());
        }

        System.out.println("A remover elementos");
        lista.removerDoInicio();
        lista.removerDoFim();
        lista.remover(1);
        lista.removerPorReferencia(lista.consultar(1));


        System.out.println("\nApós remoção de elementos");
        for (Contacto contacto : lista) {
            System.out.println(contacto);
        }
    }


    public static void main(String[] args) {
        new MainPraticaListaDuplaNaoOrdenada();
    }
}
