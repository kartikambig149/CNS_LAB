#include <stdio.h>
#include <string.h>
#include <openssl/aes.h>

int main() {
    unsigned char key[] = "MySecretKey"; // 16-byte key
    unsigned char iv[] = "MyInitVector"; // 16-byte IV
    unsigned char plaintext[] = "Hello, world!";
    unsigned char ciphertext[sizeof(plaintext)];
    unsigned char decryptedtext[sizeof(plaintext)];

    // Create AES key and IV
    AES_KEY aesKey;
    AES_set_encrypt_key(key, 128, &aesKey);

    // Encrypt the plaintext
    AES_cbc_encrypt(plaintext, ciphertext, sizeof(plaintext), &aesKey, iv, AES_ENCRYPT);
    printf("Encrypted text: ");
    for(int i=0; i<sizeof(ciphertext); i++) {
        printf("%02x", ciphertext[i]);
    }
    printf("\n");

    // Decrypt the ciphertext
    AES_set_decrypt_key(key, 128, &aesKey);
    AES_cbc_encrypt(ciphertext, decryptedtext, sizeof(ciphertext), &aesKey, iv, AES_DECRYPT);
    printf("Decrypted text: %s\n", decryptedtext);

    return 0;
}
//gcc -o aes_example aes_example.c -lssl -lcrypto

