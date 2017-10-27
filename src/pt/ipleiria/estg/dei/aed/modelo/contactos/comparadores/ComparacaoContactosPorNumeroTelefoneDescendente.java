package pt.ipleiria.estg.dei.aed.modelo.contactos.comparadores;

import pt.ipleiria.estg.dei.aed.Comparacao;
import pt.ipleiria.estg.dei.aed.modelo.contactos.Contacto;

public class ComparacaoContactosPorNumeroTelefoneDescendente
                implements Comparacao<Contacto>{
    @Override   
    public int comparar(Contacto o1, Contacto o2) {
        return -Long.compare(o1.getNumeroTelefone(), o2.getNumeroTelefone());
    }
}
