package RailroadCars;

import java.util.Random;

public class ToxicRailroadCar extends HeavyFreightRailroadCar{
    public ToxicRailroadCar(float netWeight, float grossWeight, String shipper, String cargo){
        super(netWeight, grossWeight, shipper, cargo);
    }

    public ToxicRailroadCar(){
        super();
        setCargo("Toxic");
    }

    @Override
    public String toString() {
        return "ToxicRailroadCar[" + "id=" + super.getId() + ", netWeight=" + super.getNetWeight() + ", grossWeight=" + super.getGrossWeight() + ", shipper='" + super.getShipper() + '\'' + ", electricityRequired=" + super.isElectricityRequired() + ", cargo='" + super.getCargo() + '\'' + super.getCargoQuantity() + "]";

    }
}
