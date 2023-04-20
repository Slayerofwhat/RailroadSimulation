import RailroadCars.*;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        final String ANSI_RESET = "\u001B[0m";
        final String ANSI_RED = "\u001B[31m";
        final String ANSI_GREEN = "\u001B[32m";
        final String ANSI_YELLOW = "\u001B[33m";
        RailwayStructure railwayStructure = new RailwayStructure();
        railwayStructure.GenerateStations(100);
        railwayStructure.GenerateConnections(3);
        List<TrainSet> trainSets = railwayStructure.GenerateTrainSet(25);
        startTrainsets(trainSets);
        FileWriter fileWriter = new FileWriter(trainSets);
        fileWriter.start();
        Scanner scanner = new Scanner(System.in);
        String ch = "";

        System.out.println("Hello! Welcome to Railway Structure Simulation. While you are reading this, randomly generated trainsets have already started to move!");
        while(!ch.equals("0")){
            System.out.println("[1] to deal with trainset");
            System.out.println("[2] to deal with railroad car");
            System.out.println("[3] to deal with railway station");
            System.out.println("[4] to deal with railway connections");
            System.out.println("[5] to deal with cargo or people");
            System.out.println("[6] to check status of all trainsets");
            System.out.println("[7] to check one trainset in detail");
            System.out.println("[0] to exit program");
            ch = scanner.nextLine();
            if (ch.equals("1")){
                System.out.println("[1] to create trainset");
                System.out.println("[2] to delete trainset");
                ch = scanner.nextLine();
                if (ch.equals("1")){
                    System.out.println("We need to know source and destination station to create trainset. Enter id of source station");
                    for (RailwayStation station : railwayStructure.getStations()){
                        System.out.println("Id: " + station.getId() + ", name: " + station.getName());
                    }
                    RailwayStation source = null;
                    while(source == null) {
                        ch = scanner.nextLine();
                        for (RailwayStation station : railwayStructure.getStations()) {
                            if (station.getId() == Integer.parseInt(ch)) {
                                source = station;
                                break;
                            }
                        }
                        if (source == null) {
                            System.out.println(ANSI_YELLOW + "There is no station with this number, try again" + ANSI_RESET);
                        }
                    }
                    System.out.println("Enter destination station");
                    RailwayStation destination = null;
                    while (destination == null) {
                        ch = scanner.nextLine();
                        for (RailwayStation station : railwayStructure.getStations()) {
                            if (station.getName().equals("Station " + ch)) {
                                destination = station;
                                break;
                            }
                        }
                        if (destination == null) {
                            System.out.println(ANSI_YELLOW + "There is no station with this number, try again" + ANSI_RESET);
                        }
                    }
                    TrainSet trainSet = new TrainSet(source, destination, railwayStructure.getShortestPath(source, destination), railwayStructure.getAllConnections());
                    trainSet.start();
                    trainSets.add(trainSet);
                    System.out.println(ANSI_GREEN + "Trainset was created" + ANSI_RESET);
                }
                else if (ch.equals("2")){
                    System.out.println("Select which trainset to delete by his id");
                    for (TrainSet trainSet : trainSets){
                        System.out.println("Trainset id = " + trainSet.getHead().getId());
                    }

                    ch = scanner.nextLine();
                    boolean isDeleted = false;
                    for (TrainSet trainSet : trainSets){
                        if (trainSet.getHead().getId() == Integer.parseInt(ch)){
                            trainSet.interrupt();
                            trainSets.remove(trainSet);
                            trainSet = null;
                            System.gc();
                            System.out.println(ANSI_GREEN + "Deleted" + ANSI_RESET);
                            isDeleted = true;
                            break;
                        }
                    }
                    if (!isDeleted){
                        System.out.println(ANSI_RED + "There is no trainset with this id" + ANSI_RESET);
                    }

                }
                else System.out.println("There is no such option!");
            }
            else if (ch.equals("2")){
                System.out.println("[1] to create railroad car");
                System.out.println("[2] to delete railroad car");
                ch = scanner.nextLine();
                if (ch.equals("1")){
                    System.out.println("There is total of 12 types of railroad car. Type number of type you want to create");
                    System.out.println("1. BaggageMailRailroadCar 2. ExplosivesRailroadCar 3. FreightRailroadCar 4. GaseousRailroadCar 5. HeavyFreightRailroadCar 6. LiquidRailroadCar 7. LiquidToxicRailroadCar 8. PassengerRailroadCar 9. PostOfficeRailroadCar 10. RefrigeratedRailroadCar 11. RestaurantRailroadCar 12. ToxicRailroadCar");

                    RailroadCar railroadCar = null;
                    ch = scanner.nextLine();
                    switch (Integer.parseInt(ch) - 1) {
                        case 0 -> {
                            railroadCar = new  BaggageMailRailroadCar();
                            System.out.println(railroadCar);
                        }
                        case 1 -> {
                            railroadCar = new ExplosivesRailroadCar();
                            System.out.println(railroadCar);
                        }
                        case 2 -> {
                            railroadCar = new FreightRailroadCar();
                            System.out.println(railroadCar);
                        }
                        case 3 -> {
                            railroadCar = new GaseousRailroadCar();
                            System.out.println(railroadCar);
                        }
                        case 4 -> {
                            railroadCar = new HeavyFreightRailroadCar();
                            System.out.println(railroadCar);
                        }
                        case 5 -> {
                            railroadCar = new LiquidRailroadCar();
                            System.out.println(railroadCar);
                        }
                        case 6 -> {
                            railroadCar = new LiquidToxicRailroadCar();
                            System.out.println(railroadCar);
                        }
                        case 7 -> {
                            railroadCar = new PassengerRailroadCar();
                            System.out.println(railroadCar);
                        }
                        case 8 -> {
                            railroadCar = new PostOfficeRailroadCar();
                            System.out.println(railroadCar);
                        }
                        case 9 -> {
                            railroadCar = new RefrigeratedRailroadCar();
                            System.out.println(railroadCar);
                        }
                        case 10 -> {
                            railroadCar = new RestaurantRailroadCar();
                            System.out.println(railroadCar);
                        }
                        case 11 -> {
                            railroadCar = new ToxicRailroadCar();
                            System.out.println(railroadCar);
                        }
                    }
                    if (railroadCar == null) {
                        System.out.println(ANSI_RED + "Railroad car was not created" + ANSI_RESET);

                    }
                    else {
                        System.out.println("Select trainset by its id to which you will try to connect this railroad car");
                        for (TrainSet trainSet : trainSets){
                            System.out.println("Trainset id = " + trainSet.getHead().getId());
                        }

                        ch = scanner.nextLine();
                        for (TrainSet trainSet : trainSets){
                            if (trainSet.getHead().getId() == Integer.parseInt(ch)){
                                try {
                                    trainSet.addRailroadCar(railroadCar);
                                } catch (TooBigWeightException | TooBigNumberException e) {
                                    e.printStackTrace();
                                } finally {
                                    System.out.println(ANSI_GREEN + "Finished" + ANSI_RESET);
                                }
                            }
                        }
                    }
                }
                else if (ch.equals("2")){
                    System.out.println("Select trainset from which to delete railroad car");
                    for (TrainSet trainSet : trainSets){
                        System.out.println("Trainset id = " + trainSet.getHead().getId());
                    }
                    ch = scanner.nextLine();

                    boolean isDeleted = false;
                    for (TrainSet trainSet : trainSets){
                        if (trainSet.getHead().getId() == Integer.parseInt(ch)){
                            System.out.println("Select railroad car to delete depending on it`s id");
                            for (RailroadCar railroadCar : trainSet.getRailroadCars()){
                                System.out.println(railroadCar);
                            }
                            ch = scanner.nextLine();

                            for (RailroadCar railroadCar : trainSet.getRailroadCars()){
                                if (railroadCar.getId() == Integer.parseInt(ch)){
                                    trainSet.RemoveRailroadCar(railroadCar);
                                    railroadCar = null;
                                    System.gc();
                                    System.out.println(ANSI_GREEN + "Deleted railroad car with id " + ch + ANSI_RESET);
                                    isDeleted = true;
                                    break;
                                }
                            }
                            break;
                        }
                    }
                    if (!isDeleted){
                        System.out.println(ANSI_RED + "There is no railroad car with this id" + ANSI_RESET);
                    }
                }
            }
            else if (ch.equals("3")){
                System.out.println("[1] to create railway station");
                System.out.println("[2] to list all railway stations");
                ch = scanner.nextLine();
                if (ch.equals("1")){
                    System.out.println("Enter name of station");
                    ch = scanner.nextLine();

                    railwayStructure.addStation(new RailwayStation(ch));
                    System.out.println(ANSI_GREEN + "Station created" + ANSI_RESET);
                }
                else if (ch.equals("2")){
                    for (RailwayStation station : railwayStructure.getStations()){
                        System.out.println("Id: " + station.getId() + ", name: " + station.getName());
                    }
                    System.out.println("[ENTER] to continue");
                    ch = scanner.nextLine();
                }
            }
            else if (ch.equals("4")){
                System.out.println("[1] to add connection");
                System.out.println("[2] to list all connections");
                System.out.println("[3] to list connection of specific station");
                ch = scanner.nextLine();

                if (ch.equals("1")){
                    System.out.println("We need to know source, destination and distance");
                    System.out.println("Enter id of source station");
                    RailwayStation source = null;
                    RailwayStation destination = null;
                    int distance;
                    for (RailwayStation station : railwayStructure.getStations()){
                        System.out.println("Id: " + station.getId() + ", name: " + station.getName());
                    }
                    ch = scanner.nextLine();

                    for (RailwayStation station : railwayStructure.getStations()){
                        if(station.getId() == Integer.parseInt(ch)){
                            source = station;
                            break;
                        }
                    }
                    System.out.println("Enter id of destination station");
                    ch = scanner.nextLine();

                    for (RailwayStation station : railwayStructure.getStations()){
                        if(station.getId() == Integer.parseInt(ch)){
                            destination = station;
                            break;
                        }
                    }

                    System.out.println("Enter distance between them");
                    ch = scanner.nextLine();

                    distance = Integer.parseInt(ch);
                    boolean isNew = true;
                    for (RailwayConnection connection : railwayStructure.getConnections(source)){
                        if (connection.getDestination() == destination){
                            System.out.println(ANSI_RED + "Such connection already exists" + ANSI_RESET);
                            isNew = false;
                            break;
                        }
                    }
                    if (isNew){
                        railwayStructure.addConnection(source, destination, distance);
                        System.out.println(ANSI_GREEN + "Created" + ANSI_RESET);
                    }
                }
                else if (ch.equals("2")){
                    for (RailwayConnection connection : railwayStructure.getAllConnections()){
                        System.out.println(connection);
                    }
                    System.out.println("[ENTER] to continue");
                    ch = scanner.nextLine();
                }
                else if (ch.equals("3")){
                    System.out.println("Enter id of station");
                    RailwayStation copy = null;
                    for (RailwayStation railwayStation : railwayStructure.getStations()){
                        System.out.println("Id: " + railwayStation.getId() + ", name: " + railwayStation.getName());
                    }
                    ch = scanner.nextLine();
                    for (RailwayStation railwayStation : railwayStructure.getStations()){
                        if (railwayStation.getId() == Integer.parseInt(ch)){
                            copy = railwayStation;
                            break;
                        }
                    }

                    for (RailwayConnection connection : railwayStructure.getAllConnections()){
                        if(connection.getSource() == copy){
                            for (RailwayConnection railwayConnection : railwayStructure.getConnections(copy)){
                                System.out.println(railwayConnection);
                            }
                            break;
                        }
                    }
                    System.out.println("[ENTER] to exit");
                    ch = scanner.nextLine();
                }
            }
            else if (ch.equals("5")){
                System.out.println("[1] to deal with cargo");
                System.out.println("[2] to deal with people");
                ch = scanner.nextLine();
                if (ch.equals("1")){
                    System.out.println("Select which trainset to deal with by his id");
                    for (TrainSet trainSet : trainSets){
                        System.out.println("Trainset id = " + trainSet.getHead().getId());
                    }
                    ch = scanner.nextLine();
                    for (TrainSet trainSet : trainSets){
                        if (trainSet.getHead().getId() == Integer.parseInt(ch)){
                            System.out.println("Choose railroad car by it`s id");
                            for (RailroadCar railroadCar : trainSet.getRailroadCars()){
                                System.out.println(railroadCar);
                            }
                            ch = scanner.nextLine();
                            boolean isCar = false;
                            boolean isCargo = false;
                            for (RailroadCar railroadCar : trainSet.getRailroadCars()){
                                if (railroadCar.getId() == Integer.parseInt(ch)){
                                    isCar = true;
                                    if (railroadCar.isHasCargo()){
                                        isCargo = true;
                                        System.out.println("Enter amount of cargo to add or remove(with '-')");
                                        ch = scanner.nextLine();
                                        FreightRailroadCar freightRailroadCar = (FreightRailroadCar) railroadCar;
                                        freightRailroadCar.addCargo(Integer.parseInt(ch));
                                        System.out.println("Now there are " + freightRailroadCar.getCargoQuantity() + " cargo now");
                                    }
                                }
                            }
                            if (!isCar){
                                System.out.println("There is no railroad car with this id");
                            }
                            else if (!isCargo){
                                System.out.println("There is no cargo in this railroad car");
                            }
                        }
                    }
                }
                else if (ch.equals("2")){
                    System.out.println("Select which trainset to deal with by his id");
                    for (TrainSet trainSet : trainSets){
                        System.out.println("Trainset id = " + trainSet.getHead().getId());
                    }
                    ch = scanner.nextLine();
                    for (TrainSet trainSet : trainSets) {
                        if (trainSet.getHead().getId() == Integer.parseInt(ch)) {
                            System.out.println("Choose railroad car by it`s id");
                            for (RailroadCar railroadCar : trainSet.getRailroadCars()) {
                                System.out.println(railroadCar);
                            }
                            ch = scanner.nextLine();
                            boolean isCar = false;
                            boolean isPeople = false;
                            for (RailroadCar railroadCar : trainSet.getRailroadCars()) {
                                if (railroadCar.getId() == Integer.parseInt(ch)) {
                                    isCar = true;
                                    if (railroadCar.isHasPeople()) {
                                        isPeople = true;
                                        System.out.println("Enter amount of people to add or remove(with '-')");
                                        ch = scanner.nextLine();
                                        PassengerRailroadCar passengerRailroadCar = (PassengerRailroadCar) railroadCar;
                                        passengerRailroadCar.AddPassengers(Integer.parseInt(ch));
                                        System.out.println("Now there are " + passengerRailroadCar.getPassengerNumber() + " passengers now");
                                    }
                                }
                            }
                            if (!isCar) {
                                System.out.println("There is no railroad car with this id");
                            } else if (!isPeople) {
                                System.out.println("There is no people in this railroad car");
                            }
                        }
                    }
                }
            }
            else if (ch.equals("6")){
                while (!ch.equals("0")){
                    for (TrainSet trainSet : trainSets){
                        System.out.print("Trainset " + trainSet.getHead().getId() + " is moving with speed " + trainSet.getHead().getSpeed());
                        if (trainSet.isHazarded()){
                            System.out.println(ANSI_RED +  " [!] Hazard" + ANSI_RESET);
                        }
                        else System.out.println();
                    }
                    System.out.println("[ENTER] to update");
                    System.out.println("[0] to exit");
                    ch = scanner.nextLine();
                }
                ch = "";
            }
            else if (ch.equals("7")){
                System.out.println("Select trainset by id");
                for (TrainSet trainSet : trainSets){
                    System.out.println("Trainset id = " + trainSet.getHead().getId());
                }
                ch = scanner.nextLine();
                int id = Integer.parseInt(ch);

                for(TrainSet trainSet : trainSets){
                    if(trainSet.getHead().getId() == id){
                        trainSet.setVisible(true);
                        break;
                    }
                }
                System.out.println("[ENTER] to exit");
                ch = scanner.nextLine();
                for(TrainSet trainSet : trainSets){
                    if(trainSet.getHead().getId() == id){
                        trainSet.setVisible(false);
                        break;
                    }
                }
                System.out.println("Exited");
            }
        }
        scanner.close();
        stopTrainsets(trainSets);
        System.exit(0);
    }


    public static void startTrainsets(List<TrainSet> trainSets){
        for (TrainSet trainSet : trainSets){
            trainSet.start();
        }
    }

    public static void stopTrainsets(List<TrainSet> trainSets){
        for (TrainSet trainSet : trainSets){
            trainSet.interrupt();
        }
    }
}
