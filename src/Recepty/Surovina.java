package Recepty;

public class Surovina {
    /**
     * Název suroviny
     */
    private String nazev;

    /**
     * Konstruktor pro surovinu
     * @param nazev definuje Název suroviny
     */
    public Surovina (String nazev){
        this.nazev = nazev;
    }

    /**
     * Vrátí název
     * @return nazev
     */
    public String getNazev() {
        return nazev;
    }

    /**
     * Vrátí celý název suroviny
     * @return celý název
     */
    @Override
    public String toString() {
        return getNazev();
    }
}

