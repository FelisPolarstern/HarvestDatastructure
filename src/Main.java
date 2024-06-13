import GameClasses.Game;

import java.util.Scanner;


public class Main {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = " ";
        while(!input.equals("ja")){
            Game currentGame = gameStart();
            final String ITALIC = "\033[3m";
            final String RESET = "\033[0m";
            System.out.println(ITALIC + "Die Sonne schiebt sich träge über die fernen Berge. Es klingelt und die gut gelaunte Händlerin steht an deinem Farmtor." + RESET);
            currentGame = shopping(currentGame);
            System.out.println(ITALIC + "Der Händler verschwindet in der Ferne. Zeit für einen Tag voller harter körperlicher Arbeit. Immerhin bist du an der frischen Luft." + RESET);
            currentGame = action(currentGame);
            currentGame = goToBed(currentGame);
            System.out.println(ITALIC + "Möchtest du das Spiel beenden?");
            input = scanner.next().toLowerCase();
        }

    }

    private static Game gameStart() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Willkommen in Datastructure- Valley. Bitte gibt deinen Namen ein.");
        String farmerName = scanner.next();
        System.out.println("Dein Großonkel hat dir eine Farm hinterlassen. Dein neues Leben beginnt. Wie möchtest du deine Farm nennen?");
        String farmName = scanner.next();
        Game newGame = new Game(farmerName, farmName);
        System.out.println("Willkommen " + newGame.getFarmerName() + " auf deiner Farm " + newGame.getFarmName() + ".");
        return newGame;
    }

    private static Game shopping(Game currentGame) {
        currentGame.shopping();
        return currentGame;
    }

    private static Game action(Game currentGame) {
        Scanner scanner = new Scanner(System.in);
        String input = " ";
        while (!input.equals("ausruhen")) {
            System.out.println("Was möchtest du tun? Du kannst etwas anpflanzen, etwas ernten, Pflanzen gießen oder Pflanzen düngen. Oder möchtest du dich ausruhen?");
            input = scanner.next().toLowerCase();
            int x = 0;
            int y = 0;
            switch (input){
                case ("anpflanzen"):
                    System.out.println("Du hast: " + currentGame.getSeeds());
                    input = scanner.next();
                    currentGame.action(input);
                    break;
                case("gießen"):
                    currentGame.printField();
                    System.out.println("Bitte gib die x Koordinate der Pflanze an, die du gießen möchtest");
                    x = scanner.nextInt();
                    System.out.println("Bitte gib die y Koordinate der Pflanze an, die du gießen möchtest");
                    y = scanner.nextInt();
                    currentGame.action("gießen", x, y);
                    break;
                case ("düngen"):
                    currentGame.printField();
                    System.out.println("Bitte gib die x Koordinate der Pflanze an, die du düngen möchtest");
                    x = scanner.nextInt();
                    System.out.println("Bitte gib die y Koordinate der Pflanze an, die du düngen möchtest");
                    y = scanner.nextInt();
                    currentGame.action("düngen", x, y);
                    break;
                case ("ausruhen"):
                    break;
                default:
                    System.out.println("Ich habe dich nicht verstanden.");
                    break;
            }
        }
        return currentGame;
    }

    public static Game goToBed(Game currentGame) {
        System.out.println("Mit den letzten Sonnenstrahlen verlässt du deine Felder. Erschöpft fällst du in dein Bett und schließt die Augen.");
        currentGame.goToSleep();
        return currentGame;
    }


}