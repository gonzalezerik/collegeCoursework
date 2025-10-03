#include <stdio.h>
#include <stdlib.h>
#include <limits.h>
#include <stdint.h>
#include <stdbool.h>
#include <strings.h>

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


int clk = 0;

void menuFunc(void);
bool selFunc(int);
int getSel(void);
int verifySel(void);
int paramCheck(void);
void newLine(void);
void enterFun(int);
void printTable(int);
void display(int field, char *buf, size_t size);
void fifo(int);
void reset(int);
void initClk(int);
int scan(int,int);
int maxInt(int, int);
void sjf(int num);

void newLine(void){
    puts("");
}
void menuFunc(){
    const char *schProc = "Schedule processes:";
    char *arr[] = {"FIFO", "SJF", "SRT"};
    int size = sizeof(arr) / sizeof(arr[0]);

    puts("Batch scheduling");
    puts("----------------");
    puts("1) Enter parameters");
   for(int i = 0; i < size; i++){
       printf("%x) %s with %s algorithm\n",i+2,schProc,arr[i]);
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
            fifo(num);            
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
    
    for(int i = 0;i < num; i++){
        printf("Enter process id: ");
        scanf("%d", &table[i].id);
        
        printf("Enter arrival cycle for process P[%d]: ", table[i].id);
        scanf("%d", &table[i].arvl);
        
        printf("Enter total cycles for process P[%d]: ", table[i].id);
        scanf("%d", &table[i].totalCycles);
        
        
    }
    
    printTable(num);
  
}

void printTable(int num){
    printf("%-7s %-7s %-7s %-7s %-7s %-10s\n","ID", "Arrival", "Total", "Start", "End", "Turnaround");
    puts("--------------------------------------------------");
    for(int i = 0; i < num; i++){
        char bufStart[20], bufEnd[20], bufTurn[20];

        display(table[i].start, bufStart, sizeof(bufStart));
        display(table[i].end, bufEnd, sizeof(bufEnd));
        display(table[i].turnArnd, bufTurn, sizeof(bufTurn));

        printf("%-7d %-7d %-7d %-7s %-7s %-10s\n", table[i].id, table[i].arvl, table[i].totalCycles, bufStart, bufEnd, bufTurn);
        reset(num);
    }
    newLine();
}

// modified display: it fills a buffer you give it
void display(int field, char *buf, size_t size) {
    if (field == -1) {
        snprintf(buf, size, " ");       // blank if unset
    } else {
        snprintf(buf, size, "%d", field);
    }
}



void initClk(int num){
    clk = table[0].arvl;
    for (int i = 1; i < num; i++){
        if(table[i].arvl < clk){
            clk = table[i].arvl;
        }
    }
    }

void reset(int num){
    for(int i = 0; i < num; i++){
        table[i].done = 0;
        table[i].start = -1;
        table[i].end = -1;
        table[i].turnArnd = -1;
    }
    clk = 0;
}

int scan(int check, int val){
    if (val < check){
        check = val;
    }
       return check;
   }

void fifo(int num){
    reset(num);
    

    for(int i = 0; i < num; i++){ //goes through all three procsses, 
        while(table[i].done == 0){ 
            for (int j = 1; j < num; j++){ //for loop for checking, j = table[j].arvl assuming earliest    
                    table[i].start = scan(table[0+i].arvl, table[j].arvl);
        }
            table[i].start = maxInt(table[i].start, clk);
            table[i].end = (table[i].start + table[i].totalCycles);
            table[i].turnArnd = (table[i].end - table[i].arvl);
            clk = table[i].end;
            table[i].done = 1;
        }
    }
    printTable(num);
}

int maxInt(int arvl, int currClk){
    
    if (currClk < arvl){
        return arvl;
    }
    else if (currClk >= arvl){
        return currClk;
    }
    return currClk;
}

void sjf(int num){
    reset(num); //reset .done field
    
    for (int i = 0; i < num; i++){
        while(table[i].done == 0);{
            for(int j = 1; j < num; j++){
                table[i].start = scan(table[0+i].totalCycles, table[j].totalCycles);
            }
            


        }

    }

    
}

void srt(void){
    
}



int main(){
    do { 
        menuFunc();
    } while (selFunc(getSel()));
    return 0;
}




