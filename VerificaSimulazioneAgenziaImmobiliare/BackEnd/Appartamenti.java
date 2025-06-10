package BackEnd;

public class Appartamenti extends Immobile {
    private int nVani;
    private int nBagni;

    public Appartamenti(String codiceAlfanumerico, String indirizzo, String città, int superficie, int cap, int nVani, int nBagni) {
        super( codiceAlfanumerico, indirizzo, città, superficie, cap );
        this.nVani = nVani;
        this.nBagni = nBagni;
    }

    public int getnVani() {
        return nVani;
    }

    public int getnBagni() {
        return nBagni;
    }

    public String toString() {
        return super.toString() + "Numero vani: " + nVani + "\nNumero bagni: " + nBagni + "\n\n";
    }
}
