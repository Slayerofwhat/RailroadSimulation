package RailroadCars;

import java.util.Random;

public class PostOfficeRailroadCar extends RailroadCar {

    private int clerkNumber;
    private final boolean isUseless = true;
    public PostOfficeRailroadCar(float netWeight, float grossWeight, String shipper, int clerkNumber){
        super(netWeight, grossWeight, shipper);
        this.clerkNumber = clerkNumber;
        setElectricityRequired(true);
    }

    public PostOfficeRailroadCar(){
        super();
        Random random = new Random();
        this.clerkNumber = random.nextInt(16);
        setElectricityRequired(true);
    }

    @Override
    public String toString() {
        return "PostOfficeRailroadCar[" + "id=" + super.getId() + ", netWeight=" + super.getNetWeight() + ", grossWeight=" + super.getGrossWeight() + ", shipper='" + super.getShipper() + '\'' + ", electricityRequired=" + super.isElectricityRequired() + ", clerkNumber=" + clerkNumber + ", isUseless=" + isUseless + ']';
    }
}
