package com.zzu.yuxiyuan.osPractice.singleTask;

import java.nio.channels.AcceptPendingException;
import java.util.Scanner;
import java.util.jar.Pack200;

public class SingleTaskOS {
	
	public static final int N = 10;	//数据存储区的大小
	static int ACC,PC;
	static int Data[] = new int[N];
	
	public static void main(String args[]) {
		
		System.out.println("****** 程序说明 ******\n") ;
		System.out.println("本程序模拟单任务环境下程序的调用。包括四个应用程序：\n" );
		System.out.println("    1.从键盘输入整数x和y的值，计算4x-3y的值。\n" );
		System.out.println("    2.从键盘输入整数x和y的值，计算x*y的值。\n" );
		System.out.println("    3.从键盘输入整数x和y的值，计算x+y/2的值。\n" );
		System.out.println("    4.从键盘输入整数x和y的值，计算x*x+y*y的值。\n" );
		System.out.println("\n****** 程序开始调度 ******\n" );
		
		Schedule();//调度程序
		
		System.out.println("\n****** 程序调度结束 ******\n\n\n" );
		
	}
	
	private static void Schedule() {
		int i;
		
		while(true) {
			
			System.out.println("\n请选择要执行的程序（输入5退出）： " );
			
			Scanner sca = new Scanner(System.in);
			i = sca.nextInt();
			switch (i) {
			case 1:
				p1();
				break;
			case 2:
				p2();
				break;
			case 3:
				p3();
				break;
			case 4:
				p4();
				break;
			case 5:
				return;
			default:
				System.out.println("请输入1-5的整数");
				break;
			}
			
		}
		
	}


	private static void p1() {
		//内存单元初始化
		for(int i=0;i<10;i++)
			Data[i] = 0;
		
		Data[ 0 ] = 3;
	    ACC = 0;
	    System.out.println( "程序1执行开始。\n");
	    PC = 0;
	    while( true ){
	    	
	        switch( PC ){
	        
	        case 0:
	        	System.out.println( "请输入x的值： " ); // 辅助操作
	        	Data[1] = input();
	            break;
	        case 1:
	        	System.out.println( "请输入y的值： " ); // 辅助操作
	        	Data[2] = input();
	            break;
	        case 2:
	            load( Data[1] );
	            break;
	        case 3:
	            sub( Data[2] );
	            break;
	        case 4:
	            multiply( Data[0] );
	            break;
	        case 5:
	            add( Data[1] );
	            break;
	        case 6:
	        	Data[3] = store();
	            break;
	        case 7:
	            System.out.print( "计算结果是：4*x-3y=" ); // 辅助操作
	            print( Data[3] );
	            System.out.println( "\n" );
	            break;
	        case 9:
	            stop( );
	            return;
	        }  // end switch 
	        PC++;
	    } //end while
	}  // end P1


	private static void p2() {
		System.out.println( "程序2执行开始。\n" );
		//初始化内存区
		for(int i = 0;i<10;i++)
			Data[i] = 0;
		
	    PC = 0;
	    while( true )
	    {
	        switch( PC )
	        {
	        case 0:
	        	System.out.println( "请输入x的值： " );  // 辅助操作
	        	Data[0]=input();
	            break;
	        case 1:
	        	System.out.println( "请输入y的值： " );  // 辅助操作
	        	Data[1]=input();
	            break;
	        case 2:
	            load( Data[0] );
	            break;
	        case 3:
	        	multiply(Data[1]);
	            break; 
	        case 4:
	        	Data[2] = store();
	        	break;
	        case 5:
	        	System.out.print( "计算结果是：x*y = " );  
	        	print( Data[2] );
	        	System.out.println( "\n" ); // 辅助操作 
	            break;
	        case 6:
	            stop();
	            return;
	        }  // end switch
	        PC++;
	    }
	} // end P2

	private static void p3() {
		System.out.println( "程序3执行开始。\n" );
		//初始化内存区
		for(int i = 0;i<10;i++)
			Data[i] = 0;
		
		Data[0] = 2;
		PC = 0;
		while( true ){
			
			switch( PC ){
			
				case 0:
					System.out.println( "请输入x的值： " );  // 辅助操作
					Data[1] = input();
			        break;
			    case 1:
			    	System.out.println( "请输入y的值： " );  // 辅助操作
					Data[2] = input();
			        break;
			    case 2:
			        load(Data[2]);
			        break;
			    case 3:
			    	division(Data[0]);
			        break; 
			    case 4:
			    	add(Data[1]);
			        break; 
			    case 5:
			    	Data[3] = store();
			        break;
			    case 6:
			    	System.out.println( "计算结果是：x+y/2= " );  
			    	print( Data[3] );
			        System.out.println( "\n" ); // 辅助操作 
			        break;
			    case 7:
			        stop();
			        return;
			}  // end switch
			
			PC++;
		}//end while
	} // end P3
	private static void p4() {
		System.out.println( "程序4执行开始。\n" );
		//初始化内存区
		for(int i = 0;i<10;i++)
			Data[i] = 0;
		
		PC = 0;
		while( true ){
			
			switch( PC ){
			
				case 0:
					System.out.println( "请输入x的值： " );  // 辅助操作
					Data[0] = input();
			        break;
			    case 1:
			    	System.out.println( "请输入y的值： " );  // 辅助操作
					Data[1] = input();
			        break;
			    case 2:
			        load(Data[0]);
			        break;
			    case 3:
			    	multiply(Data[0]);
			        break; 
			    case 4:
			    	Data[2] = store();
			        break; 
			    case 5:
			    	clearACC();
			        break;
			    case 6:
			    	load(Data[1]);;
			        break;
			    case 7:
			    	multiply(Data[1]);;
			        break;
			    case 8:
			    	add(Data[2]);
			        break;
			    case 9:
			    	Data[2] = store();
			        break;
			    case 10:
			    	System.out.println( "计算结果是：x*x+y*y= " );  
			    	print( Data[2] );
			        System.out.println( "\n" ); // 辅助操作 
			        break;
			    case 11:
			        stop();
			        return;
			}  // end switch
			
			PC++;
		}//end while
	} // end P4

	// 程序执行结束
	private static void stop() {
		System.out.print("程序执行完毕。\n");//辅助操作
	}
	// 将ACC中的数与内存单元中的数相加，结果存到ACC中
	private static void add(int i) {
		ACC  +=  i;		
	}
	// 将ACC中的数与内存单元中的数相加，结果存到ACC中
	private static void sub(int i) {
		ACC -= i;		
	}
	// 将ACC中的数与内存单元中的数相乘，结果存到ACC中
	private static void multiply(int i) {
		ACC *= i;		
	}
	// 将ACC中的数与内存单元中的数相除，结果存到ACC中
	private static void division(int i) {
		ACC /= i;
	}

	// 从内存读数到累加器ACC中
	private static void load(int i) {
		ACC = i;		
	}
	// 从键盘输入一个整数到内存单中
	private static int input() {
		int i;
		Scanner sca = new Scanner(System.in);
		i = sca.nextInt();
		return i;
	}
	// 将内存单元中的数打印输出
	private static void print(int i) {
		System.out.print(""+i);
		
	}
	// 将累加器ACC中的数存到内存中元
	private static int store() {
		int i;
		i = ACC;
		return i;
	}
	// 将累加器ACC清0
	private static void clearACC() {
		ACC = 0;	
	}
}
