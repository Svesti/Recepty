package Recepty;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        DatabazeReceptu databazeReceptu = new DatabazeReceptu(new ArrayList<>());
        String volba = "";
        System.out.println("\nVítej v databázi receptů☺");
        //hlavní cyklus
        while (!volba.equals("4")) {
            System.out.println(
                    """

                            Vyber akci:
                            1 - Přidat recept
                            2 - Zobraz recept
                            3 - Vypiš názvy všech receptů
                            4 - Konec
                            """);
            volba = scanner.nextLine().trim();
            // reakce na volbu
            switch (volba) {
                case "1":
                    System.out.println("Napiš název receptu:");
                    String nazevReceptu = scanner.nextLine().trim().toLowerCase();
                    System.out.println("Vypiš suroviny, které obsahuje tvůj nový recept. Suroviny odděluj čárkou a mezerou.");
                    String surovinyText = scanner.nextLine().trim().toLowerCase();
                    databazeReceptu.pridejRecept(nazevReceptu, surovinyText);
                    break;
                case "2":
                    System.out.println("Zadej název receptu pro zobrazení:");
                    String castNazvu = scanner.nextLine().trim().toLowerCase();
                    databazeReceptu.vyhledejRecept(castNazvu);
                    break;
                case "3":
                    databazeReceptu.vypisVsechnyRecepty();
                    break;
                case "4":
                    // ukončí cyklus
                    System.out.println("Uzavírám databázi, měj hezký den ☺☻");
                    break;
                default:
                    System.out.println("Neplatná volba, zadej znovu.");
                    break;
            }
        }
    }
}
