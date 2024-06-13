package GameClasses;

public class Action {
    String actionType;
    PlantType plantType;
    int x;
    int y;

    protected Action(PlantType plantType){
        this.plantType = plantType;
        this.actionType = "anpflanzen";
    }
    protected Action(String actionType, int x, int y){
        this.actionType = actionType;
        this.x = x;
        this.y = y;
    }

    protected String getActionType(){
        return this.actionType;
    }

    protected int getX(){
        return this.x;
    }

    protected int getY(){
        return this.y;
    }
}
