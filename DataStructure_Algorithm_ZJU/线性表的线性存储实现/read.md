1. malloc()
2. 数组下标i和线性表的第i个元素的关系
3. 初始化算法中
```
PtrL->Last = -1;
```
会带来问题，先初始化再插入后Last的值会比实际值小1，因为插入元素只做了一次自增，空表插入第一个元素时Last就是0，依此类推
4. 查找算法要考虑返回值是数组下标还是元素在线性表中的位置
```
int Find( ElementType X, List PtrL ){ 
    int i = 0;
    while( i <= PtrL->Last && PtrL->Data[i]!= X )
        i++;
    if (i > PtrL->Last) return -1; /*如果没找到，返回-1 */
    else return i; /* 找到后返回的是存储位置 */
}
```
如果返回的是储存位置那就是返回i，如果是元素再线性表中的位置应该返回i+1
5. 删除算法交换元素时
```
for ( j = i; j <= PtrL->Last; j++ )
    PtrL->Data[j-1] = PtrL->Data[j];
```
j为什么要到Ptrl->Last？

因为j到Ptrl->Last-1倒数第二个元素已经被赋了倒数第一个元素，而倒数一个元素却还是原来的，它不该有，所以把PtrL->Data[Ptrl->Last]赋给它，因为数组这个元素没有初始化，还是系统随便给的值
