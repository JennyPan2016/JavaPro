import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.WindowAdapter;


public class Yard extends Frame {
	
	public static final int ROWS = 50; //常量字母大写
	public static final int COLS = 50; 
	public static final int BLOCK_SIZE = 10; 
	Snake s = new Snake();
	
	
	public void launch(){   //启动窗口
		this.setLocation(300, 300);  //设置窗口出现的位置
		this.setSize(COLS * BLOCK_SIZE, ROWS * BLOCK_SIZE);  //设置窗口大小
		this.addWindowListener(new WindowAdapter(){} );   //匿名内部类
		this.setVisible(true);
	}
	

	public static void main(String[] args) {  //程序入口
		new Yard().launch();
	}
	
	
	@Override
	public void paint(Graphics g) {   //重写paint方法，画出窗口内部小格
		Color c = g.getColor();  //拿到画笔原始颜色
		g.setColor(Color.GRAY);  //设置窗口背景颜色
		g.fillRect(0,0, COLS * BLOCK_SIZE, ROWS * BLOCK_SIZE);  //设置窗口内部背景的形状、出现的位置和大小
		g.setColor(Color.DARK_GRAY);  //设置窗口内部小格颜色
		
		//画出窗口内部横线
		for (int i=1; i<ROWS; i++){   
			g.drawLine(0, BLOCK_SIZE * i, COLS * BLOCK_SIZE, BLOCK_SIZE * i);
		}
		for (int i=1; i<COLS; i++){   
			g.drawLine(BLOCK_SIZE * i, 0 ,BLOCK_SIZE * i, ROWS * BLOCK_SIZE);
		}
		
		g.setColor(c);  //恢复画笔原始颜色
		s.draw(g);;
	}

