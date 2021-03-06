package gov.usgs.cida.coastalhazards.session;

import gov.usgs.cida.coastalhazards.session.io.SessionIO;
import gov.usgs.cida.coastalhazards.session.io.SessionIOException;
import gov.usgs.cida.coastalhazards.jpa.SessionManager;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;

/**
 *
 * @author isuftin
 */
public class SessionTest {
	String sessionJSON =  "{\"baselayer\":\"ESRI World Imagery\","
            + "\"scale\":13867008.52318302,\"bbox\":[-14879968.140907,3626269.4777222,-6470672.0382553,7755091.9969996],"
            + "\"center\": [5690680.7373609,-10675320.089581],"
            + "\"items\": ["
            + "{ \"id\":\"C2qL7nP\"}"
            + "]}";

	public SessionTest() {
	}
	
	@BeforeClass
	public static void setUpClass() {
	}
	
	@AfterClass
	public static void tearDownClass() {
	}
	
	@Before
	public void setUp() {
	}
	
	@After
	public void tearDown() {
	}
    
    @Test
    @Ignore // need to figure out how to do local db test
    public void testDB() throws SessionIOException {
        SessionIO sessionio = new SessionManager();
		String sessionID;
		
		sessionID = sessionio.save(sessionJSON);
		assertNotNull(sessionID);
		
		String json = sessionio.load(sessionID);
		assertNotNull(json);
    }
    
//    @Test
//    public void testSpring() {
//        ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("jpa-context.xml");
//
//		 try {
//			 SessionIO sessionio = context.getBean("session-manager", SessionJPAIO.class);
//         } finally {
//             context.close();
//         }
//    }
	
//	@Test
//	public void sessionReadWriteTest() throws SessionIOException {
//		SessionIO sessionio = new SessionFileIO();
//		String sessionID;
//		
//		sessionID = sessionio.save(sessionJSON);
//		assertNotNull(sessionID);
//		
//		String json = sessionio.load(sessionID);
//		assertNotNull(json);
//	}
}