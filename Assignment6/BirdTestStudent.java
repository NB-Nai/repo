import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BirdTestStudent {
	Bird bird;

	@BeforeEach
	void setUp() throws Exception {
		bird = new Bird("Cawl", 10, "Pigeon", "Vibrant");
	}

	@AfterEach
	void tearDown() throws Exception {
		bird = null;
	}

	@Test
	void testBird() {
		assertEquals("Cawl", bird.getName());
		assertEquals(10, bird.getAge());
	}

	@Test
	void testMove() {
		bird.move();
		assertTrue(true);
	}

	@Test
	void testMakeSound() {
		bird.makeSound();
		assertTrue(true);
	}

	@Test
	void testGetName() {
		assertEquals("Cawl", bird.getName());
	}

	@Test
	void testGetAge() {
		assertEquals(10, bird.getAge());
	}

	@Test
	void testEqualsBird() {
		Bird sameBird = new Bird("Cawl", 10, "Pigeon", "Vibrant");
		Bird diffBird = new Bird("Bawl", 14, "Chicken", "White");
		
		assertTrue(bird.equals(bird));
		assertTrue(bird.equals(sameBird));
		assertFalse(bird.equals(null));
		assertFalse(bird.equals(diffBird));
	}

	@Test
	void testClone() throws CloneNotSupportedException {
		Bird clonedBird = (Bird) bird.clone();
		assertTrue(bird.equals(clonedBird));
	}
	
	@Test
	void testToString() {
		String expected = "Name: Cawl\nAge: 10\nSpecies: Pigeon\nColor: Vibrant";
		assertEquals(expected, bird.toString());
	}

}
