import java.util.NoSuchElementException;

/**
 * Created by Xu on 3/14/2015.
 */
public class TriTree {

    private Node nodeFounded = null;
    private Node nodeParent = new Node(Integer.MIN_VALUE);
    private Node tempParent = null;
    private Node minNode = null;
    private Node minParent = null;

    public void insertNode (Node newNode, Node root) {
        if (newNode == null)
            return;
        if (root != null) {
            // if new node is smaller than root, then inset it into left child
            if (newNode.compareTo(root) < 0) {
                insertNode(newNode, root.left);
                if (root.left == null)
                    root.left = newNode;
            }
            // if new node is larger than root, then inset it into left child
            else if (newNode.compareTo(root) > 0) {
                insertNode(newNode, root.right);
                if (root.right == null)
                    root.right = newNode;
            }
            // if new node is equal to the root, then insert in into middle child
            else {
                if (root.middle == null)
                    root.middle = newNode;
                else {
                    newNode.middle = root.middle;
                    root.middle = newNode;
                }
            }
        }
        root = newNode;
        return;
    }

    private Node treeDfs (Node targetNode, Node root) {
        // if we found the target node, return that node
        nodeFounded = null;
        if (root.equals(targetNode)) {
            nodeFounded = root;
            nodeParent = tempParent;
            return nodeFounded;
        }
        if (root.left != null) {
            tempParent = root;
            nodeFounded = treeDfs(targetNode, root.left);
        }
        if (root.middle != null) {
            tempParent = root;
            nodeFounded = treeDfs(targetNode, root.middle);
        }
        if (root.right != null) {
            tempParent = root;
            nodeFounded = treeDfs(targetNode, root.right);
        }
        return nodeFounded;
    }

    private Node findMin (Node root, Node nodeFounded) {
        if (root == null)
            return null;
        minNode = root;
        minParent = nodeFounded;
        // find the left most node in the sub-tree
        while (root.left != null) {
            minParent = root;
            minNode = root.left;
            root = root.left;
        }
        return minNode;
    }

    public Node deleteNode (Node targetNode, Node root) throws NoSuchElementException {
        // first, find the node
        Node nodeFounded = treeDfs(targetNode, root);
        // return null if no target node found
        if (nodeFounded == null) throw new NoSuchElementException("Could not find the node with value " + targetNode.value);
        // if the target node has no children
        if (nodeFounded.left == null && nodeFounded.right == null && nodeFounded.middle == null) {
            if (!nodeFounded.equals(root)) {
                if (nodeParent.left != null)
                    if (nodeParent.left.equals(nodeFounded))
                        nodeParent.left = null;
                if (nodeParent.right != null)
                    if (nodeParent.right.equals(nodeFounded))
                        nodeParent.right = null;
                if (nodeParent.middle != null)
                    if (nodeParent.middle.equals(nodeFounded))
                        nodeParent.middle = null;
            } else {
                root = null;
            }
            return root;
        }
        // if middle node needs to be deleted
        if (nodeFounded.middle != null) {
            nodeFounded.middle = nodeFounded.middle.middle;
        } else if ((nodeFounded.left == null) ^ (nodeFounded.right == null)) {
            // if the target node has one child other than middle child
            if (nodeFounded.left == null) {
                if (nodeParent.compareTo(nodeFounded) > 0)
                    nodeParent.left = nodeFounded.right;
                if (nodeParent.compareTo(nodeFounded) < 0)
                    nodeParent.right = nodeFounded.right;
            }
            if (nodeFounded.right == null) {
                if (nodeParent.compareTo(nodeFounded) > 0)
                    nodeParent.left = nodeFounded.left;
                if (nodeParent.compareTo(nodeFounded) < 0)
                    nodeParent.right = nodeFounded.left;
            }
        } else {
            // if the target node has two children other than middle child
            Node nodeToBeDelete = findMin(nodeFounded.right, nodeFounded);
            if (minParent != null) {
                nodeFounded.value = nodeToBeDelete.value;
                if (root != minParent)
                    if (nodeToBeDelete.compareTo(minParent) < 0)
                        minParent.left = nodeToBeDelete.right;
                    else
                        minParent.right = nodeToBeDelete.right;
                else {
                    //root.right = nodeToBeDelete.left;
                    root.right = nodeToBeDelete.right;
                }
            }
            else
                nodeFounded.right = null;
        }
         return root;
    }
}
