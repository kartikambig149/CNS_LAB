#include <stdio.h>
#include <string.h>

// Function to encrypt plaintext using Vigenere Cipher
void vigenereEncrypt(char plaintext[], char key[]) {
    int len = strlen(plaintext);
    int keyLen = strlen(key);
    char encryptedText[len + 1];
    
    for (int i = 0; i < len; i++) {
        encryptedText[i] = ((plaintext[i] + key[i % keyLen]) % 26) + 'A';
    }
    encryptedText[len] = '\0';
    
    printf("Encrypted text (Vigenere Cipher): %s\n", encryptedText);
    
    // Decrypt the encrypted text
    char decryptedText[len + 1];
    for (int i = 0; i < len; i++) {
        decryptedText[i] = ((encryptedText[i] - key[i % keyLen] + 26) % 26) + 'A';
    }
    decryptedText[len] = '\0';
    
    printf("Decrypted text (Vigenere Cipher): %s\n", decryptedText);
}

int main() {
    char text[100], key[100];
    
    printf("Enter the plaintext: ");
    fgets(text, sizeof(text), stdin);
    printf("Enter the key for Vigenere Cipher: ");
    scanf("%s", key);
    
    // Remove newline character from text
    text[strcspn(text, "\n")] = '\0';
    
    vigenereEncrypt(text, key);
    
    return 0;
}

