import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import java.util.Base64;

public class DESEncryptionExample {

    public static void main(String[] args) throws Exception {
        String plaintext = "Hello, world!";
        String keyString = "MySecretKey"; // You can change the key as needed

        // Create DES key from the key string
        DESKeySpec desKeySpec = new DESKeySpec(keyString.getBytes());
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
        SecretKey secretKey = keyFactory.generateSecret(desKeySpec);

        // Create Cipher instance and initialize it for encryption
        Cipher cipher = Cipher.getInstance("DES/ECB/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);

        // Encrypt the plaintext
        byte[] encryptedBytes = cipher.doFinal(plaintext.getBytes());

        // Convert encrypted byte array to Base64 for easier display
        String encryptedText = Base64.getEncoder().encodeToString(encryptedBytes);
        System.out.println("Encrypted text: " + encryptedText);

        // Initialize Cipher for decryption
        cipher.init(Cipher.DECRYPT_MODE, secretKey);

        // Decrypt the ciphertext
        byte[] decryptedBytes = cipher.doFinal(Base64.getDecoder().decode(encryptedText));
        String decryptedText = new String(decryptedBytes);
        System.out.println("Decrypted text: " + decryptedText);
    }
}

