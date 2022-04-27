package Queue;

public class QueueApp {
    public static void main(String[] args) {
        Queue test = new Queue(5);
        test.insert(10);
        test.insert(20);
        test.insert(30);
        test.insert(40);
        test.insert(50);
//        test.insert(60);
        test.view();
        test.remove();
        test.view();
    }

}
