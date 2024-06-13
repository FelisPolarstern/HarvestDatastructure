package GameClasses;

import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;

public class GameTest {

    void provideInput(String data) {
        ByteArrayInputStream testIn = new ByteArrayInputStream(data.getBytes());
        System.setIn(testIn);
    }

    public Game prepeation(){
        Game test = new Game("Test", "TestFarm");
        return test;
    }

    public Game preperationWateringCan(){
        Game test = new Game("Test", "TestFarm");
        provideInput("gießkanne\nja\nnein\n");
        test.buyTools();
        return test;
    }

    public Game preperationWS(){
        Game test = new Game("Test", "TestFarm");
        provideInput("gießkanne\nja\nnein\n");
        test.buyTools();
        provideInput("feldsalat\n5\nja\nnein\nnein");
        test.buySeeds();
        return test;
    }

    public Game preperationsWSF(){
        Game test = new Game("Test", "TestFarm");
        provideInput("gießkanne\nja\nnein\n");
        test.buyTools();
        provideInput("dünger\nja\nnein\n");
        test.buyTools();
        provideInput("feldsalat\n5\nja\nnein\nnein");
        test.buySeeds();
        return test;
    }

    public Game buyFertilizer(Game currentGame){
        provideInput("dünger\nja\nnein\n");
        currentGame.buyTools();
        return currentGame;
    }

    @Test
    public void GameShoppingToolsTest(){
        Game test = preperationWS();
        test.printField();
        test.action("feldsalat");
        test.action("feldsalat");
        test.action("feldsalat");
        test.action("feldsalat");
        test.action("feldsalat");
        test.action("gießen", 0,0);
        test.action("gießen", 0,1);
        test.action("gießen", 0,2);
        test.action("gießen", 0,3);
        test.action("gießen", 0,4);
        test.goToSleep();
        test.printField();
    }

    @Test
    public void GameHarvestTest(){
        Game test = preperationWS();
        test.printField();
        test.action("feldsalat");
        test.action("feldsalat");
        test.action("feldsalat");
        test.action("feldsalat");
        test.action("feldsalat");
        test.action("gießen", 0,0);
        test.action("gießen", 0,1);
        test.action("gießen", 0,2);
        test.action("gießen", 0,3);
        test.action("gießen", 0,4);
        test.goToSleep();
        test.action("gießen", 0,0);
        test.action("gießen", 0,1);
        test.action("gießen", 0,2);
        test.action("gießen", 0,3);
        test.action("gießen", 0,4);
        test.printField();
        test.goToSleep();
        test.action("gießen", 0,0);
        test.action("gießen", 0,1);
        test.action("gießen", 0,2);
        test.action("gießen", 0,3);
        test.action("gießen", 0,4);
        test.printField();
        test.goToSleep();
        test.action("gießen", 0,0);
        test.action("gießen", 0,1);
        test.action("gießen", 0,2);
        test.action("gießen", 0,3);
        test.action("gießen", 0,4);
        test.printField();
        test.goToSleep();
        test.action("gießen", 0,0);
        test.action("gießen", 0,1);
        test.action("gießen", 0,2);
        test.action("gießen", 0,3);
        test.action("gießen", 0,4);
        test.printField();
        test.goToSleep();
        test.action("gießen", 0,0);
        test.action("gießen", 0,1);
        test.action("gießen", 0,2);
        test.action("gießen", 0,3);
        test.action("gießen", 0,4);
        test.printField();
        test.goToSleep();
        test.action("gießen", 0,0);
        test.action("gießen", 0,1);
        test.action("gießen", 0,2);
        test.action("gießen", 0,3);
        test.action("gießen", 0,4);
        test.printField();
        test.action(0,0);
        test.action(0,1);
        test.action(0,2);
        test.action(0,3);
        test.action(0,4);
        test.goToSleep();
        test.printField();
    }

    @Test
    public void gameHarvestFertiliseTest(){
        Game test = preperationsWSF();
        test.action("feldsalat");
        test.action("feldsalat");
        test.action("feldsalat");
        test.action("feldsalat");
        test.action("feldsalat");
        test.action("gießen", 0,0);
        test.action("gießen", 0,1);
        test.action("gießen", 0,2);
        test.action("gießen", 0,3);
        test.action("gießen", 0,4);
        test.goToSleep();

        for(int i = 0; i<7; i++){
            test = buyFertilizer(test);
            test.action("gießen", 0,0);
            test.action("gießen", 0,1);
            test.action("gießen", 0,2);
            test.action("gießen", 0,3);
            test.action("gießen", 0,4);
            test.action("düngen", 0,0);
            test.action("düngen", 0,1);
            test.action("düngen", 0,2);
            test.action("düngen", 0,3);
            test.action("düngen", 0,4);
            test.printField();
            test.goToSleep();
        }
        test.printField();
        test.action(0,0);
        test.action(0,1);
        test.action(0,2);
        test.action(0,3);
        test.action(0,4);
        test.goToSleep();
        test.printField();
    }
}
