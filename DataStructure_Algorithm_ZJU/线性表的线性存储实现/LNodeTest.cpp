#include <stdio.h>
#include <stdlib.h>
#include "malloc.h"
const int MAXSIZE = 100;
//线性表的顺序存储实现，利用数组的连续存储空间线性存放线性表的各元素，以整数为例
typedef struct LNode *List;
struct LNode{
	int Data[MAXSIZE];
	int Last;
};

//线性表的初始化
List MakeEmpty(){
	List PtrL;
	PtrL = (List)malloc( sizeof(struct LNode) );
	PtrL->Last = 0;
	return PtrL;
}
//查找,返回值是元素在线性表中的序号n( 1<=n<=PtrL.Last ),若没有则返回-1
int Find(int X,List PtrL){
	int i = 0;
	while ( i<=PtrL->Last && PtrL->Data[i] != X ) //List是线性表最后一个元素的序号，当找到的时候i其实是数组的下标(找到后i并没有再加1)
		i++;
	if( i>PtrL->Last)
		return -1;
	else 
		return i+1;//返回的是元素在线性表中的位置
}
//插入(第i( 1=<i<=n+1 )个位置插入一个值为X的新元素 )
void Insert(int X,int i,List PtrL){
	int j;
	if (PtrL->Last == MAXSIZE-1 ){
		printf("表满，无法插入");
		return;
	}
	if(i<1 || i > PtrL->Last+2 ){
		printf("插入位置不合法，无法插入");
		return;
	}
	//在第i个位置插入元素，对应插入在数组下标为i-1处故原来的Data[i-1]-Data[last-1]要往后移,此时从后往前从Data[Last]开始依次等于前一项的值
	for(j=PtrL->Last;j>=i;j++)
		PtrL->Data[j+1]=PtrL->Data[j];
	PtrL->Data[i-1] = X;
	//移动后线性表长度加1
	PtrL->Last++;
	return;
}
//删除
void Delete(int i,List PtrL){
	int j;
	if(i<1 || i>PtrL->Last+1){
		printf("不存在第%d个元素\n",i);
		return;
	}
	for(j = i; j <= PtrL->Last; j++)
		PtrL->Data[j-1] = PtrL->Data[j];
	PtrL->Last--;
	return;
}
int main(void){
	printf("初始化一个空表\n");
	List list1 = MakeEmpty();
	printf("初始化完成，依次插入1,2,3,4,5\n");
	Insert(1,1,list1);
	Insert(2,2,list1);
	Insert(3,3,list1);
	Insert(4,4,list1);
	Insert(5,5,list1);
	printf("插入完成，依次查询1,2,3,4,5的序号\n");
	for (int i=1;i<6;i++){
		int n;
		n = Find(i,list1);
		printf("%d的序号是%d\n",i,n);
	}
	printf("list1->last=%d\n",list1->Last);
	printf("查一下100试试\n");
	int n = Find(100,list1);
	printf("%d\n",n);
	printf("把第1个元素删了\n");
	Delete(1,list1);
	printf("删除完成，依次查询1，2,3,4,5的序号\n");
	for (int i=1;i<6;i++){
		int n;
		n = Find(i,list1);
		printf("%d的序号是%d\n",i,n);
	}
	system("pause");
	return 0;
}