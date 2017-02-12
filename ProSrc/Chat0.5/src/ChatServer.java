import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ChatServer extends Frame {
	TextField stfTxt = new TextField(); // 对话输入框
	static TextArea staContent = new TextArea(); // 显示框
	
	public static void main(String[] args) {
		
		try {
			
			ServerSocket ss = new ServerSocket(9988);
			new ChatServer().ServlaunchFrame();
			while (true) {
				Socket s = ss.accept();
				
				DataInputStream dis = new DataInputStream(s.getInputStream());
				System.out.println("Client said:" + dis.readUTF()); // 显示Client端发送的数据
				
				staContent.setText( dis.readUTF());
			} 
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
	public void ServlaunchFrame() {
		setLocation(300, 300);
		setSize(300, 200);
		add(stfTxt, BorderLayout.SOUTH);
		add(staContent, BorderLayout.NORTH);
		pack();
		addWindowListener(new WindowAdapter() { // 添加内部类_关闭窗口响应
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0); // 0是正常退出
			}
		});
		stfTxt.addActionListener(new TFListener2());
		setVisible(true);
	}
	private class TFListener2 implements ActionListener { // 为TextField添加监听
		@Override
		public void actionPerformed(ActionEvent e) {
			String str2 = staContent.getText().trim(); // trim用来去掉字符串两端的空格
			staContent.setText(str2); // 显示框显示,显示框不需要额外添加监听了。
			stfTxt.setText(""); // 输入框回车后会清空里面的内容				
		}

	}
}
