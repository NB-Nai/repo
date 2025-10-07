import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GradeBookTest {
	GradeBook gradebook1;
	GradeBook gradebook2;

	@BeforeEach
	void setUp() throws Exception {
		gradebook1 = new GradeBook(5);
		gradebook2 = new GradeBook(5);
		
		gradebook1.addScore(25);
		gradebook1.addScore(63);
		gradebook1.addScore(47);
		gradebook1.addScore(78);
		gradebook2.addScore(53);
		gradebook2.addScore(17);
		gradebook2.addScore(51);
	}

	@AfterEach
	void tearDown() throws Exception {
		gradebook1 = null;
		gradebook2 = null;
	}

	@Test
	void testAddScore() {
		assertTrue(gradebook1.toString().equals("25.0 63.0 47.0 78.0 "));
		assertEquals(gradebook1.getScoreSize(), 4);
		
		assertTrue(gradebook2.toString().equals("53.0 17.0 51.0 "));
		assertEquals(gradebook2.getScoreSize(), 3);
	}

	@Test
	void testSum() {
		assertEquals(gradebook1.sum(), 213, 0.0001);
		
		assertEquals(gradebook2.sum(), 121, 0.0001);
	}

	@Test
	void testMinimum() {
		assertEquals(gradebook1.minimum(), 25, 0.001);
		
		assertEquals(gradebook2.minimum(), 17, 0.001);
	}

	@Test
	void testFinalScore() {
		assertEquals(gradebook1.finalScore(), 188);
		
		assertEquals(gradebook2.finalScore(), 104);
	}
}
