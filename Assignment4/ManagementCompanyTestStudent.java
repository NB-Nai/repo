import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ManagementCompanyTestStudent {
	Property sampleProperty;
	ManagementCompany mgCo;

	@BeforeEach
	void setUp() throws Exception {
		mgCo = new ManagementCompany("Johnson", "123456789",8);
		
	}

	@AfterEach
	void tearDown() throws Exception {
		mgCo = null;
	}

	@Test
	public void testAddProperty() {
		sampleProperty = new Property ("Physic Class", "America", 5000, "Washington",1,2,3,4);
		assertEquals(mgCo.addProperty(sampleProperty),0);
	}

	@Test
	void testGetTotalRent() {
		mgCo.addProperty(new Property ("Building 1", "Rockville", 1200, "Mayor"));
		assertEquals(mgCo.getTotalRent(), 1200.0);
	}

	@Test
	void testGetHighestRentProperty() {
		mgCo.addProperty(new Property ("Building 2", "Rockville", 4800, "Mayor"));
		assertEquals(mgCo.getHighestRentProperty().getRentAmount(), 4800.0);
	}

	@Test
	void testRemoveLastProperty() {
		mgCo.addProperty(new Property ("Building 3", "Rockville", 0, "Mayor"));
		assertEquals(mgCo.getPropertiesCount(), 1);
		mgCo.removeLastProperty();
		assertEquals(mgCo.getPropertiesCount(), 0);
	}

	@Test
	void testToString() {
		sampleProperty = new Property ("Building 4", "Rockville", 1200, "Mayor");
		assertEquals(mgCo.addProperty(sampleProperty), 0);
		String expectedString = "List of the properties for Johnson, taxID: 123456789\n"
				+ "______________________________________________________\n"
				+ "Building 4,Rockville,Mayor,1200.0\n"
				+ "______________________________________________________\n"
				+"\n"
				+ " total management Fee: 96.0";
		assertEquals(expectedString, mgCo.toString());
		
	}

}
