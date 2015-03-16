/**
 * Created by Xu on 3/14/2015.
 */
public class Node<T extends Comparable> implements Comparable{
    Node left;
    Node middle;
    Node right;
    T value;

    Node(T value) {
        this.value = value;
        this.left = null;
        this.right = null;
        this.middle = null;
    }

    @Override
    public int compareTo(Object o) {
        return this.value.compareTo(((Node) o).value);
    }

    @Override
    public boolean equals(Object obj) {
        return this.value == ((Node)obj).value;
    }
}
