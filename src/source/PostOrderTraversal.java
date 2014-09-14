package source;

import entity.CreateTree;
import entity.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Intellij IEDA.
 * DATE : 2014/7/28
 * TIME : 16:52
 * AUTHOR : Allen.Xue
 * E-MAIL : xuezy90@gmail.com
 */
public class PostOrderTraversal {

    List<Integer> postOrder = new ArrayList<Integer>();
    public List<Integer> postorderTraversal(TreeNode root) {
        if(root == null) return postOrder;
        if(root.left != null)
        {
          postorderTraversal(root.left);
        }
        if(root.right != null)
        {
            postorderTraversal(root.right);
        }
        postOrder.add(root.val);
//        System.out.println(postOrder);
        return postOrder;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        PostOrderTraversal pot = new PostOrderTraversal();
        CreateTree.createTree(root);
        pot.postorderTraversal(root);
    }
}
