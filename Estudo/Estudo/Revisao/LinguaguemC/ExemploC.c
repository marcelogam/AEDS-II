#include <stdio.h>
#include <stdlib.h>
#include <math.h>
#include <string.h>

int main()
{
int *x1;
int x2;
int *x3;
x1 = (int*) malloc(sizeof(int));
x3 = (int*) malloc(sizeof(int));
*x1 = 20;
x2 = *x1;
*x3 = x2 * *x1;
x3 = &x2;
x2 = 15;
/*************************************/
x2 = 13 & 3;
printf("X: %i \n", x2);

x2 = 13 | 3;
printf("X: %i \n", x2);

x2 = 13 >> 1;
printf("X: %i \n", x2);

x2 = 13 << 1;
printf("X: %i \n", x2);
}
