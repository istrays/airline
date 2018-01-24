package strays.airline.aircompany.aircraft;

public abstract class Aircraft implements Flyable {
    protected String model;
    protected int number;
    protected int carryingCapacity;
    protected int passengerCapacity;
    protected int fuelConsumption;
    protected int fuelCapacity;
    protected int flightRange;

    public Aircraft(String model, int number, int carryingCapacity, int passengerCapacity, int fuelConsumption, int fuelCapacity, int flightRange) {
        this.model = model;
        this.number = number;
        this.carryingCapacity = carryingCapacity;
        this.passengerCapacity = passengerCapacity;
        this.fuelConsumption = fuelConsumption;
        this.fuelCapacity = fuelCapacity;
        this.flightRange = flightRange;
    }

    public int getCarryingCapacity() {
        return carryingCapacity;
    }

    public int getPassengerCapacity() {
        return passengerCapacity;
    }

    public int getFuelConsumption() {
        return fuelConsumption;
    }

    public int getFuelCapacity() {
        return fuelCapacity;
    }

    public int getFlightRange() {
        return flightRange;
    }

    @Override
    public String toString() {
        return "Aircraft {" + model + '\'' + number +
                ", carrying capacity: " + carryingCapacity +
                ", passenger capacity: " + passengerCapacity +
                ", fuel consumption: " + fuelConsumption +
                ", fuel capacity: " + fuelCapacity +
                ", flight range: " + flightRange +
                '}';
    }
}
