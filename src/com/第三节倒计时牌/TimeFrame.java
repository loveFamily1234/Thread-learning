package com.�����ڵ���ʱ��;

import java.awt.*;
import java.util.*;
import javax.swing.*;
public class TimeFrame {
	private JFrame jf;
	private JLabel label1;
	private JLabel label2;
	public TimeFrame(){
		jf=new JFrame("����ʱ��");
		//label1����ʾ����ʱ����
		label1=new JLabel("���л����񹲺͹�����70���껹�У�");
		label2=new JLabel("");//label2����ʾʣ��ʱ��
		jf.add(label1,BorderLayout.NORTH);
		jf.add(label2,BorderLayout.CENTER);
		//����RefreshTimeThread����t
		Thread t=new RefreshTimeThread(new GregorianCalendar(2019,Calendar.OCTOBER,1,0,0,0));
		t.start();//�����߳�
	}
	
	public void showMe(){//��װ�������ʾ����
		jf.setBounds(200,200,300,150);
		jf.setVisible(true);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args){//������
		new TimeFrame().showMe();
	}
	
	//����RefreshTimeThread�࣬�̳���Thread��
	class RefreshTimeThread extends Thread{
		private Calendar targetTime;
		public RefreshTimeThread(Calendar targetTime){//���췽�������뵹��ʱ��ʱ��
			this.targetTime=targetTime;
		}
		public void run(){//��дrun����
			while(true){
				//����GregorianCalendar�������ڵ�ʱ��
				Calendar todayTime=new GregorianCalendar();
				//����long���͵�seconds����ʾʣ�������
				long seconds=(targetTime.getTimeInMillis()-todayTime.getTimeInMillis())/1000;
				if(seconds<=0){//���ʱ��С��0����˵��ʱ�䵽
					label2.setText("ʱ�䵽��");
					break;
				}
				int day=(int)(seconds/(24*60*60));
				int hour=(int)(seconds/(60*60)%24);
				int min=(int)(seconds/60%60);
				int sec=(int)(seconds%60);
				String str=day+"��"+hour+"ʱ"+min+"��"+sec+"��";
				label2.setText(str);//ˢ��label2�ϵ�ʱ��
				try{
					Thread.sleep(1000);//ÿ��˯1�룬���ʱ��ʱ��ÿ���һ��
				}catch(InterruptedException e){
					e.printStackTrace();
				}
			}
		}
	}
}
