package pt.ipleiria.estg.dei.aed.modelo;

import java.util.InvalidPropertiesFormatException;

public class Data {
    private int dia;
    private int mes;
    private int ano;


    public Data(int dia, int mes, int ano){
        this.dia = dia;
        this.mes = mes;
        this.ano = ano;
    }

    public int getDia() {
        return dia;
    }

    public int getMes() {
        return mes;
    }

    public int getAno() {
        return ano;
    }

    @Override
    public String toString() {
        return dia + "/" + mes +"/" + ano;
    }

    public int comparar(Data dataNascimento) {
        int resultado = Integer.compare(ano, dataNascimento.ano);

        if(resultado != 0){
            return resultado;
        }

        resultado = Integer.compare(mes, dataNascimento.mes);
        if(resultado != 0)
        {
            return resultado;
        }

        return Integer.compare(dia , dataNascimento.dia);
    }

    public static Data ParseData(String strData) throws InvalidPropertiesFormatException {
        String[] partes = strData.split("/");
        if (partes.length != 3){
            throw new InvalidPropertiesFormatException("Data num formato invalido: " + strData);
        }
        return new Data(Integer.parseInt(partes[0]),Integer.parseInt(partes[1]),Integer.parseInt(partes[2]));
    }
}
