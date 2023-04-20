package RailroadCars;

public class LiquidToxicRailroadCar extends HeavyFreightRailroadCar{
    public LiquidToxicRailroadCar(float netWeight, float grossWeight, String shipper, String cargo){
        super(netWeight, grossWeight, shipper, cargo);
    }

    public LiquidToxicRailroadCar(){
        super();
        setCargo("Liquid toxic");
    }

    @Override
    public String toString() {
        return "LiquidToxicRailroadCar[" + "id=" + super.getId() + ", netWeight=" + super.getNetWeight() + ", grossWeight=" + super.getGrossWeight() + ", shipper='" + super.getShipper() + '\'' + ", electricityRequired=" + super.isElectricityRequired() + ", cargo='" + super.getCargo() + '\'' + super.getCargoQuantity() + "]";
    }
}
