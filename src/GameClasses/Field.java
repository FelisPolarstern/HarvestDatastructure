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
                    System.out.print(plants[i][j].getPlantType().getIcon());
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
                this.plants[i][j].deFertilizePlant();
            }
        }
    }

    protected void resetWater(){
        for (int i = 0; i < plants.length; i++) {
            for (int j = 0; j < plants[i].length; j++) {
                this.plants[i][j].deWaterPlant();
            }
        }
    }

    protected void waterPlant(int x, int y){
        this.plants[y][x].waterPlant();
    }
    protected void fertilizePlant(int x, int y){
        this.plants[y][x].fertilisePlant();
    }

    protected void growPlants(){
        for( int i = 0; i< this.plants.length; i++){
            for (int j= 0; j< this.plants[j].length; j++){
                this.plants[i][j].grow(this.ecoValue);
            }
        }
    }

    protected boolean canPlantBeHarvetest(int x, int y){
        return this.plants[y][x].canBeHarvested();
    }

    protected PlantType harvestPlant(int x, int y){
        return this.plants[y][x].getPlantType();
    }






}
