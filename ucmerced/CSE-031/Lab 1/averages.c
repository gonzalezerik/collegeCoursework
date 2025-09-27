#include <stdio.h>

int main(){
    int input = 1, evenC = 0, oddC = 0;
    float avg_even = 0, avg_odd = 0;

    while (input != 0){
        printf("Please enter an integer: ");
        scanf("%d", &input);
        if (input == 0){
            break;
        }

        if (input % 2 == 0){
            avg_even += input;
            evenC++;
        }
        else{
            oddC++;
            avg_odd += input;
        }
    }

    avg_even = avg_even / evenC;
    avg_odd = avg_odd / oddC;

    printf("\n");
    if (evenC > 0 ){
        printf("Average of even numbers: %.2f\n", avg_even);
    }
    if (oddC > 0) {
        printf("Average of odd numbers: %.2f\n", avg_odd);
    }
    if (evenC == 0 && oddC == 0){
        printf("There is no average.\n");
    }


    return 0;
}