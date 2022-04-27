package Stack;

public class Stack {
    private int maxSize;
    private long[] stackArray;
    private int top;  // represent index(or pointer)

    public Stack(int size){
        this.maxSize = size;
        this.stackArray = new long[maxSize];  // init array with size
        this.top = -1;
    }

    public void push(long j){
        if (isfull()){
            System.out.println("Exceed array size!");
            return;
        }
        top++;
        stackArray[top] = j;
    }

    public long pop(){
        if (isEmpty()){
            System.out.println("Exceed array size!");
            return -1;
        }
        int old_top = top;
        top--;
        return stackArray[old_top];
    }

    public boolean isEmpty(){
        return(top == -1);
    }

    public boolean isfull(){
        return (maxSize-1 == top);
    }

}
