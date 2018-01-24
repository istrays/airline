package strays.airline.aircompany;

import strays.airline.aircompany.aircraft.Aircraft;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Airline {
    private static final Comparator<Aircraft> AIRCRAFT_RANGE_COMPARATOR = Comparator.comparing(Aircraft::getFlightRange);
    private List<Aircraft> aircraft;

    public Airline() {
        this(new ArrayList<>());
    }

    public Airline(Aircraft aircraft) {
        this();
        this.aircraft.add(aircraft);
    }

    public Airline(List<Aircraft> aircraft) {
        this.aircraft = aircraft;
    }

    public void addAircraft(Aircraft aircraft) {
        this.aircraft.add(aircraft);
    }

    public List<Aircraft> getAircraft() {
        return aircraft;
    }

    public void deleteAircraft(Aircraft aircraft) {
        this.aircraft.remove(aircraft);
    }

    public int passengersCapacity() {
        int result = 0;
        for (Aircraft aircraft : this.aircraft)
            result += aircraft.getPassengerCapacity();

        return result;
    }

    public int carryingCapacity() {
        int result = 0;
        for (Aircraft aircraft : this.aircraft)
            result += aircraft.getCarryingCapacity();

        return result;
    }

    public List<Aircraft> getSortedByFlightRange() {
        List<Aircraft> result = new ArrayList<>(aircraft);
        result.sort(AIRCRAFT_RANGE_COMPARATOR);
        return result;
    }

    public List<Aircraft> getWithFuelConsumptionLimits(int from, int to) {
        List<Aircraft> result = new ArrayList<>();

        for (Aircraft ac : aircraft) {
            int consumption = ac.getFuelConsumption();

            if (consumption >= from && consumption <= to)
                result.add(ac);
        }
        return result;
    }
}
