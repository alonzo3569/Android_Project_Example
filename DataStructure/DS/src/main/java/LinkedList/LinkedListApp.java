package LinkedList;

public class LinkedListApp {
    public static void main(String[] args) {

        SinglyLinkedList test = new SinglyLinkedList();
        test.insertFirst(100);
        test.insertFirst(99);
        test.displayList();

        CircularLinkedList tmp = new CircularLinkedList();
        tmp.insertFirst(100);
        tmp.insertFirst(99);
        tmp.displayList();
    }

    public static int listLength(Node node){
        int length = 0;
        Node currentNode = node.next;
        while (node.next != null){
            length++;
            node = node.next;
        }
        length++; // count last one

        return length;
    }
}
