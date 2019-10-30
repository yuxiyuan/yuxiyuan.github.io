#include <cstdio>
const int maxnum = 100010;
int school[maxnum]={0};
int main(){
	int N,scID,scresult;
	scanf("%d",&N);
	for (int i=0;i<N;i++)
	{
		scanf("%d%d",&scID,&scresult);
		school[scID] += scresult;
	}

	int k=1,max=-1;
	for (int i=1;i<=N;i++)
	{
		if( school[i] > max){
			max = school[i];
			k = i;
		}
	}
	printf("%d %d\n",k,max);
	return 0;
}