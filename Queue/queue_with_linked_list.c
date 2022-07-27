#include <stdio.h>
#include <stdlib.h>

typedef struct n{
    struct n* next;
    int data;
}node;

node* deque(node *r){
    if(r == NULL){
        printf("Linked list empty...\n");
        return r;
    }
    node *temp = r;
    int popped = temp -> data;
    r = r -> next;
    free(temp);
    return r;
}

node *enque(int data,node *r){
    if(r == NULL){
        r = (node*)malloc(sizeof(node));
        r -> next = NULL;
        r -> data = data;
        return r;
    }
    node *iter = r;
    while(iter-> next != NULL){
        iter = iter -> next;
    }
    iter -> next = (node *)malloc(sizeof(node));
    iter -> next -> next = NULL;
    iter -> next -> data = data;
    return r;
}

void printQue(node *r){
    int counter = 0;
    while(r != NULL){
        counter++;
        printf("%d. index -> %d\n",counter,r -> data);
        r = r -> next;
    }
    if(counter == 0)
        printf("Linked list empty...\n");
}

int main(){
    /* 
    -> First in First out: İlk giren ilk çıkar
    -> 2 farkli sekilde yaklasabiliriz
    -> Basa ekleyip sondan cikarma yapabiliriz yada sona ekleyip bastan cikarma yapabiliriz
    -> İlk secenek aslinda daha kisa bir yol izlemektedir
    -> İkinci secenekte her cikarma isleminde listeyi tekrar gezmemiz gerekir
    */
    node *root = NULL;
/*     root = enque(10,root);
    root = enque(20,root);
    root = enque(30,root);
    root = enque(30,root);
    root = enque(50,root);
    printQue(root);
    root = deque(root);
    root = deque(root);
    printQue(root); */
    for(int i = 0 ; i < 10 ; i++){
        root = enque(i*10,root);
    }
    printQue(root);
    for(int i = 0 ; i < 13 ; i++){
        root = deque(root);
    }
    printQue(root);
}