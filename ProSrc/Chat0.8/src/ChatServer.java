/*
 * Server端添加链接判定符
 * */

import java.awt.Frame;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import org.omg.PortableInterceptor.DISCARDING;

public class ChatServer extends Frame {

	public static void main(String[] args) {
		boolean started = false;
		
		try {			
			ServerSocket ss = new ServerSocket(9989);
			started = true;  //有客户端连接到端口9989时，started置为true
			
			while (started) {  
				boolean connected = false;
				Socket s = ss.accept();
				connected = true;   // 当客户端连接成功时，connceted置为true
				System.out.println("Client Connect!");
				DataInputStream dis = new DataInputStream(s.getInputStream()); //输入流
				
				while(connected){					
					String str = dis.readUTF();
					System.out.println(str);   //打印Client端发送的信息
				}
				
				dis.close();  //关闭输入流				
			} 
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
}
