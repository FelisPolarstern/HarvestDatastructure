package GameClasses;

import java.util.ArrayList;
import java.util.List;

public class Farm {
    private Farmer farmer;
    private String name;
    private List<Field> fields;

    protected Farm(String farmer, String name){
        this.farmer = new Farmer(farmer);
        this.name = name;
        this.fields = new ArrayList<Field>();
        this.fields.add(new Field(4, 4));
    }

    protected String getName(){
        return this.name;
    }

    protected String getFarmerName(){
        return this.farmer.getName();
    }

    protected boolean hasWateringCan(){
        return this.farmer.hasWateringCan();
    }

    protected boolean hasFertilizer(){
        return this.farmer.hasFertilizer();
    }

    protected boolean hasEnoughGold(double price){
        return this.farmer.hasEnoughGold(price);
    }

    protected double getGold(){
        return this.farmer.getGold();
    }

    protected void buyWateringCan(){
        this.farmer.buyWateringCan();
    }

    protected void buyFertilizer(){
        this.farmer.buyFertiliser();
    }


}
