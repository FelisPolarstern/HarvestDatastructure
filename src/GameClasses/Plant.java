package GameClasses;

public class Plant {
    private PlantType type;
    private double growthState;
    private boolean fertilised;
    private boolean watered;
    private boolean canBeHarvested;

    protected Plant(PlantType plantType){
        this.type = plantType;
        this.growthState = 0;
        this.fertilised = false;
        this.watered = false;
        this.canBeHarvested = false;
    }

    protected String matchString(String type){
        if(type.equalsIgnoreCase("AppleTree")){
            return "AppleTree";
        }
        if(type.equalsIgnoreCase("CherryTree")){
            return "CherryTree";
        }
        if(type.equalsIgnoreCase("Spinach")){
            return "Spinach";
        }
        if(type.equalsIgnoreCase("Onion")){
            return "Onion";
        }
        if(type.equalsIgnoreCase("Pea")){
            return "Pea";
        }
        if(type.equalsIgnoreCase("Mache")){
            return "Mache";
        }
        if(type.equalsIgnoreCase("Potato")){
            return "Potato";
        }
        return "false";
    }

    protected void waterPlant(){
        this.watered = true;
    }

    protected void deWaterPlant(){
        this.watered = false;
    }

    protected void deFertilizePlant(){
        this.fertilised = false;
    }

    protected void fertilisePlant(){
        this.fertilised = true;
    }

    protected PlantType getPlantType(){
        return this.type;
    }

    protected String plantTypeToString(){
        return this.type.getName();
    }

    protected void grow(double echoValueField){
        double growth = type.getGrowthRate();
        /*add echoBonus*/
        growth = (echoValueField/100) * growth;
        /*reduce if not watered*/
        if(!this.watered){
            growth = growth /2;
        }
        if(this.fertilised){
            growth = growth *2;
        }
        if(this.growthState >= 6){
            this.growthState = 6;
            this.canBeHarvested = true;
        }
    }

    protected boolean canBeHarvested(){
        if(this.growthState == 6){
            return true;
        }
        return false;
    }
}
