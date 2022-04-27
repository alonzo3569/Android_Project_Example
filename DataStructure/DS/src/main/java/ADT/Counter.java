package ADT;

public class Counter {
    private String name = null;
    private int number = 0;

    public Counter(String str) {
        this.name = str;
    }

    public void increment(){
        number+=1;
    }

    public int getCurrentValue() {
        return number;
    }

    @Override
    public String toString() {
        return "Counter{" +
                "name='" + name + '\'' +
                ", number=" + number +
                '}';
    }
}
