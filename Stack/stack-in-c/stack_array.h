#ifndef stack_array
#define stack_array
struct s{
    int size;
    int top;
    int *array;
};
typedef struct s stack;
stack * init(stack *);
int pop(stack *);
void push(int,stack *);
void printStack(stack *);
#endif
