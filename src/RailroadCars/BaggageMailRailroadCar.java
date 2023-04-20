package RailroadCars;

import java.util.Random;

public class BaggageMailRailroadCar extends RailroadCar {
    private int mailNumber;
    private int baggageNumber;
    public BaggageMailRailroadCar(float netWeight, float grossWeight, String shipper, int mailNumber, int baggageNumber){
        super(netWeight, grossWeight, shipper);
        this.mailNumber = mailNumber;
        this.baggageNumber = baggageNumber;
    }

    public BaggageMailRailroadCar(){
        super();
        Random random = new Random();
        this.mailNumber = random.nextInt(200);
        this.baggageNumber =random.nextInt(100);
    }

    @Override
    public String toString() {
        return "BaggageMailRailroadCar[" + "id=" + super.getId() + ", netWeight=" + super.getNetWeight() + ", grossWeight=" + super.getGrossWeight() + ", shipper='" + super.getShipper() + '\'' + ", electricityRequired=" + super.isElectricityRequired() + ", mailNumber=" + mailNumber + ", baggageNumber=" + baggageNumber + ", cargo quantity=" + ']';
    }
}
