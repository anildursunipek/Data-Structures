#include <stdio.h>
#include <stdlib.h>
#include "stack_ll.h"

node *pop(node *root){
    if(root == NULL){
        printf("Stack is empty...\n");
        return root;
    }else{
        if(root -> next == NULL){
            int rvalue;
            rvalue = root -> data;
            free(root);
            root = NULL;
            printf("%d popped\n",rvalue);
            return root;
        }
        node *iter =root;
        while(iter -> next -> next != NULL){
            iter = iter -> next;
        }
        node *temp = iter -> next;
        int rvalue = temp -> data;
        iter -> next = NULL;
        free(temp);
        printf("%d popped\n",rvalue);
        return root;
    }
}

node *push(int data,node *root){
    if(root == NULL){
        root = (node *)malloc(sizeof(node));
        root -> data = data;
        root -> next = NULL;
        return root;
    }
    node *iter =root;
    while(iter -> next != NULL){
        iter = iter -> next;
    }
    iter -> next = (node *)malloc(sizeof(node));
    iter -> next -> data = data;
    iter -> next -> next = NULL;
    return root;
}

void printStack(node *root){
    node *iter = root;
    int counter = 0;
    while(iter != NULL){
        counter++;
        printf("%d. index -> %d\n",counter,iter -> data);
        iter = iter -> next;
    }
}

/*void main(){
    node *root = NULL;
    //printf("%d popped\n",pop(root));
    root = pop(root);
    root = push(10,root);
    printStack(root);
    root = pop(root);
    root = pop(root);
    root = push(10,root);
    root = push(20,root);
    root = push(30,root);
    root = push(40,root);
    printStack(root);
    //printf("%d popped\n",pop(root));
    //printf("%d popped\n",pop(root));
    //printf("%d popped\n",pop(root));
    root = push(20,root);
    root = push(30,root);
    root = push(40,root);
    root = push(50,root);
    root = push(60,root);
    printStack(root);
    printf("%d popped\n",pop(root));
    printf("%d popped\n",pop(root));
    printf("%d popped\n",pop(root));
    printStack(root);
     
}*/