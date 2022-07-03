#include <stdio.h>
#include <stdlib.h> // imported for malloc

typedef struct n{
    int x;
    struct n* next;
}node;

void addList(node *r,int x){
    while(r -> next != NULL){
        r = r -> next;
    }// Dizinin son elemanına kadar gitmemizi saglayan while dongusu
    r -> next = (node *)malloc(sizeof(node));
    r -> next -> x = x;
    r -> next -> next = NULL;
}

void printList(node * r){
    int counter = 0;
    while(r != NULL){
        counter++;
        printf("%d. data = %d\n",counter,r -> x);
        r = r -> next;
    }
}

int main(){
    node *root;
    root -> x = 0;
    root -> next = NULL;
    for(int i=1;i<7;i++){
        addList(root,i*10);
    }
    printList(root);
}
