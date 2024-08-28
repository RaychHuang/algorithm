package com.anonymouscorgi.karakoram.jiuzhang.sort;

import com.anonymouscorgi.karakoram.base.ListNode;

public class QuickSort {
	
    public ListNode sortList(ListNode head) {
        // write your code here
        if(head == null){
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = quickSort(head);
        head = dummy.next.next;
        dummy.next.next = null;
        
        return head;
    }
    
    private ListNode quickSort(ListNode head){
        if(head == null || head.next == null){
        	head.next = head;
            return head;
        }
        ListNode[] dummy = new ListNode[3], tail = new ListNode[3];
        int[] count = {0, 0, 0};
        
        for(int i = 0; i < 3 ; i++){
        	dummy[i] = new ListNode(0);
        	tail[i] = dummy[i];
        }
        
        ListNode medianNode = head;
        // medianNode = head;?
        while(head != null){
            if(head.val < medianNode.val){
            	tail[0].next = head;
            	tail[0] = tail[0].next;
            	count[0]++;
            }else if(head.val > medianNode.val){
            	tail[2].next = head;
            	tail[2] = tail[2].next;
            	count[2]++;
            }else{
            	tail[1].next = head;
            	tail[1] = tail[1].next;
            	count[1]++;
            }
            head = head.next;
        }
        
        
        ListNode dummyAll = new ListNode(0), tailAll = dummyAll;
        for(int i = 0; i < 3; i++){
        	tail[i].next = null;
        	if(count[i] == 0){
        		continue;
        	}
        	if(i != 1){
        		dummy[i].next = quickSort(dummy[i].next);
        		tailAll.next = dummy[i].next.next;
        		tailAll = dummy[i].next;
        	}else{
        		tailAll.next = dummy[i].next;
        		tailAll = tail[i];
        	}
//        	tailAll.next = null;
        }
        tailAll.next = dummyAll.next;
        return tailAll;
    }

	@SuppressWarnings("unused")
	private ListNode findMedian(ListNode head){
        ListNode slow = head;
        ListNode quick = head.next;
        while(quick != null && quick.next != null){
            slow = slow.next;
            quick = quick.next.next;
        }
        return slow;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {21, 6, 25, 31, 4, 5};
		ListNode head = ListNode.fromIntArray(arr);
		QuickSort one = new QuickSort();
		System.out.println(head.toString());
		head = one.sortList(head);
		System.out.println(head.toString());
	}
}
