#include <stdio.h>
#include <stdlib.h>
#include "stack_array.h"

void main(){
    stack *s1 = init(s1);
    stack *s2 = init(s2);
    for(int i = 0;i<10;i++)
        push(i*10,s1);
    printStack(s1);
    for(int i = 0;i<10;i++)
        push(pop(s1),s2);
    printStack(s1);
    printStack(s2);
    /* Debugging
    pop(s1);
    push(10,s1);
    push(20,s1);
    printStack(s1);
    push(30,s1);
    push(40,s1);
    push(50,s1);
    push(60,s1);
    printStack(s1);
    push(70,s1);
    push(80,s1);
    push(90,s1);
    push(100,s1);
    printStack(s1);
    printf("%d popped\n",pop(s1));
    printf("%d popped\n",pop(s1));
    printf("%d popped\n",pop(s1));
    printf("%d popped\n",pop(s1));
    printStack(s1);
    printf("%d popped\n",pop(s1));
    printf("%d popped\n",pop(s1));
    printf("%d popped\n",pop(s1));
    printStack(s1);
    push(100,s1);
    push(1000,s1);
    printStack(s1);*/
}
