package LinkedList;

public class CircularLinkedList {
    private Node firstNode;
    private Node lastNode;  // Add this

    public CircularLinkedList(){

    }

    public boolean isEmpty(){
        return (firstNode == null);
    }

    // Insert Node to the beginning
    public void insertFirst(int data){
        Node newNode = new Node();
        newNode.data = data;

        if (isEmpty()){           // Difference between Singly Linked List
            lastNode = newNode;
        }
        newNode.next = firstNode; // Give old first node address to New First node's next
        firstNode = newNode;      // give new node address to firstNode
    }

    public void insertLast(int data){
        Node tmp = new Node();
        tmp.data = data;

        if (isEmpty()){
            firstNode = tmp;
            lastNode = tmp;
        }else {
            lastNode.next = tmp; // Remove null in old last node's next
            lastNode = tmp;      // Update last node address in CircularLinkedList
        }
    }

    public Node deleteFirst(){
        Node temp = firstNode;
        if (firstNode.next == null){  // If firstNode is the only node
            lastNode = null;          // update lastNode to null
        }
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
    } // Same in Singly
}
