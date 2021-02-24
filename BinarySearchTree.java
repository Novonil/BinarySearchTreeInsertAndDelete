public class BinarySearchTree
{
    TreeNode root;
    BinarySearchTree()
    {
        root = null;
    }
    
    void TraverseInOrder()
    {
        InorderTraversal(root);
    }

    ///Inorder Traversal of the BST
    void InorderTraversal(TreeNode rootNode)
    {
        if(rootNode != null)
        {
            InorderTraversal(rootNode.left);
            System.out.print(rootNode.value + " ");
            InorderTraversal(rootNode.right);
        }
    }

    /// Inserts Nodes into the BST
    void Insert(int val)
    {
        root = InsertNode(root, val);
    }
    TreeNode InsertNode(TreeNode rootNode, int val)
    {
        if(rootNode == null)
        {
            rootNode = new TreeNode(val);
            return rootNode;
        }
        if(val < rootNode.value)
        {
            rootNode.left = InsertNode(rootNode.left, val);
        }
        else if(val > rootNode.value)
        {
            rootNode.right = InsertNode(rootNode.right, val);
        }
        return rootNode;
    }
    
    void delete(int val)
    {
        root = deleteNode(root, val);
    }
    ///Delete node from the BST
    TreeNode deleteNode(TreeNode rootNode, int val)
    {
        if (rootNode == null)
            return rootNode;
        if(val < rootNode.value)
        {
            rootNode.left = deleteNode(rootNode.left, val);
        }
        else if (val > rootNode.value)
        {
            rootNode.right = deleteNode(rootNode.right, val);
        }
        else
        {
            if (rootNode.left == null)
                return rootNode.right;
            else if (rootNode.right == null)
                return rootNode.left;
            rootNode.value = Predecessor(rootNode.left);
            rootNode.left = deleteNode(rootNode.left, rootNode.value);
        }
        return rootNode;
    }

    ///Find out the predecessor node
    int Predecessor(TreeNode rootNode)
    {
        int predecessor = rootNode.value;
        while(rootNode.right != null)
        {
            predecessor = rootNode.right.value; ;
            rootNode = rootNode.right;
        }
        return predecessor;
    }

    public static void main(String[] args)
    {
        BinarySearchTree tree = new BinarySearchTree();
        //Insert nodes into the tree
        tree.Insert(100);
        tree.Insert(50);
        tree.Insert(200);
        tree.Insert(150);
        tree.Insert(300);
        tree.Insert(25);
        tree.Insert(75);
        tree.Insert(12);
        tree.Insert(37);
        tree.Insert(125);
        tree.Insert(175);
        tree.Insert(250);
        tree.Insert(320);
        tree.Insert(67);
        tree.Insert(87);
        tree.Insert(94);
        tree.Insert(89);
        tree.Insert(92);
        tree.Insert(88);
        System.out.println("After Inserting all values and doing an Inorder Traversal");
        tree.TraverseInOrder();
        
        System.out.println();
        System.out.println();
        //Delete node 100 from the tree
        tree.delete(100);
        System.out.println("After Deleting and doing inorder traversal");
        tree.TraverseInOrder();
    }
}