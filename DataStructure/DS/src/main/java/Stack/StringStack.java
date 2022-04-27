package Stack;

public class StringStack {
    private int maxSize;
    private char[] stackArray;
    private int top;  // represent index(or pointer)

    public StringStack(int size){
        this.maxSize = size;
        this.stackArray = new char[maxSize];  // init array with size
        this.top = -1;
    }

    public void push(char j){
        if (isfull()){
            System.out.println("Exceed array size!");
            return;
        }
        top++;
        stackArray[top] = j;
    }

    public char pop(){
        if (isEmpty()){
            System.out.println("Exceed array size!");
            return '0';
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
