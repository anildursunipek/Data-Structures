#include <stdio.h>
#include <stdlib.h>

typedef struct n{
    int x;
    struct n *next;
}node;

void addList(node *r,int x){
    while(r -> next != NULL){
        r = r -> next;
    }
    r -> next = (node *)malloc(sizeof(node));
    r -> next -> x = x;
    r -> next -> next = NULL;
}

void printList(node *r){
    int counter = 0;
    while(r != NULL){
        counter ++;
        printf("%d. = %d\n",counter,r -> x);
        r = r -> next;
    }
}

int main(){
node *root;
node *iter;
int i;
root = (node *)malloc(sizeof(node));
root -> x = 0;
root -> next = NULL;
for(i=1;i<8;i++){
    addList(root,i*10);
}
printList(root);
printf("--------------------\n");

// İNSERTİON
iter = root; 
for(i=0;i<5;i++){
    iter = iter -> next;
}// For döngüsü ile ekleme yapılacak aralığa gidilir
node *temp = (node *)malloc(sizeof(node));// Temp adında geçici değişken oluşturuldu
temp -> next = iter -> next; // Temp'in next'ine bir sonraki eleman bağlandı
iter -> next = temp; // İterin next'ine temp bağlandı
temp -> x = 55;
printList(root);
}