package source;

import entity.ListNode;
import tools.LinkedList;

/**
 * Created by Intellij IEDA.
 * DATE : 2014/7/22
 * TIME : 20:17
 * AUTHOR : Allen.Xue
 * E-MAIL : xuezy90@gmail.com
 */
public class SortList {
    public ListNode sortList(ListNode head) {
//        this.printList("ReadyForSort : ",head);
        if(head == null || head.next == null || head.next.next == null) return head;
        ListNode nspeed = head;
        ListNode dspeed = head;
        while(dspeed.next != null && dspeed.next.next!=null)
        {
            nspeed = nspeed.next;
            dspeed = dspeed.next.next;
        }
        ListNode newhead = new ListNode(0);
        newhead.next = nspeed.next;
        nspeed.next = null;
        ListNode temp1 = this.sortList(newhead);
        ListNode temp2 = this.sortList(head);
        return this.mergeSort(temp2,temp1);
    }
    public ListNode mergeSort(ListNode a,ListNode b)
    {
//        this.printList("ReadyForMerge : ",a);
//        this.printList("ReadyForMerge : ",b);
        ListNode temp;
        ListNode p1 = a;
        ListNode p2 = b;
        while(p1.next != null && p2.next != null)
        {
            if(p1.next.val >p2.next.val){
                temp = p2.next.next;
                p2.next.next = p1.next;
                p1.next = p2.next;
                p2.next = temp;
                p1 = p1.next;
            }
            else
                p1 = p1.next;
        }
        if(p1.next != null) p2.next = p1.next;
        if(p2.next != null) p1.next = p2.next;
//        this.printList("MergeRes : ",a);
        return a;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(0);
        ListNode p1 = new ListNode(2);//1
        ListNode p2 = new ListNode(1);//3
        ListNode p3 = new ListNode(2);
        ListNode p4 = new ListNode(7);
        ListNode p5 = new ListNode(5);
        ListNode p6 = new ListNode(6);
        head.next = p1;
        p1.next = p2;
//        p2.next = p3;
//        p3.next = p4;
//        p4.next = p5;
//        p5.next = p6;
        SortList sl = new SortList();
        head = sl.sortList(head);
        LinkedList.printList("result : ", head);
    }
}

