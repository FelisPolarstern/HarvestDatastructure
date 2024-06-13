import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

public class ScannerInputTest {
    void provideInput(String data) {
        ByteArrayInputStream testIn = new ByteArrayInputStream(data.getBytes());
        System.setIn(testIn);
    }

    @Test
    public void inputTest(){
        ScannerInput test = new ScannerInput();
        provideInput("Felis\nJust\n");
        test.inputName();
    }

}
