import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class HorseTestStudent {
	Horse horse;

	@BeforeEach
	void setUp() throws Exception {
		horse = new Horse("Julian", 21, "Arabian", "Brown");
	}

	@AfterEach
	void tearDown() throws Exception {
		horse = null;
	}

	@Test
	void testHorse() {
		assertEquals("Julian", horse.getName());
		assertEquals(21, horse.getAge());
	}

	@Test
	void testMove() {
		horse.move();
		assertTrue(true);
	}

	@Test
	void testMakeSound() {
		horse.makeSound();
		assertTrue(true);
	}

	@Test
	void testGetName() {
		assertEquals("Julian", horse.getName());
	}

	@Test
	void testGetAge() {
		assertEquals(21, horse.getAge());
	}

	@Test
	void testEqualsHorse() {
		Horse sameHorse = new Horse("Julian", 21, "Arabian", "Brown");
		Horse diffHorse = new Horse("Bowl", 23, "Dutch", "White");
		
		assertTrue(horse.equals(horse));
		assertTrue(horse.equals(sameHorse));
		assertFalse(horse.equals(null));
		assertFalse(horse.equals(diffHorse));
	}
	
	@Test
	void testClone() throws CloneNotSupportedException {
		Horse clonedHorse = (Horse) horse.clone();
		assertTrue(horse.equals(clonedHorse));
	}

	@Test
	void testToString() {
		String expected = "Name: Julian\nAge: 21\nSpecies: Arabian\nColor: Brown";
		assertEquals(expected, horse.toString());
	}

}
