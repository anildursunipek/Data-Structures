#include <stdio.h>
#include <stdlib.h>
#include "stack_array.h"

stack * init(stack *s){
    s = (stack *)malloc(sizeof(stack));
    s -> size = 2;
    s -> top = 0;
    s -> array = NULL;
    return s;
}
int pop(stack *s){
    if(s->array == NULL){
        printf("Array is empty...\n");
        return -1;
    }else{
        if(s -> top <= s -> size / 4){
            s -> size /= 2; // Dizi boyutu yariya indirildi ve malloc ile yeni bir dizi tanimlandi
            int *array2 = (int*)malloc(sizeof(int) * s -> size);
            for(int i=0;i < s -> top;i++){
                array2[i] = s -> array[i]; // Yeni diziye elemanlar aktarildi
            }
            free(s -> array); // Eski dizi bellekten temizlendi
            s -> array = array2; // Yeni dizi ilk parametremiz olan array'e referans olarak atandi
        }
        return s -> array[--s -> top]; // Stack'den cikarilan deger geri donduruldu
    }
}
void push(int a,stack *s){
    if(s -> array == NULL){
        s -> array = (int*)malloc(sizeof(int)*2);
    }
    if(s -> top >= s -> size){
        /*Eger dizi tamamen doluysa dizi boyutunu arttirmamiz gerekir.
        Eski dizinin boyutunun 2 kati olan yeni bir dizi olusturuldu.*/
        int *array2 = (int*)malloc(sizeof(int)*s -> size*2); 
        for(int i=0;i<s -> top;i++){// Eski dizinin elemanlari yeni diziye kopayalandi
            array2[i] = s -> array[i];
        }
        free(s -> array);// Bellekte gereksiz alan kaplamamasi icin eski dizi silindi
        s -> array = array2;// Yeni dizi eski diziye atandi
        s -> size *= 2;// Dizi boyutu parametresi 2 katina cikarildi cunku yeni dizimizde artik 2 kat daha fazla alan var
    }
    s -> array[s -> top++] = a; // Diziye eleman ekle ve top degerini 1 arttir
}

void printStack(stack *s){
    printf("size -> %d top -> %d\n",s -> size,s -> top);
    for(int i=0;i<s -> top;i++){
        printf("%d.index -> %d\n",i,s -> array[i]);
    }
}
/*
void main(){
    stack *s1 = init(s1);
    stack *s2 = init(s2);
    printf("%d",s1 -> size);
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
    printStack(s1);
}*/