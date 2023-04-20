import java.util.*;

public class RailwayStructure {
    private ArrayList<RailwayStation> stations;
    private Map<RailwayStation, List<RailwayConnection>> connections;



    public RailwayStructure() {
        stations = new ArrayList<>();
        connections = new HashMap<>();
    }

    public void addStation(RailwayStation station) {
        stations.add(station);
        connections.put(station, new ArrayList<>());
    }

    public void addConnection(RailwayStation source, RailwayStation destination, int distance) {
        RailwayConnection connection1 = new RailwayConnection(source, destination, distance);
        RailwayConnection connection2 = new RailwayConnection(destination, source, distance);

        connections.get(source).add(connection1);
        connections.get(destination).add(connection2);
    }

    public List<RailwayStation> getStations() {
        return stations;
    }

    public List<RailwayConnection> getConnections(RailwayStation station) {
        return connections.get(station);
    }

    public List<RailwayStation> getShortestPath(RailwayStation source, RailwayStation destination) {
        Map<RailwayStation, Integer> distances = new HashMap<>();
        Map<RailwayStation, RailwayConnection> previous = new HashMap<>();
        Set<RailwayStation> unvisited = new HashSet<>(stations);

        for (RailwayStation station : stations) {
            distances.put(station, Integer.MAX_VALUE);
        }
        distances.put(source, 0);

        while (!unvisited.isEmpty()) {
            RailwayStation currentStation = getClosestStation(unvisited, distances);
            unvisited.remove(currentStation);

            if (currentStation == destination) {
                break;
            }

            for (RailwayConnection connection : getConnections(currentStation)) {
                RailwayStation neighbor = connection.getDestination(/*currentStation*/);
                int altDistance = distances.get(currentStation) + connection.getDistance();
                if (altDistance < distances.get(neighbor)) {
                    distances.put(neighbor, altDistance);
                    previous.put(neighbor, connection);
                }
            }
        }

        List<RailwayStation> path = new ArrayList<>();
        RailwayStation currentStation = destination;
        while (previous.containsKey(currentStation)) {
            path.add(currentStation);
            currentStation = previous.get(currentStation).getSource();
        }
        path.add(source);
        Collections.reverse(path);

        return path;
    }

    private RailwayStation getClosestStation(Set<RailwayStation> stations, Map<RailwayStation, Integer> distances) {
        int minDistance = Integer.MAX_VALUE;
        RailwayStation closestStation = null;
        for (RailwayStation station : stations) {
            int distance = distances.get(station);
            if (distance < minDistance) {
                minDistance = distance;
                closestStation = station;
            }
        }
        return closestStation;
    }




    public List<RailwayConnection> getAllConnections() {
        List<RailwayConnection> allConnections = new ArrayList<>();
        for (List<RailwayConnection> stationConnections : connections.values()) {
            allConnections.addAll(stationConnections);
        }
        return allConnections;
    }

    public int getDistance(RailwayStation source, RailwayStation destination){
        List<RailwayConnection> connections = getConnections(source);
        for (RailwayConnection connection : connections) {
            if (destination == connection.getDestination()) return connection.getDistance();
        }
        return 0;
    }

    public RailwayStation getRandomStation() {
        Random random = new Random();
        int index = random.nextInt(stations.size());
        return stations.get(index);
    }

    public RailwayStation getDifRailwayStation(RailwayStation station){
        RailwayStation destination = getRandomStation();
        while(destination == station){
            destination = getRandomStation();
        }
        return destination;
    }

    public void GenerateConnections(int n){
        Random random = new Random();
        for (RailwayStation railwayStation : getStations()){
            for (int i = 0; i < n; i++){
                addConnection(railwayStation, getDifRailwayStation(railwayStation), random.nextInt(100) + 20);
            }
        }
    }

    public void GenerateStations(int n){
        for (int i = 0; i < n; i++) {
            RailwayStation station = new RailwayStation("Station " + (i+1));
            addStation(station);
        }
    }

    public List<TrainSet> GenerateTrainSet(int n){
        List<TrainSet> trainSets = new ArrayList<>();
        for (int i = 0; i < n; i++){
            RailwayStation source = getRandomStation();
            RailwayStation destination = getDifRailwayStation(source);
            TrainSet trainSet = new TrainSet(source, destination, getShortestPath(source, destination), getAllConnections());
            trainSets.add(trainSet);
        }
        return trainSets;
    }
}
