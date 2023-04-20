import java.util.List;

public class Presentation extends Main{
    public static void main(String[] args) {
        //Create railway structure, main class of program
        RailwayStructure railwayStructure1 = new RailwayStructure();

        //Create new n stations
        railwayStructure1.GenerateStations(5);

        //Generate n random connections to every station
        railwayStructure1.GenerateConnections(2);

        //Create new n trainsets
        List<TrainSet> trainSets1 = railwayStructure1.GenerateTrainSet(2);

        //Start trainset
        startTrainsets(trainSets1);

        //Generate path for train
        List<RailwayStation> path = railwayStructure1.getShortestPath(trainSets1.get(0).getHead().getSourceStation(), trainSets1.get(0).getHead().getDestinationStation());

        //Display path
        System.out.println(path);

        //Gain information about trainset
        trainSets1.get(0).setVisible(true);
    }
}
