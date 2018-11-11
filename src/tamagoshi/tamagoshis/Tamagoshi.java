package tamagoshi.tamagoshis;

import java.util.Random;

public class Tamagoshi {
    private int age;
    private static int lifeTime = 10;
    private int energy;
    private int maxEnergy;
    private String name;
    private Random rand = new Random();

    public Tamagoshi(String name) {
        this.name = name;
        this.age = 0;
        this.maxEnergy = rand.nextInt(5)+5;
        this.energy = rand.nextInt(5)+3;
    }

    public int getAge() {
        return age;
    }

    public int getEnergy() {
        return energy;
    }

    public int getMaxEnergy() {
        return maxEnergy;
    }

    public String getName() {
        return name;
    }

    public static int getLifeTime() {
        return lifeTime;
    }

    public boolean parle() {
        boolean statusBool;
        String statusTxt;

        if (this.energy <= 4) {
            statusTxt = "Je suis affamé";
            statusBool = false;
        } else {
            statusTxt = "Tout est ok";
            statusBool = true;
        }

        System.out.println(this.name+"> "+statusTxt);
        return statusBool;
    }

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

    public boolean consommeEnergie() {
        this.energy--;

        if (this.energy <= 0) {
            System.out.println(this.name+"> Je suis K.O.");
            return false;
        } else {
            return true;
        }
    }

    public boolean vieillir() {
        this.age++;
        return this.age < Tamagoshi.lifeTime;
    }

    @Override
    public String toString() {
        String txt = this.getClass().getSimpleName()+" "+this.name+" (";
        txt += "age="+this.age+"; ";
        txt += "lifetime="+Tamagoshi.lifeTime+"; ";
        txt += "energy="+this.energy+"; ";
        txt += "maxEnergy="+this.maxEnergy;
        txt += ")";

        return txt;
    }
}
