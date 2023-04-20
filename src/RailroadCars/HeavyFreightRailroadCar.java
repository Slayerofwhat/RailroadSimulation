package RailroadCars;

public class HeavyFreightRailroadCar extends FreightRailroadCar{
    public HeavyFreightRailroadCar(float netWeight, float grossWeight, String shipper, String cargo){
        super(netWeight, grossWeight, shipper, cargo);
    }

    public HeavyFreightRailroadCar(){
        super();
        setGrossWeight(getGrossWeight() + 100);
    }

    @Override
    public String toString() {
        return "HeavyFreightRailroadCar[" + "id=" + super.getId() + ", netWeight=" + super.getNetWeight() + ", grossWeight=" + super.getGrossWeight() + ", shipper='" + super.getShipper() + '\'' + ", electricityRequired=" + super.isElectricityRequired() + ", cargo='" + super.getCargo() + '\'' + super.getCargoQuantity() + "]";
    }
}
