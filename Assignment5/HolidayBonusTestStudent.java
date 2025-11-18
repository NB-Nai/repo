import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class HolidayBonusTestStudent {
	
	private double[][] data = {{49, 73, 38, 94}, {36, 54, 84}, {32, 79}, {93, 77, 36}};

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testCalculateHolidayBonus() {
		double[] bonuses = HolidayBonus.calculateHolidayBonus(data);
		assertEquals(11000.0, bonuses[0], 0.001);
		assertEquals(8000.0, bonuses[1], 0.001);
		assertEquals(6000.0, bonuses[2], 0.001);
		assertEquals(8000.0, bonuses[3], 0.001);
	}

	@Test
	void testCalculateTotalHolidayBonus() {
		assertEquals(33000.0, HolidayBonus.calculateTotalHolidayBonus(data));
	}

}
