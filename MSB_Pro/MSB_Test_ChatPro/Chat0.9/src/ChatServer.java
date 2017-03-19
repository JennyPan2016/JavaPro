/*
 * Server端添加异常捕获
 * */

import java.awt.Frame;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import org.omg.PortableInterceptor.DISCARDING;

public class ChatServer extends Frame {

	public static void main(String[] args) {
		boolean started = false;
		ServerSocket ss = null;
		Socket s = null;
		DataInputStream  dis = null;
		
		try {			
			ss = new ServerSocket(9989);
			started = true;  //有客户端连接到端口9989时，started置为true
			
			while (started) {  
				boolean connected = false;
				s = ss.accept();
				connected = true;   // 当客户端连接成功时，connceted置为true
				System.out.println("Client Connect!");
				dis = new DataInputStream(s.getInputStream()); //输入流
				
				while(connected){					
					String str = dis.readUTF();
					System.out.println(str);   //打印Client端发送的信息
				}				
				//dis.close();  //关闭输入流				
			} 
		}catch(EOFException eof){  //客户端关闭会引起的EOFException
			System.out.println("Client端连接失败！");			
		}catch (Exception e1) {  //捕获到任何异常都进行处理
			e1.printStackTrace();
		}finally{			
				try {
					if(dis != null) dis.close();  //dis为null,说明dis还没有初始化，所以没有必要close
					if(s != null)  s.close();	
				} catch (IOException e) {
					e.printStackTrace();
				}
			
		}
	}
}
