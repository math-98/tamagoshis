package tamagoshi.jeu;

import tamagoshi.tamagoshis.Tamagoshi;
import tamagoshi.util.Utilisateur;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Game class
 * @author Mathieu SERVIERE
 */
public class TamaGame {
    private ArrayList<Tamagoshi> initialList = new ArrayList<>();
    private ArrayList<Tamagoshi> currentList;

    /**
     * Init method.<br>
     * This method asks the user how many Tamagoshi he wants to create.<br>
     * For each one it asks for a name.<br>
     * It adds everytime the created Tamagoshi to a list (Initial).<br>
     * This list is duplicated at the end (Current),
     * this clone will only contain alive Tamagoshis.
     */
    private void initialisation() {
        Tamagoshi tamagoshi;

        int nb = Utilisateur.saisieNombre("Entrer le nombre de Tamagoshi à créer (min. 2) :", 2);
        System.out.println();

        for (int i=0; i<nb; i++) {
            System.out.println("Tamagoshi "+(i+1)+", entrer un nom : ");
            tamagoshi = new Tamagoshi(Utilisateur.saisieClavier());
            System.out.println(tamagoshi);
            initialList.add(tamagoshi);
            System.out.println();
        }

        this.currentList = (ArrayList<Tamagoshi>) this.initialList.clone();
    }

    /**
     * Game method.<br>
     * This method runs while there are still alive Tamagoshis:
     * <ul>
     *     <li>It makes every Tamagoshi to speak.</li>
     *     <li>The user selects wich Tamagoshi he wants to feed.</li>
     *     <li>The user selects wich Tamagoshi he wants to play with.</li>
     *     <li>It removes from the current list the dead Tamagoshis (Age, hunger, boreness).</li>
     * </ul>
     */
    private void play() {
        int tour = 0;
        while (!currentList.isEmpty()) {
            System.out.println("=====================================");
            System.out.println();

            System.out.println("Tour n°"+tour);
            String listTama = "";
            int i = 0;
            for(Tamagoshi tamagoshi : currentList) {
                tamagoshi.parle();
                listTama += "\n"+"("+i+") "+tamagoshi.getName();
                i++;
            }
            System.out.println();

            String txtfeed = "Nourrir quel Tamagoshi ?";
            txtfeed += listTama;
            currentList.get(Utilisateur.saisieNombre(txtfeed, 0, currentList.size()-1)).mange();

            System.out.println();

            String txtfun = "S'amuser avec quel Tamagoshi ?";
            txtfun += listTama;
            currentList.get(Utilisateur.saisieNombre(txtfun, 0, currentList.size()-1)).divertir();

            for(Iterator<Tamagoshi> tamagoshiIterator = currentList.iterator(); tamagoshiIterator.hasNext();) {
                Tamagoshi tamagoshi = tamagoshiIterator.next();
                if (!tamagoshi.consommeEnergie()) {
                    tamagoshiIterator.remove();
                } else if (!tamagoshi.consommeFun()) {
                    tamagoshiIterator.remove();
                } else if (!tamagoshi.vieillir()) {
                    tamagoshiIterator.remove();
                }
            }

            System.out.println();
            tour++;
        }
    }

    /**
     * Method calculing and showing the score at the end of the game.<br>
     * This methods loops over the initial list and looks the age each Tamagoshi had at the end of the game:
     * <ul>
     *     <li>If the Tamagoshi had reached its lifetime it's considered to have survived.</li>
     *     <li>Else it means it's dead because of carelessness (Hunger or boreness)(Faim ou manque d'amusement).</li>
     * </ul>
     * It sums these ages to calculate the final score.
     */
    private void score() {
        int points = 0;
        for (Tamagoshi tamagoshi : initialList) {
            if (tamagoshi.getAge() == Tamagoshi.getLifeTime()) {
                System.out.println(tamagoshi.getName()+" a survécu, bravo !");
            } else {
                System.out.println(tamagoshi.getName()+" est mort !");
            }
            points += tamagoshi.getAge();
        }

        System.out.println();
        System.out.println("Score : "+((float) points / (float) (initialList.size() * Tamagoshi.getLifeTime()))*100+"%");
        System.out.println("Difficulté : "+(initialList.size()-1));
    }

    /**
     * Main method.<br>
     * This method successively calls:
     * <ul>
     *     <li>Initialization (Tamagoshis creation).</li>
     *     <li>Game itself.</li>
     *     <li>Score calculation &amp; displaying.</li>
     * </ul>
     * @see TamaGame#initialisation()
     * @see TamaGame#play()
     * @see TamaGame#score()
     * @param args Arguments entered in command line (Unused)
     */
    public static void main(String[] args) {
        TamaGame game = new TamaGame();
        game.initialisation();
        game.play();
        game.score();
    }
}