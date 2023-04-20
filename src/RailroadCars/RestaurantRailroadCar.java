package RailroadCars;

import java.util.Random;

public class RestaurantRailroadCar extends RailroadCar {
    private int customerMaxNumber;
    private int staffNumber;
    public RestaurantRailroadCar(float netWeight, float grossWeight, String shipper, int customerMaxNumber, int staffNumber){
        super(netWeight, grossWeight, shipper);
        this.customerMaxNumber = customerMaxNumber;
        this.staffNumber = staffNumber;
        setElectricityRequired(true);
    }

    public void AngryCustomers(){
        if(customerMaxNumber > staffNumber*3){
            System.out.println("Customers are angry!");
        }
    }

    public RestaurantRailroadCar(){
        super();
        Random random = new Random();
        this.customerMaxNumber = random.nextInt(46);
        this.staffNumber = random.nextInt(16);
        setElectricityRequired(true);
    }

    @Override
    public String toString() {
        return "RestaurantRailroadCar[" + "id=" + super.getId() + ", netWeight=" + super.getNetWeight() + ", grossWeight=" + super.getGrossWeight() + ", shipper='" + super.getShipper() + '\'' + ", electricityRequired=" + super.isElectricityRequired() + ", customerMaxNumber=" + customerMaxNumber + ", staffNumber=" + staffNumber + ']';
    }
}
