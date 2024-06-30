import java.util.HashMap;
import java.util.Map;

public class SubstitutionCipher {
    private static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";

    public static String encrypt(String plaintext, String key) {
        plaintext = plaintext.toLowerCase();
        StringBuilder ciphertext = new StringBuilder();
        Map<Character, Character> encryptionMap = generateEncryptionMap(key);

        for (char c : plaintext.toCharArray()) {
            if (Character.isLetter(c)) {
                ciphertext.append(encryptionMap.getOrDefault(c, c));
            } else {
                ciphertext.append(c);
            }
        }

        return ciphertext.toString();
    }

    public static String decrypt(String ciphertext, String key) {
        ciphertext = ciphertext.toLowerCase();
        StringBuilder plaintext = new StringBuilder();
        Map<Character, Character> decryptionMap = generateDecryptionMap(key);

        for (char c : ciphertext.toCharArray()) {
            if (Character.isLetter(c)) {
                plaintext.append(decryptionMap.getOrDefault(c, c));
            } else {
                plaintext.append(c);
            }
        }

        return plaintext.toString();
    }

    private static Map<Character, Character> generateEncryptionMap(String key) {
        Map<Character, Character> encryptionMap = new HashMap<>();
        for (int i = 0; i < ALPHABET.length(); i++) {
            encryptionMap.put(ALPHABET.charAt(i), key.charAt(i));
        }
        return encryptionMap;
    }

    private static Map<Character, Character> generateDecryptionMap(String key) {
        Map<Character, Character> decryptionMap = new HashMap<>();
        for (int i = 0; i < ALPHABET.length(); i++) {
            decryptionMap.put(key.charAt(i), ALPHABET.charAt(i));
        }
        return decryptionMap;
    }

    public static void main(String[] args) {
        String key = "zyxwvutsrqponmlkjihgfedcba"; // Example key
        String plaintext = "hello world";
        
        // Encrypt the plaintext
        String encryptedText = encrypt(plaintext, key);
        System.out.println("Encrypted text: " + encryptedText);

        // Decrypt the ciphertext
        String decryptedText = decrypt(encryptedText, key);
        System.out.println("Decrypted text: " + decryptedText);
    }
}

