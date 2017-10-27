package pt.ipleiria.estg.dei.aed.modelo.contactos;

import pt.ipleiria.estg.dei.aed.modelo.Data;

public class Contacto {
    private String primeiroNome;
    private String ultimoNome;
    private String morada;
    private Data dataNascimento;
    private Long numeroTelefone;

    public Contacto(String primeiroNome, String ultimoNome, String morada, Data dataNascimento, Long numeroTelefone) {
        this.primeiroNome = primeiroNome;
        this.ultimoNome = ultimoNome;
        this.morada = morada;
        this.dataNascimento = dataNascimento;
        this.numeroTelefone = numeroTelefone;
    }

    public String getPrimeiroNome() {
        return primeiroNome;
    }

    public String getUltimoNome() {
        return ultimoNome;
    }

    public String getMorada() {
        return morada;
    }

    public Data getDataNascimento() {
        return dataNascimento;
    }

    public Long getNumeroTelefone() {
        return numeroTelefone;
    }

    @Override
    public String toString() {
        return "Contacto: " + primeiroNome + " - " + ultimoNome + " - " + morada
                + " - " + dataNascimento + " - " + numeroTelefone;

    }
}
