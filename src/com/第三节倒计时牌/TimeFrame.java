package com.第三节倒计时牌;

import java.awt.*;
import java.util.*;
import javax.swing.*;
public class TimeFrame {
	private JFrame jf;
	private JLabel label1;
	private JLabel label2;
	public TimeFrame(){
		jf=new JFrame("倒计时牌");
		//label1上提示倒计时内容
		label1=new JLabel("距中华人民共和国成立70周年还有：");
		label2=new JLabel("");//label2中显示剩余时间
		jf.add(label1,BorderLayout.NORTH);
		jf.add(label2,BorderLayout.CENTER);
		//创建RefreshTimeThread对象t
		Thread t=new RefreshTimeThread(new GregorianCalendar(2019,Calendar.OCTOBER,1,0,0,0));
		t.start();//启动线程
	}
	
	public void showMe(){//封装窗体的显示方法
		jf.setBounds(200,200,300,150);
		jf.setVisible(true);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args){//主方法
		new TimeFrame().showMe();
	}
	
	//定义RefreshTimeThread类，继承自Thread类
	class RefreshTimeThread extends Thread{
		private Calendar targetTime;
		public RefreshTimeThread(Calendar targetTime){//构造方法，传入倒计时的时间
			this.targetTime=targetTime;
		}
		public void run(){//重写run方法
			while(true){
				//创建GregorianCalendar对象即现在的时间
				Calendar todayTime=new GregorianCalendar();
				//定义long类型的seconds，表示剩余的秒数
				long seconds=(targetTime.getTimeInMillis()-todayTime.getTimeInMillis())/1000;
				if(seconds<=0){//如果时间小于0，则说明时间到
					label2.setText("时间到！");
					break;
				}
				int day=(int)(seconds/(24*60*60));
				int hour=(int)(seconds/(60*60)%24);
				int min=(int)(seconds/60%60);
				int sec=(int)(seconds%60);
				String str=day+"天"+hour+"时"+min+"分"+sec+"秒";
				label2.setText(str);//刷新label2上的时间
				try{
					Thread.sleep(1000);//每次睡1秒，则计时牌时间每秒变一次
				}catch(InterruptedException e){
					e.printStackTrace();
				}
			}
		}
	}
}
