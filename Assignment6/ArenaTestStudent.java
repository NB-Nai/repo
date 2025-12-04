import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ArenaTestStudent {
	Arena arena;

	@BeforeEach
	void setUp() throws Exception {
		arena = new Arena("Red", 30.0, 40.0);
	}

	@AfterEach
	void tearDown() throws Exception {
		arena = null;
	}

	@Test
	void testArena() {
		assertEquals("Red", arena.getColor());
		assertEquals(30.0, arena.getLength());
		assertEquals(40.0, arena.getWidth());
	}

	@Test
	void testSetSize() {
		arena.setSize(50.0, 60.0);
		assertEquals(50.0, arena.getLength());
		assertEquals(60.0, arena.getWidth());
	}

	@Test
	void testGetLength() {
		assertEquals(30.0, arena.getLength());
	}

	@Test
	void testGetWidth() {
		assertEquals(40.0, arena.getWidth());
	}

	@Test
	void testSetColor() {
		arena.setColor("Blue");
		assertEquals("Blue", arena.getColor());
	}

	@Test
	void testGetColor() {
		assertEquals("Red", arena.getColor());
	}

	@Test
	void testSetBuildingType() {
		arena.setBuildingType("Tournament");
		assertEquals("Tournament", arena.getBuildingType());
	}

	@Test
	void testGetBuildingType() {
		assertEquals("Arena", arena.getBuildingType());
	}

	@Test
	void testToString() {
		String expected = "Color: Red\nLength: 30.0\nWidth: 40.0\nBuilding: Arena";
		assertEquals(expected, arena.toString());
	}

}
