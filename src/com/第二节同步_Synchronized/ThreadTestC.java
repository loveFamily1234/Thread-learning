package com.第二节同步_Synchronized;

//两个线程共享代码也共享数据，使用synchronized同步
public class ThreadTestC {
	public static void main(String[] args) {
		Thread t1=new MyThreadC();//创建MyThreadC的对象t1
		Thread t2=new MyThreadC();//创建MyThreadC的对象t2
		Runnable run=new MyRunnableC();
		Thread t3=new Thread(run);//创建MyRunnableC的对象t3
		Thread t4=new Thread(run);//创建MyRunnableC的对象t4
		t1.setName("Thread-01");//给t1设置名字
		t2.setName("Thread-02");//给t2设置名字
		t1.start();
		t2.start();
//		t3.start();
//		t4.start();
	}
}

//MyThreadC继承Thread类
class MyThreadC extends Thread{
	static int i=0;
	static Object obj=new Object(); 
	public void run(){//重写run方法
		while(i<20){
			synchronized(obj){//同步代码块
				i++;
				for(int j=0;j<1000000;j++){
					;
				}
				System.out.println(this.getName()+":i="+i);//输出i的值
			}
//			ml();
		}
	}
	
	public synchronized void ml(){//同步方法ml()
		i++;
		for(int j=0;j<1000000;j++){
			;
		}
		System.out.println(this.getName()+":i="+i);
	}
}

class MyRunnableC implements Runnable{//实现Runnable接口
	int i=0;
	public void run(){
		while(i<20){
			synchronized(this){//同步代码块
				i++;
				for(int j=0;j<1000000;j++){
					;
				}
				System.out.println("i="+i);
			}
		}
	}
}
