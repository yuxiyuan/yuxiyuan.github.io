package com.zzu.yuxiyuan.osPractice.singleTask;

import java.nio.channels.AcceptPendingException;
import java.util.Scanner;
import java.util.jar.Pack200;

public class SingleTaskOS {
	
	public static final int N = 10;	//���ݴ洢���Ĵ�С
	static int ACC,PC;
	static int Data[] = new int[N];
	
	public static void main(String args[]) {
		
		System.out.println("****** ����˵�� ******\n") ;
		System.out.println("������ģ�ⵥ���񻷾��³���ĵ��á������ĸ�Ӧ�ó���\n" );
		System.out.println("    1.�Ӽ�����������x��y��ֵ������4x-3y��ֵ��\n" );
		System.out.println("    2.�Ӽ�����������x��y��ֵ������x*y��ֵ��\n" );
		System.out.println("    3.�Ӽ�����������x��y��ֵ������x+y/2��ֵ��\n" );
		System.out.println("    4.�Ӽ�����������x��y��ֵ������x*x+y*y��ֵ��\n" );
		System.out.println("\n****** ����ʼ���� ******\n" );
		
		Schedule();//���ȳ���
		
		System.out.println("\n****** ������Ƚ��� ******\n\n\n" );
		
	}
	
	private static void Schedule() {
		int i;
		
		while(true) {
			
			System.out.println("\n��ѡ��Ҫִ�еĳ�������5�˳����� " );
			
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
				System.out.println("������1-5������");
				break;
			}
			
		}
		
	}


	private static void p1() {
		//�ڴ浥Ԫ��ʼ��
		for(int i=0;i<10;i++)
			Data[i] = 0;
		
		Data[ 0 ] = 3;
	    ACC = 0;
	    System.out.println( "����1ִ�п�ʼ��\n");
	    PC = 0;
	    while( true ){
	    	
	        switch( PC ){
	        
	        case 0:
	        	System.out.println( "������x��ֵ�� " ); // ��������
	        	Data[1] = input();
	            break;
	        case 1:
	        	System.out.println( "������y��ֵ�� " ); // ��������
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
	            System.out.print( "�������ǣ�4*x-3y=" ); // ��������
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
		System.out.println( "����2ִ�п�ʼ��\n" );
		//��ʼ���ڴ���
		for(int i = 0;i<10;i++)
			Data[i] = 0;
		
	    PC = 0;
	    while( true )
	    {
	        switch( PC )
	        {
	        case 0:
	        	System.out.println( "������x��ֵ�� " );  // ��������
	        	Data[0]=input();
	            break;
	        case 1:
	        	System.out.println( "������y��ֵ�� " );  // ��������
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
	        	System.out.print( "�������ǣ�x*y = " );  
	        	print( Data[2] );
	        	System.out.println( "\n" ); // �������� 
	            break;
	        case 6:
	            stop();
	            return;
	        }  // end switch
	        PC++;
	    }
	} // end P2

	private static void p3() {
		System.out.println( "����3ִ�п�ʼ��\n" );
		//��ʼ���ڴ���
		for(int i = 0;i<10;i++)
			Data[i] = 0;
		
		Data[0] = 2;
		PC = 0;
		while( true ){
			
			switch( PC ){
			
				case 0:
					System.out.println( "������x��ֵ�� " );  // ��������
					Data[1] = input();
			        break;
			    case 1:
			    	System.out.println( "������y��ֵ�� " );  // ��������
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
			    	System.out.println( "�������ǣ�x+y/2= " );  
			    	print( Data[3] );
			        System.out.println( "\n" ); // �������� 
			        break;
			    case 7:
			        stop();
			        return;
			}  // end switch
			
			PC++;
		}//end while
	} // end P3
	private static void p4() {
		System.out.println( "����4ִ�п�ʼ��\n" );
		//��ʼ���ڴ���
		for(int i = 0;i<10;i++)
			Data[i] = 0;
		
		PC = 0;
		while( true ){
			
			switch( PC ){
			
				case 0:
					System.out.println( "������x��ֵ�� " );  // ��������
					Data[0] = input();
			        break;
			    case 1:
			    	System.out.println( "������y��ֵ�� " );  // ��������
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
			    	System.out.println( "�������ǣ�x*x+y*y= " );  
			    	print( Data[2] );
			        System.out.println( "\n" ); // �������� 
			        break;
			    case 11:
			        stop();
			        return;
			}  // end switch
			
			PC++;
		}//end while
	} // end P4

	// ����ִ�н���
	private static void stop() {
		System.out.print("����ִ����ϡ�\n");//��������
	}
	// ��ACC�е������ڴ浥Ԫ�е�����ӣ�����浽ACC��
	private static void add(int i) {
		ACC  +=  i;		
	}
	// ��ACC�е������ڴ浥Ԫ�е�����ӣ�����浽ACC��
	private static void sub(int i) {
		ACC -= i;		
	}
	// ��ACC�е������ڴ浥Ԫ�е�����ˣ�����浽ACC��
	private static void multiply(int i) {
		ACC *= i;		
	}
	// ��ACC�е������ڴ浥Ԫ�е������������浽ACC��
	private static void division(int i) {
		ACC /= i;
	}

	// ���ڴ�������ۼ���ACC��
	private static void load(int i) {
		ACC = i;		
	}
	// �Ӽ�������һ���������ڴ浥��
	private static int input() {
		int i;
		Scanner sca = new Scanner(System.in);
		i = sca.nextInt();
		return i;
	}
	// ���ڴ浥Ԫ�е�����ӡ���
	private static void print(int i) {
		System.out.print(""+i);
		
	}
	// ���ۼ���ACC�е����浽�ڴ���Ԫ
	private static int store() {
		int i;
		i = ACC;
		return i;
	}
	// ���ۼ���ACC��0
	private static void clearACC() {
		ACC = 0;	
	}
}
