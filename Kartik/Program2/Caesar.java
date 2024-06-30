public class CaesarCipher {
    public static String encrypt(String plaintext, int shift) {
        StringBuilder ciphertext = new StringBuilder();

        for (char c : plaintext.toCharArray()) {
            if (Character.isLetter(c)) {
                char base = Character.isLowerCase(c) ? 'a' : 'A';
                int offset = (c - base + shift) % 26;
                if (offset < 0) {
                    offset += 26;
                }
                ciphertext.append((char) (base + offset));
            } else {
                ciphertext.append(c);
            }
        }

        return ciphertext.toString();
    }

    public static String decrypt(String ciphertext, int shift) {
        return encrypt(ciphertext, -shift);
    }

    public static void main(String[] args) {
        String plaintext = "hello world";
        int shift = 3;

        // Encrypt the plaintext
        String encryptedText = encrypt(plaintext, shift);
        System.out.println("Encrypted text: " + encryptedText);

        // Decrypt the ciphertext
        String decryptedText = decrypt(encryptedText, shift);
        System.out.println("Decrypted text: " + decryptedText);
    }
}

