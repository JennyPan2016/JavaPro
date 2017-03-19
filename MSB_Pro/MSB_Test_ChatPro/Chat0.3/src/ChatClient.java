/*
 * 添加窗口关闭响应
 * */


import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Frame;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


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
		add(tfTxt,BorderLayout.SOUTH);
		add(taContent,BorderLayout.NORTH);
		pack();
		addWindowListener(new WindowAdapter() {   //添加内部类_关闭窗口响应
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);  //0是正常退出
			}			
		});
		setVisible(true);
	}
	
}

