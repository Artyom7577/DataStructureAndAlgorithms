package stack;

public class StackTest {
    public static void main(String[] args) {
        testStack();
    }

    private static void testStack() {
        SimpleStack<Integer> stack = new SimpleStack<>();

        for (int i = 0; i < 10; i++){
            System.out.print(i + " ");
            stack.push(i);
        }
        System.out.println("\n");

        while (!stack.isEmpty()){
            System.out.print(stack.pop() + " ");
        }

    }
}
