package com.��һ���߳�֪ʶ���_�̳�Thread��;

//�����̹߳�����룬������������
public class ThreadTestB {
	public static void main(String[] args) {
		//����MyThreadB���������̶߳��󣬲�����
		Thread t1=new MyThreadB1();
		Thread t2=new MyThreadB1();
		t1.start();
		t2.start();
	}
}

class MyThreadB1 extends Thread{
	private int i=0;
	public void run(){
		for(;i<20;i++){
			//���0~19������
			System.out.println(getName()+":i="+i);
			try{
				Thread.sleep(200);//�߳�˯��200����
			}
			catch(InterruptedException e){
				e.printStackTrace();
			}
		}
	}
}
