/*
 * 添加getMessage方法接收Server端发送的信息
 * */

import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class ChatClient_jenny extends Frame {

	// 作为成员变量，方便后面访问
	private TextField tfTxt = new TextField(); // 对话输入框
	private TextArea taContent = new TextArea(); // 显示框
	private Socket s = null; 
	private DataOutputStream dos = null;
	private DataInputStream dis = null;
	boolean c = false;
	
	public static void main(String[] args) {
		new ChatClient_jenny().launchFrame();	
		
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
				disConnectToServer();  //先关闭TCP连接
				System.exit(0);  //0是正常退出
				
			}			
		});
		tfTxt.addActionListener(new TFListener());   //不要另外自己添加keyListener,直接使用TextField已经实现的方法addActionListener，实现ActionListener接口即可
		setVisible(true);
		connectToServer();  //启动窗口时立即连接到Server端
		c = true;
		while(c){   //死循环，一直保持接收Server端信息状态
			getMessage();
		}
		
		
	}

	public void connectToServer(){  //连接到Server端
		try {
			s = new Socket("127.0.0.1", 9989);
			System.out.println("Connect Success!");
			dos = new DataOutputStream(s.getOutputStream());	//记得在这个地方初始化dos	
			dis = new DataInputStream(s.getInputStream());
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void disConnectToServer(){  //窗口关闭的时候回调用此方法
		try {
			dos.close();
			dis.close();
			s.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	 
	public void getMessage(){   //接收Server信息
		try {
			String str = dis.readUTF();
			if (str != null){
				System.out.println(str);
				taContent.setText(str);  //接收到的信息显示在文本框中
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private class TFListener implements ActionListener{   //为TextField添加监听

		public void actionPerformed(ActionEvent e) {
			String str = tfTxt.getText().trim(); //trim用来去掉字符串两端的空格
			taContent.setText(str);  //显示框显示,显示框不需要额外添加监听了。
			tfTxt.setText("");  //输入框回车后会清空里面的内容
			try {
				dos.writeUTF(str);    //给Server端发送一句话
				dos.flush();
			} catch (IOException e1) {
				e1.printStackTrace();
			}			
		}
	}

	
}
