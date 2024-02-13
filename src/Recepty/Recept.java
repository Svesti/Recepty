package Recepty;

import java.util.ArrayList;

public class Recept {
    /**
     * Název pro recept získaný od uživatele
     */
    private String nazevReceptu;

    /**
     * Kolekce surovin
     */
    public ArrayList<Surovina> recept;

    /**
     * Konstruktor pro recepty
     */
    public Recept(ArrayList<Surovina> recept) {
        this.recept = recept;
    }

    /**
     * Nastaví název receptu podle zadání uživatele
     * @param nazevReceptu zadává uživatel
     */
    public void setNazevReceptu(String nazevReceptu) {
        this.nazevReceptu = nazevReceptu;
    }

    /**
     * Vypíše název a suroviny konkrétního receptu
     * @return surovinyReceptu
     */
    @Override
    public String toString() {
        StringBuilder surovinyReceptu = new StringBuilder();
        for (int i = 0; i < getRecept().size(); i++) {
            surovinyReceptu.append(getRecept().get(i).toString());
            if ( i < getRecept().size() - 1)
                surovinyReceptu.append(", ");
        }
        return  "V receptu " + getNazevReceptu() + " jsou tyto suroviny: " + surovinyReceptu;
    }

    /**
     * Kolekce surovin v každém receptu
     */
    public ArrayList<Surovina> getRecept() {
        return recept;
    }

    /**
     *  Vrátí název receptu
     * @return Název receptu
     */
    public String getNazevReceptu() {
        return nazevReceptu;
    }
}
