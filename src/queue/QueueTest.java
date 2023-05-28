package queue;

public class QueueTest {
    public static void main(String[] args) {
        testQueue();
    }

    private static void testQueue() {
        SimpleQueue<Integer> queue = new SimpleQueue<>();

        for (int i = 0; i < 10; i++) {
            System.out.print(i + " ");
            queue.add(i);
        }

        System.out.println("\n");

        while (!queue.isEmpty()) {
            System.out.print(queue.remove() + " ");
        }
    }
}
