package GameClasses;

import java.util.*;

public class Game {
    public Farm farm;
    private Queue<Action> actionQueue;
    private int planningPlanting;


    public Game(String farmerName, String farmName) {
        this.farm = new Farm(farmerName, farmName);
        this.actionQueue = new LinkedList<>();
        this.planningPlanting = 0;
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
        System.out.println("Guten Morgen " + this.farm.getFarmerName() + " möchtest du heute etwas kaufen?"); //ToDO buy a new field
        String quit = scanner.next();
        if (quit.equalsIgnoreCase("nein")) {
            System.out.println("Dann wünsche ich dir einen schönen Tag! Bis morgen früh!");
            return;
        }
        while (quit.equalsIgnoreCase("Ja")) {
            System.out.println("Was möchtest du denn kaufen? Werkzeuge oder Pflanzensamen?");
            String buy = scanner.next();
            buy = buy.toLowerCase();
            switch (buy) {
                case "werkzeug":
                    buyTools();
                    break;
                case "pflanzensamen":
                    buySeeds();
                    break;
                default:
                    System.out.println("Ich habe dich nicht verstanden, könntest du das wiederholen?");
                    break;
            }
            System.out.println("Möchtest du noch etwas kaufen?");
            quit = scanner.next();
        }
    }

    private void buyTools() {
        Scanner scanner = new Scanner(System.in);
        boolean hasWateringCan = this.farm.hasWateringCan();
        boolean hasFertilizer = this.farm.hasFertilizer();
        if (hasWateringCan && hasFertilizer) {
            System.out.println("Du hast schon alles was du brauchst, ich kann dir keine neuen Werkzeug verkaufen!");
        }
        System.out.println("Was möchtest du kaufen? Ich habe eine Gießkanne und Dünger.");
        String input = scanner.next();
        /*Wants to buy WateringCan*/
        if (input.equalsIgnoreCase("Gießkanne")) {
            if (hasWateringCan) {
                System.out.println("Du hast schon eine Gießkanne du brauchst keine Zweite!");
                return;
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
                return;
            }
            System.out.println("Möchtest du Dünger kaufen? Das kostet " + Tool.FERTILISER.getToolCost() + "G.");
            input = scanner.next();
            if (input.equalsIgnoreCase("Ja")) {
                if (!this.farm.hasEnoughGold(Tool.FERTILISER.getToolCost())) {
                    System.out.println("Dafür hast du nicht genug Gold!");
                } else {
                    System.out.println("Vielen Dank für den Einkauf!");
                    this.farm.buyFertiliser();
                }
            }
        }

    }

    private void buySeeds() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ich verkaufe folgende Samen: " + PlantType.PEA.getName() + ", " + PlantType.APPLETREE.getName() + ", " + PlantType.CHERRYTREE.getName() + ", " +
                PlantType.MACHE.getName() + ", " + PlantType.ONION.getName() + ", " + PlantType.POTATO.getName() + ", " + PlantType.SPINACH.getName() + ".");
        String input = scanner.next().toLowerCase();
        PlantType plantType = getPlantType(input);
        if (plantType == null) {
            System.out.println("Ich habe dich nicht verstanden.");
            buySeeds();
        }
        System.out.println("Eine Saat kostet: " + plantType.getCost() + " G. Wie viele möchtets du kaufen?");
        String amount = scanner.next();
        double price = Double.parseDouble(amount) * plantType.getCost();
        if (farm.hasEnoughGold(price)) {
            System.out.println("Das macht dann " + price + " G. Bist du damit einverstanden?");
            input = scanner.next().toLowerCase();
            if (input.equals("ja")) {
                this.farm.buySeeds(plantType, Integer.parseInt(amount));
            } else {
                buySeeds();
            }
        } else {
            System.out.println("Dafür hast du nicht genug Gold");
        }
        System.out.println("Möchtest du weitere Saat kaufen?");
        input = scanner.next();
        if(input.equalsIgnoreCase("ja")){
            shopping();
        }
    }

    private PlantType getPlantType(String input) {
        switch (input) {
            case ("erbsen"):
                return PlantType.PEA;
            case ("feldsalat"):
                return PlantType.MACHE;
            case ("kirschbaum"):
                return PlantType.CHERRYTREE;
            case ("apfelbaum"):
                return PlantType.APPLETREE;
            case ("zwiebel"):
                return PlantType.ONION;
            case ("kartoffel"):
                return PlantType.POTATO;
            case ("spinat"):
                return PlantType.SPINACH;
            default:
                return null;
        }
    }

    public boolean action(String plant){ //Plant something
        if(!this.farm.hasEnergy()){
            System.out.println("Du bist zu müde um das zu tun.");
            return false;
        } else if(!this.farm.fieldHasSpace(planningPlanting +1)){
            System.out.println("Du hast keinen Platz mehr auf dem Feld.");
            return false;
        } else if(getPlantType(plant) == null){
            System.out.println("Das ist kein valider Pflanzentyp");
            return false;
        }
        PlantType plantType = getPlantType(plant);
        if(!this.farm.hasEnoughSeeds(plantType)){
            System.out.println("Du hast nicht genügend Sämerein.");
            return false;
        }
        this.farm.reduceSeeds(plantType);
        this.actionQueue.add(new Action(plantType));
        this.planningPlanting ++;
        this.farm.reduceEnergy();
        return true;
    }

    public boolean action(int x, int y){ //etwas ernten
        if(!this.farm.hasEnergy()){
            return false;
        }
        if(!this.farm.canBeHarvested(x,y)){
            System.out.println("Diese Pflanze kannst du noch nicht ernten.");
            return false;
        }
        this.actionQueue.add(new Action("reap", x, y));
        this.farm.reduceEnergy();
        //ToDo: Prüfen ob geerntet werden kann
        return true;
    }

    public boolean action(String mendType, int x, int y){ //Düngen/ Gießen
        if(!this.farm.hasEnergy()){
            return false;
        } else if (mendType.equals("gießen") && !this.farm.hasWateringCan()){
            System.out.println("Du hast keine Gießkann, du kannst nicht gießen.");
            return false;
        } else if (mendType.equals("düngen") && !this.farm.hasFertilizer()) {
            System.out.println("Du hast keinen Dünger, du kannst nicht düngen.");
            return false;
        }

        mendType = mendType.toLowerCase();
        this.actionQueue.add(new Action(mendType, x, y));
        this.farm.reduceEnergy();
        return true;
    }

    public void printField(){
        this.farm.printField();
    }

    public String getSeeds(){
        return this.farm.getSeeds();
    }

    public void goToSleep(){
        while(!this.actionQueue.isEmpty()){
            Action currentAction = actionQueue.poll();
            switch (currentAction.getActionType()) {
                case "anpflanzen":
                    this.farm.plantSeed(currentAction.plantType);
                    break;
                case "gießen":
                    this.farm.waterPlant(currentAction.getX(), currentAction.getY());
                    break;
                case "düngen":
                    this.farm.fertilizePlant(currentAction.getX(), currentAction.getY());
                    break;
                case "ernten":
                    this.farm.harvestPlant(currentAction.getX(), currentAction.getY());
            }
        }
        this.planningPlanting = 0;
        this.farm.growPlants();
        this.farm.resetFertilizePlants();
        this.farm.resetWaterPlants();
        this.farm.resetEnergy();
        this.farm.sellHarvest();
    }








}
