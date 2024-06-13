package GameClasses;

public class Field {
    private Plant plants[][];
    private double ecoValue;


    protected Field(int height, int width){
        this.plants = new Plant[height][width];
    }

    protected void printField(){
        for(int i = 0; i< plants.length; i++){
            System.out.print("[");
            for(int j = 0; j< plants[i].length; j++){
                if(plants[i][j] == null){
                    System.out.print("--");
                }
                else {
                    System.out.print(plants[i][j].getPlantType().getIcon() + plants[i][j].getGrowthState() + "|");
                }
            }
            System.out.println("]");
        }
    }

    protected boolean plantSeed(PlantType plant){
        for(int i = 0; i<plants.length; i++){
            for(int j = 0; j< plants[i].length; j++){
                if(plants[i][j] == null){
                    plants[i][j] = new Plant(plant);
                    this.ecoValue += plant.getEcoValue();
                    return true;
                }
            }
        }
        System.out.println("Du hast keinen Platz mehr auf deinem Feld!");
        return false;
    }

    protected boolean hasSpace(){
        boolean hasSpace = false;
        for(int i = 0; i<plants.length; i++) {
            for (int j = 0; j < plants[i].length; j++) {
                if(plants[i][j] == null){
                    hasSpace = true;
                }
            }
        }
        return hasSpace;
    }

    protected int leftSpace(){
        int space = 0;
        for(int i = 0; i<plants.length; i++) {
            for (int j = 0; j < plants[i].length; j++) {
                if(plants[i][j] == null){
                    space ++;
                }
            }
        }
        return space;
    }

    protected double getEcoValue(){
        return this.ecoValue;
    }

    protected void resetFertilized() {
        for (int i = 0; i < plants.length; i++) {
            for (int j = 0; j < plants[i].length; j++) {
                if(this.plants[i][j] ==null){
                    continue;
                }
                this.plants[i][j].deFertilizePlant();
            }
        }
    }

    protected void resetWater(){
        for (int i = 0; i < plants.length; i++) {
            for (int j = 0; j < plants[i].length; j++) {
                if(this.plants[i][j] ==null){
                    continue;
                }
                this.plants[i][j].deWaterPlant();
            }
        }
    }

    protected void waterPlant(int x, int y){
        if(this.plants[x][y] == null){
            System.out.println("Hier wächst keine Pflanze");
            return;
        }
        this.plants[x][y].waterPlant();
    }
    protected void fertilizePlant(int x, int y){
        this.plants[x][y].fertilisePlant();
    }

    protected void growPlants(){
        for( int i = 0; i< this.plants.length; i++){
            for (int j= 0; j< this.plants[i].length; j++){
                if(this.plants[i][j] == null){
                    continue;
                }
                this.plants[i][j].grow(this.ecoValue);
            }
        }
    }

    protected boolean canPlantBeHarvetest(int x, int y){
        if(this.plants[x][y] == null){
            return false;
        }
        return this.plants[x][y].canBeHarvested();
    }

    protected PlantType harvestPlant(int x, int y){
        return this.plants[x][y].getPlantType();
    }






}
