package entity;

/**
 * Created by Intellij IEDA.
 * DATE : 2014/7/23
 * TIME : 23:54
 * AUTHOR : Allen.Xue
 * E-MAIL : xuezy90@gmail.com
 */
public class DoubleLinkedList {
     public DoubleLinkedList next = null;
     public DoubleLinkedList pref = null;
     public int key;
     public int val;
     public DoubleLinkedList(int k,int v)
     {
         this.key = k;
         this.val = v;
         next = null;
         pref = null;
     }
}
