import java.math.BigInteger;
import java.security.SecureRandom;
public class practise {
    private BigInteger publickey;
    private BigInteger privatekey;
    private BigInteger modulus;

    public practise(int bitLength){
        SecureRandom random=new SecureRandom();
        BigInteger p=new BigInteger(bitLength/2, 100,random);
        BigInteger q=new BigInteger(bitLength/2, 100,random);
        modulus=p.multiply(q);
        BigInteger phi=(p.subtract(BigInteger.ONE).multiply(q.subtract(BigInteger.ONE)));

        publickey = new BigInteger("65537");
        privatekey = publickey.modInverse(phi);

    }
    public byte[] encrypt(byte[] message){
        BigInteger msg=new BigInteger(message);
        return msg.modPow(publickey,modulus).toByteArray();
    }
    public byte[] decrypt(byte[] enmessage){
        BigInteger enmsg=new BigInteger(enmessage);
        return enmsg.modPow(privatekey,modulus).toByteArray();
    }
    public static void main(String[] args){
        practise rsa=new practise(1024);
        String plaintext="hello world";
        byte[] encrypted=rsa.encrypt(plaintext.getBytes());
        byte[] decrypted=rsa.decrypt(encrypted);
        System.out.println("Encrypted Text="+ new String(encrypted));
        System.out.println("decrypted text"+ new String(decrypted));

    }
    
}
