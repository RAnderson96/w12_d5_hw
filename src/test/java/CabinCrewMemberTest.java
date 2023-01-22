import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CabinCrewMemberTest {

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


    private CrewRank crewRank;


    @Before
    public void setUp(){
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

    }

    @Test
    public void hasRank(){
        assertEquals(1, flightAttendant1.getCrewRank());
    }

    @Test
    public void canRelayMessage(){
        assertEquals("Can passenger Edd Janson please stop screaming?", flightAttendant1.relayMessage("Can passenger Edd Janson please stop screaming?") );
    }
}
