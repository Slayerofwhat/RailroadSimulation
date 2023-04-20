package RailroadCars;

public class ExplosivesRailroadCar extends HeavyFreightRailroadCar{
    public ExplosivesRailroadCar(float netWeight, float grossWeight, String shipper, String cargo){
        super(netWeight, grossWeight, shipper, cargo);
    }

    public ExplosivesRailroadCar(){
        super();
        setCargo("Explosives!!!");
    }

    @Override
    public String toString() {
        return "ExplosivesRailroadCar[" + "id=" + super.getId() + ", netWeight=" + super.getNetWeight() + ", grossWeight=" + super.getGrossWeight() + ", shipper='" + super.getShipper() + '\'' + ", electricityRequired=" + super.isElectricityRequired() + ", cargo='" + super.getCargo() + '\'' + ", cargo quantity=" + super.getCargoQuantity() + "]";
    }
}
