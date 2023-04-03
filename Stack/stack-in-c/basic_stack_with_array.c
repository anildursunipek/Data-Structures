#include <stdio.h>
#include <stdlib.h>

int *array;
int top = 0;
int size = 2; 

int pop(){
    if(top <= size/4){
        size /= 2; // Dizi boyutu yariya indirildi ve malloc ile yeni bir dizi tanimlandi
        int *array2 = (int*)malloc(sizeof(int)*size);
        for(int i=0;i<top;i++){
            array2[i] = array[i]; // Yeni diziye elemanlar aktarildi
        }
        free(array); // Eski dizi bellekten temizlendi
        array = array2; // Yeni dizi ilk parametremiz olan array'e referans olarak atandi
    }
    return array[--top]; // Stack'den cikarilan deger geri donduruldu
}
void push(int a){
    if(top >= size){
        /*Eger dizi tamamen doluysa dizi boyutunu arttirmamiz gerekir.
        Eski dizinin boyutunun 2 kati olan yeni bir dizi olusturuldu.*/
        int *array2 = (int*)malloc(sizeof(int)*size*2); 
        for(int i=0;i<top;i++){// Eski dizinin elemanlari yeni diziye kopayalandi
            array2[i] = array[i];
        }
        free(array);// Bellekte gereksiz alan kaplamamasi icin eski dizi silindi
        array = array2;// Yeni dizi eski diziye atandi
        size *= 2;// Dizi boyutu parametresi 2 katina cikarildi cunku yeni dizimizde artik 2 kat daha fazla alan var
    }
    array[top++] = a; // Diziye eleman ekle ve top degerini 1 arttir
}

void printStack(){
    printf("size -> %d top -> %d\n",size,top);
    for(int i=0;i<top;i++){
        printf("%d.index -> %d\n",i,array[i]);
    }
}

void main(){
    // Data'nin integer bir sayi oldugu var sayilarak kodlandi.
    array = (int*)malloc(sizeof(int)*2);
    push(10);
    push(20);
    printStack();
    push(30);
    push(40);
    push(50);
    push(60);
    printStack();
    push(70);
    printStack();
    push(80);
    printStack();
    push(90);
    printStack();
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
}