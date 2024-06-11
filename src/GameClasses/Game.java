package GameClasses;

import GameClasses.Farm;

import java.util.Scanner;

public class Game {
    private Farm farm;

    public Game(String farmerName, String farmName) {
        this.farm = new Farm(farmerName, farmName);
    }

    public String getFarmerName() {
        return this.farm.getFarmerName();
    }

    public String getFarmName() {
        return this.farm.getName();
    }

    public void shopping() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Du schaust in deine Goldbörse, du hast " + this.farm.getGold() + " G zur Verfügung.");
        System.out.println("Guten Morgen " + this.farm.getFarmerName() + " möchtest du heute etwas kaufen?");
        String wannaBuy = scanner.next();
        if (wannaBuy.equalsIgnoreCase("nein")) {
            System.out.println("Dann wünsche ich dir einen schönen Tag! Bis morgen früh!");
            return;
        }
        String quite = "";
        while (quite.equalsIgnoreCase("Nein")) {
            System.out.println("Was möchtest du denn kaufen? Werkzeuge, Pflanzensamen oder Dünger?");
            String buy = scanner.next();
            buy = buy.toLowerCase();
            switch (buy) {
                case "werkzeug":
                    buyTools();
            }
        }
        System.out.println("Möchtest du noch etwas kaufen?");

        quite = scanner.next();
    }

    private void buyTools() {
        Scanner scanner = new Scanner(System.in);
        boolean hasWateringCan = this.farm.hasWateringCan();
        boolean hasFertilizer = this.farm.hasFertilizer();
        if (hasWateringCan && hasFertilizer) {
            System.out.println("Du hast schon alles was du brauchst, ich kann dir keine neuen Werkzeuge verkaufen!");
        }
        System.out.println("Was möchtest du kaufen? Ich habe eine Gießkanne und Dünger.");
        String input = scanner.next();
        /*Wants to buy WateringCan*/
        if (input.equalsIgnoreCase("Gießkanne")) {
            if (hasWateringCan) {
                System.out.println("Du hast schon eine Gießkanne du brauchst keine Zweite!");
            }
            System.out.println("Möchtest du eine Gießkanne kaufen? Das kostet " + Tool.WATERINGCAN.getToolCost() + "G.");
            input = scanner.next();
            if (input.equalsIgnoreCase("Ja")) {
                if (!this.farm.hasEnoughGold(Tool.WATERINGCAN.getToolCost())) {
                    System.out.println("Dafür hast du nicht genug Gold!");
                } else {
                    System.out.println("Vielen Dank für den Einkauf!");
                    this.farm.buyWateringCan();
                }

            }
            /*Wants to buy Fertilizer*/
        } else if (input.equalsIgnoreCase("Dünger")) {
            if (hasFertilizer) {
                System.out.println("Du hast schon Dünger du brauchst keinen weiteren!");
            }
            System.out.println("Möchtest du eine Gießkanne kaufen? Das kostet " + Tool.WATERINGCAN.getToolCost() + "G.");
            input = scanner.next();
            if (input.equalsIgnoreCase("Ja")) {
                if (!this.farm.hasEnoughGold(Tool.WATERINGCAN.getToolCost())) {
                    System.out.println("Dafür hast du nicht genug Gold!");
                } else {
                    System.out.println("Vielen Dank für den Einkauf!");
                    this.farm.buyWateringCan();
                }
            }
        }

    }


}
