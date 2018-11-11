package tamagoshi.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Class interacting with user.
 * @author Mathieu SERVIERE
 */
public class Utilisateur {
    /**
     * Get user's keyboard input
     * @return The typed string
     */
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

    /**
     * Get a keyboard inputed integer.<br>
     * If the input isn't an integer an error is displayed and the user has to redo.
     * @param texte A text to display before the input (Empty string to ignore)
     * @return The inputed integer
     */
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

    /**
     * Get a keyboard inputed integer greater than a given minimum.<br>
     * If the input doesn't respect the conditions an error is displayed and the user has to redo.
     * @param texte A text to display before the input (Empty string to ignore)
     * @param min The minimum to check against
     * @return The inputed integer
     */
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

    /**
     * Get a keyboard inputed integer inside a given interval.<br>
     * If the input doesn't respect the conditions an error is displayed and the user has to redo.
     * @param texte A text to display before the input (Empty string to ignore)
     * @param min The minimum to check against (null to ignore)
     * @param max The maximum to check against
     * @return The inputed integer
     */
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