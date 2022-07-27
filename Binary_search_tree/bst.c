#include <stdio.h>
#include <stdlib.h>

typedef struct n{
    struct n* right;
    struct n* left;
    int data;
}node;

node* addTree(int data,node *tree){
    if(tree == NULL){
        node *root = (node*)malloc(sizeof(node));
        root -> data = data;
        root -> right = NULL;
        root -> left = NULL;
        return root;
    }
    if(data > tree -> data){
        tree -> right = addTree(data,tree -> right);
        return tree;
    }
    tree -> left =  addTree(data,tree -> left);
    return tree;
}

void printTree(node *tree){
    // 3 Farkli traversal yapisi vardir   
    // İnfix = LNR , RNL   -> LNR Agactaki verileri kucukten buyuge siralamaktadir
    // Prefix = NLR , NRL
    // Postfix = LRN , RLN
    if(tree == NULL){
        return ;
    }
    printTree(tree -> left);
    printf("%d\n",tree -> data);
    printTree(tree -> right);
}

int searchTree(node *tree,int data){
    if(tree == NULL)
        return -1;
    if(tree -> data == data)
        return 1;
    if(searchTree(tree->right,data) == 1)
        return 1;
    if(searchTree(tree->left,data) == 1)
        return 1;
    return -1;
}

int findMin(node *tree){
    if(tree == NULL)
        printf("Tree is empty..\n");
    while(tree -> left !=NULL)
        tree = tree -> left;
    printf("Min -> %d\n",tree -> data);
}

int findMax(node *tree){
    if(tree == NULL)
        printf("Tree is empty..\n");
    while(tree -> right !=NULL)
        tree = tree -> right;
    printf("Max -> %d\n",tree -> data);
}

int main(){
    node *tree = NULL;
    tree = addTree(10,tree);
    printTree(tree);
    printf("---------------\n");
    tree = addTree(25,tree);
    printTree(tree);
    printf("---------------\n");
    tree = addTree(30,tree);
    tree = addTree(40,tree);
    printTree(tree);
    printf("---------------\n");
    tree = addTree(5,tree);
    tree = addTree(3,tree);
    printTree(tree);
    printf("---------------\n");
    printf("Search result -> %d\n",searchTree(tree,30));
    printf("Search result -> %d\n",searchTree(tree,340));
    findMin(tree);
    findMax(tree);
}
