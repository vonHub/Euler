#include <stdio.h>
#include <math.h>

int easy()
{
    int prod = pow(2, 4);
    prod = prod * pow(3, 2);
    prod = prod * 5 * 7 * 11 * 13 * 17 * 19;
    printf("%d\n", prod);
    return 0;
}

int hard()
{
    int prod = 1;

    int num = 2;

    for(num = 2; num <= 20; num++) {
        int prime = 1;
        int primetest;
        for(primetest = 2; primetest < num; primetest++) {
            if(num % primetest == 0) {
                prime = 0;
                break;
            }
        }
        if(prime) {
            int mult = num;
            while(mult * num <= 20) {
                mult *= num;
            }
            prod *= mult;
        }
    }

    printf("%d\n", prod);
    return 0;
}

int main(int argc, char *argv[])
{
    hard();
    int num = 15;
    float n = (float)num;
    float p = pow(n, .5);
    printf("%f\n", p);
    return 0;
}
