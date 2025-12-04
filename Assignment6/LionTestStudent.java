import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LionTestStudent {
	Lion lion;

	@BeforeEach
	void setUp() throws Exception {
		lion = new Lion("Simba", 26, "Mufasa", "Orange");
	}

	@AfterEach
	void tearDown() throws Exception {
		lion = null;
	}

	@Test
	void testLion() {
		assertEquals("Simba", lion.getName());
		assertEquals(26, lion.getAge());
	}

	@Test
	void testMove() {
		lion.move();
		assertTrue(true);
	}

	@Test
	void testMakeSound() {
		lion.makeSound();
		assertTrue(true);
	}

	@Test
	void testGetName() {
		assertEquals("Simba", lion.getName());
	}

	@Test
	void testGetAge() {
		assertEquals(26, lion.getAge());
	}

	@Test
	void testEqualsLion() {
		Lion sameLion = new Lion("Simba", 26, "Mufasa", "Orange");
		Lion diffLion = new Lion("Panthera", 17, "Big Cat", "Orange");
		
		assertTrue(lion.equals(lion));
		assertTrue(lion.equals(sameLion));
		assertFalse(lion.equals(null));
		assertFalse(lion.equals(diffLion));
	}

	@Test
	void testClone() throws CloneNotSupportedException {
		Lion clonedLion = (Lion) lion.clone();
		assertTrue(lion.equals(clonedLion));
	}
	
	@Test
	void testToString() {
		String expected = "Name: Simba\nAge: 26\nSpecies: Mufasa\nColor: Orange";
		assertEquals(expected, lion.toString());
	}

}
