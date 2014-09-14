package tools;

import com.sun.org.apache.xpath.internal.SourceTree;
import entity.DoubleLinkedList;
import entity.ListNode;
import entity.RandomListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Intellij IEDA.
 * DATE : 2014/7/22
 * TIME : 23:14
 * AUTHOR : Allen.Xue
 * E-MAIL : xuezy90@gmail.com
 */
public class LinkedList {
    static Set<ListNode> old = new HashSet<ListNode>();
    static Set<RandomListNode> old1 = new HashSet<RandomListNode>();
    public static void printList(String s, ListNode head) {
        ListNode p = head;
        System.out.print(s);
        if(head == null) {
            System.out.println("NULL");
            return;
        }
        while(p.next != null && !old.contains(p))
        {
            old.add(p);
            System.out.print(" --> " + p.val);
            p = p.next;
        }
        if(p.next != null) System.out.print(" --> Cycle happened ");
        System.out.print(" --> " + p.val);
        System.out.println();
    }

    public static void printList(String s, RandomListNode head) {
        RandomListNode p = head;
        System.out.print(s);
        if(head == null) {
            System.out.println("NULL");
            return;
        }
        while(p.next != null)
        {
            old1.add(p);
//            System.out.println(p.random == null? "NULL":p.random.label);
            System.out.print(" --> " + p.label +" , "+ (p.random == null? "NULL":p.random.label));
            p = p.next;
        }
        if(p.next != null) System.out.print(" --> Cycle happened ");
        System.out.print(" --> " + p.label +" , "+ (p.random == null? "NULL":p.random.label));
        System.out.println();
    }

    public static void printList(String s, DoubleLinkedList head) {
        DoubleLinkedList p = head;
        System.out.print(s);
        while(p.next != null)
        {
            p = p.next;
            System.out.print(" --> " + p.val);
        }
        System.out.println();
    }
}
