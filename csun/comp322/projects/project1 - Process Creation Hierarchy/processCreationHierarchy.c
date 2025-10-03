#include <stdio.h>
#include <stdlib.h>

typedef struct child{
    int childIndex;
    struct child* next;
} child;

typedef struct pcb {
    int parent;
    child* children;
    int isFree;
} pcb;

void menuFunc(void);
int  getSel(void);
void selFunc(int sel, pcb **arr, int *pmax);
int  maxProc(void);
pcb* initArr(int max);
void create(pcb *arr, int max);
void freeMem(pcb *arr, int max);
void destroyDesc(pcb *arr, int max);
void destroySubTree(pcb *arr, int max, int p);
void printParentChildren(pcb *arr, int max);

void menuFunc(void){
    puts("\nProcess creation and destruction");
    puts("-----------------------------------");
    puts("1) Enter parameters");
    puts("2) Create a new child process");
    puts("3) Destroy all descendants of a process");
    puts("4) Quit program and free memory\n");
}

int getSel(void){
    int sel;
    menuFunc();
    printf("Enter selection: ");
    if (scanf("%d", &sel) != 1) return 4;
    if (sel < 1 || sel > 4) return 4;
    return sel;
}

int maxProc(void){
    int max;
    printf("Enter the maximum number of processes: ");
    if (scanf("%d", &max) != 1 || max < 1) max = 1;
    if (max > 1000000) max = 1000000;
    return max;
}

pcb* initArr(int max){
    pcb *dynaArr = malloc(max * sizeof(pcb));
    if (!dynaArr) { perror("malloc"); exit(1); }
    for (int i = 0; i < max; i++) {
        dynaArr[i].isFree = 0;
        dynaArr[i].parent = -1;
        dynaArr[i].children = NULL;
    }
    dynaArr[0].isFree = 1;
    dynaArr[0].parent = -1;
    return dynaArr;
}

void freeMem(pcb *arr, int max){
    if (!arr) return;
    for (int i = 0; i < max; i++) {
        child *c = arr[i].children;
        while (c) { child *n = c->next; free(c); c = n; }
        arr[i].children = NULL;
    }
    free(arr);
}

void printParentChildren(pcb *arr, int max){
    for (int i = 0; i < max; i++) {
        if (arr[i].isFree && arr[i].children) {
            printf("PCB[%d] is the parent of: ", i);
            child *c = arr[i].children;
            while (c) { printf("PCB[%d] ", c->childIndex); c = c->next; }
            printf("\n");
        }
    }
}

void create(pcb *arr, int max){
    if (!arr) { printf("Not initialized.\n"); return; }
    int parentIndex;
    printf("Enter the parent process index: ");
    if (scanf("%d", &parentIndex) != 1) { printf("Bad input.\n"); return; }
    if (parentIndex < 0 || parentIndex >= max) {
        printf("Invalid parent index (out of range).\n");
        return;
    }
    if (arr[parentIndex].isFree == 0) {
        printf("Invalid parent index (process not in use).\n");
        return;
    }
    int childIndex = -1;
    for (int i = 1; i < max; i++) {
        if (arr[i].isFree == 0) { childIndex = i; break; }
    }
    if (childIndex == -1) { printf("No free PCB available.\n"); return; }
    arr[childIndex].isFree = 1;
    arr[childIndex].parent = parentIndex;
    arr[childIndex].children = NULL;
    child *node = malloc(sizeof(child));
    if (!node) { perror("malloc"); exit(1); }
    node->childIndex = childIndex;
    node->next = NULL;
    if (arr[parentIndex].children == NULL) {
        arr[parentIndex].children = node;
    } else {
        child *cur = arr[parentIndex].children;
        while (cur->next) cur = cur->next;
        cur->next = node;
    }
    printParentChildren(arr, max);
}

void destroySubTree(pcb *arr, int max, int p){
    child *cur = arr[p].children;
    while (cur) {
        int q = cur->childIndex;
        destroySubTree(arr, max, q);
        arr[q].isFree = 0;
        arr[q].parent = -1;
        arr[q].children = NULL;
        child *next = cur->next;
        free(cur);
        cur = next;
    }
    arr[p].children = NULL;
}

void destroyDesc(pcb *arr, int max){
    if (!arr) { printf("Not initialized.\n"); return; }
    int p;
    printf("Enter the index of the process whose descendants are to be destroyed: ");
    if (scanf("%d", &p) != 1) { printf("Bad input.\n"); return; }
    if (p < 0 || p >= max) {
        printf("Invalid process index (out of range).\n");
        return;
    }
    if (arr[p].isFree == 0) {
        printf("Invalid process index (process not in use).\n");
        return;
    }
    destroySubTree(arr, max, p);
    printParentChildren(arr, max);
}

void selFunc(int sel, pcb **arr, int *pmax){
    switch (sel) {
        case 1: {
            int newMax = maxProc();
            freeMem(*arr, *pmax);
            *arr = initArr(newMax);
            *pmax = newMax;
            break;
        }
        case 2:
            if (!*arr) { printf("Pick 1 first to initialize.\n"); break; }
            create(*arr, *pmax);
            break;
        case 3:
            if (!*arr) { printf("Pick 1 first to initialize.\n"); break; }
            destroyDesc(*arr, *pmax);
            break;
        case 4:
            printf("Quitting program...\n");
            freeMem(*arr, *pmax);
            *arr = NULL;
            *pmax = 0;
            break;
        default:
            printf("Invalid selection.\n");
    }
}

int main(void){
    pcb *dynaArr = NULL;
    int max = 0;
    int sel;
    do {
        sel = getSel();
        selFunc(sel, &dynaArr, &max);
    } while (sel != 4);
    return 0;
}

