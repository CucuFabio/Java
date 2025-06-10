package BackEnd;

public class Ville extends Immobile {
    private int superficieGiardino;

    public Ville(String codiceAlfanumerico, String indirizzo, String città, int superficie, int cap, int superficieGiardino) {
        super( codiceAlfanumerico, indirizzo, città, superficie, cap );
        this.superficieGiardino = superficieGiardino;
    }

    public int getSuperficieGiardino() {
        return superficieGiardino;
    }

    public String toString() {
        return super.toString() + "Superficie giardino: " + superficieGiardino + "\n\n";
    }
}
