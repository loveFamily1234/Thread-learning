package com.�ڶ���ͬ��_Synchronized;

//�����̹߳������Ҳ�������ݣ�ʹ��synchronizedͬ��
public class ThreadTestC {
	public static void main(String[] args) {
		Thread t1=new MyThreadC();//����MyThreadC�Ķ���t1
		Thread t2=new MyThreadC();//����MyThreadC�Ķ���t2
		Runnable run=new MyRunnableC();
		Thread t3=new Thread(run);//����MyRunnableC�Ķ���t3
		Thread t4=new Thread(run);//����MyRunnableC�Ķ���t4
		t1.setName("Thread-01");//��t1��������
		t2.setName("Thread-02");//��t2��������
		t1.start();
		t2.start();
//		t3.start();
//		t4.start();
	}
}

//MyThreadC�̳�Thread��
class MyThreadC extends Thread{
	static int i=0;
	static Object obj=new Object(); 
	public void run(){//��дrun����
		while(i<20){
			synchronized(obj){//ͬ�������
				i++;
				for(int j=0;j<1000000;j++){
					;
				}
				System.out.println(this.getName()+":i="+i);//���i��ֵ
			}
//			ml();
		}
	}
	
	public synchronized void ml(){//ͬ������ml()
		i++;
		for(int j=0;j<1000000;j++){
			;
		}
		System.out.println(this.getName()+":i="+i);
	}
}

class MyRunnableC implements Runnable{//ʵ��Runnable�ӿ�
	int i=0;
	public void run(){
		while(i<20){
			synchronized(this){//ͬ�������
				i++;
				for(int j=0;j<1000000;j++){
					;
				}
				System.out.println("i="+i);
			}
		}
	}
}
