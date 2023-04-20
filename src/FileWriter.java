import RailroadCars.RailroadCar;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FileWriter extends Thread{
    private List<TrainSet> trainSets = new ArrayList<>();
    private List<TrainSet> updateTrainSet = new ArrayList<>();

    public FileWriter(List<TrainSet> trainSets){
        this.trainSets.addAll(trainSets);
        this.updateTrainSet = trainSets;
    }

    public void run() {
        while (true){
            trainSets.clear();
            this.trainSets.addAll(updateTrainSet);

            this.trainSets.sort((t1, t2) -> {
                int routeLength1 = t1.getOverallDistance();
                int routeLength2 = t2.getOverallDistance();
                return Integer.compare(routeLength2, routeLength1);
            });

            try (FileOutputStream outputStream = new FileOutputStream("AppState.txt")) {
                for (TrainSet trainSet : trainSets) {
                    List<RailroadCar> cars = new ArrayList<>(trainSet.getRailroadCars());
                    cars.sort((c1, c2) -> Float.compare(c1.getGrossWeight(), c2.getGrossWeight()));
                    String trainSetInfo = "Trainset " + trainSet.getHead().getId() + ":\n";
                    outputStream.write(trainSetInfo.getBytes());
                    trainSetInfo = "";
                    for (RailroadCar car : cars){
                        trainSetInfo = car.toString() + "\n";
                        outputStream.write(trainSetInfo.getBytes());
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
