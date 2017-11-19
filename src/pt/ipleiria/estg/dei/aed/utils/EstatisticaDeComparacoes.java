package pt.ipleiria.estg.dei.aed.utils;

/**
 * @author Actual code:
 * Carlos Urbano<carlos.urbano@ipleiria.pt>
 * Catarina Reis<catarina.reis@ipleiria.pt>
 * Marco Ferreira<marco.ferreira@ipleiria.pt>
 * João Ramos<joao.f.ramos@ipleiria.pt>
 * Original code: José Magno<jose.magno@ipleiria.pt>
 */
public class EstatisticaDeComparacoes extends Estatistica {

    public EstatisticaDeComparacoes(int tamanho) {
        super(tamanho, "Número de Comparações");
    }

    protected EstatisticaDeComparacoes(int tamanho, String... nomesContadores) {
        super(tamanho, nomesContadores);
    }

    public void incrementarComparacoes() {
        incrementarContador(0);
    }

    public long getComparacoes() {
        return getContador(0);
    }
}
