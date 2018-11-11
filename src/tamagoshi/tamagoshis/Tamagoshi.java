package tamagoshi.tamagoshis;

import java.util.Random;

/**
 * Class that represents a basic Tamagoshi.
 * @author Mathieu SERVIERE
 */
public class Tamagoshi {
    /**
     * The Tamagoshi's age.
     */
    private int age;

    /**
     * The lifetime of a Tamagoshi.
     */
    private static int lifeTime = 10;

    /**
     * The Tamagoshi energy level.
     */
    private int energy;

    /**
     * The Tamagoshi maximum energy level.<br>
     * It refuses to eat if its energy level is greater than this.
     */
    private int maxEnergy;

    /**
     * The Tamagoshi fun level.
     */
    private int fun;

    /**
     * The Tamagoshi maximum fun level.<br>
     * It refuses to play if its fun level is greater than this.
     */
    private int maxFun;

    /**
     * The Tamagoshi name.
     */
    private String name;

    /**
     * Variable for random number generation.
     */
    private Random rand = new Random();

    /**
     * Tamagoshi creation.
     * @param name The Tamagoshi's name
     */
    public Tamagoshi(String name) {
        this.name = name;
        this.age = 0;
        this.maxEnergy = rand.nextInt(5)+5;
        this.maxFun = rand.nextInt(5)+5;
        this.energy = rand.nextInt(5)+3;
        this.fun = rand.nextInt(5)+3;
    }

    /**
     * @return The Tamagoshi's age.
     */
    public int getAge() {
        return age;
    }

    /**
     * @return The Tamagoshi's energy level.
     */
    public int getEnergy() {
        return energy;
    }

    /**
     * @return The Tamagoshi's maximum energy level.
     */
    public int getMaxEnergy() {
        return maxEnergy;
    }

    /**
     * @return The Tamagoshi's fun level.
     */
    public int getFun() {
        return fun;
    }

    /**
     * @return The Tamagoshi's maximum fun level.
     */
    public int getMaxFun() {
        return maxFun;
    }

    /**
     * @return The Tamagoshi's name.
     */
    public String getName() {
        return name;
    }

    /**
     * @return The lifetime of a Tamagoshi.
     */
    public static int getLifeTime() {
        return lifeTime;
    }

    /**
     * Makes the Tamagoshi to talk.<br>
     * The Tamagoshi says its name and status (Bored, Starving, ...).
     * @return true if the Tamagoshi feels well, else false
     */
    public boolean parle() {
        boolean statusBool = false;
        String statusTxt;

        if (this.energy <= 4 && this.fun <= 4) {
            statusTxt = "J'ai faim et je m'ennuie";
        } else if (this.energy <= 4) {
            statusTxt = "Je suis affamé";
        } else if (this.fun <= 4) {
            statusTxt = "Je m'ennuie";
        } else {
            statusTxt = "Tout est ok";
            statusBool = true;
        }

        System.out.println(this.name+"> "+statusTxt);
        return statusBool;
    }

    /**
     * Makes the Tamagoshi to eat.<br>
     * If the Tamagoshi's energy level is greater than its maximum, it refuses.
     * @return Has the Tamagoshi eaten?
     */
    public boolean mange() {
        if (this.energy < this.maxEnergy) {
            this.energy += rand.nextInt(4)+1;
            System.out.println(this.name+"> Miam, c'était bon !");
            return true;
        } else {
            System.out.println(this.name+"> J'ai pas faim !!!");
            return false;
        }
    }

    /**
     * Makes the Tamagoshi to spend energy.
     * @return Does the Tamagoshi still have energy in stock?
     */
    public boolean consommeEnergie() {
        this.energy--;

        if (this.energy <= 0) {
            System.out.println(this.name+"> Je suis K.O.");
            return false;
        } else {
            return true;
        }
    }

    /**
     * Play with the Tamagoshi.<br>
     * If the Tamagoshi's fun level is greater that its maximum, it refuses.
     * @return Has the Tamagoshi had fun?
     */
    public boolean divertir() {
        if (this.fun < this.maxFun) {
            this.fun += rand.nextInt(4)+1;
            System.out.println(this.name+"> Waw, qu'est-ce qu'on s'amuse !");
            return true;
        } else {
            System.out.println(this.name+"> Laisse moi tranquille !!!");
            return false;
        }
    }

    /**
     * Makes the Tamagoshi to spend fun.
     * @return Does the Tamagoshi still have fun in stock?
     */
    public boolean consommeFun() {
        this.fun--;

        if (this.fun <= 0) {
            System.out.println(this.name+"> Je déprime, je vais me pendre !");
            return false;
        } else {
            return true;
        }
    }

    /**
     * Makes the Tamagoshi to age.
     * @return Is the Tamagoshi still under its lifetime?
     */
    public boolean vieillir() {
        this.age++;
        return this.age < Tamagoshi.lifeTime;
    }

    /**
     * @return Infos about the Tamagoshi (To debug)
     */
    @Override
    public String toString() {
        String txt = this.getClass().getSimpleName()+" "+this.name+" (";
        txt += "age="+this.age+"; ";
        txt += "lifetime="+Tamagoshi.lifeTime+"; ";
        txt += "energy="+this.energy+"; ";
        txt += "maxEnergy="+this.maxEnergy+"; ";
        txt += "fun="+this.fun+"; ";
        txt += "maxFun="+this.maxFun;
        txt += ")";

        return txt;
    }
}
