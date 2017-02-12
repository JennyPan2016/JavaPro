/*
 * 添加对话输入框和显示框
 * */


import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.TextArea;
import java.awt.TextField;


public class ChatClient extends Frame{
	
	//作为成员变量，方便后面访问
	TextField tfTxt = new TextField(1);  //对话输入框
	TextArea taContent = new TextArea(500,200);  //显示框
	
	public static void main(String[] args){
		new ChatClient().launchFrame();
		
	}
	
	public void launchFrame(){
		setLocation(300,300);
		setSize(500, 300);
		setVisible(true);		
		add(tfTxt,BorderLayout.SOUTH);
		add(taContent,BorderLayout.NORTH);
	}
}
