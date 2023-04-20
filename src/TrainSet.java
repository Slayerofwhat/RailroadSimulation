import RailroadCars.*;

import java.util.*;

public class TrainSet extends Thread {
    private static final int STOP_TIME = 2000;
    private static final int WAIT_TIME = 30000;
    private Locomotive head;
    private ArrayList<RailroadCar> railroadCars;
    private int weight = 0;
    private int electricity = 0;
    private int number = 0;
    private boolean isVisible = false;
    private List<RailwayStation> path;
    private static List<RailwayConnection> connections;
    private boolean isHazarded = false;
    private int overallDistance = 0;

    public TrainSet(Locomotive head) {
        this.head = head;
        railroadCars = new ArrayList<>();
    }

    public int getOverallDistance() {
        return overallDistance;
    }

    public TrainSet(RailwayStation source, RailwayStation destination, List<RailwayStation> path, List<RailwayConnection> connections) {
        TrainSet.connections = connections;
        this.path = path;
        this.head = new Locomotive();
        this.head.setSourceStation(source);
        this.head.setDestinationStation(destination);
        railroadCars = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < random.nextInt(6) + 5; i++) {
            switch (random.nextInt(12)) {
                case 0 -> {
                    try {
                        addRailroadCar(new BaggageMailRailroadCar());
                    } catch (TooBigNumberException e) {
                        //System.out.println("Too big number of cars!");
                    } catch (TooBigWeightException e) {
                        //System.out.println("Too big weight!");
                    }
                }
                case 1 -> {
                    try {
                        addRailroadCar(new ExplosivesRailroadCar());
                    } catch (TooBigNumberException e) {
                        //System.out.println("Too big number of cars!");
                    } catch (TooBigWeightException e) {
                        //System.out.println("Too big weight!");
                    }
                }
                case 2 -> {
                    try {
                        addRailroadCar(new FreightRailroadCar());
                    } catch (TooBigNumberException e) {
                        //System.out.println("Too big number of cars!");
                    } catch (TooBigWeightException e) {
                        //System.out.println("Too big weight!");
                    }
                }
                case 3 -> {
                    try {
                        addRailroadCar(new GaseousRailroadCar());
                    } catch (TooBigNumberException e) {
                        //System.out.println("Too big number of cars!");
                    } catch (TooBigWeightException e) {
                        //System.out.println("Too big weight!");
                    }
                }
                case 4 -> {
                    try {
                        addRailroadCar(new HeavyFreightRailroadCar());
                    } catch (TooBigNumberException e) {
                        //System.out.println("Too big number of cars!");
                    } catch (TooBigWeightException e) {
                        //System.out.println("Too big weight!");
                    }
                }
                case 5 -> {
                    try {
                        addRailroadCar(new LiquidRailroadCar());
                    } catch (TooBigNumberException e) {
                        //System.out.println("Too big number of cars!");
                    } catch (TooBigWeightException e) {
                        //System.out.println("Too big weight!");
                    }
                }
                case 6 -> {
                    try {
                        addRailroadCar(new LiquidToxicRailroadCar());
                    } catch (TooBigNumberException e) {
                        //System.out.println("Too big number of cars!");
                    } catch (TooBigWeightException e) {
                        //System.out.println("Too big weight!");
                    }
                }
                case 7 -> {
                    try {
                        addRailroadCar(new PassengerRailroadCar());
                    } catch (TooBigNumberException e) {
                        //System.out.println("Too big number of cars!");
                    } catch (TooBigWeightException e) {
                        //System.out.println("Too big weight!");
                    }
                }
                case 8 -> {
                    try {
                        addRailroadCar(new PostOfficeRailroadCar());
                    } catch (TooBigNumberException e) {
                        //System.out.println("Too big number of cars!");
                    } catch (TooBigWeightException e) {
                        //System.out.println("Too big weight!");
                    }
                }
                case 9 -> {
                    try {
                        addRailroadCar(new RefrigeratedRailroadCar());
                    } catch (TooBigNumberException e) {
                        //System.out.println("Too big number of cars!");
                    } catch (TooBigWeightException e) {
                        //System.out.println("Too big weight!");
                    }
                }
                case 10 -> {
                    try {
                        addRailroadCar(new RestaurantRailroadCar());
                    } catch (TooBigNumberException e) {
                        //System.out.println("Too big number of cars!");
                    } catch (TooBigWeightException e) {
                        //System.out.println("Too big weight!");
                    }
                }
                case 11 -> {
                    try {
                        addRailroadCar(new ToxicRailroadCar());
                    } catch (TooBigNumberException e) {
                        //System.out.println("Too big number of cars!");
                    } catch (TooBigWeightException e) {
                        //System.out.println("Too big weight!");
                    }
                }
            }
        }
    }

    public void addRailroadCar(RailroadCar railroadCar) throws TooBigWeightException, TooBigNumberException {
        if (weight + railroadCar.getGrossWeight() < head.getMaxWeight()) {
            if (number < head.getMaxCars()) {
                if (railroadCar.isElectricityRequired()) {
                    if (electricity < head.getMaxElectricity() && railroadCar.isElectricityRequired()) {
                        railroadCars.add(railroadCar);
                        weight += railroadCar.getGrossWeight();
                        electricity++;
                        number++;
                    }
                } else {
                    railroadCars.add(railroadCar);
                    weight += railroadCar.getGrossWeight();
                    number++;
                }
            } else throw new TooBigNumberException();
        } else throw new TooBigWeightException();
    }

    public ArrayList<RailroadCar> getRailroadCars() {
        return railroadCars;
    }

    public Locomotive getHead() {
        return head;
    }

    public void setVisible(boolean visible) {
        isVisible = visible;
    }

    public boolean isHazarded() {
        return isHazarded;
    }

    public void RemoveRailroadCar(RailroadCar railroadCar){
        this.railroadCars.remove(railroadCar);
    }

    public void run() {
        Thread speedChange = new Thread(head);
        speedChange.start();
            while (true) {
                int overallDistance = 0;
                int overallDistanceCompleted = 0;
                for (int i = 0; i < path.size() - 1; i++) {
                    RailwayConnection connection;

                    RailwayStation source = path.get(i);
                    RailwayStation destination = path.get(i + 1);
                    for (RailwayConnection c : connections) {
                        if (c.getDestination() == destination && c.getSource() == source) {
                            connection = c;
                        } else connection = null;
                        if (connection != null) {
                            overallDistance += connection.getDistance();
                        }
                    }
                }
                this.overallDistance = overallDistance;
                for (int i = 0; i < path.size() - 1; i++) {

                    RailwayStation source = path.get(i);
                    RailwayStation destination = path.get(i + 1);

                    RailwayConnection connection = null;
                    for (RailwayConnection c : connections) {
                        if (c.getDestination() == destination && c.getSource() == source) {
                            connection = c;
                            break;
                        }
                    }


                    for (RailwayConnection c : connections) {
                        if (connection == c) {
                            while (c.isOccupied()) {
                                try {
                                    Thread.sleep(1000);
                                    if (isVisible) {
                                        System.out.print("Train " + head.getId() + " is waiting for path " + c.getSource().getName() + ", " + c.getDestination().getName() + "\r");
                                    }
                                } catch (InterruptedException e) {
                                    //System.out.println("Sleep interrupted");
                                }
                            }
                            c.setOccupied(true);
                        }
                    }


                    if (connection != null) {
                        int distance = connection.getDistance();
                        int distanceBetween = connection.getDistance();

                        while (distance > 0) {
                            if (head.getSpeed() > 200) try {
                                throw new RailroadHazard(this, overallDistance, distanceBetween, overallDistanceCompleted, distanceBetween - distance);
                            } catch (RailroadHazard e) {
                                if (isVisible) System.out.println(e.getMessage());
                                isHazarded = true;
                                head.setHazarded(true);
                                try {
                                    Thread.sleep(20000);
                                } catch (InterruptedException ex) {
                                    //System.out.println("Sleep interrupted");
                                }
                                isHazarded = false;
                                head.setHazarded(false);
                                head.setSpeed(150);
                            }

                            if(isVisible) {
                                System.out.print("Train " + head.getId() + " is moving to " + destination.getName() + " with speed " + head.getSpeed() + " km/h, distance left " + distance + "\r");
                            }
                            overallDistanceCompleted += head.getSpeed() / 3600;
                            distance -= head.getSpeed() / 3600;

                            try {
                                Thread.sleep(1000);
                            } catch (InterruptedException e) {
                                //System.out.println("Sleep interrupted");
                            }
                        }

                        if (isVisible) {
                            System.out.print("Train " + head.getId() + " stopped at " + destination.getName() + " with distance " + overallDistance + "\r");
                        }
                        try {
                            Thread.sleep(STOP_TIME);
                        } catch (InterruptedException e) {
                            //System.out.println("Sleep interrupted");
                        }

                        for (RailwayConnection c : connections) {
                            if (connection == c) {
                                c.setOccupied(false);
                            }
                        }
                    }
                }

                if (isVisible) {
                    System.out.print("Train " + head.getId() + " reached destination " + path.get(path.size() - 1).getName() + "\r");
                }

                try {
                    Thread.sleep(WAIT_TIME);
                } catch (InterruptedException e) {
                    //System.out.println("Sleep interrupted");
                }
                Collections.reverse(path);
            }
    }
}