package com.��һ���߳�֪ʶ���_ʵ��Runnable�ӿ�;

//��������룬Ҳ����������
public class ThreadTestA {
	public static void main(String[] args) {//�������ഴ�������̶߳���
		Thread t1=new MyThreadA();
		Thread t2=new Thread(new MyRunnableA());
		t1.setName("Thread-01");//�����̶߳��������
		t2.setName("Thread-02");
		t1.setPriority(5);//�����̵߳����ȼ�
		t2.setPriority(5);//�����̵߳����ȼ�
		t2.setDaemon(true);//����t2�߳�Ϊ�ػ��߳�
		t1.start();
		t2.start();
	}
}

//�����˼̳���Thread���MyThread��
class MyThreadA extends Thread{
	public void run(){
		//�жϵ�ǰ�̶߳����Ƿ��ǵ�ǰ����ִ�е��̶߳���
		System.out.println("��ǰ�̶߳���"+((this==Thread.currentThread()?"��":"����")+"����ִ�е��̶߳���"));
		for(int i=1;i<=20;i++){
			System.out.println(Thread.currentThread().getName()+":I="+i);
			if(i%5==0){
				Thread.yield();//��i��5�ı���ʱ�ò�
			}
			//����дһ���յ�ѭ����ռ��CPU������
//			for(int j=0;j<1000000;j++){
//				;
//			}
//			try{
//				Thread.sleep(500);//˯��
//			}catch(InterruptedException e){
//				e.printStackTrace();
//			}
		}
	}
}

//��MyRunnableAʵ����Runnable�ӿ�
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