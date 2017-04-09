import java.awt.Frame;


public class ChatClient extends Frame{
	
	public static void main(String[] args){
		new ChatClient().launchFrame();
		
	}
	
	public void launchFrame(){
		setLocation(300,300);
		setSize(500, 300);
		setVisible(true);
	}
}
