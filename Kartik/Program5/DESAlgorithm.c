#include <stdio.h>
#include <string.h>
#include <openssl/des.h>

void encryptDES(const unsigned char *plaintext, const unsigned char *key, unsigned char *ciphertext) {
    DES_cblock keyEncrypt;
    DES_key_schedule keySchedule;
    
    // Generate key
    DES_set_key((DES_cblock *)key, &keySchedule);

    // Encrypt the plaintext
    DES_ecb_encrypt((DES_cblock *)plaintext, (DES_cblock *)ciphertext, &keySchedule, DES_ENCRYPT);
}

void decryptDES(const unsigned char *ciphertext, const unsigned char *key, unsigned char *plaintext) {
    DES_cblock keyEncrypt;
    DES_key_schedule keySchedule;
    
    // Generate key
    DES_set_key((DES_cblock *)key, &keySchedule);

    // Decrypt the ciphertext
    DES_ecb_encrypt((DES_cblock *)ciphertext, (DES_cblock *)plaintext, &keySchedule, DES_DECRYPT);
}

int main() {
    unsigned char key[] = "MySecretK"; // 8-byte key
    unsigned char plaintext[] = "Hello, world!";
    unsigned char ciphertext[sizeof(plaintext)];
    unsigned char decryptedtext[sizeof(plaintext)];

    // Encrypt the plaintext
    encryptDES(plaintext, key, ciphertext);
    printf("Encrypted text: ");
    for(int i=0; i<sizeof(ciphertext); i++) {
        printf("%02x", ciphertext[i]);
    }
    printf("\n");

    // Decrypt the ciphertext
    decryptDES(ciphertext, key, decryptedtext);
    printf("Decrypted text: %s\n", decryptedtext);

    return 0;
}

//EXCECUTION COMMANDS

//gcc -o DESAlgorithm DESAlgorithm.c -lssl -lcrypto
//sudo apt-get install libssl-dev
//sudo yum install openssl-devel
//gcc -o DESAlgorithm DESAlgorithm.c -lssl -lcrypto
//./DESAlgorithm

