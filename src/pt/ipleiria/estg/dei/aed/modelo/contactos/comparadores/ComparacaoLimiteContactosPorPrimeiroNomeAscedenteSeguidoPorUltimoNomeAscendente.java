package pt.ipleiria.estg.dei.aed.modelo.contactos.comparadores;

import pt.ipleiria.estg.dei.aed.ComparacaoLimite;
import pt.ipleiria.estg.dei.aed.modelo.contactos.Contacto;

public enum ComparacaoLimiteContactosPorPrimeiroNomeAscedenteSeguidoPorUltimoNomeAscendente
        implements ComparacaoLimite<Contacto> {
    CRITERIO;

    private static final Contacto LIMITE = new Contacto(
            String.valueOf(Character.MAX_VALUE), "", 0, "", null);

    @Override
    public Contacto getLimite() {
        return LIMITE;
    }

    @Override
    public int comparar(Contacto o1, Contacto o2) {
        int cp = o1.getPrimeiroNome().compareTo(o2.getPrimeiroNome());
        if(cp!=0){
            return cp;
        }
        return o1.getUltimoNome().compareTo(o2.getUltimoNome());
    }
}
