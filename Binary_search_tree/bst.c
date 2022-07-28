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

node *deletion(node *tree,int data){
    if(tree == NULL)
        return NULL;
    if(tree -> data == data){
        if(tree -> right == NULL && tree -> right == NULL){
            return NULL;
        }
        if(tree -> right != NULL){
            tree -> data = findMin(tree -> right);
            tree -> right = deletion(tree -> right,findMin(tree -> right));
            return tree;
        }
        tree -> data = findMax(tree -> left);
        tree -> left = deletion(tree -> left,findMax(tree -> left));
        return tree;
    }
    if(tree -> data < data ){
        tree -> data= deletion(tree -> right,data);
        return tree;
    }
    tree -> left = deletion(tree -> left,data);
    return tree;

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
    return tree -> data;
}

int findMax(node *tree){
    if(tree == NULL)
        printf("Tree is empty..\n");
    while(tree -> right !=NULL)
        tree = tree -> right;
    return tree -> data;
}

int main(){
    node *tree = NULL;
    tree = addTree(56,tree);
    printTree(tree);
    printf("---------------\n");
    tree = addTree(26,tree);
    printTree(tree);
    printf("---------------\n");
    tree = addTree(200,tree);
    tree = addTree(18,tree);
    tree = addTree(28,tree);
    tree = addTree(190,tree);
    tree = addTree(213,tree);
    printTree(tree);
    printf("---------------\n");
    tree = addTree(12,tree);
    tree = addTree(24,tree);
    tree = addTree(27,tree);
    printTree(tree);
    printf("---------------\n");
    printf("Search result -> %d\n",searchTree(tree,24));
    printf("Search result -> %d\n",searchTree(tree,340));
    printf("Min -> %d\n",findMin(tree));
    printf("Max -> %d\n",findMax(tree));
    tree = deletion(tree,18);
    tree = deletion(tree,56);
    printTree(tree);
}
