#include <stdio.h>

int inputCheck(int x, int y){
    
    switch(y){
        case 0 :
            printf("You entered an invalid value for the number of repitions!\n");
            printf("Enter the number of repitions for the punishment phrase again: ");
            scanf("%d", &x);
            return x;
            break;
        

        case 1:
            printf("You entered an invalid value for the typo placement\n");
            printf("Enter the repetition count when you wish to introduce a typo again: ");
            scanf("%d", &x);
            return x;
            break;
    }
        
}