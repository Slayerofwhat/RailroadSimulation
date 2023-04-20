package RailroadCars;

import java.util.Random;

public class RailroadCar{
    private static int counter;
    private int id;
    private float netWeight;
    private float grossWeight;
    private String shipper;
    private boolean electricityRequired = false;
    private boolean hasCargo = false;
    private boolean hasPeople = false;

    public RailroadCar(float netWeight, float grossWeight, String shipper){
        counter++;
        id = counter;
        this.netWeight = netWeight;
        this.grossWeight = grossWeight;
        this.shipper = shipper;
    }

    public RailroadCar(){
        counter++;
        id = counter;
        Random random = new Random();
        this.grossWeight = random.nextFloat(51) + 50;
        this.netWeight = random.nextFloat(grossWeight - 20);
        switch (random.nextInt(5)) {
            case 0 -> {
                this.shipper = "SwiftShip";
            }
            case 1 -> {
                this.shipper = "Horizon Shipping";
            }
            case 2 -> {
                this.shipper = "FastTrack Shipping";
            }
            case 3 -> {
                this.shipper = "TransGlobal Shipping";
            }
            case 4 -> {
                this.shipper = "Coastal Cargo";
            }
        }
    }

    public void setHasPeople(boolean hasPeople) {
        this.hasPeople = hasPeople;
    }

    public boolean isHasPeople() {
        return hasPeople;
    }

    public void setHasCargo(boolean hasCargo) {
        this.hasCargo = hasCargo;
    }

    public boolean isHasCargo() {
        return hasCargo;
    }

    public int getId() {
        return id;
    }

    public float getGrossWeight() {
        return grossWeight;
    }

    public float getNetWeight() {
        return netWeight;
    }

    public String getShipper() {
        return shipper;
    }

    public void setElectricityRequired(boolean electricityRequired) {
        this.electricityRequired = electricityRequired;
    }

    public boolean isElectricityRequired() {
        return electricityRequired;
    }


    public void setId(int id) {
        this.id = id;
    }

    public void setGrossWeight(float grossWeight) {
        this.grossWeight = grossWeight;
    }


    @Override
    public String toString() {
        return "RailroadCar[" + "id=" + id + ", netWeight=" + netWeight + ", grossWeight=" + grossWeight + ", shipper='" + shipper + '\'' + ", electricityRequired=" + electricityRequired + ']';
    }
}
