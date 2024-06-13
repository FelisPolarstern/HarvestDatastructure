package GameClasses;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Farm {
    private Farmer farmer;
    private String name;
    private List<Field> fields;
    double gold;
    private ArrayList<Tool> tools;
    private HashMap<PlantType, Integer> seeds;
    private HashMap<PlantType, Integer> harvest;


    protected Farm(String farmer, String name){
        this.farmer = new Farmer(farmer);
        this.name = name;
        this.fields = new ArrayList<Field>();
        this.fields.add(new Field(4, 4));
        this.gold = 200;
        this.tools = new ArrayList<>();
        this.seeds = new HashMap<>();
        this.harvest = new HashMap<>();
    }

    protected String getName(){
        return this.name;
    }

    protected String getFarmerName(){
        return this.farmer.getName();
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

    protected void buySeeds(PlantType plantType, int amount){
        this.gold -= amount*plantType.getCost();
        addSeeds(amount, plantType);
    }
    private void addSeeds(int amount, PlantType plantType){
        if(this.seeds.containsKey(plantType)){
            Integer amountInFarm = this.seeds.get(plantType);
            this.seeds.put(plantType, amountInFarm + amount );
        }
        else {
            this.seeds.put(plantType, amount);
        }
    }



    protected boolean hasEnoughSeeds(PlantType plantType){
        if(this.seeds.get(plantType) -1 <0){
            return false;
        }
        return true;
    }
    public void reduceSeeds(PlantType plantType){
        int seedCount = this.seeds.get(plantType) -1;
        this.seeds.put(plantType, seedCount);
    }

    protected void printField(){
        this.fields.get(0).printField();
    }

    protected boolean hasEnergy(){
        if(!this.farmer.hasEnergy()){
            System.out.println("Du bist zu müde, um noch mehr zu tun.");
            return false;
        }
        return true;
    }

    protected boolean fieldHasSpace(int planningPlanting){
        if(this.fields.get(0).leftSpace() + planningPlanting >=0){
            return true;
        }
        return false;
    }

    protected String getSeeds(){
        String seeds = " ";
        for(Map.Entry<PlantType, Integer> seed: this.seeds.entrySet()){
            seeds += seed.getKey().getName() + " " + seed.getValue();
        }
        return seeds;
    }

    protected boolean plantSeed(PlantType plantType){
        int seedCount = this.seeds.get(plantType) -1;
        this.seeds.put(plantType, seedCount);
        this.fields.get(0).plantSeed(plantType);
        return true;
    }

    protected void waterPlant(int x, int y){
        this.fields.get(0).waterPlant(x, y);
    }

    protected void fertilizePlant(int x, int y){
        this.fields.get(0).fertilizePlant(x, y);
    }

    protected void resetWaterPlants(){
        this.fields.get(0).resetWater();
    }

    protected void resetFertilizePlants(){
        this.fields.get(0).resetFertilized();
    }

    protected void growPlants(){
        this.fields.get(0).growPlants();
    }

    protected void resetEnergy(){
        this.farmer.resetEnergy();
    }

    protected void sellHarvest() {
        if(this.harvest.isEmpty()){
            return;
        }
        for (Map.Entry<PlantType, Integer> entry : this.harvest.entrySet()) {
            double price = entry.getKey().getSellingPrice();
            price *= entry.getValue();
            this.gold += price;
        }
        this.harvest.clear();
    }

    protected void reduceEnergy(){
        this.farmer.reduceEnergy();
    }

    protected boolean canBeHarvested(int x, int y){
        return this.fields.get(0).canPlantBeHarvetest(x, y);
    }

    protected void harvestPlant(int x, int y){
        PlantType harvest = this.fields.get(0).harvestPlant(x,y);
        this.harvest.put(harvest, harvest.getHarvest());
    }

}
