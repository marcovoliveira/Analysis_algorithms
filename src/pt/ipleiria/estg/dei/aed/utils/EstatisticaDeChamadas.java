package pt.ipleiria.estg.dei.aed.utils;

/**
 * @author Actual code:
 * Carlos Urbano<carlos.urbano@ipleiria.pt>
 * Catarina Reis<catarina.reis@ipleiria.pt>
 * Marco Ferreira<marco.ferreira@ipleiria.pt>
 * João Ramos<joao.f.ramos@ipleiria.pt>
 * Original code: José Magno<jose.magno@ipleiria.pt>
 */
public class EstatisticaDeChamadas extends Estatistica {

    public EstatisticaDeChamadas(int tamanho) {
        this(tamanho, "Número de Chamadas");
    }

    protected EstatisticaDeChamadas(int tamanho, String... nomesContadores) {
        super(tamanho, nomesContadores);
    }

    public void incrementarChamadas() {
        incrementarContador(0);
    }

    public long getChamadas() {
        return getContador(0);
    }
}
