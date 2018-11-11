package tamagoshi.jeu;

import tamagoshi.tamagoshis.Tamagoshi;
import tamagoshi.util.Utilisateur;

import java.util.ArrayList;
import java.util.Iterator;

public class TamaGame {
    private ArrayList<Tamagoshi> initialList = new ArrayList<>();
    private ArrayList<Tamagoshi> currentList;

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

            for(Iterator<Tamagoshi> tamagoshiIterator = currentList.iterator(); tamagoshiIterator.hasNext();) {
                Tamagoshi tamagoshi = tamagoshiIterator.next();
                if (!tamagoshi.consommeEnergie()) {
                    tamagoshiIterator.remove();
                } else if (!tamagoshi.vieillir()) {
                    tamagoshiIterator.remove();
                }
            }

            System.out.println();
            tour++;
        }
    }

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

    public static void main(String[] args) {
        TamaGame game = new TamaGame();
        game.initialisation();
        game.play();
        game.score();
    }
}