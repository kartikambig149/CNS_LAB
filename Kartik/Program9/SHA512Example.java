import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class SHA512Example {
    public static void main(String[] args) {
        String text = "Hello, world!";
        
        try {
            // Create MessageDigest instance for SHA-512
            MessageDigest md = MessageDigest.getInstance("SHA-512");
            
            // Add the text bytes to the digest
            md.update(text.getBytes());
            
            // Get the hash bytes
            byte[] hashBytes = md.digest();
            
            // Convert hash bytes to hex format
            StringBuilder hexStringBuilder = new StringBuilder();
            for (byte b : hashBytes) {
                hexStringBuilder.append(String.format("%02x", b));
            }
            
            // Print the hash in hex format
            System.out.println("SHA-512 Hash: " + hexStringBuilder.toString());
        } catch (NoSuchAlgorithmException e) {
            System.err.println("SHA-512 algorithm not found.");
            e.printStackTrace();
        }
    }
}

