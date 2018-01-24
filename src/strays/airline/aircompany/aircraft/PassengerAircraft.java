package strays.airline.aircompany.aircraft;

public class PassengerAircraft extends Aircraft {
    public PassengerAircraft(String model, int number, int carryingCapacity, int passengerCapacity, int fuelConsumption, int fuelCapacity, int flightRange) {
        super(model, number, carryingCapacity, passengerCapacity, fuelConsumption, fuelCapacity, flightRange);
    }

    @Override
    public String toString() {
        return "Passenger " + super.toString();
    }
}
