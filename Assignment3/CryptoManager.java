/*
 * Class: CMSC203 
 * Instructor: Huseyin Aygun
 * Description: Allow three different methods of encryption and decryption of a message, which are through Vigenere, Playfair, and Caesar cipher.
 * Due: 10/13/25
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming assignment 
* independently. I have not copied the code from a student or   * any source. I have not given my code to any student.
 * Print your Name here: Natdanai Boonyaleephan
*/

/**
 * This is a utility class that encrypts and decrypts a phrase using three
 * different approaches. 
 * 
 * The first approach is called the Vigenere Cipher.Vigenere encryption 
 * is a method of encrypting alphabetic text based on the letters of a keyword.
 * 
 * The second approach is Playfair Cipher. It encrypts two letters (a digraph) 
 * at a time instead of just one.
 * 
 * The third approach is Caesar Cipher. It is a simple replacement cypher. 
 * 
 * @author Huseyin Aygun
 * @version 8/3/2025
 */

public class CryptoManager { 

    private static final char LOWER_RANGE = ' ';
    private static final char UPPER_RANGE = '_';
    private static final int RANGE = UPPER_RANGE - LOWER_RANGE + 1;
    // Use 64-character matrix (8X8) for Playfair cipher  
    private static final String ALPHABET64 = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789 !\"#$%&'()*+,-./:;<=>?@[\\]^_";

    public static boolean isStringInBounds(String plainText) {
        for (int i = 0; i < plainText.length(); i++) {
        	if (!(plainText.charAt(i) >= LOWER_RANGE && plainText.charAt(i) <= UPPER_RANGE)) {
        		return false;
            }
        }
        return true;
    }
    
    public static void main(String[] args) {
    	// Vigenere Encryption Tests
    	
    	// First Test
    	System.out.println("\nVigenere Encryption 1");
    	System.out.println("Plaintext: ATTACK AT DAWN");
    	System.out.println("Key: LEMON");
    	String vigenereEncryptedText = vigenereEncryption("ATTACK AT DAWN", "LEMON");
    	System.out.println("Encrypted Text: " + vigenereEncryptedText);
    	if (vigenereEncryptedText != null)
    		System.out.println("Decrypted Text: " + vigenereDecryption(vigenereEncryptedText, "LEMON"));
    	
    	// Second Test
    	System.out.println("\nVigenere Encryption 2");
    	System.out.println("Plaintext: WATCH YOUR SIX");
    	System.out.println("Key: BATTLEFIELD");
    	String vigenereEncryptedText2 = vigenereEncryption("WATCH YOUR SIX", "BATTLEFIELD");
    	System.out.println("Encrypted Text: " + vigenereEncryptedText2);
    	if (vigenereEncryptedText2 != null)
    		System.out.println("Decrypted Text: " + vigenereDecryption(vigenereEncryptedText2, "BATTLEFIELD"));
    	
    	// Caesar Encryption Tests
    	
    	// First Test
    	System.out.println("\nCaesar Encryption 1");
    	System.out.println("Plaintext: HELLO WORLD");
    	System.out.println("Key: 3");
    	String caesarEncryptedText = caesarEncryption("HELLO WORLD", 3);
    	System.out.println("Encrypted Text: " +caesarEncryptedText);
    	if (caesarEncryptedText != null)
    		System.out.println("Decrypted Text: " + caesarDecryption(caesarEncryptedText, 3));
    	
    	// Second Test
    	System.out.println("\nCaesar Encryption 2");
    	System.out.println("Plaintext: SCHOOL SUMMER BREAK");
    	System.out.println("Key: 7");
    	String caesarEncryptedText2 = caesarEncryption("SCHOOL SUMMER BREAK", 7);
    	System.out.println("Encrypted Text: " +caesarEncryptedText2);
    	if (caesarEncryptedText2 != null)
    		System.out.println("Decrypted Text: " + caesarDecryption(caesarEncryptedText2, 7));
    	
    	// Playfair Encryption Tests
    	
    	// First Test
    	System.out.println("\nPlayfair Encryption 1");
    	System.out.println("Plaintext: HIDE THE GOLD");
    	System.out.println("Key: MONARCHY");
    	String playfairEncryptedText = playfairEncryption("HIDE THE GOLD", "MONARCHY");
    	System.out.println("Encrypted Text: " + playfairEncryptedText);
    	if (playfairEncryptedText != null)
    		System.out.println("Decrypted Text: " + playfairDecryption(playfairEncryptedText, "MONARCHY"));
    	
    	// Second Test
    	System.out.println("\nPlayfair Encryption 2");
    	System.out.println("Plaintext: JACK O'S LANTERN");
    	System.out.println("Key: APPLE");
    	String playfairEncryptedText2 = playfairEncryption("JACK O'S LANTERN", "APPLE");
    	System.out.println("Encrypted Text: " + playfairEncryptedText2);
    	if (playfairEncryptedText2 != null)
    		System.out.println("Decrypted Text: " + playfairDecryption(playfairEncryptedText2, "APPLE"));
    
    	// Test Plans
    	
    	// First Test
		String plain1 = "MONTGOMERY COLLEGE EDUCATION 2025!";
		String key1 = "ROCKVILLE";
		System.out.println("\nTest Plan 1");
		System.out.println("Plaintext: " + plain1);
		System.out.println("Key: " + key1);
		
		String encrypted1 = CryptoManager.vigenereEncryption(plain1, key1);
		String decrypted1 = CryptoManager.vigenereDecryption(encrypted1, key1);
		System.out.println("Encrypted Text: " + encrypted1);
		System.out.println("Decrypted Text: " + decrypted1);
		System.out.println("Equals: " + plain1.equals(decrypted1));
		
		// Second Test
		String plain2 = "Montgomery College Education 2025!";
		int key2 = 15;
		System.out.println("\nTest Plan 2");
		System.out.println("Plaintext: " + plain2);
		System.out.println("Key: " + key2);
		
		String encrypted2 = CryptoManager.caesarEncryption(plain2, key2);
		String decrypted2 = CryptoManager.caesarDecryption(encrypted2, key2);
		System.out.println("Encrypted Text: " + encrypted2);
		System.out.println("Decrypted Text: " + decrypted2);
		System.out.println("Equals: " + plain2.equals(decrypted2));

		// Third Test
		String plain3 = "M0NTGOMERY C0LLEGE EDUCATION @)@%!";
		String key3 = "MARYLAND";
		System.out.println("\nTest Plan 3");
		System.out.println("Plaintext: " + plain3);
		System.out.println("Key: " + key3);
		
		String encrypted3 = CryptoManager.playfairEncryption(plain3, key3);
		String decrypted3 = CryptoManager.playfairDecryption(encrypted3, key3);
		System.out.println("Encrypted Text: " + encrypted3);
		System.out.println("Decrypted Text: " + decrypted3);
		System.out.println("Equals: " + plain3.equals(decrypted3));

		// Fourth Test
		String plain4 = "MoNtGoMeRy cOlLeGe eDuCaTiOn 1234!";
		String key4 = "GERMANTOWN";
		System.out.println("\nTest Plan 4");
		System.out.println("Plaintext: " + plain4);
		System.out.println("Key: " + key4);
		
		String encrypted4 = CryptoManager.playfairEncryption(plain4, key4);
		String decrypted4 = CryptoManager.playfairDecryption(encrypted4, key4);
		System.out.println("Encrypted Text: " + encrypted4);
		System.out.println("Decrypted Text: " + decrypted4);
		System.out.println("Equals: " + plain4.equals(decrypted4));
    }

	/**
	 * Vigenere Cipher is a method of encrypting alphabetic text 
	 * based on the letters of a keyword. It works as below:
	 * 		Choose a keyword (e.g., KEY).
	 * 		Repeat the keyword to match the length of the plaintext.
	 * 		Each letter in the plaintext is shifted by the position of the 
	 * 		corresponding letter in the keyword (A = 0, B = 1, ..., Z = 25).
	 */   

    public static String vigenereEncryption(String plainText, String key) {
        // Initialize variables for encryption.
    	String result = "";
    	String fullKey = "";
    	int count = 0, keyCount = 0;

    	// Check if strings is within ASCII values. Method return null if false.
    	if (!isStringInBounds(plainText)) {
    		System.out.println("The selected string is not in bounds, Try again.");
    		return null;
    	}
    	
    	key = key.toUpperCase();
    	// Create full key for encryption 
    	// For example - plainText: "HELLO WORLD" with key: "KEY" will result "KEYKE YKEYK" as the full key.
    	while (fullKey.length() != plainText.length()) {
    		if (plainText.charAt(count) == ' ') 
    			// Avoid putting key at empty space.
    			fullKey += ' ';
    		else 
    			// Repeat for full key.
    			fullKey += (char)(key.charAt(keyCount++ % key.length()));
    		count++;
    	}
    	
    	// Encryption process.
    	for (int i=0; i<plainText.length(); i++) {
    		// Skip and add space to result if empty space.
    		if (plainText.charAt(i) == ' ') {
    			result += ' ';
    			continue;
    		} 
    			
    		// Set plainText value to the placing of character in alphabets by indexing character in ALPHABET64.
    		int p = ALPHABET64.indexOf(plainText.charAt(i));
    		// Same goes for key value.
    		int k = ALPHABET64.indexOf(fullKey.charAt(i));
 
    		// Encrypting through the use of formula.
    		// Formula: Add plainText value by key value, then modulus to get value within ALPHABET64.
    		if (p < 36)
    			result += ALPHABET64.charAt((p+k) % 36);
    		else
    			result += plainText.charAt(i);
    	}
    	
    	// Return encrypted text.
    	return result;
    }

    // Vigenere Decryption
    public static String vigenereDecryption(String encryptedText, String key) {
    	if (encryptedText == null)
    		return null;
    	
    	// Initialize variables for decryption.
    	String result = "";
    	String fullKey = "";
    	int count = 0, keyCount = 0;
    	
    	key = key.toUpperCase();
    	// Create full key for decryption 
    	// For example - plainText: "HELLO WORLD" with key: "KEY" will result "KEYKE YKEYK" as the full key.
    	while (fullKey.length() != encryptedText.length()) {
    		if (encryptedText.charAt(count) == ' ') 
    			// Avoid putting key at empty space.
    			fullKey += ' ';
    		else 
    			// Repeat for full key.
    			fullKey += (char)(key.charAt(keyCount++ % key.length()));
    		count++;
    	}
    	
    	// Decryption process.
    	for (int i=0; i<encryptedText.length(); i++) {
    		// Skip and add space to result if empty space.
    		if (encryptedText.charAt(i) == ' ') {
    			result += ' ';
    			continue;
    		} 
    			
    		// Set encrypted value to the placing of character in alphabets by indexing character in ALPHABET64.
    		int e = ALPHABET64.indexOf(encryptedText.charAt(i));
    		// Same goes for key value.
    		int k = ALPHABET64.indexOf(fullKey.charAt(i));
 
    		// Decrypting through the use of formula.
    		// Formula: Subtract encrypted value by key value, then add 36 to prevent minus value, then modulus to get value within ALPHABET64.
    		if (e < 36)
    			result += ALPHABET64.charAt((e-k+36) % 36);
    		else
    			result += encryptedText.charAt(i);
    	}
    	
    	// Return decrypted text.
    	return result;
    }


	/**
	 * Playfair Cipher encrypts two letters at a time instead of just one.
	 * It works as follows:
	 * A matrix (8X8 in our case) is built using a keyword
	 * Plaintext is split into letter pairs (e.g., ME ET YO UR).
	 * Encryption rules depend on the positions of the letters in the matrix:
	 *     Same row: replace each letter with the one to its right.
	 *     Same column: replace each with the one below.
	 *     Rectangle: replace each letter with the one in its own row but in the column of the other letter in the pair.
	 */    

    public static String playfairEncryption(String plainText, String key) {
    	// Initialize variables for encryption.
    	final int SIZE = 8;
    	String playfairCipher = "";
    	String result = "";

    	// Check if strings is within ASCII values. Method return null if false.
    	if (!isStringInBounds(plainText)) {
    		System.out.println("The selected string is not in bounds, Try again.");
    		return null;
    	}
    	
    	key = key.toUpperCase();
    	// Setting up playfair cipher matrix.
    	// Adding key into the playfair Cipher first.
        for (int i = 0; i < key.length(); i++) {
            char c = key.charAt(i);
            if (ALPHABET64.indexOf(c) >= 0 && playfairCipher.indexOf(c) == -1)
            	playfairCipher += c;
        }
        // Then fill in playfair Cipher with all other value in ALPHABET64 .
        for (int i = 0; i < ALPHABET64.length(); i++) {
            char c = ALPHABET64.charAt(i);
            if (playfairCipher.indexOf(c) == -1)
            	playfairCipher += c;
        }
    	
        // Splitting plainText into paired texts and encryption process.
        int count2 = 0;
        while (count2 < plainText.length()) {
        	// Get first character of each two letters every count.
            char a = plainText.charAt(count2);
            // Get second character of each two letters every count. Return empty space if reached the end of text.
            char b = ' ';
            if (count2 + 1 < plainText.length())
                b = plainText.charAt(count2 + 1);

            // Encryption part.
            int indexA = playfairCipher.indexOf(a);
            int indexB = playfairCipher.indexOf(b);
            
            // Get row and column based on where letter is indexed in playfairCipher (think it as 8x8 matrix).
            int rowA = indexA / SIZE, colA = indexA % SIZE;
            int rowB = indexB / SIZE, colB = indexB % SIZE;

            // Initialize characters for getting encrypted characters.
            char encA, encB;
            if (rowA == rowB) { // same row -> shift right 
                encA = playfairCipher.charAt(rowA * SIZE + (colA + 1) % SIZE);
                encB = playfairCipher.charAt(rowB * SIZE + (colB + 1) % SIZE);
            } else if (colA == colB) { // same column -> shift down
                encA = playfairCipher.charAt(((rowA + 1) % SIZE) * SIZE + colA);
                encB = playfairCipher.charAt(((rowB + 1) % SIZE) * SIZE + colB);
            } else { // rectangle -> swap columns
                encA = playfairCipher.charAt(rowA * SIZE + colB);
                encB = playfairCipher.charAt(rowB * SIZE + colA);
            }
            
            // Add encrypted characters into the final result.
            result += "" + encA + encB;
            count2 += 2;
        }
    	
        // Return encrypted text.
    	return result;
    }

    // Playfair Decryption
    public static String playfairDecryption(String encryptedText, String key) {
    	if (encryptedText == null)
    		return null;
    	
    	// Initialize variables for encryption.
    	final int SIZE = 8;
    	String playfairCipher = "";
    	String result = "";
    	
    	key = key.toUpperCase();
    	// Setting up playfair cipher matrix.
        for (int i = 0; i < key.length(); i++) {
            char c = key.charAt(i);
            if (ALPHABET64.indexOf(c) >= 0 && playfairCipher.indexOf(c) == -1) {
            	playfairCipher += c;
            }
        }
        for (int i = 0; i < ALPHABET64.length(); i++) {
            char c = ALPHABET64.charAt(i);
            if (playfairCipher.indexOf(c) == -1) {
            	playfairCipher += c;
            }
        }
        
        // Decryption process.
        int count = 0;
        while (count < encryptedText.length()) {
        	// Get first letter of the pair in encrypted text.
            char a = encryptedText.charAt(count);
            // Get second letter of the pair in encrypted text. Return empty space character if none found.
            char b = (count + 1 < encryptedText.length()) ? encryptedText.charAt(count + 1) : ' ';
            
            // Encryption part.
            int indexA = playfairCipher.indexOf(a);
            int indexB = playfairCipher.indexOf(b);
            
            // Get row and column based on where letter is indexed in playfairCipher (think it as 8x8 matrix).
            int rowA = indexA / SIZE, colA = indexA % SIZE;
            int rowB = indexB / SIZE, colB = indexB % SIZE;

            // Initialize characters for getting decrypted characters.
            char decA, decB;
            if (rowA == rowB) { // Same row -> shift left
                decA = playfairCipher.charAt(rowA * SIZE + (colA + SIZE - 1) % SIZE);
                decB = playfairCipher.charAt(rowB * SIZE + (colB + SIZE - 1) % SIZE);
            } else if (colA == colB) { // Same column -> shift up
                decA = playfairCipher.charAt(((rowA + SIZE - 1) % SIZE) * SIZE + colA);
                decB = playfairCipher.charAt(((rowB + SIZE - 1) % SIZE) * SIZE + colB);
            } else { // Rectangle -> swap columns
                decA = playfairCipher.charAt(rowA * SIZE + colB);
                decB = playfairCipher.charAt(rowB * SIZE + colA);
            }
            
            // Add decrypted characters into final result.
            // At last iteration, check if the last character is an empty space. If it is, then remove it.
            if (count+2 == encryptedText.length() && decB == ' ')
            	result += "" + decA;
            else
            	result += "" + decA + decB;
            count += 2;
        }
        
        // Return decrypted text.
    	return result;
    }

    /**
     * Caesar Cipher is a simple substitution cipher that replaces each letter in a message 
     * with a letter some fixed number of positions down the alphabet. 
     * For example, with a shift of 3, 'A' would become 'D', 'B' would become 'E', and so on.
     */    
 
    public static String caesarEncryption(String plainText, int key) {
    	// Initialize variables for encryption.
    	String result = "";

    	// Check if strings is within ASCII values. Method return null if false.
    	if (!isStringInBounds(plainText)) {
    		System.out.println("The selected string is not in bounds, Try again.");
    		return null;
    	}
    	
    	// Encryption process.
    	for (int i=0; i<plainText.length(); i++) {
    		// Skip and add space to result if empty space.
    		if (plainText.charAt(i) == ' ') {
    			result += ' ';
    			continue;
    		}
    			
    		// Set encrypted value to the placing of character in alphabets by subtracting the character by 'A'.
    		int p = plainText.charAt(i) - 'A';
 
    		// Formula: Add encrypted value by key value, then add it by alphabet total letters to prevent minus value, then modulus to get value within alphabet letters, then add 'A' to get to ASCII value.
    		result += (char)((p+key+26) % 26 + 'A');
    	}
    	
    	// Return encrypted text.
    	return result;
    }

    // Caesar Decryption
    public static String caesarDecryption(String encryptedText, int key) {
    	if (encryptedText == null)
    		return null;
    	
    	// Initialize variables for decryption.
    	String result = "";

    	// Decryption process.
    	for (int i=0; i<encryptedText.length(); i++) {
    		// Skip and add space to result if empty space.
    		if (encryptedText.charAt(i) == ' ') {
    			result += ' ';
    			continue;
    		}
    			
    		// Set encrypted value to the placing of character in alphabets by subtracting the character by 'A'.
    		int p = encryptedText.charAt(i) - 'A';
 
    		// Formula: Subtract encrypted value by key value, then add it by alphabet total letters to prevent minus value, then modulus to get value within alphabet letters, then add 'A' to get to ASCII value.
    		result += (char)((p-key+26) % 26 + 'A');
    	}
    	
    	// Return decrypted text.
    	return result;
    }    

}
