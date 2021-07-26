package com.algorithms.write2;

import com.algorithms.sort.Node;

import java.util.*;

/**
 * @Description : TODO
 * @Author : 黄信俊
 * @Date : 7/26/21 5:25 PM
 * @Version : 1.0
 **/
public class TreeSearchAlgorithms {

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
        System.out.println();
        inOrder(n);
        System.out.println();
        postOrder(n);
        System.out.println();
        levelScan(n);
        System.out.println();
        preOrder2(n);
        System.out.println();
        inOrder2(n);
        System.out.println();
        postOrder2(n);
        System.out.println();
    }

    //前序-递归
    public static void preOrder(Node node){
        //根-》左-》右
        System.out.print(node.val);
        if(node.left!=null){
            preOrder(node.left);
        }
        if(node.right!=null){
            preOrder(node.right);
        }
    }

    //中序-递归
    public static void inOrder(Node node){
        //左-》根-》右
        if(node.left!=null){
            inOrder(node.left);
        }
        System.out.print(node.val);
        if(node.right!=null){
            inOrder(node.right);
        }
    }

    //后序-递归
    public static void postOrder(Node node){
        //左-》右-》根
        if(node.left!=null){
            postOrder(node.left);
        }
        if(node.right!=null){
            postOrder(node.right);
        }
        System.out.print(node.val);
    }

    //BFS-层次遍历
    //出队列则打印，出队列则队列依次装左和右
    public static void levelScan(Node node){
        Queue<Node> queue=new LinkedList<Node>();
        queue.add(node);
        while(!queue.isEmpty()){
            node=queue.poll();
            System.out.print(node.val);
            if(node.left!=null){
                queue.add(node.left);
            }
            if(node.right!=null){
                queue.add(node.right);
            }

        }
    }

    //前序-非递归
    public static void preOrder2(Node node){
        Stack<Node> stack=new Stack<Node>();
        while(node!=null || !stack.isEmpty()){
            if(node!=null){
                stack.push(node);
                System.out.print(node.val);
                node=node.left;
            }else{
                node=stack.pop();
                node=node.right;
            }
        }
    }

    //中序-非递归
    public static void inOrder2(Node node){
        Stack<Node> stack=new Stack<Node>();
        while(node!=null||!stack.isEmpty()){
            if(node!=null){
                stack.push(node);
                node=node.left;
            }else{
                node=stack.pop();
                System.out.print(node.val);
                node=node.right;
            }
        }
    }

    //后序-非递归,先装右，后装左
    public static void postOrder2(Node node){
        Stack<Node> stack=new Stack<Node>();
        Stack<Node> output=new Stack<Node>();
        while(node!=null||!stack.isEmpty()){
            if(node!=null){
                stack.push(node);
                output.push(node);
                node=node.right;
            }else{
                node=stack.pop();
                node=node.left;
            }

        }
        while(output.size()>0){
            System.out.print(output.pop().val);
        }
    }

}
