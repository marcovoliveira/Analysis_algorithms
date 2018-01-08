package pt.ipleiria.estg.dei.aed.modelo.contactos;

import java.io.*;
import java.util.InvalidPropertiesFormatException;

public class ContactosIO {
    public static Contacto[] lerFicheiro(File ficheiro) {
        try (BufferedReader br = new BufferedReader(new FileReader(ficheiro))) {

        String primeiraLinha = br.readLine().trim();
        int numeroDeContactos = Integer.parseInt(primeiraLinha);
        Contacto[] contactos = new Contacto[numeroDeContactos];

        int posContacto = 0;
        String linha = null;
        while ((linha = br.readLine()) != null){
            String[] partes = linha.split(",");
            if (partes.length != 5){
                throw new InvalidPropertiesFormatException("Contacto invalido!  " +linha);
            }
            contactos[posContacto] = new Contacto(partes[0], partes[1],
                    Long.parseLong(partes[2]), partes[3], Data.parseData(partes[4]));
            posContacto++;
        }

        if (posContacto!=numeroDeContactos){
            throw  new InvalidPropertiesFormatException("Numero de contactos invalido");
        }
        return contactos;

        } catch (IOException e) {
            e.printStackTrace();
        }
        return new Contacto[0];
    }
}
