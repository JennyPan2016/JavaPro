import java.awt.Color;
import java.awt.Graphics;


public class Snake {
	Node head;
	Node tail;
	int size = 0;
	
	public Snake(){
		
	}
	
	
	
	private class Node{   //内部类，蛇的每一节
		int row, col;
		int height = Yard.BLOCK_SIZE;
		int width = Yard.BLOCK_SIZE;
		
		private Node(int row, int col){  //构造方法
			this.row = row;
			this.col = col;			
		}
		
		void draw (Graphics g){  //画出蛇的每一节
			Color c = g.getColor();
			g.setColor(Color.WHITE);
			g.fillRect(Yard.BLOCK_SIZE * row, Yard.BLOCK_SIZE * col, width, height);
			g.setColor(c);
		}
	}
}
