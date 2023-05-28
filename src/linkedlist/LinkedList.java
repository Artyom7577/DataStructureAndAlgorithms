package linkedlist;

class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class LinkedList {
    public static void main(String[] args) {
        Node head = new Node(4);
        head.next = new Node(2);
        head.next.next = new Node(1);
        head.next.next.next = new Node(3);

        System.out.println("Before Sorting");
        printList(head);

        head = sortList(head);

        System.out.println("After sorting:");
        printList(head);
    }


    public static Node sortList(Node head){
        if (head == null || head.next == null){
            return head;
        }

        Node sortedList = null;
        Node current = head;

        while (current != null){
            Node next = current.next;
            sortedList = insertIntoSortedList(sortedList, current);
            current = next;
        }

        return sortedList;

    }

    private static Node insertIntoSortedList(Node sortedList, Node newNode) {
        if (sortedList == null || newNode.data < sortedList.data) {
            newNode.next = sortedList;
            return newNode;
        }

        Node current = sortedList;
        while (current.next != null && current.next.data < newNode.data){
            current = current.next;
        }

        newNode.next = current.next;
        current.next = newNode;

        return sortedList;
    }

    public static void printList(Node head) {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

}
