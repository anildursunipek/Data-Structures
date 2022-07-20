#include <stdio.h>
#include <stdlib.h>
#include "stack_ll.h"

void main(){
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
}