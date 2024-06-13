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
        /*

        Wachstum berechnen
        wachstum: growthrate + echovalue feld, - 50% nicht gewässert, +50% für gedüngt
        growthrate 25% -> in 4 * 6 Tagen ausgewachsen +75% echo value (75% von 25), -/+ von 25%
         */
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

        /*double number = 0.25;

        // Prozentwert, den wir berechnen wollen (75%)
        double percentage = 75.0;

        // Berechnung des Prozentsatzes
        double result = (percentage / 100) * number;
        */

    }
}
