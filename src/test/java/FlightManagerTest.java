import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;

import static org.junit.Assert.assertEquals;

public class FlightManagerTest {
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
    private FlightManager flightManager;
    private Date flightDate;


    @Before
    public void setUp(){
        passenger1 = new Passenger("ChiChi", 1);
        passenger2 = new Passenger("Thor", 2);
        passenger3 = new Passenger("Rory", 1);
        passenger4 = new Passenger("Abby", 0);
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
        flight1 = new Flight(pilot, crewMembers, boeing747, "123", "AMS", "EDB", flightDate);
        flightManager = new FlightManager(flight1);

    }



    @Test
    public void canCalculateWeightReservedPerPassenger(){
        flightManager.getPassengerWeightAllowance(passenger1);
        assertEquals(30, flightManager.getPassengerWeightAllowance(passenger1), 0.01);
    }

    @Test
    public void canCalculateHowMuchWeightBookedByPassengers(){
        flightManager.checkInPassenger(passenger1);
        flightManager.checkInPassenger(passenger1);
        assertEquals(60, flightManager.getFlightTotalBagWeight(), 0.01);
    }

    @Test
    public void canAddAPassenger(){
        flightManager.checkInPassenger(passenger1);
        assertEquals(30, flightManager.getFlightTotalBagWeight(), 0.01);
        assertEquals(1,flight1.getPassengerCount());
    }
    @Test
    public void canNotAddPassengerIfOverPassengerCapacity(){
        flightManager.checkInPassenger(passenger1);
        flightManager.checkInPassenger(passenger2);
        flightManager.checkInPassenger(passenger4);
        flightManager.checkInPassenger(passenger4);
        flightManager.checkInPassenger(passenger4);
        assertEquals(0,flight1.getNumberOfFreeSeats());
        assertEquals(4,flight1.getPassengerCount());
        assertEquals(90.0, flightManager.getFlightTotalBagWeight(), 0.01);
    }

    @Test
    public void canGetRemainingWeightALlocationWithNoPassengers(){

        assertEquals(120, flightManager.getRemainingWeightAllocation(), 0.01);
    }

    @Test
    public void canGetRemainingWeightAllocationWhenAddedPassengers(){
        flightManager.checkInPassenger(passenger1);
        flightManager.checkInPassenger(passenger1);
        assertEquals(60, flightManager.getRemainingWeightAllocation(), 0.01);
    }





}
