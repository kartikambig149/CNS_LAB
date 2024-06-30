import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5 {
    public static void main(String[] args) {
        String text = "Hello, world!";
        
        try {
            // Create MessageDigest instance for MD5
            MessageDigest md = MessageDigest.getInstance("MD5");
            
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
            System.out.println("MD5 Hash: " + hexStringBuilder.toString());
        } catch (NoSuchAlgorithmException e) {
            System.err.println("MD5 algorithm not found.");
            e.printStackTrace();
        }
    }
}

