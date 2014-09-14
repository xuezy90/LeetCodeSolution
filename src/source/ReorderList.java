package source;

import entity.ListNode;
import tools.LinkedList;

/**
 * Created by Intellij IEDA.
 * DATE : 2014/7/28
 * TIME : 18:47
 * AUTHOR : Allen.Xue
 * E-MAIL : xuezy90@gmail.com
 */
public class ReorderList {

    public void reorderList(ListNode head) {
        if(head == null || head.next == null) return;
        ListNode p1 = head;
        ListNode p2 = head.next;
        while(p2 != null && p2.next != null)
        {
            p1 = p1.next;
            p2 = p2.next.next;
        }
        ListNode newHead = p1.next;
        p1.next = null;
//        LinkedList.printList("head : ",head);
//        LinkedList.printList("newHead : ",newHead);
        newHead = reverseList(newHead);
        mergeList(head,newHead);

    }

    private void mergeList(ListNode head, ListNode newHead) {
//        LinkedList.printList("MergeSort1 : ",head);
//        LinkedList.printList("MergeSort2 : ",newHead);
        ListNode p = head;
        ListNode hh;
        while(newHead != null){
            hh = newHead;
            newHead = hh.next;
            hh.next = p.next;
            p.next = hh;
            p = p.next.next;
        }
//        LinkedList.printList("MergeResult : ",head);
    }

    private ListNode reverseList(ListNode head) {
//        LinkedList.printList("ReadyForReverse : ",head);
        if(head == null || head.next == null) return head;
        ListNode newH = new ListNode(0);
        newH.next = head;
        ListNode p1 = head;
        ListNode p2;
        while(p1.next != null)
        {
            p2 = p1.next;
            p1.next = p2.next;
            p2.next = newH.next;
            newH.next = p2;
        }
//        LinkedList.printList("AfterReverse : ",head);
        return newH.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(3);
        ListNode p1 = new ListNode(2);//1
        ListNode p2 = new ListNode(1);//3
        ListNode p3 = new ListNode(2);
        ListNode p4 = new ListNode(7);
        ListNode p5 = new ListNode(5);
        ListNode p6 = new ListNode(6);
//        head.next = p1;
//        p1.next = p2;
//        p2.next = p3;
//        p3.next = p4;
//        p4.next = p5;
//        p5.next = p6;
        head = null;
        LinkedList.printList("Source : ", head);
        ReorderList sl = new ReorderList();
        sl.reorderList(head);
        LinkedList.printList("result : ", head);
    }
}
