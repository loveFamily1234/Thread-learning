package com.第四节我的迅雷_多线程下载工具;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;
//本类写了MyXunlei的界面和监听响应
//定义类MyXunlei，继承JFrame类，实现ActionListener接口
public class MyXunlei extends JFrame implements ActionListener{
	//定义界面需要的面板、文本框、按钮、进度条、复选框等
	/*
	 * 此处代码省略，详细代码请参见光盘源代码
	 */
	JButton openButton,downLoadButton,stopButton,proxybutton;
	JTextField textField1,textField2;
	JTextArea textArea;
	public MyXunlei(){
		//定义组件的默认值，标题、大小、位置，添加监听，并将组件添加到相应的容器中
		//创建和设置默认下载地址、标签、按钮、proxybutton、nThreadBox等组件
		//将组件添加到面板容器中，设置文本区、滚动体、进度条属性，设置窗体属性
		/*
		 * 此处代码省略，详细代码请参见光盘源代码
		 */
	}
	//重写actionPerformed方法，为每个按钮、复选框添加响应
	public void actionPerformed(ActionEvent e){
		if(e.getSource()==openButton){//单击“打开”按钮时，显示文件选择对话框
			JFileChooser fc=new JFileChooser();
			if(fc.showSaveDialog(this)==fc.APPROVE_OPTION){
				File f=fc.getSelectedFile();
				textField2.setText(f.getAbsolutePath());
			}
		}
		if(e.getSource()==downLoadButton){//单击“下载”按钮时，开始下载，如果地址和保存路径为空，给出提示
			String URL=textField1.getText();
			String saveURL=textField2.getText();
			if(URL.compareTo("")==0&&saveURL.compareTo("")==0){
				textArea.setText("请输入要下载的文件和保存文件完整地址");
			}else {
				try{
					downFile=new DownLoadFile(URL,saveURL,textArea,nTread,jProgressBar);
					downFile.start();
					textArea.append("主线程启动......");
				}catch(Exception ex){
					ex.printStackTrace();
				}
			}
		}
		if(e.getSource()==nThreadBox){//如果选择线程数，改变当前的线程数
			String item=nThreadBox.getSelectedItem().toString();
			System.out.println("item is:"+item);
			nTread=Integer.parseInt(item);
		}
		if(e.getSource()==stopButton){//如果单击“停止”按钮，停止下载
			downFile.stop();
			textArea.append("\n停止下载！！");
		}
		if(e.getSource()==proxybutton){//选择或取消代理服务器
			if(proxybutton.isSelected()){
				textArea.append("\n代理服务被选择");
				Point point=this.getLocation();
				int x=this.getHeight()/2+point.x;
				int y=this.getWidth()/2+point.y;
				ProxyPanel proxypanel=new ProxyPanel(x,y);
			}else{
				textArea.append("\n取消代理服务");
				System.getProperties().clear();
			}
		}
	}
	public static void main(String[] args){
		MyXunlei download=new MyXunlei();//创建MyXunlei对象，运行程序
	}
}
