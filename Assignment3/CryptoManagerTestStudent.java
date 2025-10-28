import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CryptoManagerTestStudent {

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testIsStringInBounds() {
		assertTrue(CryptoManager.isStringInBounds("COMPUTER SCIENCE CLASS 2025!"));
        assertFalse(CryptoManager.isStringInBounds("Computer Science Class 2025!"));
        assertFalse(CryptoManager.isStringInBounds("Computer Science Class @)@%"));
	}

	@Test
	void testVigenereEncryption() {
		String plain = "COMPUTER SCIENCE STUDENTS 101!";
        String key = "MAJOR";
        String correctEncrypted = "OOVDLFEA GTUEWQV ETDRVZTB 101!";
        String encrypted = CryptoManager.vigenereEncryption(plain, key);
        assertEquals(encrypted, correctEncrypted);
	}

	@Test
	void testVigenereDecryption() {
		String plain = "COMPUTER SCIENCE STUDENTS 101!";
		String key = "MAJOR";
		String encrypted = "OOVDLFEA GTUEWQV ETDRVZTB 101!";
		String decrypted = CryptoManager.vigenereDecryption(encrypted, key);
		assertEquals(decrypted, plain);
	}

	@Test
	void testPlayfairEncryption() {
		String plain = "MAIL IS NAI@MONTGOMERYCOLLEGE.EDU";
        String key = "OUTLOOK";
        String correctEncrypted = "ICGA!H2(VOF]DCQODLDFN1OUKKFHF-FEK7";
        String encrypted = CryptoManager.playfairEncryption(plain, key);
        assertEquals(encrypted, correctEncrypted);
	}

	@Test
	void testPlayfairDecryption() {
		String plain = "MAIL IS NAI@MONTGOMERYCOLLEGE.EDU";
		String key = "OUTLOOK";
		String encrypted = "ICGA!H2(VOF]DCQODLDFN1OUKKFHF-FEK7";
		String decrypted = CryptoManager.playfairDecryption(encrypted, key);
		assertEquals(decrypted, plain);
	}

	@Test
	void testCaesarEncryption() {
		String plain = "HEY, I FOUND A 4-LEAF CLOVER!";
        int key = 7;
        String correctEncrypted = "OLF, P MVBUK H 4-SLHM JSVCLY!";
        String encrypted = CryptoManager.caesarEncryption(plain, key);
        assertEquals(encrypted, correctEncrypted);
	}

	@Test
	void testCaesarDecryption() {
		String plain = "HEY, I FOUND A 4-LEAF CLOVER!";
		int key = 7;
		String encrypted = "OLF, P MVBUK H 4-SLHM JSVCLY!";
		String decrypted = CryptoManager.caesarDecryption(encrypted, key);
		assertEquals(decrypted, plain);
	}

}
