package com.���Ľ��ҵ�Ѹ��_���߳����ع���;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;
//����д��MyXunlei�Ľ���ͼ�����Ӧ
//������MyXunlei���̳�JFrame�࣬ʵ��ActionListener�ӿ�
public class MyXunlei extends JFrame implements ActionListener{
	//���������Ҫ����塢�ı��򡢰�ť������������ѡ���
	/*
	 * �˴�����ʡ�ԣ���ϸ������μ�����Դ����
	 */
	JButton openButton,downLoadButton,stopButton,proxybutton;
	JTextField textField1,textField2;
	JTextArea textArea;
	public MyXunlei(){
		//���������Ĭ��ֵ�����⡢��С��λ�ã���Ӽ��������������ӵ���Ӧ��������
		//����������Ĭ�����ص�ַ����ǩ����ť��proxybutton��nThreadBox�����
		//�������ӵ���������У������ı����������塢���������ԣ����ô�������
		/*
		 * �˴�����ʡ�ԣ���ϸ������μ�����Դ����
		 */
	}
	//��дactionPerformed������Ϊÿ����ť����ѡ�������Ӧ
	public void actionPerformed(ActionEvent e){
		if(e.getSource()==openButton){//�������򿪡���ťʱ����ʾ�ļ�ѡ��Ի���
			JFileChooser fc=new JFileChooser();
			if(fc.showSaveDialog(this)==fc.APPROVE_OPTION){
				File f=fc.getSelectedFile();
				textField2.setText(f.getAbsolutePath());
			}
		}
		if(e.getSource()==downLoadButton){//���������ء���ťʱ����ʼ���أ������ַ�ͱ���·��Ϊ�գ�������ʾ
			String URL=textField1.getText();
			String saveURL=textField2.getText();
			if(URL.compareTo("")==0&&saveURL.compareTo("")==0){
				textArea.setText("������Ҫ���ص��ļ��ͱ����ļ�������ַ");
			}else {
				try{
					downFile=new DownLoadFile(URL,saveURL,textArea,nTread,jProgressBar);
					downFile.start();
					textArea.append("���߳�����......");
				}catch(Exception ex){
					ex.printStackTrace();
				}
			}
		}
		if(e.getSource()==nThreadBox){//���ѡ���߳������ı䵱ǰ���߳���
			String item=nThreadBox.getSelectedItem().toString();
			System.out.println("item is:"+item);
			nTread=Integer.parseInt(item);
		}
		if(e.getSource()==stopButton){//���������ֹͣ����ť��ֹͣ����
			downFile.stop();
			textArea.append("\nֹͣ���أ���");
		}
		if(e.getSource()==proxybutton){//ѡ���ȡ�����������
			if(proxybutton.isSelected()){
				textArea.append("\n�������ѡ��");
				Point point=this.getLocation();
				int x=this.getHeight()/2+point.x;
				int y=this.getWidth()/2+point.y;
				ProxyPanel proxypanel=new ProxyPanel(x,y);
			}else{
				textArea.append("\nȡ���������");
				System.getProperties().clear();
			}
		}
	}
	public static void main(String[] args){
		MyXunlei download=new MyXunlei();//����MyXunlei�������г���
	}
}
