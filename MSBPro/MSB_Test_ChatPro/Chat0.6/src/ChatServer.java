/*
 * Server端启动
 * */

import java.awt.Frame;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ChatServer extends Frame {

	public static void main(String[] args) {
		
		try {			
			ServerSocket ss = new ServerSocket(9989);
			while (true) {
				Socket s = ss.accept();
				System.out.println("Client Connect!");
			} 
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
}
