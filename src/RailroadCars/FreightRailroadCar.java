package RailroadCars;

import java.util.Random;

public class FreightRailroadCar extends RailroadCar{
    private String cargo;
    private int cargoQuantity;
    public FreightRailroadCar(float netWeight, float grossWeight, String shipper, String cargo){
        super(netWeight, grossWeight, shipper);
        this.cargo = cargo;
        setHasCargo(true);
    }


    public FreightRailroadCar(){
        super();
        Random random = new Random();
        switch (random.nextInt(4)){
            case 0 -> this.cargo = "[SECRET]";
            case 1 -> this.cargo = "Iron ore";
            case 2 -> this.cargo = "Automobiles";
            case 3 -> this.cargo = "Consumer goods";
        }
        this.cargoQuantity = random.nextInt(30);
        setHasCargo(true);
    }

    public String getCargo() {
        return cargo;
    }

    public int getCargoQuantity() {
        return cargoQuantity;
    }

    public void addCargo(int n){
        cargoQuantity += n;
        if (cargoQuantity < 0) cargoQuantity = 0;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    @Override
    public String toString() {
        return "FreightRailroadCar[" + "id=" + super.getId() + ", netWeight=" + super.getNetWeight() + ", grossWeight=" + super.getGrossWeight() + ", shipper='" + super.getShipper() + '\'' + ", electricityRequired=" + super.isElectricityRequired() + ", cargo='" + this.cargo + '\'' + ", cargo quantity=" + cargoQuantity + "]";
    }
}
