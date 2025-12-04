import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DogTestStudent {
	Dog dog;

	@BeforeEach
	void setUp() throws Exception {
		dog = new Dog("Doubloon", 16, "Golden Retriever", "Gold");
	}

	@AfterEach
	void tearDown() throws Exception {
		dog = null;
	}

	@Test
	void testDog() {
		assertEquals("Doubloon", dog.getName());
		assertEquals(16, dog.getAge());
	}

	@Test
	void testMove() {
		dog.move();
		assertTrue(true);
	}

	@Test
	void testMakeSound() {
		dog.makeSound();
		assertTrue(true);
	}

	@Test
	void testGetName() {
		assertEquals("Doubloon", dog.getName());
	}

	@Test
	void testGetAge() {
		assertEquals(16, dog.getAge());
	}

	@Test
	void testEqualsDog() {
		Dog sameDog = new Dog("Doubloon", 16, "Golden Retriever", "Gold");
		Dog diffDog = new Dog("Dark", 13, "Default", "Black");
		
		assertTrue(dog.equals(dog));
		assertTrue(dog.equals(sameDog));
		assertFalse(dog.equals(null));
		assertFalse(dog.equals(diffDog));
	}
	
	@Test
	void testClone() throws CloneNotSupportedException {
		Dog clonedDog = (Dog) dog.clone();
		assertTrue(dog.equals(clonedDog));
	}

	@Test
	void testToString() {
		String expected = "Name: Doubloon\nAge: 16\nSpecies: Golden Retriever\nColor: Gold";
		assertEquals(expected, dog.toString());
	}

}
