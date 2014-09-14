package entity;

/**
 * Created by Intellij IEDA.
 * DATE : 2014/7/22
 * TIME : 23:16
 * AUTHOR : Allen.Xue
 * E-MAIL : xuezy90@gmail.com
 */
public class ListNode {
      public int val;
      public int key;
      public ListNode next;
      public ListNode(int x) {
          val = x;
          next = null;
      }
      public ListNode(int k,int v)
      {
          this.key = k;
          this.val = v;
      }
}
