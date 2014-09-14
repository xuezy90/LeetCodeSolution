package entity;

/**
 * Created by Intellij IEDA.
 * DATE : 2014/7/28
 * TIME : 17:27
 * AUTHOR : Allen.Xue
 * E-MAIL : xuezy90@gmail.com
 */
public class CreateTree {

   public static TreeNode createTree(TreeNode t)
   {
       TreeNode left = new TreeNode(1);
       TreeNode right = new TreeNode(3);
       t.left = left;
       t.right = right;
       return t;
   }
}
