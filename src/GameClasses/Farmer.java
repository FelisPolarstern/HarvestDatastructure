package GameClasses;
import java.util.HashMap;

public class Farmer {
    private String name;
    private double energy;


    private HashMap<PlantType, Integer> seeds;

    protected Farmer(String name){
        this.name = name;
        this.energy = 100;
    }

    protected String getName(){
        return this.name;
    }

    protected void action(){
        this.energy -= 10;
    }

    protected void resetEnergy(){
        this.energy = 100;
    }

    protected boolean hasEnergy(){
        if(this.energy == 0){
            return false;
        }
        return true;
    }

    protected void reduceEnergy(){
        this.energy -= 10;
    }


}
