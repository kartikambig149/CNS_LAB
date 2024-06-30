#include<stdio.h>
#include<string.h>
void main () {
char str[] = "Hello World";
 
char str1[11] , str2[11],str3[11];
int i,len;
 
len = strlen(str) ;
printf("After appling AND operation corresponding Ascii and its values :\n  ");
for (i=0; i<len ; i++)
 
{
str1[i]=str[i]&127;
printf("%d=%c \n",str[i], str[i]);
 
}
 
printf("output string : %s", str1);
printf("\n");
printf("after applying XOR operation corresponding Ascii and its values");
for (int i = 0; i<len ; i++)
{
str2[i]= str[i]^127;
printf("%d = %c \n",str2[i],str2[i]);
}
printf("output string : %s ", str2);
printf("\n");
printf("after applying OR operation corresponding Ascii and its values");
for (int i = 0; i<len ; i++)
{
str3[i]= str[i]||127;
printf("%d = %c \n",str3[i],str[i]);
}
printf("output string : %s ", str3);
printf("\n");
}

//https://drive.google.com/drive/folders/15_pXUfMqmxKDpzIrUfDh09wQuE0snpfi?usp=drive_link


