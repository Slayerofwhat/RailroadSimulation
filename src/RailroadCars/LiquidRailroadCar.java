package RailroadCars;

import java.util.Random;

public class LiquidRailroadCar extends FreightRailroadCar{
    public LiquidRailroadCar(float netWeight, float grossWeight, String shipper, String cargo){
        super(netWeight, grossWeight, shipper, cargo);
    }

    public LiquidRailroadCar(){
        super();
        Random random = new Random();
        switch (random.nextInt(3)){
            case 0 -> setCargo("Water");
            case 1 -> setCargo("Refined oil");
            case 2 -> setCargo("Crude oil");
        }
    }

    @Override
    public String toString() {
        return "LiquidRailroadCar[" + "id=" + super.getId() + ", netWeight=" + super.getNetWeight() + ", grossWeight=" + super.getGrossWeight() + ", shipper='" + super.getShipper() + '\'' + ", electricityRequired=" + super.isElectricityRequired() + ", cargo='" + super.getCargo() + '\'' + super.getCargoQuantity() + "]";
    }
}
