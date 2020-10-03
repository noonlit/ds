package util;

public class BST
{
    private class Node
    {
        Node left;
        Node right;
        int value;

        public Node(int value)
        {
            left = null;
            right = null;
            this.value = value;
        }
    }

    Node root;
    
    public void add(int value)
    {
        Node toAdd = new Node(value);

        if (root == null) {
            root = toAdd;
            return;
        }

        Node previousNode = null;
        Node currentNode = root;

        while (currentNode != null) {
            if (toAdd.value == currentNode.value) {
                return;
            }

            if (toAdd.value < currentNode.value) {
                previousNode = currentNode;
                currentNode = currentNode.left;
                continue;
            }

            if (toAdd.value > currentNode.value) {
                previousNode = currentNode;
                currentNode = currentNode.right;
            }
        }

        /*
         * At this point, the current node is null and the previous is the intended
         * parent of toAdd
         */

        if (toAdd.value < previousNode.value) {
            previousNode.left = toAdd;
            return;
        }

        previousNode.right = toAdd;
    }

    public void showInPreorder()
    {
        showInPreorderRecursively(root);
        System.out.println();
    }

    private void showInPreorderRecursively(Node node)
    {
        if (node == null) {
            return;
        }

        System.out.print(node.value + " ");

        System.out.print("left: ");
        showInPreorderRecursively(node.left);

        System.out.print("right: ");
        showInPreorderRecursively(node.right);
    }

    public static void main(String[] args)
    {
        BST tree = new BST();

        tree.add(10);
        tree.add(9);
        tree.add(8);
        tree.add(7);
        tree.add(6);
        
        tree.showInPreorder();
    }
}
