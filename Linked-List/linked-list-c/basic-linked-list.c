#include <stdio.h>
#include <stdlib.h> // imported for malloc

typedef struct n{
    int x; // data
    struct n* next;
}node;


int main(){
    node * root = (node *)(malloc(sizeof(node))); // Tip dönüşümü yapıldı. Malloc void return ettiği için ayırılan bellek alan node yapısı ile dolduruldu
    root -> x = 10;
    printf("Root -> x = %d\n",root -> x);
    root -> next = (node *)(malloc(sizeof(node))); 
    /*
    +Root listenin ilk elemanı. 
    +Root değişkeninden sonraki eleman için root'un next değişkenine yeni bir alan tanımlandı.
    */
    root -> next -> x= 20;
    printf("Root -> next -> x = %d\n",root -> next -> x);
    root -> next -> next = (node *)(malloc(sizeof(node)));
    root -> next -> next -> x = 30;
    printf("Root -> next -> next -> x = %d\n",root -> next -> next-> x);
    root -> next -> next -> next = NULL; // Malloc ile bellek ayırma yapılırken bellek alanı boş olmayabilir. Bu nedenle listenin son elemanının nexti null olarak işaret edilir.
    /* Simple Way = iter */
    node *iter;
    iter = root;
    printf("%d\n",iter -> x);
    iter = iter -> next;
    printf("%d\n",iter -> x);
    iter = iter -> next;
    printf("%d\n",iter -> x);
    /*
    İter değişkeni ile sürekli next next yazmaktan kurtularak pointer içeriğni basit bir şekilde değiştiriyoruz.
    Bunun sonucunda daha pratik bir şekilde print etmemize ve yapıyı kullanmamızı sağlıyor.
    Kısacası iter'in asıl amacı pointer üzerinde gezmemizi sağlamak.
    */

   // Linked List with loop and function
    iter = root; // iterator'ı listenin ilk elemanına alır
    int counter = 0;
    /*while(iter -> next != NULL){ // Ekleme yapabilmek için son kutuyu işaret ediyoruz. İter -> next şeklinde tanımlayarak
        counter++;
        printf("%d. data = %d\n",counter,iter->x);
        iter = iter -> next;
    }*/
    // For döngüsü ile değer ekleme
    iter = root;
    for(int i=0;i<5;i++){
        iter -> next = (node *)(malloc(sizeof(node)));
        iter -> x = i*10;
        iter = iter -> next;
        iter -> next = NULL;
    }
    // Printing list
    iter = root;
    counter = 0;
    while(iter -> next != NULL){ // Ekleme yapabilmek için son kutuyu işaret ediyoruz. İter -> next şeklinde tanımlayarak
        counter++;
        printf("%d. data = %d\n",counter,iter->x);
        iter = iter -> next;
    }
}