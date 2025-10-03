#include <stdio.h>
#include <stdlib.h>
#include <limits.h>
#include <stdint.h>
#include <stdbool.h>
int sel;

bool init = false;

void menuFunc(void);
void selFunc(int sel);
int getSel(void);
int verifySel(void);
int paramCheck(void);
void newLine(void);
struct node {

    int id;
    int arvl;
    int totalCycles;
    int totalRem;
    int done;
    int start;
    int alrS;
    int end;
    int turnArnd;
} *table = NULL;
void newLine(void){
    puts("");
}
void menuFunc(){
    const char *schProc = "Schedule processes:";
    char *arr[] = {"FIFO", "SJF", "SRT"};
    int size = sizeof(arr) / sizeof(arr[0]);
    puts("Batch scheduling");
    puts("----------------");
   for(int i = 0; i < size; i++){
       printf("%x) %s with %s algorithm\n",i+1,schProc,arr[i]);
    }
    puts("5) Quit and free memory\n");
}
void selFunc(int sel){
    switch(sel){
        case 1:
            puts("case1");
            init = true;
            break;
        case 2:
            paramCheck();
            puts("case2");
            break;
        case 3:
            paramCheck();
            puts("case3");
            break;
        case 4:
            paramCheck();
            puts("case4");
            break;
        case 5: 
            puts("Quitting program . . . ");
            break;
        default:
            puts("Invalid selection");
    }

}

int getSel(void){
    while(1){
        menuFunc();
        printf("Enter selection: ");
        return(verifySel());
    }
}
int verifySel(void){
    if(scanf("%d", &sel) == 1 && sel >= 1 && sel <= 5){
       return sel;
    }
}

int paramCheck(void){
    if (!init){
        puts("Pick 1 to enter parameters first");
        newLine();
    }
}


int main(){
    do { 
        selFunc(getSel());
    } while (sel != 5);

        return 0;
}




