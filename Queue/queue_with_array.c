#include <stdio.h>
#include <stdlib.h>
typedef struct q{
    int *array;
    int head;
    int end;
    int size;
}que;

que* init(que *q){
    q -> array = NULL;
    q -> head = 0;
    q -> end = 0;
    q -> size = 2;
}

int deque(que *q){
    if(q -> head == q -> end){ // Sirada eleman yoksa bu islem uygulanir
        printf("Queue is empty");
        return -1;
    }
    if((q -> end) - (q -> head) <= q -> size /4 ){
        q -> size /= 2;
        int *array2 = (int*)malloc(sizeof(int)*q->size);
        for(int i=0;i < q->size;i++){
            array2[i] = q -> array[i];
        }
        free(q -> array);
        q -> array = array2;
    }
    return q -> array[q -> head++]; // Eleman varsa cıkarilan elemanı geri dondur ver siranin basini 1 arttir
}
void clearQue(que *q){ // Siradaki boslukları temizleyen bir fonksiyon
    if(q -> head == 0){
        return ;
    }
    for(int i = 0; i < q -> size;i++){
        q -> array[i] = q -> array[i + q -> head];
    }
    q -> end -= q -> head;
    q -> head = 0;
}

void enque(int data, que *q){
    if(q -> array == NULL){ // Eger sira bos ise yeni bir alan ayir
        q -> array = (int*)malloc(sizeof(int)* q -> size);
    }
    if(q -> end >= q -> size){ // Eger dizinin eleman sayisi dolmussa eleman sayisini 2 katina cikar 
        q -> size *= 2;
        int *array2 = (int*)malloc(sizeof(int)* q-> size); // Yeni bir dizi olusturarak elemanları bu diziye aktarıyoruz
        for(int i=0;i < q -> size / 2; i++){
            array2[i] = q -> array[i];
        }
        free(q -> array); // Eski diziyi free yaptiktan sonra yeni dizimizi eski dizimize atiyoruz
        q -> array = array2;
    }
    q -> array[q -> end++] = data; // Eger dizide bir sorun yoksa yeni gelen elemanı son indise ata ve dizinin  sonunu 1 arttir
}

void printQue(que *q){
    for(int i = 0; i < q -> end;i++){
        printf("%d. index -> %d\n",i,q -> array[i]);
    }
}

int main(){
    que *q1 = init(q1);
    printf("Size -> %d Head -> %d End -> %d\n",q1 -> size, q1 -> head, q1 -> end);
    for(int i = 0; i < 20 ; i++)
        enque(i*10,q1);
    printf("Size -> %d Head -> %d End -> %d\n",q1 -> size, q1 -> head, q1 -> end);
    printQue(q1);
    clearQue(q1);
    printf("Size -> %d Head -> %d End -> %d\n",q1 -> size, q1 -> head, q1 -> end);
    printQue(q1);
    for(int i = 0; i < 10 ; i++)
        deque(q1);
    clearQue(q1);
    printf("Size -> %d Head -> %d End -> %d\n",q1 -> size, q1 -> head, q1 -> end);
    printQue(q1);
    for(int i = 0; i < 2 ; i++)
        deque(q1);
/*     for(int i = 0; i < 5 ; i++)
        deque(q1);
    clearQue(q1);
    printf("Size -> %d Head -> %d End -> %d\n",q1 -> size, q1 -> head, q1 -> end);
    printQue(q1); */
}