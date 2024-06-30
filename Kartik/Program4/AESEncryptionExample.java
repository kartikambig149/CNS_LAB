import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

public class AESEncryptionExample {

    public static void main(String[] args) throws Exception {
        String plaintext = "Hello, world!";
        String keyString = "MySecretKey"; // 16-byte key
        String initializationVector = "MyInitVector"; // 16-byte IV

        // Create AES key from the key string
        SecretKeySpec secretKeySpec = new SecretKeySpec(keyString.getBytes(), "AES");

        // Create Initialization Vector (IV)
        IvParameterSpec ivParameterSpec = new IvParameterSpec(initializationVector.getBytes());

        // Create Cipher instance and initialize it for encryption
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec, ivParameterSpec);

        // Encrypt the plaintext
        byte[] encryptedBytes = cipher.doFinal(plaintext.getBytes());

        // Convert encrypted byte array to Base64 for easier display
        String encryptedText = Base64.getEncoder().encodeToString(encryptedBytes);
        System.out.println("Encrypted text: " + encryptedText);

        // Initialize Cipher for decryption
        cipher.init(Cipher.DECRYPT_MODE, secretKeySpec, ivParameterSpec);

        // Decrypt the ciphertext
        byte[] decryptedBytes = cipher.doFinal(Base64.getDecoder().decode(encryptedText));
        String decryptedText = new String(decryptedBytes);
        System.out.println("Decrypted text: " + decryptedText);
    }
}

