

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import timecard.domain.*;
import timecard.ui.*;

/**
 *
 * @author tvalkone
 */
public class TimecardTest {
    
    User user1;
    
    public TimecardTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        String password = "test2";
        String userid = "test1";
        String forename = "test3";
        String surname = "test4";
        user1 = new User(userid,password,forename,surname);
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void consturctorSetCorrectUserInfo() {
        
    
        String test1 = user1.getUserId(); 
        assertEquals("test1", test1);
        String test2 = user1.getPassword(); 
        assertEquals("test2", test2);
        String test3 = user1.getForename(); 
        assertEquals("test3", test3);
        String test4 = user1.getSurname(); 
        assertEquals("test4", test4);
    }
    
}
