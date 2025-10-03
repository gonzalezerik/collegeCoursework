#include <stdio.h>
#include <stdlib.h>
#include <limits.h>
#include <stdint.h>
#include <stdbool.h>
int i;
void menuFunc(void);
bool selFunc(int);
int getSel(void);
int verifySel(void);
int paramCheck(void);
void newLine(void);
void enterFun(int);
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
   for(i = 0; i < size; i++){
       printf("%x) %s with %s algorithm\n",i+1,schProc,arr[i]);
    }
    puts("5) Quit and free memory\n");
}
bool selFunc(int vrfdSel){
    static int num;
    static bool init;
    switch(vrfdSel){
        case 1:
            init = true;
            printf("Enter total number of processes: ");
            scanf("%d", &num);
            enterFun(num);
            

            return true;
            break;
        case 2:
            paramCheck();
            puts("case2");
            
            return true;
            break;
        case 3:
            paramCheck();
            puts("case3");
            return true;
            break;
        case 4:
            paramCheck();
            puts("case4");
            return true;
            break;
        case 5: 
            puts("Quitting program . . . ");
            return false;
            break;
        default:
            puts("Invalid selection");
    }

}

int getSel(void){
    while(1){
        printf("Enter selection: ");
        return(verifySel());
    }
}
int verifySel(void){
    int sel;
    if(scanf("%d", &sel) == 1 && sel >= 1 && sel <= 5){
       return sel;
    }
}

int paramCheck(void){
    if (!table){
        puts("Pick 1 to enter parameters first");
        newLine();
    }
}

void enterFun(int num){
    table = malloc(num * sizeof(struct node));

    for(i = 0; i < num; i++){
        printf("Enter process id: ");
        scanf("%d", &table[i].id);
        
        printf("Enter arrival cycle for process P[%d]: ", table[i].id);
        scanf("%d", &table[i].arvl);
        
        printf("Enter total cycles for process P[%d]: ", table[i].id);
        scanf("%d", &table[i].totalCycles);
        
    }
  
}

void fifo(void){

}

void sjf(void){

}

void srt(void){

}

int main(){
    do { 
        menuFunc();
    } while (selFunc(getSel()));
    return 0;
}




