package Stack;

public class StackApp {
    public static void main(String[] args) {
//        Stack theStack = new Stack(1);
//        theStack.push(10);
//        theStack.push(20);
//        theStack.pop();

        String msg = reverseString("Hello");
        System.out.println(msg);

    }

    public static String reverseString(String str) {
        String revertMsg = "";
        StringStack st = new StringStack(str.length());

        for (int i=0; i < str.length() ; i++){
            st.push(str.charAt(i));
        }

        // Better solution
        while (!st.isEmpty()){
            revertMsg += st.pop();
        }

        return revertMsg;
    }
}
