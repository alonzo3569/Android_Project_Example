package DoublyLinkedList;

public class DoublyLinkedList {

    private Node first;
    private Node last;

    // constructor
    public DoublyLinkedList() {
        this.first = null;
        this.last = null;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public void insertFirst(int data) {
        Node newNode = new Node();
        newNode.data = data;

        if (isEmpty()) {
            first = newNode;
            last = newNode;
        } else {
            first.previous = newNode;
            newNode.next = first;
            first = newNode;
        }
    }

    public void insertLast(int data) {
        Node newNode = new Node();
        newNode.data = data;

        if (isEmpty()) {
            first = newNode;
            last = newNode;
        } else {
            last.next = newNode;
            newNode.previous = last;
            last = newNode;
        }
    }

    public Node deleteFirst() {
        Node tmp = first;

        if (first.next == null) { // List only has one node
            first = null;
            last = null;
        } else {
            first = first.next;
            first.previous = null;
        }
        return tmp;
    }

    public Node deleteLast() {
        Node tmp = last;
        if (first.next == null) {
            first = null;
            last = null;
        } else{
            last = last.previous;
            last.next = null;
        }
        return tmp;
    }

    public boolean insertAfter(int key, int data){ // key : the data we're looking for
        Node tmp = first;
        Node newNode = new Node();
        newNode.data = data;

        while(tmp.data != key){
            tmp = tmp.next;

            // *** Caution : reach the end of the list
            if (tmp == null){
                return false;
            }
        }

        if (tmp.next == null){  // insert after the last node
            newNode.previous = tmp;
            tmp.next = newNode;
            last = newNode;
        }else {
            newNode.next = tmp.next;
            newNode.previous = tmp;
            tmp.next.previous = newNode;
            tmp.next = newNode;
        }
        return true;
    }

    public Node deleteKey(int key){
        Node tmp = first;

        while(tmp.data != key){
            tmp = tmp.next;

            // *** Caution : reach the end of the list
            if (tmp == null){
                return null;
            }
        }

        if (tmp == first){  // tmp is first Node
            first = tmp.next;
        } else {
            tmp.previous.next = tmp.next;
        }

        if (tmp == last) {  // tmp is last Node
            last = tmp.previous;
        } else {
            tmp.next.previous = tmp.previous;
        }

        return tmp;
    }

    public void displayForward(){
        System.out.println("List (first ---> last)");
        Node currentNode = first;
        while (currentNode != null){
            currentNode.displayNode();
            currentNode = currentNode.next;
        }
        System.out.println();
    }

    public void displayBackward(){
        System.out.println("List (last ---> first)");
        Node currentNode = last;
        while (currentNode != null){
            currentNode.displayNode();
            currentNode = currentNode.previous;
        }
        System.out.println();
    }
}

