package GameClasses;

import GameClasses.Game;
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

    public Game preperationWCS(){
        Game test = new Game("Test", "TestFarm");
        provideInput("gießkanne\nja\nnein\n");
        test.buyTools();
        provideInput("feldsalat\n5\nja\nnein\nnein");
        test.buySeeds();
        return test;
    }

    @Test
    public void GameShoppingToolsTest(){
        Game test = preperationWCS();
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
    }
}
