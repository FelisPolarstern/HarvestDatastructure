package GameClasses;

public class Test {
    public static void main(String[] args) {
        PlantType test =  PlantType.APPLETREE;
        System.out.println(test.getName());
        Farmer farmerTest = new Farmer("Felis");
        Farm testFarm = new Farm("Farmer", "Farm");
        testFarm.buySeeds(PlantType.APPLETREE, 1);
        testFarm.buySeeds(PlantType.MACHE, 5);

        Field testField = new Field(5, 5);
        testField.plantSeed(PlantType.PEA);
        testField.plantSeed(PlantType.APPLETREE);
        testField.plantSeed(PlantType.MACHE);
        testField.plantSeed(PlantType.ONION);
        testField.plantSeed(PlantType.CHERRYTREE);
        testField.plantSeed(PlantType.POTATO);
        testField.plantSeed(PlantType.SPINACH);
        testField.printField();
        System.out.println(testField.getEcoValue());

        Game testGame = new Game("Felis" , "FelisFarm");

        testGame.farm.buySeeds(PlantType.PEA, 2);
        testGame.farm.buyWateringCan();
        testGame.action("erbsen");
        testGame.action("erbsen");
        testGame.action("erbsen");



    }
}
