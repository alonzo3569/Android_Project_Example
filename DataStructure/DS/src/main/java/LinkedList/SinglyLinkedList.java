package LinkedList;

public class SinglyLinkedList {
    private Node firstNode; // First Node Address

    public SinglyLinkedList(){

    }

    public boolean isEmpty(){
        return (firstNode == null);
    }

    // Insert Node to the beginning
    public void insertFirst(int data){
        Node newNode = new Node();
        newNode.data = data;
        newNode.next = firstNode; // Give old first node address to New First node's next
        firstNode = newNode;      // give new node address to firstNode
    }

    public Node deleteFirst(){
        Node temp = firstNode;
        firstNode = firstNode.next;
        return temp;
    }

    public void displayList(){
        System.out.println("List (first ---> last)");
        Node currentNode = firstNode;
        while (currentNode != null){
            currentNode.displayNode();
            currentNode = currentNode.next;
        }
        System.out.println();
    }

    public void insertLast(int data){
        Node tmp = firstNode;
        while (tmp != null){
            tmp = tmp.next;
        }
        Node lastNode = new Node();
        lastNode.data = data;
        tmp.next = lastNode;
    }
}
