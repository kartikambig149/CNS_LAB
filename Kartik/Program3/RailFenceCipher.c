#include <stdio.h>
#include <string.h>

// Function to encrypt plaintext using Rail Fence Cipher
void railFenceEncrypt(char plaintext[], int key) {
    int len = strlen(plaintext);
    char railMatrix[key][len];
    
    // Initialize rail matrix
    for (int i = 0; i < key; i++)
        for (int j = 0; j < len; j++)
            railMatrix[i][j] = '\0';
    
    // Fill the rail matrix
    int row = 0;
    int dir = 0; // 0 for down, 1 for up
    for (int i = 0; i < len; i++) {
        railMatrix[row][i] = plaintext[i];
        if (row == 0)
            dir = 0;
        else if (row == key - 1)
            dir = 1;
        if (dir == 0)
            row++;
        else
            row--;
    }
    
    // Read the rail matrix to get encrypted text
    printf("Encrypted text: ");
    for (int i = 0; i < key; i++)
        for (int j = 0; j < len; j++)
            if (railMatrix[i][j] != '\0')
                printf("%c", railMatrix[i][j]);
    printf("\n");

    // Now decrypt the encrypted text
    printf("Decrypted text: ");
    row = 0;
    dir = 0;
    for (int i = 0; i < len; i++) {
        printf("%c", railMatrix[row][i]);
        if (row == 0)
            dir = 0;
        else if (row == key - 1)
            dir = 1;
        if (dir == 0)
            row++;
        else
            row--;
    }
    printf("\n");
}

int main() {
    char text[100];
    int key;
    
    printf("Enter the plaintext: ");
    fgets(text, sizeof(text), stdin);
    printf("Enter the key (number of rails): ");
    scanf("%d", &key);
    
    
    // Remove newline character from text
    text[strcspn(text, "\n")] = '\0';
    
    railFenceEncrypt(text, key);
    
    return 0;
}

