#include <stdio.h>
#include <malloc.h>
#define STACK_INIT_SIZE 2000

typedef struct PosTypeition{    
    int x;
    int y;
}PosType;
typedef struct SElement{
    int ord;    //�߹������
    PosType seat;//����
    int di;     //����
}SE;
typedef struct stack{
    SE *base;   
    SE *top;    
    int stacksize;
}Stack,*stack;
int current=0;   //��¼���
int maze[10][10]={{1,1,1,1,1,1,1,1,1,1},     
            {1,0,0,1,0,0,0,1,0,1},
            {1,0,0,1,0,0,0,1,0,1},
            {1,0,0,0,0,1,1,0,0,1},
            {1,0,1,1,1,0,0,0,0,1},
            {1,0,0,0,1,0,0,0,0,1},
            {1,0,1,0,0,0,1,0,0,1},
            {1,0,1,1,1,0,1,1,0,1},
            {1,1,0,0,0,0,0,0,0,1},
            {1,1,1,1,1,1,1,1,1,1}
};//��ʼ���Թ�

void InitStack(stack L,stack N){  
    L->base=(stack)malloc(STACK_INIT_SIZE * sizeof(Stack));
    if(!L->base){
        printf("����\n");
    }
    L->top=L->base;
    L->stacksize=STACK_INIT_SIZE;
    N->base=(stack)malloc(STACK_INIT_SIZE * sizeof(Stack));
    if(!N->base){
        printf("����\n");
    }
    N->top=N->base;
    N->stacksize=STACK_INIT_SIZE;
}//��ʼ��ջ
int StackEmpty(Stack L){     
    if(L.top>L.base){
        return 1;
    }
    else{
        return 0;
    }
}//�ж�ջ�Ƿ�Ϊ��
int isPass(stack L){   
    int i;
    PosType e;
    L->top--;
    e=L->top->seat;
    L->top++;
    for(i=1;i<=5;i++){
        L->top->di=i;

        switch(i){
            case 1:{
                if(maze[e.x][e.y+1]==0){ //����
                    e.y=e.y+1;
                    StackTrace(L,e);    //���ºۼ�
                    return 1;
                }
                break;
            }
            case 2:{
                if(maze[e.x+1][e.y]==0){ //����
                    e.x=e.x+1;
                    StackTrace(L,e);
                    return 1;
                }
                break;
            }
            case 3:{    //����
                if(maze[e.x][e.y-1]==0){
                    e.y=e.y-1;
                    StackTrace(L,e);
                    return 1;
                }
                break;
            }
            case 4:{    //����
                if(maze[e.x-1][e.y]==0){
                    e.x=e.x-1;
                    StackTrace(L,e);
                    return 1;
                }
                break;
            }
            default :
                return 0;
        }
    }
}//�ж���һ��λ���ܷ�ͨ��

void StackTrace(stack L,PosType e){    
    current++;
    maze[e.x][e.y]=3;    //���߹��ĺۼ���Ϊ3
    L->top->seat=e;    //λ�ý�ջ
    L->top->ord=current;         //��ż�һ
    L->top++;   //��ַ��һ
}//���ºۼ�
int isEnd(Stack L,PosType end){  
    L.top--;
    if(L.top->seat.x==end.x&&L.top->seat.y==end.y){
        L.top++;
        return 1;
    }
    L.top++;
    return 0;
}//�ж��Ƿ��ҵ��յ�
void PrintTrace(Stack L,Stack N){ 
    while(L.top>L.base){    //��L���Ƹ�N
        --L.top;
        *(N.top)=*(L.top);
        N.top++;
    }
    while(N.top>N.base){
        N.top--;
        printf(" (%d,%d)",N.top->seat.x,N.top->seat.y);
    }
}//�����ڵ����ڵ�·��
void main(){
    int i,j;
    Stack L,N;
    PosType start,end;
    start.x=1;  //���λ��
    start.y=1;
    end.x=8;    //����λ��
    end.y=8;
    for(i=0;i<10;i++){
        for(j=0;j<10;j++){
            printf("%5d",maze[i][j]);
        }
        printf("\n");
    }
    InitStack(&L,&N);  //��ʼ��ջ
    StackTrace(&L,start);   //����ںۼ�����ջ
    //��ջ��Ϊ���������
    do{
        if(isPass(&L)){   //�����һλ�ÿ���ͨ��
            if(isEnd(L,end)){   //��������յ������
                break;
            }
        }
        else{   //���򳷻�
            L.top--;
        }

    }while(StackEmpty(L));
    if(isEnd(L,end)){
        printf("\n·����\n\n");
        PrintTrace(L,N);
    }
    else{
        printf("û���ҵ�·��\n");
    }
}
