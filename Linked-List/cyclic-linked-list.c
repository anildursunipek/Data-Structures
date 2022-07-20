#include <stdio.h>
#include <stdlib.h>

typedef struct n{
    int x;
    struct n *next;
}node;

void printList(node *r){
    int counter = 1;
    node *iter = r;
    printf("%d. = %d\n",counter,iter -> x); // Ilk elemani yazdiramadigimiz icin dongu oncesinde 1 kere print edip next'liyoruz
    iter = iter -> next;
    while(iter != r){
        counter ++;
        printf("%d. = %d\n",counter,iter -> x);
        iter = iter -> next;
    }
    printf("-----------------\n");
}

void addList(node *r,int x){
    node *iter = r;
    iter = iter -> next;
    while(iter -> next != r){
        iter = iter -> next;
    }
    iter -> next = (node *)malloc(sizeof(node));
    iter -> next -> x = x;
    iter -> next -> next = r;
}

node *addSortedCyclicList(node *r,int x){
    if(r == NULL){// Eger listede hic eleman yoksa ilk elemanı olusturuyoruz    
        r = (node *)malloc(sizeof(node));
        r -> next = r;
        r -> x = x;
        return r;
    }
    if(r -> x > x){ // Eger liste icindeki ilk elemanin degerinden daha kucuk bir deger ekliyorsak bu islemler uygulanir
        node *temp;
        node *iter;
        iter = r;
        while(iter -> next != r){
            iter = iter -> next;
        }
        temp = (node *)malloc(sizeof(node));
        temp -> x = x;
        temp -> next = r;
        iter -> next = temp;
        return temp; //(r = temp;) Root değeri değişmemesi için fonksiyonda root değerini geri döndürüyoruz ve main içinde fonksiyonu roota eşitliyoruz
    }
    node *temp;
    node *iter;
    iter = r;
    while(iter -> next != r && iter -> x < x){
        iter = iter -> next;
    }
    temp = (node *)malloc(sizeof(node));
    temp -> x = x;
    temp -> next = iter -> next;
    iter -> next = temp;
    return r;
}

node *deleteFromList(node *r,int x){
    node *temp;
    node *iter;
    iter = r;
    if(r -> x == x){ // İlk elemani silme islemi
        while(iter -> next != r){
            iter = iter -> next;
        }
        temp = r;
        iter -> next = r -> next;
        r = r -> next;
        free(temp);
        printf("First index deleted...\n");
        return r;
    }
    while(iter -> next != r && iter -> next -> x != x){
        iter = iter -> next;
    }
    if(iter -> next == r){
        printf("Number not found...");
        return r;
    }
    temp = iter -> next;
    iter -> next = iter -> next -> next;
    free(temp);
    return r;
}

int main(){
    node *root;
    root = NULL;
    printf("addSortedCyclicList Function Test\n ------------------\n");
    root = addSortedCyclicList(root,350);
    printList(root);
    root = addSortedCyclicList(root,250);
    printList(root);
    root = addSortedCyclicList(root,450);
    printList(root);
    root = addSortedCyclicList(root,150);
    printList(root);
    root = addSortedCyclicList(root,250);
    printList(root);
    root = addSortedCyclicList(root,700);   
    printList(root);
    printf("deleteFromList Function Test\n ------------------\n");
    root = deleteFromList(root,250);
    printList(root);
    root = deleteFromList(root,450);
    printList(root);
    root = deleteFromList(root,150);
    printList(root);
    root = deleteFromList(root,700);
    printList(root);
}