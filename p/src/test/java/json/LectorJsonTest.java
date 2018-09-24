package json;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Test;

import lectors.LectorJson;
import main.Constants;

public class LectorJsonTest {

	@Test(expected=NullPointerException.class)
	public void getIntOfJsonTest1() {
		LectorJson lector = new LectorJson(Constants.ROUTE_JSON_INSTRUCTIONS_1);
		assertNotNull(lector.getDoubleOfJson("sd"));
	}

	@Test(expected=AssertionError.class)
	public void getIntOfJsonTest2() {
		LectorJson lector = new LectorJson("sgsdfsdf");
		assertNull(lector.getDoubleOfJson("sd"));
	}

	@Test
	public void getIntOfJsonTest3() {
		LectorJson lector = new LectorJson(Constants.ROUTE_JSON_INSTRUCTIONS_1);
		assertNotNull(lector.getDoubleOfJson("Width"));
	}
	
	@Test
	public void getListOfJsonTest1() {
		LectorJson lector = new LectorJson(Constants.ROUTE_JSON_INSTRUCTIONS_1);
		assertNotNull(lector.getListOfJson("sd"));
	}

	@Test(expected=AssertionError.class)
	public void getListOfJsonTest2() {
		LectorJson lector = new LectorJson("asdasd");
		assertNotNull(lector.getListOfJson("sd"));
	}

	@Test
	public void getListOfJsonTest3() {
		LectorJson lector = new LectorJson(Constants.ROUTE_JSON_INSTRUCTIONS_1);
		assertNotNull(lector.getListOfJson("Points"));
	}
}
