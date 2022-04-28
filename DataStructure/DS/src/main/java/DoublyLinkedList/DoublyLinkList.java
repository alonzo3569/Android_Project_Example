package DoublyLinkedList;

public class DoublyLinkList {

    private Node first;
    private Node last;

    // constructor
    public DoublyLinkList() {
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

    public Node delteLast() {
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
}

