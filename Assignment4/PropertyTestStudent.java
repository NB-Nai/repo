import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PropertyTestStudent {
	Property property1;

	@BeforeEach
	void setUp() throws Exception {
		property1 = new Property("Science Center Building", "Maryland", 7500.00, "MC College", 1, 2, 3, 2);
	}

	@AfterEach
	void tearDown() throws Exception {
		property1 = null;
	}

	@Test
	void testGetPropertyName() {
		assertEquals("Science Center Building", property1.getPropertyName());
	}

	@Test
	void testGetCity() {
		assertEquals("Maryland", property1.getCity());
	}

	@Test
	void testGetRentAmount() {
		assertEquals(7500.00, property1.getRentAmount());
	}

	@Test
	void testGetOwner() {
		assertEquals("MC College", property1.getOwner());
	}

	@Test
	void testGetPlot() {
		assertEquals(1, property1.getPlot().getX());
		assertEquals(2, property1.getPlot().getY());
		assertEquals(3, property1.getPlot().getWidth());
		assertEquals(2, property1.getPlot().getDepth());
	}

	@Test
	void testSetPropertyName() {
		property1.setPropertyName("Science Center West Building");
		assertEquals("Science Center West Building", property1.getPropertyName());
	}

	@Test
	void testSetCity() {
		property1.setCity("Rockville");
		assertEquals("Rockville", property1.getCity());
	}

	@Test
	void testSetRentAmount() {
		property1.setRentAmount(25000.00);
		assertEquals(25000.00, property1.getRentAmount());
	}

	@Test
	void testSetOwner() {
		property1.setOwner("US Government");
		assertEquals("US Government", property1.getOwner());
	}

	@Test
	void testSetPlot() {
		property1.setPlot(new Plot(4, 3, 2, 2));
		assertEquals(4, property1.getPlot().getX());
		assertEquals(3, property1.getPlot().getY());
		assertEquals(2, property1.getPlot().getWidth());
		assertEquals(2, property1.getPlot().getDepth());
	}

	@Test
	void testToString() {
		assertEquals("Science Center Building,Maryland,MC College,7500.0",property1.toString());
	}

}
