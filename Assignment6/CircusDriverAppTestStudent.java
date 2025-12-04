import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CircusDriverAppTestStudent {

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testMain() {
		boolean success = true;
		try {
			// If no error was caught when using the driverApp, then the test succeed.
			CircusDriverApp.main(null);
		} catch (Exception e) {
			// Else if the program caught an error, then the test will fail.
			System.out.println(String.format("Error: %s", e));
			success = false;
		}
		assertTrue(success);
	}

}
