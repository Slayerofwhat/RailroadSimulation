import java.util.Random;

public class Locomotive implements Runnable{
    private static int counter;
    private int id;
    private String name;
    private int maxCars;
    private int maxWeight;
    private int maxElectricity;
    private RailwayStation sourceStation;
    private RailwayStation destinationStation;
    private float speed;
    private static final double SPEED_VARIATION = 0.03;

    private boolean isHazarded = false;

    public Locomotive(String name, int maxCars, int maxWeight, int maxElectricity, RailwayStation sourceStation, RailwayStation destinationStation){
        counter++;
        id = counter;
        this.name = name;
        this.maxCars = maxCars;
        this.maxWeight = maxWeight;
        this.maxElectricity = maxElectricity;
        this.sourceStation = sourceStation;
        this.destinationStation = destinationStation;
    }

    public Locomotive(){
        counter++;
        id = counter;
        this.speed = 150;
        Random random = new Random();
        char c1 = (char) (random.nextInt(26) + 'a');
        char c2 = (char) (random.nextInt(26) + 'a');
        this.name = "";
        this.name += c1;
        this.name += c2;
        for(int i = 0; i < 4; i++){
            int num = random.nextInt(10);
            this.name += num;
        }
        this.maxCars = random.nextInt(11) + 5;
        this.maxWeight = random.nextInt(750) + 500;
        this.maxElectricity = random.nextInt(this.maxCars);
    }

    public int getMaxWeight() {
        return maxWeight;
    }

    public int getMaxElectricity() {
        return maxElectricity;
    }

    public int getMaxCars() {
        return maxCars;
    }

    public RailwayStation getSourceStation() {
        return sourceStation;
    }

    public RailwayStation getDestinationStation() {
        return destinationStation;
    }

    public void setSourceStation(RailwayStation sourceStation) {
        this.sourceStation = sourceStation;
    }

    public void setDestinationStation(RailwayStation destinationStation) {
        this.destinationStation = destinationStation;
    }

    public float getSpeed() {
        return speed;
    }

    public int getId() {
        return id;
    }

    public void setHazarded(boolean hazarded) {
        isHazarded = hazarded;
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }

    @Override
    public void run() {
        while (true) {
            if(!isHazarded) {
                Random random = new Random();
                float variation = (float) (speed * SPEED_VARIATION);
                this.speed = speed + (random.nextBoolean() ? variation : -variation);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                }
            }
        }
    }
}
