import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PlotTestStudent {
	private Plot plot1, plot2, plot3, plot4;

	@BeforeEach
	void setUp() throws Exception {
		plot1 = new Plot(2, 2, 6, 6);
		plot2 = new Plot(7, 7, 2, 2);
		plot3 = new Plot(3, 4, 4, 3);
		plot4 = new Plot(9, 9, 2, 2);
	}

	@AfterEach
	void tearDown() throws Exception {
		plot1 = plot2 = plot3 = null;
	}

	@Test
	void testOverlaps() {
		assertTrue(plot1.overlaps(plot2));
		assertTrue(plot1.overlaps(plot3));
		assertFalse(plot1.overlaps(plot4));
	}

	@Test
	void testEncompasses() {
		assertFalse(plot1.encompasses(plot2));
		assertTrue(plot1.encompasses(plot3));
		assertFalse(plot1.encompasses(plot4));
	}

	@Test
	void testToString() {
		assertEquals("2,2,6,6", plot1.toString());
	}

}
