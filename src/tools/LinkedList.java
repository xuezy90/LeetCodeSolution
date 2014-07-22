package tools;

import entity.ListNode;

/**
 * Created by Intellij IEDA.
 * DATE : 2014/7/22
 * TIME : 23:14
 * AUTHOR : Allen.Xue
 * E-MAIL : xuezy90@gmail.com
 */
public class LinkedList {
    public static void printList(String s, ListNode head) {
        ListNode p = head;
        System.out.print(s);
        while(p.next != null)
        {
            p = p.next;
            System.out.print(" --> " + p.val);
        }
        System.out.println();
    }
}
