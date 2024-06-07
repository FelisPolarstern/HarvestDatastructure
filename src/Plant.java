public class Plant {
    PlantType type;
    double growthState;
    boolean fertilised;
    boolean watered;

    public Plant(String type){
        String checkedType = matchString(type);
        if(checkedType.equals("false")){
            System.out.println("This is not a valid planttype. Valid planttypes are: AppleTree, CherryTree, Spinach, Onion, Mache, Pea or Potato.");
            return;
        }
        switch (checkedType) {
            case "AppleTree" -> this.type = PlantType.APPLETREE;
            case "CherryTree" -> this.type = PlantType.CHERRYTREE;
            case "Spinach" -> this.type = PlantType.SPINACH;
            case "Onion" -> this.type = PlantType.ONION;
            case "Mache" -> this.type = PlantType.MACHE;
            case "Pea" -> this.type = PlantType.PEA;
            case "Potato" -> this.type = PlantType.POTATO;
        }
        this.growthState = 0;
        this.fertilised = false;
        this.watered = false;
    }

    private String matchString(String type){
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

    public void waterPlant(){
        this.watered = true;
    }

    public void fertilisePlant(){
        this.fertilised = true;
    }

    public PlantType getPlantType(){
        return this.type;
    }

    public String plantTypeToString(){
        return this.type.getType();
    }
}
