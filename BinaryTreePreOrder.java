/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 
 /**
 * 解法一：递归
 */
class Solution {
    List<Integer> list = new LinkedList<>();
    public List<Integer> preorderTraversal(TreeNode root) {
        preorder(root,list);
        return list;
    }

    public void preorder(TreeNode node,List<Integer> list){
        if (node == null)
            return;
        list.add(node.val);
        preorder(node.left,list);
        preorder(node.right,list);
    }
}

/**
* 解法二：迭代
*/
class Solution {
    LinkedList<TreeNode> stack = new LinkedList<>();
    LinkedList<Integer> output = new LinkedList<>();
    public List<Integer> preorderTraversal(TreeNode root) {     
        if (root == null) {
            return output;
        }

        stack.add(root);
        
        //压栈时先压右结点，再压左结点，这样放入链表的顺序就是正确的
        while (!stack.isEmpty()) {
            TreeNode node = stack.pollLast();
            output.add(node.val);
            if (node.right != null) {
                stack.add(node.right);
            }
            if (node.left != null) {
                stack.add(node.left);
            }
        }
        return output;
    }
}


/**
* 解法三：莫里斯遍历
*/
//来自官方题解
class Solution {
  public List<Integer> preorderTraversal(TreeNode root) {
    LinkedList<Integer> output = new LinkedList<>();

    TreeNode node = root;
    while (node != null) {
      if (node.left == null) {
        output.add(node.val);
        node = node.right;
      }
      else {
        TreeNode predecessor = node.left;
        while ((predecessor.right != null) && (predecessor.right != node)) {
          predecessor = predecessor.right;
        }

        if (predecessor.right == null) {
          output.add(node.val);
          predecessor.right = node;
          node = node.left;
        }
        else{
          predecessor.right = null;
          node = node.right;
        }
      }
    }
    return output;
  }
}
