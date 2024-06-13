import java.util.Scanner;

public class ScannerInput {
    public static void main(String[] args) {

    }

    public void inputName(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Bitte gib deinen Vornamen ein.");
        String firstName = scanner.next();
        System.out.println("Bitte gibt deinen Nachnamen ein.");
        String lastName = scanner.next();
        System.out.println("Dein Name ist: " + firstName + " " + lastName);
    }
}
