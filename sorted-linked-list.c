#include <stdio.h>
#include <stdlib.h>

typedef struct n{
    int x;
    struct n *next;
}node;

void printList(node *r){
    int counter = 0;
    while(r != NULL){
        counter ++;
        printf("%d. = %d\n",counter,r -> x);
        r = r -> next;
    }
}

node * addSortedList(node *r,int x){
    node *temp;
    if(r == NULL){// Eger listede hic eleman yoksa ilk elemanı olusturuyoruz    
        r = (node *)malloc(sizeof(node));
        r -> next = NULL;
        r -> x = x;
        return r;
    }
    if(r -> x > x){
        temp = (node *)malloc(sizeof(node));
        temp -> x = x;
        temp -> next = r;
        return temp; //(r = temp;) Root değeri değişmemesi için fonksiyonda root değerini geri döndürüyoruz ve main içinde fonksiyonu roota eşitliyoruz
    }
    node *iter = r;
    while(iter -> next != NULL && iter -> x < x){
        iter = iter -> next;
    }
    temp = (node *)malloc(sizeof(node));
    temp -> x = x;
    temp -> next = iter -> next;
    iter -> next = temp;
    return r;
}

int main(){
    node *root;
    root = NULL;
    root = addSortedList(root,350);
    root = addSortedList(root,250);
    root = addSortedList(root,450);
    root = addSortedList(root,150);
    root = addSortedList(root,250);
    root = addSortedList(root,700);   
    printList(root);

}