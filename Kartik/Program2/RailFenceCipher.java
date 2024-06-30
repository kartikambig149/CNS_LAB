import java.util.*;

public class RailFenceCipher {
    public static String encrypt(String plaintext, int rails) {
        StringBuilder ciphertext = new StringBuilder();

        // Create the rail fence pattern
        String[] fence = new String[rails];
        for (int i = 0; i < rails; i++) {
            fence[i] = "";
        }

        int rail = 0;
        boolean down = true;
        for (char c : plaintext.toCharArray()) {
            fence[rail] += c;
            if (rail == 0) {
                down = true;
            } else if (rail == rails - 1) {
                down = false;
            }
            rail += down ? 1 : -1;
        }

        // Concatenate the fence rows to form the ciphertext
        for (String railString : fence) {
            ciphertext.append(railString);
        }

        return ciphertext.toString();
    }

    public static String decrypt(String ciphertext, int rails) {
        StringBuilder plaintext = new StringBuilder();

        // Create the rail fence pattern
        String[] fence = new String[rails];
        for (int i = 0; i < rails; i++) {
            fence[i] = "";
        }

        int[] railLengths = new int[rails];
        int rail = 0;
        boolean down = true;
        for (int i = 0; i < ciphertext.length(); i++) {
            railLengths[rail]++;
            if (rail == 0) {
                down = true;
            } else if (rail == rails - 1) {
                down = false;
            }
            rail += down ? 1 : -1;
        }

        // Fill the rail fence with the ciphertext
        int index = 0;
        for (int i = 0; i < rails; i++) {
            for (int j = 0; j < railLengths[i]; j++) {
                fence[i] += ciphertext.charAt(index++);
            }
        }

        // Read the plaintext from the rail fence
        rail = 0;
        down = true;
        for (int i = 0; i < ciphertext.length(); i++) {
            plaintext.append(fence[rail].charAt(0));
            fence[rail] = fence[rail].substring(1);
            if (rail == 0) {
                down = true;
            } else if (rail == rails - 1) {
                down = false;
            }
            rail += down ? 1 : -1;
        }

        return plaintext.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the PlainText to encrypt:_ ");
        String plaintext = sc.nextLine();
        System.out.println("Enter the Rail value:");
        int rails = sc.nextInt();

        // Encrypt the plaintext
        String encryptedText = encrypt(plaintext, rails);
        System.out.println("Encrypted text: " + encryptedText);

        // Decrypt the ciphertext
        String decryptedText = decrypt(encryptedText, rails);
        System.out.println("Decrypted text: " + decryptedText);
    }
}

