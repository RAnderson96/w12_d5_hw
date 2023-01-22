import org.junit.Before;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertEquals;

public class FlightTest {

    private Date flightDate;
    private CabinCrewMember flightAttendant1;
    private CabinCrewMember flightAttendant2;
    private CabinCrewMember flightAttendant3;
    private CabinCrewMember purser1;
    private CabinCrewMember purser2;
    private CabinCrewMember purser3;
    private CabinCrewMember firstOfficer1;
    private CabinCrewMember firstOfficer2;
    private CabinCrewMember firstOfficer3;
    private CabinCrewMember captain;

    private Pilot pilot;

    private CrewRank crewRank;

    private ArrayList<CabinCrewMember> crewMembers;

    private Passenger passenger1;
    private Passenger passenger2;
    private Passenger passenger3;
    private Passenger passenger4;
    private Passenger passenger5;
    private Passenger passenger6;
    private Plane boeing747;
    private Plane airbus;

    private Flight flight1;


    private ArrayList<Passenger> passengers;


    @Before
    public void setUp(){
        passenger1 = new Passenger("ChiChi", 1);
        passenger2 = new Passenger("Thor", 2);
        passenger3 = new Passenger("Rory", 1);
        passenger4 = new Passenger("Abby", 1);
        passenger5 = new Passenger("Alex", 1);
        passenger6 = new Passenger("Bessie", 2);



        flightAttendant1= new CabinCrewMember("Pierce Hawthorne", CrewRank.FlIGHTATTENDANT);
        flightAttendant2= new CabinCrewMember("Dean Craig Pelton", CrewRank.FlIGHTATTENDANT);
        flightAttendant3= new CabinCrewMember("Jeff Winger", CrewRank.FlIGHTATTENDANT);
        purser1= new CabinCrewMember("Abed Nadir", CrewRank.PURSER);
        purser2= new CabinCrewMember("Annie Edison", CrewRank.PURSER);
        purser3= new CabinCrewMember("Senor Chang", CrewRank.PURSER);
        firstOfficer1= new CabinCrewMember("Britta Perry", CrewRank.FIRSTOFFICER);
        firstOfficer2= new CabinCrewMember("Shirley Bennett", CrewRank.FIRSTOFFICER);
        firstOfficer3= new CabinCrewMember("Inspector Spacetime", CrewRank.FIRSTOFFICER);

        captain= new CabinCrewMember("Leonard", CrewRank.CAPTAIN);

        pilot = new Pilot("Leonard","1234");
        crewMembers = new ArrayList<CabinCrewMember>();
        crewMembers.add(flightAttendant1);
        crewMembers.add(purser1);
        crewMembers.add(firstOfficer1);
        crewMembers.add(captain);

        passengers = new ArrayList<Passenger>();


        boeing747 = new Plane(PlaneType.BOEING747);
        airbus = new Plane(PlaneType.AIRBUSA380);
        flightDate = new Date(2023, 02, 20, 10, 30);
        flight1 = new Flight(pilot, crewMembers, boeing747, "123", "AMS", "EDB" , flightDate);



    }





    @Test
    public void canCheckInPassengers(){
        flight1.addPassenger(passenger1);
        flight1.addPassenger(passenger2);
        flight1.addPassenger(passenger3);
        assertEquals(3, flight1.getPassengers().size());

    }

    @Test
    public void canGetPlanesCapacity(){
        assertEquals(4, flight1.getFlightCapacity());
    }

    @Test
    public void canGetNumberOfCheckedInPassengers(){
        flight1.addPassenger(passenger1);
        flight1.addPassenger(passenger2);
        flight1.addPassenger(passenger3);

        assertEquals(3, flight1.getPassengerCount());
    }

    @Test
    public void canReturnNumberOfAvailableSeats(){
        flight1.addPassenger(passenger1);
        flight1.addPassenger(passenger2);
        flight1.addPassenger(passenger3);

        assertEquals(1, flight1.getNumberOfFreeSeats());

    }

    @Test
    public void cannotHaveMorePassengersAddedThanCapacity(){
        flight1.addPassenger(passenger1);
        flight1.addPassenger(passenger2);
        flight1.addPassenger(passenger3);
        flight1.addPassenger(passenger4);
        flight1.addPassenger(passenger5);

        assertEquals(4, flight1.getPassengerCount());

    }
    @Test
    public void canGetFlightWeightCapacity(){
        flight1.addPassenger(passenger1);
        flight1.addPassenger(passenger2);
        flight1.addPassenger(passenger3);
        flight1.addPassenger(passenger4);

        assertEquals(120.0, flight1.getFlightTotalBagWeightCapacity(), 0.01);
    }


    @Test
    public void canGetFlightDate(){

        assertEquals("Tue Mar 20 10:30:00 GMT 3923",flight1.getDepartureTime());
    }

}
