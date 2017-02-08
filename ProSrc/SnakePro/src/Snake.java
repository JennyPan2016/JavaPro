import java.awt.Color;
import java.awt.Graphics;

import javax.xml.bind.annotation.XmlElementDecl.GLOBAL;

import sun.awt.geom.AreaOp.NZWindOp;


public class Snake {
	private Node head = null;  //蛇的头部
	private Node tail = null; //蛇的尾部
	int size = 0; //蛇的长度
	private Yard y;
	
	Node n = new Node(20, 30, Direction.Left);

	public Snake(){
		head = n;
		tail = n;
		size = 1;
	}
	
	public void addToHead() {   //根据蛇不同的运动方法，在不同的位置从蛇头部添加节点
		Node node = null;
		switch(head.dir) {
		case Left :
			node = new Node(head.row, head.col - 1, head.dir);
			break;
		case Up :
			node = new Node(head.row - 1, head.col, head.dir);
			break;
		case Right :
			node = new Node(head.row, head.col + 1, head.dir);
			break;
		case Down :
			node = new Node(head.row + 1, head.col, head.dir);
			break;
		}
		node.nextNode = head;
		head.preNode = node;
		head = node;
		size ++;
	}
	
	
	public void addTotail(){  //根据蛇不同的运动方法，在不同的位置从蛇尾添加节点
		Node node = null;
		
		switch (tail.dir) {
		case Left:
			node = new Node(tail.row, tail.col + 1, tail.dir);
			break;
		case Right:
			node = new Node(tail.row, tail.col - 1, tail.dir);
			break;
		case Up:
			node = new Node(tail.row + 1, tail.col, tail.dir);
			break;	
		case Down:
			node = new Node(tail.row - 1, tail.col, tail.dir);
			break;
		default:
			break;
		}
		node.preNode = tail;
		tail.nextNode = node;
		tail = node;
	}
	
	private void deleteFromTail(){
		if (size == 0) return;
		tail = tail.preNode;
		tail.nextNode = null;
	}
	
	public void move(){
		addToHead();
		deleteFromTail();
		checkDead();
	}
	

	public void draw (Graphics g){ 
		if (size <= 0) return;
		move();
		for (Node node = head; node != null; node = node.nextNode ){ 
			node.draw(g);
		}
	}
	
	private void checkDead() {
		if(head.row < 2 || head.col < 0 || head.row > Yard.ROWS || head.col > Yard.COLS)  {
			y.stop();
		}
		
		for(Node n = head.next; n != null; n = n.next) {
			if(head.row == n.row && head.col == n.col) {
				y.stop();
			}
		}
	}
	
	
	private class Node{   //内部类，蛇的每一节点
		int row, col;
		int height = Yard.BLOCK_SIZE;
		int width = Yard.BLOCK_SIZE;
		Direction dir = Direction.Left;  //蛇的运动方向
		Node nextNode = null;
		Node preNode = null;
		
		Node(int row, int col, Direction dir){  //构造方法
			this.row = row;
			this.col = col;			
			this.dir = dir;
		}
		
		void draw (Graphics g){  //定义方法，用于画出蛇的每一节
			Color c = g.getColor();
			g.setColor(Color.RED);
			g.fillRect(Yard.BLOCK_SIZE * row, Yard.BLOCK_SIZE * col, width, height);
			g.setColor(c);
		}
	}
}
