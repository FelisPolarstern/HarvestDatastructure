package GameClasses;

import java.util.ArrayList;

public class Farmer {
    private String name;
    private double gold;
    private double energy;
    private ArrayList<Tool> tools;

    protected Farmer(String name){
        this.name = name;
        this.gold = 200;
        this.energy = 100;
        this.tools = new ArrayList<>();
    }

    protected String getName(){
        return this.name;
    }

    protected void buyWateringCan(){
        this.gold -= Tool.WATERINGCAN.getToolCost();
        this.tools.add(Tool.WATERINGCAN);
    }

    protected void buyFertiliser(){
        this.gold -= Tool.FERTILISER.getToolCost();
        this.tools.add(Tool.FERTILISER);
    }

    protected boolean hasWateringCan(){
        return this.tools.contains(Tool.WATERINGCAN);
    }
    protected boolean hasFertilizer(){
        return this.tools.contains(Tool.FERTILISER);
    }

    protected boolean hasEnoughGold(double price){
        return this.gold - price >= 0;
    }

    protected double getGold(){
        return this.gold;
    }
}
