package com.第一节线程知识简介_实现Runnable接口;

//不共享代码，也不共享数据
public class ThreadTestA {
	public static void main(String[] args) {//用两个类创建两个线程对象
		Thread t1=new MyThreadA();
		Thread t2=new Thread(new MyRunnableA());
		t1.setName("Thread-01");//设置线程对象的名称
		t2.setName("Thread-02");
		t1.setPriority(5);//设置线程的优先级
		t2.setPriority(5);//设置线程的优先级
		t2.setDaemon(true);//设置t2线程为守护线程
		t1.start();
		t2.start();
	}
}

//定义了继承自Thread类的MyThread类
class MyThreadA extends Thread{
	public void run(){
		//判断当前线程对象是否是当前正在执行的线程对象
		System.out.println("当前线程对象"+((this==Thread.currentThread()?"是":"不是")+"正在执行的线程对象"));
		for(int i=1;i<=20;i++){
			System.out.println(Thread.currentThread().getName()+":I="+i);
			if(i%5==0){
				Thread.yield();//当i是5的倍数时让步
			}
			//这里写一个空的循环来占用CPU做测试
//			for(int j=0;j<1000000;j++){
//				;
//			}
//			try{
//				Thread.sleep(500);//睡眠
//			}catch(InterruptedException e){
//				e.printStackTrace();
//			}
		}
	}
}

//类MyRunnableA实现了Runnable接口
class MyRunnableA implements Runnable{
	public void run(){
		char c='A';
		while(c<='Z'){
			System.out.println(Thread.currentThread().getName()+":II="+c);
			c++;
			for(int j=0;j<1000;j++){
				;
			}
		}
	}
}