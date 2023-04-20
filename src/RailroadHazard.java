public class RailroadHazard extends Exception{
    public RailroadHazard(TrainSet trainSet, int overallDistance, int distanceToNextStation, int overallDistanceCompleted, int distanceCompleted){
        super("Trainset " + trainSet.getHead().getId() + " reached 200km/h and now will stay to cool down! " + "It completed " + (overallDistanceCompleted*100/overallDistance) + "% of overall distance and " + distanceCompleted*100/distanceToNextStation + "% of distance to next station\r");
    }

}
