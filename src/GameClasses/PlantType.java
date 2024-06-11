package GameClasses;

public enum PlantType {
    APPLETREE("AppleTree", 6 ,0.25, 200, 10, 75), //Apfelbaum
    CHERRYTREE("CherryTree", 5, 0.25, 500, 50, 75), //Kirschbaum
    SPINACH("Spinach", 10, 1.0, 20, 10, 50), //Spinat
    ONION("Onion", 4, 0.85, 5, 5, -10), //Zwiebel
    PEA("Pea", 15, 0.5, 5, 15, -25), //Erbse
    MACHE("Mache", 2, 1.0, 10, 20, 0), //Feldsalat
    POTATO("Potato", 5, 0.75, 5, 10, -10); //Kartoffel

    private final String type;
    private final int harvest;
    private final double growthRate;
    private final double cost;
    private final double seelingPrice;
    private final int ecoValue;

    PlantType(String type, int harvest, double growthRate, double cost, double seelingPrice, int ecoValue) {
        this.type = type;
        this.harvest = harvest;
        this.growthRate = growthRate;
        this.cost = cost;
        this.seelingPrice = seelingPrice;
        this.ecoValue = ecoValue;
    }

    public String getType() {
        return type;
    }

    public int getHarvest() {
        return harvest;
    }

    public double getGrowthRate() {
        return growthRate;
    }

    public double getCost() {
        return cost;
    }

    public double getSeelingPrice() {
        return seelingPrice;
    }

    public int getEcoValue() {
        return ecoValue;
    }


}
