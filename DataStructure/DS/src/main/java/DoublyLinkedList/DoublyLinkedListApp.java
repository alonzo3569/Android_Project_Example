package DoublyLinkedList;

public class DoublyLinkedListApp {
    public static void main(String[] args) {
        DoublyLinkedList theList = new DoublyLinkedList();
        theList.insertFirst(22);
        theList.insertFirst(44);
        theList.insertFirst(66);
        theList.insertLast(11);
        theList.insertLast(33);
        theList.insertLast(55);
        theList.displayForward();

        theList.deleteFirst();
        theList.deleteLast();
        theList.deleteKey(11);
        theList.insertAfter(22, 77);
        theList.displayForward();
        theList.displayBackward();

        int[] a = {1, 2};
        System.out.println(a.length);
        a.
    }
}
