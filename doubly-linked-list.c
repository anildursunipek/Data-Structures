#include <stdio.h>
#include <stdlib.h>

struct n{
    int x;
    struct n *next;
    struct n *prev;
};
typedef struct n node;

void printList(node *r){
    int counter = 0;
    node *iter =r;
    while(iter != NULL){
        counter++;
        printf("%d -> %d\n",counter,iter->x);
        iter = iter -> next;
    }
    printf("-----------------\n");
}

node* addSortedList(node *r,int x){
    if(r == NULL){
        r = (node*)malloc(sizeof(node));
        r -> x = x;
        r -> next = NULL;
        r -> prev = NULL;
        return r;
    }
    if(r -> x > x){
        node *temp;
        temp = (node*)malloc(sizeof(node));
        temp -> x = x;
        temp -> next = r;
        temp -> prev = NULL;
        r -> prev = temp;
        return temp;
    }
    node *temp;
    node *iter = r;
    while(iter -> next != NULL && iter -> next -> x < x){
        iter = iter -> next;
    }
    temp = (node *)malloc(sizeof(node));
    temp -> x = x;
    temp -> next = iter -> next;
    temp -> prev = iter;
    iter -> next = temp;
    if(temp -> next != NULL){
        temp -> next -> prev = temp;
    }
    return r;
}

node *deleteFromList(node *r,int x){
    node *temp;
    node *iter = r;
    if(r-> x == x){
        temp = (node *)malloc(sizeof(node));
        temp = r;
        r = r -> next;
        r -> prev = NULL;
        free(temp);
        return r;
    }
    while(iter -> next != NULL && iter -> next -> x != x){
        iter = iter -> next;
    }
    temp = (node*)malloc(sizeof(node));
    temp = iter -> next;
    iter -> next = iter -> next -> next;
    if(iter -> next != NULL){ // Silinecek eleman son eleman ise NULL olacaktir. Bu nedenle prev pointer'i olmayacagi icin bu islemler yapilir
        iter -> next -> prev = iter;
    }
    free(temp);
    return r;
}

void main(){
    node *root = NULL;
    printf("addSortedList Test \n------------------\n");
    root = addSortedList(root,550);
    printList(root);
    root = addSortedList(root,250);
    printList(root);
    root = addSortedList(root,750);
    printList(root);
    root = addSortedList(root,150);
    printList(root);
    root = addSortedList(root,50);
    printList(root);
    root = addSortedList(root,1050);
    printList(root);
    printf("deleteFromList Test \n ------------------\n");
    root = deleteFromList(root,750);
    printList(root);
    root = deleteFromList(root,50);
    printList(root);
    root = deleteFromList(root,1050);
    printList(root);
}