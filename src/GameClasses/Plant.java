package GameClasses;

public class Plant {
    private PlantType type;
    private double growthState;
    private boolean fertilised;
    private boolean watered;

    protected Plant(PlantType plantType){
        this.type = plantType;
        this.growthState = 0;
        this.fertilised = false;
        this.watered = false;
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

    protected void fertilisePlant(){
        this.fertilised = true;
    }

    protected PlantType getPlantType(){
        return this.type;
    }

    protected String plantTypeToString(){
        return this.type.getName();
    }
}
