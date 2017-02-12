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
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

public class ChatClient extends Frame {

	// 作为成员变量，方便后面访问
	static TextField tfTxt = new TextField(); // 对话输入框
	TextArea taContent = new TextArea(); // 显示框

	public static void main(String[] args) {
		
		try {
			Socket s = new Socket("127.0.0.1", 9988);
			System.out.println("Connect Server Success!");
			new ChatClient().launchFrame();
			DataOutputStream dos = new DataOutputStream(s.getOutputStream());
			dos.writeUTF(tfTxt.getText());
		} catch (UnknownHostException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}	

	}

	public void launchFrame(){
		setLocation(300,300);
		setSize(300, 200);
		add(tfTxt,BorderLayout.SOUTH);
		add(taContent,BorderLayout.NORTH);
		pack();
		
		addWindowListener(new WindowAdapter() {   //添加内部类_关闭窗口响应
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);  //0是正常退出
			}			
		});
		
		tfTxt.addActionListener(new TFListener()) ;  //不要另外自己添加keyListener,直接使用TextField已经实现的方法addActionListener，实现ActionListener接口即可

		
		
		setVisible(true);
	}
	
	private class TFListener implements ActionListener{   //为TextField添加监听
		@Override
		public void actionPerformed(ActionEvent e) {
			String str = tfTxt.getText().trim(); //trim用来去掉字符串两端的空格
			taContent.setText(str);  //显示框显示,显示框不需要额外添加监听了。
			tfTxt.setText("");  //输入框回车后会清空里面的内容
		}
		
	}
}
