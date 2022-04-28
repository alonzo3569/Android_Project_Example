package DoublyLinkedList;

public class Node {
    public int data;
    public Node next = null;
    public Node previous = null;


    public Node() {
    }

    public void displayNode(){
        System.out.println(this.data);
    }
}
