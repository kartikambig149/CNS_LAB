import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;
import java.util.Scanner;

public class AESEncryptionExample {

    private static final String AES_KEY = "ThisIsASecretKey"; // 128 bit key

    public static void main(String[] args) {
        System.out.println("Enter The Text to Encrypt:");
        Scanner sc = new Scanner(System.in);
        String originalText = sc.nextLine();
        System.out.println("Original Text: " + originalText);

        try {
            byte[] encryptedText = encrypt(originalText);
            System.out.println("Encrypted Text: " + Base64.getEncoder().encodeToString(encryptedText));

            String decryptedText = decrypt(encryptedText);
            System.out.println("Decrypted Text: " + decryptedText);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static byte[] encrypt(String plainText) throws Exception {
        SecretKeySpec keySpec = new SecretKeySpec(AES_KEY.getBytes(), "AES");
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, keySpec);
        return cipher.doFinal(plainText.getBytes());
    }

    public static String decrypt(byte[] cipherText) throws Exception {
        SecretKeySpec keySpec = new SecretKeySpec(AES_KEY.getBytes(), "AES");
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.DECRYPT_MODE, keySpec);
        byte[] decryptedBytes = cipher.doFinal(cipherText);
        return new String(decryptedBytes);
    }
}

