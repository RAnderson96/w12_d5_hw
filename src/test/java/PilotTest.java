import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
public class PilotTest {

    private Pilot pilot;

    @Before
    public void setUp(){
        pilot = new Pilot("Abby", "1234");
    }
    @Test
    public void pilotCanFlyPlane(){
        assertEquals("Hello, my name is Captain Abby and I will be your pilot for your journey", pilot.flyPlane());
    }
}
