import java.util.*;

public class LeftLeavesSum {
    public static void main(String args[])
    {
        BinaryTree tree = new BinaryTree();
        tree.root = new TreeNode(20);
        tree.root.left = new TreeNode(9);
        tree.root.right = new TreeNode(49);
        tree.root.left.right = new TreeNode(12);
        tree.root.left.left = new TreeNode(5);
        tree.root.right.left = new TreeNode(23);
        tree.root.right.right = new TreeNode(52);
        tree.root.left.right.right = new TreeNode(12);
        tree.root.right.right.left = new TreeNode(50);

        System.out.println("The sum of leaves is " +
                tree.leftLeavesSum(tree.root));
    }

    // Java program to find sum of all left leaves
    // https://www.geeksforgeeks.org/find-sum-left-leaves-given-binary-tree/
    private static class TreeNode
    {
        int value;
        TreeNode left, right;

        TreeNode(int value)
        {
            this.value = value;
            left = right = null;
        }
    }

    static class BinaryTree
    {
        TreeNode root;

        boolean isLeaf(TreeNode node)
        {
            if (node == null)
                return false;
            if (node.left == null && node.right == null)
                return true;
            return false;
        }

        // Uses preorderTraversal
        int leftLeavesSum(TreeNode node)
        {
            int res = 0;

            if (node != null)
            {
                if (isLeaf(node.left))
                    res += node.left.value;
                //else
                res += leftLeavesSum(node.left);

                res += leftLeavesSum(node.right);
            }
            return res;
        }


    }
}
