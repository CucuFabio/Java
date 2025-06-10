package BackEnd;

import java.util.ArrayList;

public class Agenzia {
    private ArrayList<Immobile> listaImmobile;

    public Agenzia() {
        this.listaImmobile = new ArrayList<>();
    }

    public void addImmobile(Immobile immobile) { // Non effettuo controlli per l'esistenza essendo gia stato effettuato precedentemente
        listaImmobile.add( immobile );
    }

    public void visualizza() {
        for (Immobile immobile : listaImmobile) {
            System.out.println( immobile.toString() );
        }
    }

    public ArrayList<Immobile> getListaImmobile() {
        return listaImmobile;
    }

    public void checkEsistenza(String codiceAlfaN) throws Exception {

        for (Immobile immobile : listaImmobile) {
            if (codiceAlfaN.equals( immobile.getCodiceAlfanumerico() )) {
                throw new Exception( "Errore, immobile già presente" );
            }
        }
    }

    public void ricerca(String condizioneRicerca, String str)
    {
        for (Immobile immobile : listaImmobile) {
            if (condizioneRicerca.equalsIgnoreCase( "città" ))
            {
                if (str.equals( immobile.getCittà() ))
                {
                    System.out.println(immobile.toString());
                }
            }
        }
    }
}
