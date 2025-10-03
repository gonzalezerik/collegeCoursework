#include <stdio.h>
#include <stdlib.h>
#include <limits.h>
#include <stdint.h>
void menuFunc(void);

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


int main(){

    menuFunc();
    return 0;
}




