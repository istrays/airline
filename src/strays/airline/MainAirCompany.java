package strays.airline;

import strays.airline.aircompany.Airline;
import strays.airline.aircompany.aircraft.Aircraft;
import strays.airline.aircompany.aircraft.CargoAircraft;
import strays.airline.aircompany.aircraft.PassengerAircraft;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Random;

public class MainAirCompany {
    private final static Airline AIRLINE = new Airline();

    static {
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            Aircraft ac = new PassengerAircraft(
                    "Model_" + i,
                    random.nextInt(1000),
                    1000 + random.nextInt(1000),
                    1000 - random.nextInt(1000),
                    10 + random.nextInt(50),
                    50 + random.nextInt(500),
                    random.nextInt(500000));
            AIRLINE.addAircraft(ac);
        }

        for (int i = 0; i < 10; i++) {
            Aircraft ac = new CargoAircraft(
                    "Model_" + i,
                    random.nextInt(1000),
                    1000 + random.nextInt(1000),
                    10 + random.nextInt(50),
                    50 + random.nextInt(500),
                    random.nextInt(500000));
            AIRLINE.addAircraft(ac);
        }
    }

    public static void main(String[] args) {
        printAircraft(AIRLINE.getSortedByFlightRange());
        System.out.print("Available commands:" +
                "\n\t1 - Calculate the total people capacity of all the aircraft in the airline." +
                "\n\t2 - Calculate the total carrying capacity of all the aircraft in the airline." +
                "\n\t3 - Display the list of aircraft of the company sorted by flight range." +
                "\n\t4 - Find airplanes corresponding to a given range of fuel consumption parameters." +
                "\n\t5 - Print all aircraft" +

                "\n\t10 - Exit." +
                "\nChoose number...\n");

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            int param = getIntFromUser(reader);
            switch (param) {
                case 1:
                    System.out.printf("The total people capacity of all the aircraft in the airline is: %s\n", AIRLINE.passengersCapacity());
                    break;
                case 2:
                    System.out.printf("The total carrying capacity of all the aircraft in the airline is: %s\n", AIRLINE.carryingCapacity());
                    break;
                case 3:
                    printAircraft(AIRLINE.getSortedByFlightRange());
                    break;
                case 4:
                    System.out.println("Find airplanes corresponding to a given range of fuel consumption parameters:");
                    System.out.println("Specify the minimum value:");
                    int min = getIntFromUser(reader);
                    System.out.println("Specify the maximum value:");
                    int max = getIntFromUser(reader);
                    printAircraft(AIRLINE.getWithFuelConsumptionLimits(min, max));
                    break;
                case 5:
                    printAircraft(AIRLINE.getAircraft());
                    break;
                case 10:
                    try {
                        reader.close();
                    } catch (IOException e) {
                    }
                    return;
                default:
                    System.out.println("Wrong command. Try another command.");
            }
        }
    }

    private static int getIntFromUser(BufferedReader reader) {
        String str;
        int result = 0;

        try {
            while ((str = reader.readLine()) == null || "".equals(str)) {
            }
            result = Integer.parseInt(str);
        } catch (IOException | NumberFormatException ignored) {
        }

        return result;
    }

    private static void printAircraft(List<Aircraft> aircraft) {
        System.out.printf("Found %s aircraft\n", aircraft.size());
        for (Aircraft ac : aircraft) {
            System.out.println(ac);
        }
        System.out.println("----------------------------");
    }
}
