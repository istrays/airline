package strays.airline.aircompany.aircraft;

public class CargoAircraft extends Aircraft {

    public CargoAircraft(String model, int number, int carryingCapacity, int fuelConsumption, int fuelCapacity, int flightRange) {
        super(model, number, carryingCapacity, 0, fuelConsumption, fuelCapacity, flightRange);
    }

    @Override
    public String toString() {
        return "Cargo " + super.toString();
    }
}
