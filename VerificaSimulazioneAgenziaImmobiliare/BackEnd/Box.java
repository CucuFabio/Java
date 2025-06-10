package BackEnd;

public class Box extends Immobile {
    private int nPostiAuto;

    public Box(String codiceAlfanumerico, String indirizzo, String città, int superficie, int cap, int nPostiAuto) {
        super( codiceAlfanumerico, indirizzo, città, superficie, cap );
        this.nPostiAuto = nPostiAuto;
    }

    public int getnPostiAuto() {
        return nPostiAuto;
    }

    public String toString() {
        return super.toString() + "Numero posti auto: " + nPostiAuto + "\n\n";
    }
}
