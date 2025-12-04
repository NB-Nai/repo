import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TicketingOfficeTestStudent {
	TicketingOffice ticketOffice;

	@BeforeEach
	void setUp() throws Exception {
		ticketOffice = new TicketingOffice("Cyan", 50.0, 40.0);
	}

	@AfterEach
	void tearDown() throws Exception {
		ticketOffice = null;
	}

	@Test
	void testTicketingOffice() {
		assertEquals("Cyan", ticketOffice.getColor());
		assertEquals(50.0, ticketOffice.getLength());
		assertEquals(40.0, ticketOffice.getWidth());
	}

	@Test
	void testSetSize() {
		ticketOffice.setSize(90.0, 80.0);
		assertEquals(90.0, ticketOffice.getLength());
		assertEquals(80.0, ticketOffice.getWidth());
	}

	@Test
	void testGetLength() {
		assertEquals(50.0, ticketOffice.getLength());
	}

	@Test
	void testGetWidth() {
		assertEquals(40.0, ticketOffice.getWidth());
	}

	@Test
	void testSetColor() {
		ticketOffice.setColor("Red");
		assertEquals("Red", ticketOffice.getColor());
	}

	@Test
	void testGetColor() {
		assertEquals("Cyan", ticketOffice.getColor());
	}

	@Test
	void testSetBuildingType() {
		ticketOffice.setBuildingType("Zoo Ticketing Office");
		assertEquals("Zoo Ticketing Office", ticketOffice.getBuildingType());
	}

	@Test
	void testGetBuildingType() {
		assertEquals("Ticketing Office", ticketOffice.getBuildingType());
	}

	@Test
	void testToString() {
		String expected = "Color: Cyan\nLength: 50.0\nWidth: 40.0\nBuilding: Ticketing Office";
		assertEquals(expected, ticketOffice.toString());
	}

}
