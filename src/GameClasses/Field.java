package GameClasses;

public class Field {
    private Plant plants[][];
    private double ecoValue;

    protected Field(int height, int width){
        this.plants = new Plant[height][width];
    }


}
