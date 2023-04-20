package RailroadCars;

public class GaseousRailroadCar extends FreightRailroadCar{
    public GaseousRailroadCar(float netWeight, float grossWeight, String shipper, String cargo){
        super(netWeight, grossWeight, shipper, cargo);
    }

    public GaseousRailroadCar(){
        super();
        setCargo("Gaseous");
    }

    @Override
    public String toString() {
        return "GaseousRailroadCar[" + "id=" + super.getId() + ", netWeight=" + super.getNetWeight() + ", grossWeight=" + super.getGrossWeight() + ", shipper='" + super.getShipper() + '\'' + ", electricityRequired=" + super.isElectricityRequired() + ", cargo='" + super.getCargo() + '\'' + ", cargo quantity=" + super.getCargoQuantity() + "]";
    }
}
