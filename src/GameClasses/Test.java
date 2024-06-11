package GameClasses;

import GameClasses.Plant;
import GameClasses.PlantType;

public class Test {
    public static void main(String[] args) {
        PlantType test =  PlantType.APPLETREE;
        System.out.println(test.getType());
        Plant potato1 = new Plant("potato");
        System.out.println(potato1.getPlantType());
        Plant potato2 = new Plant("Strawberry");
    }
}
