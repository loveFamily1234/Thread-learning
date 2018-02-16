package com.第一节线程知识简介_继承Thread类;

//两个线程共享代码，但不共享数据
public class ThreadTestB {
	public static void main(String[] args) {
		//用类MyThreadB创建两个线程对象，并启动
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
			//输出0~19的数字
			System.out.println(getName()+":i="+i);
			try{
				Thread.sleep(200);//线程睡眠200毫秒
			}
			catch(InterruptedException e){
				e.printStackTrace();
			}
		}
	}
}
