#include <stdio.h>
#include <stdlib.h>

/* Define structures and global variables*/


int main() {
	/* declare local vars */
	/* while user has not chosen to quit */
		/* print menu of options */
		/* prompt for menu selection */
		/* call appropriate procedure based on choice--use switch statement or series of if, else if, else statements */	
	 /* while loop */

    int choice;

    printf("Process creation and desctruction\n");
    printf("----------------------------------\n");
    printf("1) Enter parameters\n");
    printf("2) Create a new child process\n");
    printf("3) Destroy all descendants of a process\n");
    printf("4) Quit program and free memory\n");
    printf("\nEnter selection: ");
    scanf("%d",&choice);

    
    switch (choice) {

        case 1:
            printf("case 1");
            break;
        case 2:
            printf("case 2");
            break;
        case 3:
            printf("case 3");
            break;
        case 4:
            printf("case 4");
            break;
    }




	 return 1; /* indicates success */
} /* end of procedure */
