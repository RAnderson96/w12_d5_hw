import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.ArrayList;
import java.util.HashMap;

public class FlightManager {
    private Flight flight;
    private double totalPassengersBagWeight;

    public FlightManager(Flight flight) {
        this.flight = flight;
        this.totalPassengersBagWeight = 0.0;

    }

    public double getRemainingWeightAllocation(){
        return flight.getFlightTotalBagWeightCapacity() - getFlightTotalBagWeight();
    }

    public double getFlightTotalBagWeight() {
        return totalPassengersBagWeight;
    }


    public double getPassengerWeightAllowance(Passenger passenger){
        return passenger.getNumBags()* flight.getPassengerWeightAllowance();

    }


    private void addPassengerBags(Passenger passenger){
        this.totalPassengersBagWeight += getPassengerWeightAllowance(passenger);
    }

    private Boolean checkLuggageWeight(Passenger passenger){
        if ( getPassengerWeightAllowance(passenger) + totalPassengersBagWeight < flight.getFlightTotalBagWeightCapacity() ){
            return true;
        }
        return false;
    }

    public void checkInPassenger(Passenger passenger){
        if(checkLuggageWeight(passenger) && flight.checkIfFreeSeat()){
            flight.addPassenger(passenger);
            addPassengerBags(passenger);
        }
        else if (!checkLuggageWeight(passenger)){
            flightOverBagWeightCapacity();
        }
        else if (!flight.checkIfFreeSeat()){
            flightOverPassengerCapacity();
        }

    }

    public void flightOverPassengerCapacity(){

        System.out.println("Flight is over passenger capacity");

    }
    public void flightOverBagWeightCapacity(){

        System.out.println("Flight is over baggage weight capacity");

    }
}
