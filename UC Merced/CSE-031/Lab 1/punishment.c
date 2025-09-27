#include <stdio.h>
#include "punishment.h"

int main(){

    int rep, typo, tracker;
    printf("Enter the number of repetions for the punishment phrase: ");
    scanf("%d", &rep);
    tracker = 0;
    while (rep <= 0){
        rep = inputCheck(rep, tracker);
    }

    printf("\n");

    printf("Enter the repetition count when you wish to introduce a typo: ");
    scanf("%d", &typo);
    tracker = 1;
    while (typo <= 0 || typo > rep){
        typo = inputCheck(typo, tracker);
    }

    for(int i = 0; i < rep; i++){
        if ((i + 1) == typo){
            printf("C progranming languoge is the bezt!\n");
        } else
            printf("C programming language is the best!\n");
    }

    return 0; 
}