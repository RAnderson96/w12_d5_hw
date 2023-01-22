import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;


public class Flight {
    private Pilot pilot;
    private ArrayList<CabinCrewMember> cabinCrewMembers;
    private ArrayList<Passenger> passengers;
    private Plane plane;
    private String flightNumber;
    private String destination;
    private String departureAirport;
    private Date departureTime;

    private Calendar testCalendar;

    public Flight(Pilot pilot, ArrayList<CabinCrewMember> cabinCrewMembers, Plane plane, String flightNumber, String destination, String departureAirport, Date departureTime) {
        this.pilot = pilot;
        this.cabinCrewMembers = cabinCrewMembers;
        this.plane = plane;
        this.flightNumber = flightNumber;
        this.destination = destination;
        this.departureAirport = departureAirport;
        this.departureTime = departureTime;
        this.passengers = new ArrayList<Passenger>();

    }



//    public void setDepartureTime(int year, int date, int month, int hour, int minute) {
//        testCalendar.set(Calendar.YEAR, year);
//        testCalendar.set(Calendar.DATE, date);
//        testCalendar.set(Calendar.MONTH, month );
//        testCalendar.set(Calendar.HOUR, month );
//        testCalendar.set(Calendar.MINUTE, month );
////        this.departureTime = testCalendar.getTime();
//
//          Date firstDate2 = new Date(int year, int month, int date, int hrs, int min);
//
//    }


    public void setCabinCrewMembers(ArrayList<CabinCrewMember> cabinCrewMembers) {
        this.cabinCrewMembers = cabinCrewMembers;
    }

    public ArrayList<Passenger> getPassengers() {
        return passengers;
    }
    public int getPassengerCount() {
        return passengers.size();
    }

    public int getFlightCapacity(){
        return plane.getPlaneType().getCapacity();
    }

    public void setPassengers(ArrayList<Passenger> passengers) {
        this.passengers = passengers;
    }


    public String getDepartureTime() {
        return departureTime.toString();
    }

    public double getPassengerWeightAllowance(){
        return plane.getPlaneType().getWeightPerPassenger();
    }


    public void addPassenger(Passenger passenger){
        if(getFlightCapacity() > getPassengerCount()) {
            passengers.add(passenger);

        }
    }

    public int getNumberOfFreeSeats() {
        return getFlightCapacity() - getPassengerCount();
    }

    public boolean checkIfFreeSeat(){
        if(getFlightCapacity()> getPassengerCount()){
            return true;
        }
        return false;
    }

    public double getFlightTotalBagWeightCapacity(){
       return plane.getPlaneType().getWeight();
    }


}
