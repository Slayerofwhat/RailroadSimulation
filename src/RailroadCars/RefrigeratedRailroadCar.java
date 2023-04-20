package RailroadCars;

import java.util.Random;

public class RefrigeratedRailroadCar extends FreightRailroadCar{
    private int temperature;
    public RefrigeratedRailroadCar(float netWeight, float grossWeight, String shipper, String cargo, int temperature){
        super(netWeight, grossWeight, shipper, cargo);
        this.temperature = temperature;
        setElectricityRequired(true);
    }

    public RefrigeratedRailroadCar(){
        super();
        Random random = new Random();
        this.temperature = -random.nextInt(61);
        setElectricityRequired(true);
    }

    @Override
    public String toString() {
        return "RefrigeratedRailroadCar[" + "id=" + super.getId() + ", netWeight=" + super.getNetWeight() + ", grossWeight=" + super.getGrossWeight() + ", shipper='" + super.getShipper() + '\'' + ", electricityRequired=" + super.isElectricityRequired() + ", cargo='" + super.getCargo() + '\'' + ", temperature=" + temperature + super.getCargoQuantity() +"]";
    }
}
