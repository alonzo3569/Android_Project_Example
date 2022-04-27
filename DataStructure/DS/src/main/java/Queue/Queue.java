package Queue;

public class Queue {
    private int maxSize;
    private long[] queArray;
    private int frontPointer;
    private int rearPointer;
    private int nItem;

    Queue(int size){
        this.maxSize = size;
        this.queArray = new long[size];
        this.frontPointer = 0;
        this.rearPointer = -1;
        this.nItem = 0;
    }

    public void insert(long number){
        if (isFull()){
            System.out.println("Exceed array size!");
            return;
        }

        rearPointer++;
        nItem++;
        queArray[rearPointer] = number;
    }

    public long remove(){
        long popNumber = queArray[frontPointer];
        frontPointer++;
        if (frontPointer == maxSize){
            frontPointer = 0;
        }
        nItem--;
        return popNumber;
    }

    public long peakFront(){
        return queArray[frontPointer];
    }

    public boolean isEmpty(){
        return (nItem == 0);
    }

    public boolean isFull(){
        return (nItem == maxSize);
    }

    public void view(){
        System.out.print("[ ");
        for (int i = frontPointer; i < maxSize; i++){
            System.out.print(queArray[i] + " ");
        }
        System.out.print("]");
    }
}
