#include <stdio.h>
#include <malloc.h>
#define STACK_INIT_SIZE 2000

typedef struct PosTypeition{    
    int x;
    int y;
}PosType;
typedef struct SElement{
    int ord;    //走过的序号
    PosType seat;//坐标
    int di;     //方向
}SE;
typedef struct stack{
    SE *base;   
    SE *top;    
    int stacksize;
}Stack,*stack;
int current=0;   //记录序号
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
};//初始化迷宫

void InitStack(stack L,stack N){  
    L->base=(stack)malloc(STACK_INIT_SIZE * sizeof(Stack));
    if(!L->base){
        printf("错误\n");
    }
    L->top=L->base;
    L->stacksize=STACK_INIT_SIZE;
    N->base=(stack)malloc(STACK_INIT_SIZE * sizeof(Stack));
    if(!N->base){
        printf("错误\n");
    }
    N->top=N->base;
    N->stacksize=STACK_INIT_SIZE;
}//初始化栈
int StackEmpty(Stack L){     
    if(L.top>L.base){
        return 1;
    }
    else{
        return 0;
    }
}//判断栈是否为空
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
                if(maze[e.x][e.y+1]==0){ //向右
                    e.y=e.y+1;
                    StackTrace(L,e);    //留下痕迹
                    return 1;
                }
                break;
            }
            case 2:{
                if(maze[e.x+1][e.y]==0){ //向下
                    e.x=e.x+1;
                    StackTrace(L,e);
                    return 1;
                }
                break;
            }
            case 3:{    //向左
                if(maze[e.x][e.y-1]==0){
                    e.y=e.y-1;
                    StackTrace(L,e);
                    return 1;
                }
                break;
            }
            case 4:{    //向上
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
}//判断下一个位置能否通过

void StackTrace(stack L,PosType e){    
    current++;
    maze[e.x][e.y]=3;    //将走过的痕迹改为3
    L->top->seat=e;    //位置进栈
    L->top->ord=current;         //序号加一
    L->top++;   //地址加一
}//留下痕迹
int isEnd(Stack L,PosType end){  
    L.top--;
    if(L.top->seat.x==end.x&&L.top->seat.y==end.y){
        L.top++;
        return 1;
    }
    L.top++;
    return 0;
}//判断是否找到终点
void PrintTrace(Stack L,Stack N){ 
    while(L.top>L.base){    //将L复制给N
        --L.top;
        *(N.top)=*(L.top);
        N.top++;
    }
    while(N.top>N.base){
        N.top--;
        printf(" (%d,%d)",N.top->seat.x,N.top->seat.y);
    }
}//输出入口到出口的路径
void main(){
    int i,j;
    Stack L,N;
    PosType start,end;
    start.x=1;  //入口位置
    start.y=1;
    end.x=8;    //出口位置
    end.y=8;
    for(i=0;i<10;i++){
        for(j=0;j<10;j++){
            printf("%5d",maze[i][j]);
        }
        printf("\n");
    }
    InitStack(&L,&N);  //初始化栈
    StackTrace(&L,start);   //将入口痕迹加入栈
    //当栈不为空则继续找
    do{
        if(isPass(&L)){   //如果下一位置可以通过
            if(isEnd(L,end)){   //如果到达终点则结束
                break;
            }
        }
        else{   //否则撤回
            L.top--;
        }

    }while(StackEmpty(L));
    if(isEnd(L,end)){
        printf("\n路径：\n\n");
        PrintTrace(L,N);
    }
    else{
        printf("没有找到路径\n");
    }
}
