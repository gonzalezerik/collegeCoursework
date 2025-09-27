#include <stdio.h>
#include <stdlib.h>
void printList(int* l, int size, int* sL);
int bSearch(int *sL, int l, int r, int x);
int* inSort(int* l, int size);


int main(){
    int listSize;
    printf("Enter size of list (between 1 and 25): ");
    scanf("%d", &listSize);

    int *list = (int*)malloc(listSize *sizeof(int));
    int *sList = (int*)malloc(listSize *sizeof(int));

    //printf("Size of list: %d\n", listSize);
    for(int i = 0; i < listSize; i++){
        printf("Enter one list element: ");
        scanf("%d", &*(list + i));
        *(sList + i) = *(list + i);
    }
    inSort(sList, listSize);


    printList(list, listSize, sList);

    int key;
    int result;
    
    printf("\nEnter a key to search for: ");
    scanf("%d", &key);
    result = bSearch(sList, 0, (listSize - 1), key);

    if (result == -1){
        printf("\nKey not found!\n");
    }
    else{
        printf("\nKey found\n");
    }


    //printList(list, listSize, sList);
    /*
    printf("List: ");
    for(int i = 0; i < listSize; i++){
        printf("%d, ", *(list + i));
    } */
    return 0;
}

int bSearch(int *sL, int low, int high, int key){

    printf("l: %d\n", low);
    printf("h: %d\n", high); // list size
    printf("k: %d\n", key);



    
    if (high >= low) {
        printf("\nif r(%d) >= l(%d)", high, low);
        int mid = low + (high - low) / 2;
        printf("\nint mid = %d\n", mid);
        // If the element is present at the middle
        // itself
        if (*(sL + mid) == key){
            printf("return mid: %d\n", mid);
            return mid;
        }
 
        // If element is smaller than mid, then
        // it can only be present in left subarray
        if (*(sL + mid) > key){
            printf("sL + mid(%d) > x(%d)\n", mid, x);
            return bSearch(sL, low, mid - 1, key);
        }
        // Else the element can only be present
        // in right subarray
        return bSearch(sL, mid + 1, low, key);
    }
 
    // We reach here when element is not
    // present in array
    return -1;
}



void printList(int* l, int size, int* sL){

    printf("\nContent of list: ");
    for(int i = 0; i < size; i++){
        printf("%d ", *(l + i));
    }
    
    printf("\nContent of list: ");
    for(int i = 0; i < size; i++){
        printf("%d ", *(sL + i));
    }

}

int* inSort(int* l, int size){
    printf("\n-----INSERTION SORT---------\n");
    int* sL = l;

    int i, j, key;

    for(i = 1; i < size; i++){
        key = *(sL + i);
        printf("\nKey: %d\n", key);
        j = i - 1;
        printf("j: %d\n", j);

        while(j >= 0 && *(sL + j) > key){
            printf("\nwhile j(%d) >= 0 && list(%d) > key(%d)\n", j, *(sL + j), key);
            *(sL + (j + 1)) = *(sL + j);
            printf("%d = %d\n",*(sL + (j + 1)), *(sL + j));
            j = j - 1;
            printf("j: %d\n", j);
        }
        printf("After while: %d = %d(key)\n", *(sL + (j + 1)), key);
        printf("j: %d\n", j);
        *(sL + (j + 1)) = key;
    }
    return sL;
}