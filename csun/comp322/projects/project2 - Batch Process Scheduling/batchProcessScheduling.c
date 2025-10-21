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

struct Best {
    int index;
    int value;
};

struct Pass {
    bool fifo;
    bool sjf;
    bool srt;
    bool arvl;
};


int clk = 0;
static int num;

void menuFunc(void);
bool selFunc(int);
int getSel(void);
int verifySel(void);
int paramCheck(void);
void newLine(void);
bool enterFun(void);
bool printTable(void);
void display(int field, char *buf, size_t size);
void fifo(struct Best comp);
void reset(void);
void initClk(int);
struct Best scan(int flag);
int maxInt(int, int);
void sjf(struct Best comp);
void srt(struct Best comp);
struct Best compare(struct Best best, int flag, int i);
bool isEligible(int flag, int i, int bstVal);
int idleJump(void);
void newLine(void){
    puts("");
}
void menuFunc(void){
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
    static bool init;
    switch(vrfdSel){
        case 1:
            init = true;
            printf("Enter total number of processes: ");
            scanf("%d", &num);
            return enterFun();
            break;
        case 2: 
            paramCheck();
            reset();

            for(int i = 0; i < num; i++){
                struct Best best = scan(2);
                fifo(best);
            }
            return printTable();
            break;
        case 3:
            paramCheck();
            reset();
            for (int i = 0; i < num; i++){
                struct Best best = scan(3); 
                sjf(best);
            }
            return printTable();
            break;
        case 4:
            puts("-------SRT-------");
            paramCheck();
            reset();
            for (int i = 0; i < num; i++){
                struct Best best = scan(4);
                srt(best);
            } 
            return printTable();
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

bool enterFun(void){
    table = malloc(num * sizeof(struct node));
    
    for(int i = 0;i < num; i++){
        printf("Enter process id: ");
        scanf("%d", &table[i].id);
        
        printf("Enter arrival cycle for process P[%d]: ", table[i].id);
        scanf("%d", &table[i].arvl);
        
        printf("Enter total cycles for process P[%d]: ", table[i].id);
        scanf("%d", &table[i].totalCycles);
        table[i].totalRem = table[i].totalCycles; //init for SRT
    }
    reset(); 
    printTable();
    return true;
}

bool printTable(void){
    printf("%-7s %-7s %-7s %-7s %-7s %-10s\n","ID", "Arrival", "Total", "Start", "End", "Turnaround");
    puts("--------------------------------------------------");
    for(int i = 0; i < num; i++){
        char bufStart[20], bufEnd[20], bufTurn[20];

        display(table[i].start, bufStart, sizeof(bufStart));
        display(table[i].end, bufEnd, sizeof(bufEnd));
        display(table[i].turnArnd, bufTurn, sizeof(bufTurn));

        printf("%-7d %-7d %-7d %-7s %-7s %-10s\n", table[i].id, table[i].arvl, table[i].totalCycles, bufStart, bufEnd, bufTurn);
        
    }
    newLine();
    return true;
}

// modified display: it fills a buffer you give it
void display(int field, char *buf, size_t size) {
    if (field == -1) {
        snprintf(buf, size, " ");       // blank if unset
    } else {
        snprintf(buf, size, "%d", field);
    }
} 

void reset(){
    for(int i = 0; i < num; i++){
        table[i].done = 0;
        table[i].start = -1;
        table[i].end = -1;
        table[i].turnArnd = -1;
        
    }
    clk = 0;
}

struct Best scan(int flag){
    int i = 0;
    struct Best best = {.index = -1, .value = INT_MAX};
    do {
        switch(flag){
            case 2:
                if(isEligible(2,i)){
                    best = compare(best, flag, i);
                }
                break;
            case 3: 
                if(isEligible(3,i)){
                    best = compare(best, flag, i);
                } 
                break;
            case 4:
                if(isEligible(4,i)){
                    best = compare(best, flag, i);
                }                    
                break;
            }
        i++;
        }while(i < num); 
    return best;
}


struct Best compare(struct Best best, int flag, int i){
    int value;
    switch(flag){
        case 2:
            value = table[i].arvl;
            break;
        case 3:
            value = table[i].totalCycles;
            break;
        case 4:
            value = table[i].totalRem;    
            break;
    }
    if (value < best.value){
        best.value = value;
        best.index = i;
        } else if (value == best.value) {
        if (table[i].arvl < table[best.index].arvl){
            best.index = i;
            best.value = value;
        }
    }
    return best;
}
void fifo(struct Best comp){ 
        table[comp.index].start = maxInt(table[comp.index].arvl,clk);
        table[comp.index].end = table[comp.index].start + table[comp.index].totalCycles;
        table[comp.index].turnArnd = table[comp.index].end - table[comp.index].arvl;
        clk = table[comp.index].end; 
        table[comp.index].done = 1;
}

bool isEligible(int flag, int i, int bstVal){
    struct Pass pass;
    switch(flag){
        case 2:
            if (table[i].done == 0){
                pass.fifo = true;
            } else { pass.fifo = false;}
            return pass.fifo;
            break;
        case 3:
            if(table[i].done == 0 && table[i].arvl <= clk){
                pass.sjf = true;
            } else {pass.sjf = false;}
            return pass.sjf;
            break;
        case 4:
            if(table[i].done == 0 && table[i].arvl <= clk && table[i].totalRem > 0){
                pass.srt = true;
            } else { pass.srt = false;}
            return pass.srt;
            break;
        case 5: 
            if(table[i].done == 0){
                pass.arvl = true;
            }else { pass.arvl = false;}
            return pass.arvl;
            break;
        }
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



void sjf(struct Best comp){
    table[comp.index].start = clk;
    table[comp.index].end = table[comp.index].start + table[comp.index].totalCycles;
    table[comp.index].turnArnd = table[comp.index].end - table[comp.index].arvl;
    clk = table[comp.index].end; 
    table[comp.index].done = 1;  
}

int idleJump(struct Best best){
    return table[best.index].arvl;
}

void srt(struct Best best){
    if(best.index == -1){
        if(isEligible(2,best.value)){
            clk = idleJump();
        }
        if(table[best.index].start == -1){
            table[best.index].start = clk;
        }

        /*
    else if(table[best.index].start == -1){ 
        table[best.index].start = clk;
    } else {
        clk += 1;
        table[best.index].totalRem -= 1;
        if(table[best.index].totalRem == 0){
            table[best.index].end = clk;
            table[best.index].turnArnd = table[best.index].end - table[best.index].arvl;
            table[best.index].done = 1; */
        }
    }
}
void initSRT(){
    reset();

}



int main(){
    do { 
        menuFunc();
    } while (selFunc(getSel()));
    return 0;
}




