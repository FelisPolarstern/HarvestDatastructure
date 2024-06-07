import java.util.ArrayList;

public class Farmer {
    String name;
    double gold;
    double energy;
    ArrayList<Tool> tools;

    public Farmer(String name){
        this.name = name;
        this.gold = 200;
        this.energy = 100;
        this.tools = new ArrayList<>();
    }

    public boolean buyWateringCan(){
        if(this.gold >= Tool.WATERINGCAN.getToolCost()){
            this.gold -= Tool.WATERINGCAN.getToolCost();
            this.tools.add(Tool.WATERINGCAN);
            return true;
        }
        System.out.println("You don't have enough gold to buy a watering can.");
        return false;
    }

    public boolean buyFertiliser(){
        if(this.gold >= Tool.FERTILISER.getToolCost()){
            this.gold -= Tool.FERTILISER.getToolCost();
            this.tools.add(Tool.FERTILISER);
            return true;
        }
        System.out.println("You don't have enough gold to buy fertiliser.");
        return false;
    }
}
