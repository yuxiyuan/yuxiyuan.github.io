#include <stdio.h>
#include <stdlib.h>
#include "malloc.h"
const int MAXSIZE = 100;
//���Ա��˳��洢ʵ�֣���������������洢�ռ����Դ�����Ա�ĸ�Ԫ�أ�������Ϊ��
typedef struct LNode *List;
struct LNode{
	int Data[MAXSIZE];
	int Last;
};

//���Ա�ĳ�ʼ��
List MakeEmpty(){
	List PtrL;
	PtrL = (List)malloc( sizeof(struct LNode) );
	PtrL->Last = 0;
	return PtrL;
}
//����,����ֵ��Ԫ�������Ա��е����n( 1<=n<=PtrL.Last ),��û���򷵻�-1
int Find(int X,List PtrL){
	int i = 0;
	while ( i<=PtrL->Last && PtrL->Data[i] != X ) //List�����Ա����һ��Ԫ�ص���ţ����ҵ���ʱ��i��ʵ��������±�(�ҵ���i��û���ټ�1)
		i++;
	if( i>PtrL->Last)
		return -1;
	else 
		return i+1;//���ص���Ԫ�������Ա��е�λ��
}
//����(��i( 1=<i<=n+1 )��λ�ò���һ��ֵΪX����Ԫ�� )
void Insert(int X,int i,List PtrL){
	int j;
	if (PtrL->Last == MAXSIZE-1 ){
		printf("�������޷�����");
		return;
	}
	if(i<1 || i > PtrL->Last+2 ){
		printf("����λ�ò��Ϸ����޷�����");
		return;
	}
	//�ڵ�i��λ�ò���Ԫ�أ���Ӧ�����������±�Ϊi-1����ԭ����Data[i-1]-Data[last-1]Ҫ������,��ʱ�Ӻ���ǰ��Data[Last]��ʼ���ε���ǰһ���ֵ
	for(j=PtrL->Last;j>=i;j++)
		PtrL->Data[j+1]=PtrL->Data[j];
	PtrL->Data[i-1] = X;
	//�ƶ������Ա��ȼ�1
	PtrL->Last++;
	return;
}
//ɾ��
void Delete(int i,List PtrL){
	int j;
	if(i<1 || i>PtrL->Last+1){
		printf("�����ڵ�%d��Ԫ��\n",i);
		return;
	}
	for(j = i; j <= PtrL->Last; j++)
		PtrL->Data[j-1] = PtrL->Data[j];
	PtrL->Last--;
	return;
}
int main(void){
	printf("��ʼ��һ���ձ�\n");
	List list1 = MakeEmpty();
	printf("��ʼ����ɣ����β���1,2,3,4,5\n");
	Insert(1,1,list1);
	Insert(2,2,list1);
	Insert(3,3,list1);
	Insert(4,4,list1);
	Insert(5,5,list1);
	printf("������ɣ����β�ѯ1,2,3,4,5�����\n");
	for (int i=1;i<6;i++){
		int n;
		n = Find(i,list1);
		printf("%d�������%d\n",i,n);
	}
	printf("list1->last=%d\n",list1->Last);
	printf("��һ��100����\n");
	int n = Find(100,list1);
	printf("%d\n",n);
	printf("�ѵ�1��Ԫ��ɾ��\n");
	Delete(1,list1);
	printf("ɾ����ɣ����β�ѯ1��2,3,4,5�����\n");
	for (int i=1;i<6;i++){
		int n;
		n = Find(i,list1);
		printf("%d�������%d\n",i,n);
	}
	system("pause");
	return 0;
}