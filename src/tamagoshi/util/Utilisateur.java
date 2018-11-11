package tamagoshi.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Utilisateur {
    public static String saisieClavier(){
        try {
            BufferedReader clavier = new BufferedReader(new InputStreamReader(System.in));
            return clavier.readLine();
        } catch(IOException e) {
            e.printStackTrace();
            System.exit(0);
            return null;
        }
    }

    public static int saisieNombre(String texte) {
        boolean endloop = false;
        String input = "";

        while (!endloop) {
            if (!texte.equals("")) {
                System.out.println(texte);
            }
            input = Utilisateur.saisieClavier();

            if (Check.isInteger(input)) {
                endloop = true;
            } else {
                System.out.println("Le nombre saisi est invalide");
                System.out.println();
            }
        }

        return Integer.parseInt(input);
    }

    public static int saisieNombre(String texte, int min) {
        boolean endloop = false;
        String input = "";

        while (!endloop) {
            System.out.println(texte);
            input = Utilisateur.saisieClavier();

            if (Check.isInteger(input, min)) {
                endloop = true;
            } else {
                System.out.println("Le nombre saisi est invalide");
                System.out.println();
            }
        }

        return Integer.parseInt(input);
    }

    public static int saisieNombre(String texte, Integer min, int max) {
        boolean endloop = false;
        String input = "";

        while (!endloop) {
            System.out.println(texte);
            input = Utilisateur.saisieClavier();

            if (Check.isInteger(input, min, max)) {
                endloop = true;
            } else {
                System.out.println("Le nombre saisi est invalide");
                System.out.println();
            }
        }

        return Integer.parseInt(input);
    }
}