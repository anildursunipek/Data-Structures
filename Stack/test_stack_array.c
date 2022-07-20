#include <stdio.h>
#include <stdlib.h>
#include "stack_array.h"

void main(){
    pop();
    push(10);
    push(20);
    printStack();
    push(30);
    push(40);
    push(50);
    push(60);
    printStack();
    push(70);
    push(80);
    push(90);
    push(100);
    printStack();
    printf("%d popped\n",pop());
    printf("%d popped\n",pop());
    printf("%d popped\n",pop());
    printf("%d popped\n",pop());
    printStack();
    printf("%d popped\n",pop());
    printf("%d popped\n",pop());
    printf("%d popped\n",pop());
    printStack();
    push(100);
    push(1000);
    printStack();
}
