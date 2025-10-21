#include <stdio.h>
#include <stdlib.h>
#include <pthread.h> //to use POSIX pThread library
#include <time.h> // to seed the random number generator with current time

#define NUM_THREADS 5  // Number of users accessing the account

int balance = 1000; // Shared bank account balance
pthread_mutex_t lock; // Mutex lock
// variable to enable/disable Mutex lock
// variable to go again after program run

void* transaction(void* arg) {
    int amount = rand() % 500; // Random amount to deposit/withdraw
    int choice = rand() % 2;   // 0 for withdraw, 1 for deposit

    // Lock the critical section (user toggle)
    pthread_mutex_lock(&lock);

    if (choice == 0) { // withdraw
            // print withdrawing xxx with previous balance yyy
            // adjust balance
            // print new balance
            // print Insufficient funds if trying to withdraw more than current balance
        }
    } else {
        // print depositing xxx with previous balance yyy
        // adjust balance
        // print new balance
    }

    // Unlock the critical section (user toggle)
    pthread_mutex_unlock(&lock);
	
}

int main() {
		
    pthread_t threads[NUM_THREADS];

    // Initialize the mutex lock
    pthread_mutex_init(&lock, NULL);
	
	srand(time(NULL)); // Seed the random number generator (this ensures you get different random numbers each time you run the program)

	// print/scan to enable/disable mutex lock

    // Create multiple threads limited to NUM_THREADS
    for (int i = 0; i < NUM_THREADS; i++) {
        pthread_create(&threads[i], NULL, transaction, NULL);
    }

    // Wait for all threads to finish (join runs them sequentially but does not prevent race conditions)
    for (int i = 0; i < NUM_THREADS; i++) {
        pthread_join(threads[i], NULL);
    }

    // Destroy the mutex lock to free up resources
    pthread_mutex_destroy(&lock);

	// print final account balance
	
	// ask the user to go again
}

/* Sample output:
Enter 1 to enable lock, 0 to disable lock: 1
Depositing: $470 | Previous Balance: $1000
New Balance: $1470
Withdrawing: $161 | Previous Balance: $1470
New Balance: $1309
Depositing: $129 | Previous Balance: $1309
New Balance: $1438
Withdrawing: $29 | Previous Balance: $1438
New Balance: $1409
Withdrawing: $229 | Previous Balance: $1409
New Balance: $1180
Final Account Balance: $1180
Go again (y/n)? y
Enter 1 to enable lock, 0 to disable lock: 0
Withdrawing: $337 | Previous Balance: $1180
New Balance: $843
Depositing: $177 | Previous Balance: $843
New Balance: $1020
Withdrawing: $156 | Previous Balance: $1020
Depositing: $407 | Previous Balance: $1020
New Balance: $1427
New Balance: $1271
Withdrawing: $146 | Previous Balance: $1271
New Balance: $1125
Final Account Balance: $1125
Go again (y/n)? n
*/