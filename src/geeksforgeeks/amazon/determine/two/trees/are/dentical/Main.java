package geeksforgeeks.amazon.determine.two.trees.are.dentical;

import java.util.Stack;

// https://practice.geeksforgeeks.org/problems/determine-if-two-trees-are-identical/1

public class Main {
}
class GfG
{
    /* Should return true if trees with roots as root1 and
   root2 are identical else false */
    boolean isIdentical(Node root1, Node root2)
    {
        Stack<String> stack1 = new Stack<>();
        Stack<String> stack2 = new Stack<>();
        traverseTree(root1, stack1, "Root");
        traverseTree(root2, stack2, "Root");
        if(stack1.size() != stack2.size())
            return false;
        while (!stack1.empty()){
            if (!stack1.pop().equals(stack2.pop()))
                return false;
        }
        return true;
    }

    void traverseTree(Node node, Stack<String> s, String str){
        if(node == null)
            return;
        s.push(node.data+str);
        traverseTree(node.left, s, "L");
        traverseTree(node.right, s, "R");
    }

    class Node
    {
        int data;
        Node left, right;
        Node(int item)
        {
            data = item;
            left = right = null;
        }
    }
}