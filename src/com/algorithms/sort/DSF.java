package com.algorithms.sort;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class DSF {

	public static void main(String[] args) {
		Node n=new Node();
		n.val=1;
		Node n1=new Node();
		n1.val=2;
		Node n2=new Node();
		n2.val=3;
		Node n3=new Node();
		n3.val=4;
		Node n4=new Node();
		n4.val=5;
		n.left=n1;
		n.right=n2;
		n1.left=n3;
		n1.right=n4;
		preOrder(n);
		inOrder(n);
		postOrder(n);
		levelScan(n);
	}
	
//	先往栈中压入右节点，再压左节点，这样出栈就是先左节点后右节点了。
//	首先将A节点压入栈中，stack（A）;
//	将A节点弹出，同时将A的子节点C，B压入栈中，此时B在栈的顶部，stack(B,C)；
//	将B节点弹出，同时将B的子节点E，D压入栈中，此时D在栈的顶部，stack（D,E,C）；
//	将D节点弹出，没有子节点压入,此时E在栈的顶部，stack（E，C）；
//	将E节点弹出，同时将E的子节点I压入，stack（I,C）；
	public static void preOrder(Node root) {
		Stack<Node> s = new Stack<Node>();
		Node p = root;
		while (p != null || !s.empty()) {
			if(p != null){//进栈都找左接着装，无左即出栈，出栈都找右
				System.out.print(p.val);
				s.push(p);
				p = p.left;
			}else{
				p = s.pop();
				p = p.right;
			}
		}
	}
	
	//跟前序遍历方法一思路一样，不同的只是先不打印根节点，而是先访问左子树，再打印根节点，访问右子树。
	public static void inOrder(Node root) {
	      Stack<Node> s = new Stack<Node>();
	      Node p = root;
	      while(p != null || !s.empty()) {
	    	  if(p != null) {
					s.push(p);
					p = p.left;
				}else{
					p = s.pop();
					System.out.print(p.val);
					p=p.right;
				}
	     }
	      
	}
	
	//常规遍历左右根，和前序、中序方法一类似。
	public static void postOrder(Node root) {
		
		Stack<Node> stack = new Stack<Node>();
		Stack<Node> output = new Stack<Node>();//构造一个中间栈来存储逆后续遍历的结果
		Node p = root;
		while(p != null || !stack.empty()){
			if(p != null){
				output.push(p);
				stack.push(p);
				p = p.right;
			}else{
				p = stack.pop();
				p = p.left;
			}
		}
		
		while(output.size()>0){
			System.out.print(output.pop().val);
		}
	}
	
//	先往队列中插入左节点，再插右节点，这样出队就是先左节点后右节点了。
//	　　广度优先遍历树，需要用到队列（Queue）来存储节点对象,队列的特点就是先进先出。例如，上面这颗树的访问如下：
//
//	　　首先将A节点插入队列中，队列中有元素（A）;
//
//	　　将A节点弹出，同时将A节点的左、右节点依次插入队列，B在队首，C在队尾，（B，C），此时得到A节点；
//
//	　　继续弹出队首元素，即弹出B，并将B的左、右节点插入队列，C在队首，E在队尾（C,D，E），此时得到B节点；
//
//	　　继续弹出，即弹出C，并将C节点的左、中、右节点依次插入队列，（D,E,F,G,H），此时得到C节点；
//
//	　　将D弹出，此时D没有子节点，队列中元素为（E,F,G,H），得到D节点；
	public static void levelScan(Node node){
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        while (!queue.isEmpty()){
        	Node p = queue.poll();
            System.out.print(p.val);
            if (p.left != null){//如果左孩子不为空，加入队列
                queue.add(p.left);
            }
            if (p.right != null){//如果哟孩子不为空，加入队列
                queue.add(p.right);
            }

        }
    }

}
