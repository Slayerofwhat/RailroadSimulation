package RailroadCars;

import java.util.Random;

public class PassengerRailroadCar extends RailroadCar {
    private int passengerNumber;
    private int passengerSeatsNumber;

    public PassengerRailroadCar(float netWeight, float grossWeight, String shipper, int passengerNumber, int passengerSeatsNumber){
        super(netWeight, grossWeight, shipper);
        super.setElectricityRequired(true);
        this.passengerNumber = passengerNumber;
        this.passengerSeatsNumber = passengerSeatsNumber;
        setHasPeople(true);
    }

    public PassengerRailroadCar(){
        super();
        super.setElectricityRequired(true);
        Random random = new Random();
        this.passengerSeatsNumber = random.nextInt(26) + 15;
        this.passengerNumber = random.nextInt(26) + 15;
        setHasPeople(true);
    }

    public void AngryPassengers(){
        if(passengerNumber > passengerSeatsNumber){
            System.out.println("Passengers are angry!");
        }
    }

    public void AddPassengers(int n){
        passengerNumber += n;
        if (passengerNumber < 0) passengerNumber = 0;
    }

    public int getPassengerNumber() {
        return passengerNumber;
    }

    //+ "id=" + super.getId() + ", netWeight=" + super.getNetWeight() + ", grossWeight=" + super.getGrossWeight() + ", shipper='" + super.getShipper() + '\'' + ", electricityRequired=" + super.isElectricityRequired()

    @Override
    public String toString() {
        return "PassengerRailroadCar[" + "id=" + super.getId() + ", netWeight=" + super.getNetWeight() + ", grossWeight=" + super.getGrossWeight() + ", shipper='" + super.getShipper() + '\'' + ", electricityRequired=" + super.isElectricityRequired() + ", passengerNumber=" + passengerNumber + ", passengerSeatsNumber=" + passengerSeatsNumber + ']';
    }
}
