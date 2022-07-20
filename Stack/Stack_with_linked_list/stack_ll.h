#ifndef stack_ll
#define stack_ll
typedef struct n{
    struct n* next;
    int data;
}node;
node *pop(node *);
node *push(int,node *);
void printStack(node *r);
#endif