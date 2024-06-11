import GameClasses.Game;

import java.util.Scanner;



public class Main {


    public static void main(String[] args) {
        Game currentGame = gameStart();
        final String ITALIC = "\033[3m";
        final String RESET = "\033[0m";
        System.out.println(ITALIC + "Die Sonne schiebt sich träge über die fernen Berge. Es klingelt und die gut gelaunte Händlerin steht an deinem Farmtor." + RESET);
        currentGame = shopping(currentGame);
        //Tagesablauf immer wieder regeln -> einkaufen, Aktionen ausführen, schlafen
    }

    private static Game gameStart(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Willkommen in Datastructure- Valley. Bitte gibt deinen Namen ein.");
        String farmerName = scanner.next();
        System.out.println("Dein Großonkel hat dir eine Farm hinterlassen. Dein neues Leben beginnt. Wie möchtest du deine Farm nennen?");
        String farmName = scanner.next();
        Game newGame = new Game(farmerName, farmName);
        System.out.println("Willkommen " + newGame.getFarmerName() + " auf deiner Farm " + newGame.getFarmName() + "." );
        return newGame;
    }

    private static Game shopping(Game currentGame){
       currentGame.shopping();
       return currentGame;




    }




}