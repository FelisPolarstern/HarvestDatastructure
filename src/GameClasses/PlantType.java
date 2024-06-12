package GameClasses;

public enum PlantType {
    APPLETREE("Apfelbaum", 6 ,0.25, 200, 10, 75, new String (Character.toChars(0x1F34E))), //Apfelbaum F8FF new String (Character.toChars(0x1F338));
    CHERRYTREE("Kirschbaum", 5, 0.25, 500, 50, 75, new String (Character.toChars(0x1F352))), //Kirschbaum 1F338
    SPINACH("Spinat", 10, 1.0, 20, 10, 50, new String (Character.toChars(0x1F33F))), //Spinat 1F33F
    ONION("Zwiebeln", 4, 0.85, 5, 5, -10, new String (Character.toChars(0x1F9C5))), //Zwiebel 1F9C5
    PEA("Erbsen", 15, 0.5, 5, 15, -25, new String (Character.toChars(0x1FADB))), //Erbse 1FADB
    MACHE("Feldsalat", 2, 1.0, 10, 20, 0, new String (Character.toChars(0x1F96C))), //Feldsalat 1F96C
    POTATO("Kartoffel", 5, 0.75, 5, 10, -10, new String (Character.toChars(0x1F954))); //Kartoffel 1F954

    private final String name;
    private final int harvest;
    private final double growthRate;
    private final double cost;
    private final double seelingPrice;
    private final int ecoValue;
    private final String icon;

    PlantType(String name, int harvest, double growthRate, double cost, double seelingPrice, int ecoValue, String icon) {
        this.name = name;
        this.harvest = harvest;
        this.growthRate = growthRate;
        this.cost = cost;
        this.seelingPrice = seelingPrice;
        this.ecoValue = ecoValue;
        this.icon = icon;
    }

    public String getName() {
        return name;
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

    public String getIcon(){
        return this.icon;
    }




}
