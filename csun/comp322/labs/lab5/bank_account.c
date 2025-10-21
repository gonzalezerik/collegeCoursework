#include <stdio.h>
#include <stdlib.h>
#include <pthread.h>
#include <unistd.h>
#include <time.h>
#include <stdbool.h>

#define NUM_THREADS 5

/* globals */
static int balance = 1000;           
static int useLock = 1;              
static pthread_mutex_t balMu = PTHREAD_MUTEX_INITIALIZER;

/* prototypes */
void menuFunc(void);
int  getSel(void);
void newLine(void);
void runOnce(void);
void *transaction(void *arg);

void newLine(void){
    puts("");
}

void menuFunc(void){
    printf("Enter 1 to enable lock, 0 to disable lock: ");
}

int getSel(void){
    int sel;
    if (scanf("%d", &sel) != 1) sel = 1;
    if (sel != 0) sel = 1;  
    return sel;
}

void *transaction(void *arg){
    int tid = *(int*)arg;
    unsigned int rng = (unsigned)time(NULL) ^ (unsigned)(tid * 2654435761u);
    int amount = (rand_r(&rng) % 500) + 1; 
    int choice = rand_r(&rng) % 2;      

    if (useLock) pthread_mutex_lock(&balMu);

    int before = balance;

    if (choice == 0) {
        printf("Withdrawing: $%d | Previous Balance: $%d\n", amount, before);
        if (before >= amount) {
            usleep(100 + (rand_r(&rng) % 400));
            balance = before - amount;
            printf("New Balance: $%d\n", balance);
        } else {
            printf("Insufficient funds — transaction denied.\n");
        }
    } else {
        printf("Depositing: $%d | Previous Balance: $%d\n", amount, before);
        usleep(100 + (rand_r(&rng) % 400));
        balance = before + amount;
        printf("New Balance: $%d\n", balance);
    }

    if (useLock) pthread_mutex_unlock(&balMu);
    return NULL;
}

void runOnce(void){
    pthread_t th[NUM_THREADS];
    int ids[NUM_THREADS];

    for (int i = 0; i < NUM_THREADS; i++) {
        ids[i] = i;
        pthread_create(&th[i], NULL, transaction, &ids[i]);
    }
    for (int i = 0; i < NUM_THREADS; i++) pthread_join(th[i], NULL);

    printf("Final Account Balance: $%d\n", balance);
}

int main(void){
    srand((unsigned)time(NULL));

    while (1) {
        menuFunc();
        useLock = getSel();

        runOnce();

        printf("Go again (y/n)? ");
        char ans[8];
        if (scanf("%7s", ans) != 1) break;
        if (ans[0] == 'n' || ans[0] == 'N') break;
    }

    pthread_mutex_destroy(&balMu);
    return 0;
}

