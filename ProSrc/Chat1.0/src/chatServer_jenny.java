/*
 * 使用线程类，可以实现多个Client同时访问Server端
 * */

import java.io.DataInputStream;
import java.io.EOFException;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;


public class chatServer_jenny {
	static int NUM = 0;  //记录线程个数
	
	public static void main(String[] args) {
		boolean started = false;
		ServerSocket ss = null;
		Socket s = null;
		try {
			ss = new ServerSocket(9989);
			started = true; // 有客户端连接到端口9989时，started置为true
			while (started) {
				boolean connected = false;
				s = ss.accept();				
				NUM ++;   
				connected = true;
				System.out.println("Client NO." + NUM + " Connect!");
				
				if (connected){
					ConnRunner cRunner = new ConnRunner(s);
					Thread cThread = new Thread(cRunner,"线程"+ Integer.toString(NUM)); //线程名称=num
					cThread.start();
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}


class ConnRunner implements Runnable {
	Socket s = null;
	DataInputStream dis = null;

	public ConnRunner(Socket s) {  //构造方法用来拿到当前的Socket s
		this.s = s;
	}
	
	@Override
	public void run() {
		try {
			dis = new DataInputStream(s.getInputStream()); // 输入流
			String str = dis.readUTF();
			System.out.println(str); // 打印Client端发送的信息
		} catch (EOFException eof) { // 客户端关闭会引起的EOFException
			System.out.println("Client端连接失败！");
		} catch (Exception e1) { // 捕获到任何异常都进行处理
			e1.printStackTrace();
		} finally {
			try {
				if (dis != null)
					dis.close(); // dis为null,说明dis还没有初始化，所以没有必要close
				if (s != null)
					s.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

}