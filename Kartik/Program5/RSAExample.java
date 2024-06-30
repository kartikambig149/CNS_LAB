import java.math.BigInteger;
import java.security.SecureRandom;

public class RSAExample {
    private BigInteger privateKey;
    private BigInteger publicKey;
    private BigInteger modulus;

    // Generate RSA keys
    public RSAExample(int bitLength) {
        SecureRandom random = new SecureRandom();

        // Generate two large prime numbers
        BigInteger p = new BigInteger(bitLength / 2, 100, random);
        BigInteger q = new BigInteger(bitLength / 2, 100, random);

        // Calculate modulus
        modulus = p.multiply(q);

        // Calculate Euler's totient function
        BigInteger phi = (p.subtract(BigInteger.ONE)).multiply(q.subtract(BigInteger.ONE));

        // Choose public key
        publicKey = new BigInteger("65537"); // Common choice for public exponent

        // Calculate private key
        privateKey = publicKey.modInverse(phi);
    }

    // Encrypt message using public key
    public byte[] encrypt(byte[] message) {
        BigInteger msg = new BigInteger(message);
        return msg.modPow(publicKey, modulus).toByteArray();
    }

    // Decrypt message using private key
    public byte[] decrypt(byte[] encryptedMessage) {
        BigInteger encMsg = new BigInteger(encryptedMessage);
        return encMsg.modPow(privateKey, modulus).toByteArray();
    }

    public static void main(String[] args) {
        RSAExample rsa = new RSAExample(1024);

        // Encrypt and decrypt a message
        String plaintext = "Hello, world!";
        byte[] encryptedMessage = rsa.encrypt(plaintext.getBytes());
        byte[] decryptedMessage = rsa.decrypt(encryptedMessage);

        System.out.println("Original message: " + plaintext);
        System.out.println("Encrypted message: " + new String(encryptedMessage));
        System.out.println("Decrypted message: " + new String(decryptedMessage));
    }
}

