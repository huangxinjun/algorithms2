package com.algorithms.sort;

import java.util.Stack;

public class DSF2 {

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
	}
	
	//先序遍历
	public static void preOrder(Node root){
		System.out.print(root.val);
		if(root.left != null){//使用递归遍历左孩子
			preOrder(root.left);
		}
		if(root.right != null){//使用递归遍历右孩子
			preOrder(root.right);
		}
	}
	
	
	//中序遍历
	public static void inOrder(Node root){
		if(root.left != null){//使用递归遍历左孩子
			inOrder(root.left);
		}
		System.out.print(root.val);
		if(root.right != null){//使用递归遍历右孩子
			inOrder(root.right);
		}
	}
	
	
	//后续遍历
	public static void postOrder(Node root){
		if(root.left != null){//使用递归遍历左孩子
			postOrder(root.left);
		}
		if(root.right != null){//使用递归遍历右孩子
			postOrder(root.right);
		}
		System.out.print(root.val);
	}


}
