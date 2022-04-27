package ADT;

import java.util.LinkedList;

public class ADTApp {
    public static void main(String[] args) {
        Counter myCounter = new Counter("myCounter");
        myCounter.increment();
        System.out.println(myCounter.toString());

    }
}
