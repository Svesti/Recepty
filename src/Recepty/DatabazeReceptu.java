package Recepty;

import java.util.ArrayList;

public class DatabazeReceptu {
    private final ArrayList<Recept> databazeReceptu;

    /**
     * Konstruktor
     */
    public DatabazeReceptu(ArrayList<Recept> databazeReceptu) {
        this.databazeReceptu = databazeReceptu;
    }

    /**
     * Rozdělí textový řetězec na názvy surovin pomocí metody split(", "), vytvoří kolekci surovin receptu a poté vytvoří nový recept s touto kolekcí surovin a přidá ho do databáze receptů.
     *
     * @param surovinyText je zadaný uživatelem
     */
    public void pridejRecept(String nazevReceptu, String surovinyText) {
        // Odstraní mezery z okolí textových řetězců a převede je na malá písmena
        surovinyText = surovinyText.trim().toLowerCase();
        nazevReceptu = nazevReceptu.trim().toLowerCase();

        // Rozdělení textového řetězce na názvy surovin
        String[] nazvySurovin = surovinyText.split(", ");

        // Vytvoření kolekce pro suroviny receptu
        ArrayList<Surovina> surovinyReceptu = new ArrayList<>();

        // Přidání jednotlivých surovin do kolekce
        for (String nazevSuroviny : nazvySurovin) {
            // Vytvoření instance Suroviny a přidání do kolekce surovin receptu
            Surovina surovina = new Surovina(nazevSuroviny);
            surovinyReceptu.add(surovina);
        }

        // Vytvoření instance Receptu s novou kolekcí surovin a přidání do databáze receptů
        Recept novyRecept = new Recept(surovinyReceptu);
        novyRecept.setNazevReceptu(nazevReceptu);
        databazeReceptu.add(novyRecept);
    }

    /**
     * Vyhledá v databázi recept podle názvu
     *
     * @param castNazvu je zadaná uživatelem
     */
    public void vyhledejRecept(String castNazvu) {
        boolean nalezen = false; // Indikátor, zda byl recept nalezen
        // Procházení receptů v databázi
        for (Recept recept : databazeReceptu) {
            // Kontrola, zda recept obsahuje zadanou část
            if (recept.toString().contains(castNazvu)) {
                nalezen = true;
                System.out.println(recept); // Vypsáníreceptu, pokud byl nalezen

                // Výpis pro případ, že nebyl žádný recept nalezen
                if (!nalezen) {
                    System.out.println("Žádný recept nebyl nalezen.");
                }
            }
        }
    }

    /**
     * Vypíše všechny recepty v databázi
     */
    public void vypisVsechnyRecepty() {
        // Prázdný textový řetězec pro přidávání receptů
        StringBuilder vsechnyRecepty = new StringBuilder();
        // Cyklus, který přidá recepty do prázdného řetězce
        for (Recept recept : databazeReceptu) {
            vsechnyRecepty.append(recept.getNazevReceptu()).append("\n");
        }
        // Výpis
        System.out.println(vsechnyRecepty);
    }

}

