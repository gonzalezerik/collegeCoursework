#include <stdio.h>
#include <stdlib.h>

void menuFunc(void);
void getSel(void);          // or: int getSel(void);  (see note below)
void choiceFunc(int choice);
void firstProc(void);
void secondProc(void);
void thirdProc(void);
void fourthProc(void);



void choiceFunc(int choice){
switch (choice) {

        case 1:
            firstProc();
            break;
        case 2:
            secondProc();
            break;
        case 3:
            thirdProc();
            break;
        case 4:
            fourthProc();
            break;
    }

}

void getSel(){
    int sel;
    printf("Enter selection: ");
    scanf("%d", &sel);
    choiceFunc(sel);
}

void menuFunc(){

    printf("Process creation and desctruction\n");
    printf("----------------------------------\n");
    printf("1) Enter parameters\n");
    printf("2) Create a new child process\n");
    printf("3) Destroy all descendants of a process\n");
    printf("4) Quit program and free memory\n");
    getSel();
}
/* Define structures and global variables*/
void firstProc(){
    printf("first procedure\n");
    menuFunc();

    
}
void secondProc(){
    printf("second procedure");
    menuFunc();
    
}

void thirdProc(){
    printf("third procedure");
    menuFunc();
}

void fourthProc(){
    printf("fourth procedure");
    menuFunc();
}




int main() {


    menuFunc();    
	return 1; 
} 
