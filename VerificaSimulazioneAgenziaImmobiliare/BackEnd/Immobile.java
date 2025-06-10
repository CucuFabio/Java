package BackEnd;

public class Immobile {
    private String codiceAlfanumerico;
    private String indirizzo;
    private String città;
    private int superficie;
    private int cap;

    public Immobile(String codiceAlfanumerico, String indirizzo, String città, int superficie, int cap) {
        this.codiceAlfanumerico = codiceAlfanumerico;
        this.indirizzo = indirizzo;
        this.città = città;
        this.superficie = superficie;
        this.cap = cap;
    }

    public String getCodiceAlfanumerico() {
        return codiceAlfanumerico;
    }

    public String getIndirizzo() {
        return indirizzo;
    }

    public String getCittà() {
        return città;
    }

    public int getSuperficie() {
        return superficie;
    }

    public int getCap() {
        return cap;
    }

    public String toString() {
        return String.format( "Codice alfanumerico: %s\nIndirizzo: %s\nCittà: %s\nCAP: %d\nSuperficie: %d\n", codiceAlfanumerico, indirizzo, città, cap, superficie );
    }
}
