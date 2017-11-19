package pt.ipleiria.estg.dei.aed.ordenacao.utilizacao;

import pt.ipleiria.estg.dei.aed.Comparacao;
import pt.ipleiria.estg.dei.aed.modelo.contactos.Contacto;
import pt.ipleiria.estg.dei.aed.modelo.contactos.ContactosIO;
import pt.ipleiria.estg.dei.aed.modelo.contactos.comparadores.ComparacaoContactosPorUltimoNomeAscendenteSeguidoPorDataNascimentoDescendente;
import pt.ipleiria.estg.dei.aed.ordenacao.algoritmos.*;
import pt.ipleiria.estg.dei.aed.utils.IOUtils;

import java.io.File;
import java.lang.reflect.Array;
import java.util.Arrays;

public class MainPraticaComparacaoAlgoritmosOrdenacao {
    public MainPraticaComparacaoAlgoritmosOrdenacao(){
        File ficheiro = IOUtils.escolherFicheiroAbrir();
        if (ficheiro == null) {
            return;
        }
        Contacto[] contactosOriginais = ContactosIO.lerFicheiro(ficheiro);
        System.out.println("Lidos "+ contactosOriginais.length+ " contactos");

        Comparacao<Contacto> criterio =
                ComparacaoContactosPorUltimoNomeAscendenteSeguidoPorDataNascimentoDescendente.CRITERIO;


    AlgoritmoOrdenacao<Contacto>[] algoritmos = new AlgoritmoOrdenacao[] {
            new InsertionSort<>(criterio),
            new SelectionSort<>(criterio),
            new BubbleSortOtimizado<>(criterio),
            new QuickSort<>(criterio)
    };
    for (int i = 0; i < algoritmos.length;  i++)
    {
        algoritmos[i].getEstatistica(Arrays.copyOf(contactosOriginais, contactosOriginais.length));
    }
    }

    public static void main(String[] args){
        new MainPraticaComparacaoAlgoritmosOrdenacao();
    }

}
