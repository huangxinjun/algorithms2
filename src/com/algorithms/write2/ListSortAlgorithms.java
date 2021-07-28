package com.algorithms.write2;

import com.algorithms.sort.ListNode;

/**
 * @Description : TODO
 * @Author : 黄信俊
 * @Date : 7/26/21 11:20 AM
 * @Version : 1.0
 **/
public class ListSortAlgorithms {

	//快速排序
    public static void quickSort(ListNode begin, ListNode end){
        if(begin == null || begin == end)
            return;
        ListNode index = paration(begin, end);
        quickSort(begin, index);
        quickSort(index.next, end);
    }

    /**
     * 划分函数，以头结点值为基准元素进行划分
     * @param begin
     * @param end
     * @return
     */
    public static ListNode paration(ListNode begin, ListNode end){
        if(begin == null || begin == end)
            return begin;
        int val = begin.val;  //基准元素
        ListNode index = begin, cur = begin.next;
        while(cur != end){
            if(cur.val < val){  //交换
                index = index.next;
                int tmp = cur.val;
                cur.val = index.val;
                index.val = tmp;
            }
            cur = cur.next;
        }
        begin.val = index.val;
        index.val = val;
        return index;
    }

  //归并排序
    public static ListNode mergeSort(ListNode head){
        if(head == null || head.next == null)  //空链表或者只有单个结点
            return head;
        ListNode slow = head, fast = head.next;
        while(fast != null && fast.next != null){  //使用快慢指针寻找中间 结点
            slow = slow.next;
            fast = fast.next;
            if(fast.next != null)
                fast = fast.next;
        }
        ListNode ptr1 = slow.next;
        slow.next = null;
        ListNode tmp1 = mergeSort(head);
        ListNode tmp2 = mergeSort(ptr1);
        return merge(tmp1, tmp2);
    }


    public static ListNode merge(ListNode start1,  ListNode start2){
        ListNode header = new ListNode(-1);
        ListNode pre = header;
        ListNode ptr1 = start1, ptr2 = start2;
        while(ptr1 != null && ptr2 != null){
            if(ptr1.val <= ptr2.val){
                pre.next = ptr1;
                pre = ptr1;
                ptr1 = ptr1.next;
            }else{
                pre.next = ptr2;
                pre = ptr2;
                ptr2 = ptr2.next;
            }
        }
        while(ptr1 != null){
            pre.next = ptr1;
            pre = ptr1;
            ptr1 = ptr1.next;
        }
        while(ptr2 != null){
            pre.next = ptr2;
            pre = ptr2;
            ptr2 = ptr2.next;
        }
        return header.next;

    }
    
  //冒泡排序
    public static ListNode bubbleSort(ListNode head){
        if(head == null || head.next == null)  //链表为空或者仅有单个结点
            return head;
        ListNode cur = null, tail = null;
        cur = head;
        while(cur.next != tail){
            while(cur.next != tail){
                if(cur.val > cur.next.val){
                    int tmp = cur.val;
                    cur.val = cur.next.val;
                    cur.next.val = tmp;
                }
                cur = cur.next;
            }
            tail = cur;  //下一次遍历的尾结点是当前结点(仔细琢磨一下里面的道道)
            cur = head;     //遍历起始结点重置为头结点
        }
        return head;
    }
    
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
    
    private ListNode endOfFirstHalf(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}
