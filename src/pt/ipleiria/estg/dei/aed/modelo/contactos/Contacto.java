package pt.ipleiria.estg.dei.aed.modelo.contactos;

/**
 * @author Actual code:
 * Carlos Urbano<carlos.urbano@ipleiria.pt>
 * Catarina Reis<catarina.reis@ipleiria.pt>
 * Marco Ferreira<marco.ferreira@ipleiria.pt>
 * João Ramos<joao.f.ramos@ipleiria.pt>
 * Original code: José Magno<jose.magno@ipleiria.pt>
 */
public class Contacto {
    private String primeiroNome;
    private String ultimoNome;
    private long numeroTelefone;
    private String morada;
    private Data dataNascimento;

    public Contacto(String primeiroNome, String ultimoNome,
                    long numeroTelefone, String morada,
                    Data dataNascimento) {
        this.primeiroNome = primeiroNome;
        this.ultimoNome = ultimoNome;
        this.numeroTelefone = numeroTelefone;
        this.morada = morada;
        this.dataNascimento = dataNascimento;
    }

    public String getPrimeiroNome() {
        return primeiroNome;
    }

    public String getUltimoNome() {
        return ultimoNome;
    }

    public long getNumeroTelefone() {
        return numeroTelefone;
    }

    public String getMorada() {
        return morada;
    }

    public Data getDataNascimento() {
        return dataNascimento;
    }

    @Override
    public String toString() {
        return primeiroNome + " " + ultimoNome +
                " - Nº: " + numeroTelefone +
                " - " + dataNascimento +
                " - " + morada + '\n';
    }

}
