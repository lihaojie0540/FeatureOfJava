package dataStructure;
import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * tree的相关操作
 */
public class Trees {
    public static void main(String[] args){
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode5 = new TreeNode(5);
        TreeNode treeNode6 = new TreeNode(6);
        TreeNode treeNode7 = new TreeNode(7);
        TreeNode treeNode8 = new TreeNode(8);
        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;
        //treeNode2.left = treeNode4;
        treeNode2.right = treeNode5;
        treeNode3.left = treeNode6;
        //treeNode3.right = treeNode7;
        System.out.println(isFull(treeNode1));

    }

    public static class TreeNode{
        int value;
        TreeNode left;
        TreeNode right;
        public TreeNode(int values){
            value = values;
        }
    }

    //前序遍历二叉树
    public static void preorder(TreeNode t){
        if (t == null) return;
        System.out.print(t.value+" ");
        preorder(t.left);
        preorder(t.right);
    }

    //中序遍历二叉树
    public static void midorder(TreeNode t){
        if (t == null) return;
        preorder(t.left);
        System.out.print(t.value+" ");
        preorder(t.right);
    }

    //后序遍历二叉树
    public static void posorder(TreeNode t){
        if (t == null) return;
        preorder(t.left);
        preorder(t.right);
        System.out.print(t.value+" ");
    }

    //深度优先遍历
    public static void depthOrderTraversal(TreeNode t){
        if(t == null) return ;
        ArrayDeque<TreeNode> stack = new ArrayDeque<>();
        stack.push(t);
        while(stack.isEmpty() == false){
            TreeNode node = stack.pop();
            System.out.print(node.value + " ");
            if(node.right!=null) stack.push(node.right);
            if(node.left!=null) stack.push(node.left);
        }
    }

    //广度优先遍历
    public static void levelOrderTraversal(TreeNode t){
        if(t == null) return ;
        ArrayDeque<TreeNode> queue = new ArrayDeque<TreeNode>();
        queue.add(t);
        while(queue.isEmpty()==false){
            TreeNode node = queue.remove();
            System.out.print(node.value + " ");
            if(node.left!=null) queue.add(node.left);
            if(node.right!=null) queue.add(node.right);
        }
    }

    //反转二叉树
    public static TreeNode invertTree(TreeNode t){
        if(t == null) return null;
        t.left = invertTree(t.left);
        t.right = invertTree(t.right);
        TreeNode temp = t.left;
        t.left = t.right;
        t.right = temp;
        return t;
    }

    //非递归反转二叉树
    public static TreeNode invertTree2(TreeNode t){
        if(t == null) return null;
        Stack<TreeNode> nodeStack = new Stack<>();
        nodeStack.push(t);
        while(!nodeStack.empty()){
            TreeNode tn = nodeStack.peek();
            nodeStack.pop();
            TreeNode temp = tn.right;
            tn.right = tn.left;
            tn.left = temp;
            if(tn.left!=null){
                nodeStack.push(tn.left);
            }
            if(tn.right!=null){
                nodeStack.push(tn.right);
            }
        }
        return t;
    }

    //是否完全二叉树
    public static boolean isFull(TreeNode t){
        if (t == null) return false;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(t);

        boolean mustHaveNochild = false;
        boolean result = true;

        while(!queue.isEmpty()){
            TreeNode temp = queue.remove();
            if(mustHaveNochild){
                if(temp.left!=null||temp.right!=null){
                    result = false;
                    break;
                }
            }else{
                if(temp.left != null && temp.right != null){
                    queue.add(temp.left);
                    queue.add(temp.right);
                }else if(temp.left != null && temp.right == null){
                    mustHaveNochild = true;
                    queue.add(temp.left);
                }else if(temp.left == null && temp.right != null){
                    result = false;
                    break;
                }else {
                    mustHaveNochild = true;
                }
            }
        }
        return result;
    }

    //判断两颗树是否相等
    public static boolean isEqual(TreeNode a,TreeNode b){
        if(a == null && b != null) return false;
        if(a != null && b == null) return false;
        if(a == null && b == null) return true;
        if(a.value != b.value ) return false;
        else{
            if(!isEqual(a.left,b.left)) return false;
            if(!isEqual(a.right,b.right)) return false;
        }
        return true;
    }
}


