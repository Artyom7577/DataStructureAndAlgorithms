package linkedlist;

public class LinkedList1 {

    private Node head;

    public LinkedList1() {
        head = null;
    }

    public static class Node {
        public int data;
        public Node next;

        public Node(int data) {
            this.data = data;
            next = null;
        }
    }

    public void add(int data) {
        Node newNode = new Node(data);
        Node currentNode = head;

        if(head == null) {
            head = newNode;
        } else {
            while(currentNode.next != null) {
                currentNode = currentNode.next;
            }
            currentNode.next = newNode;
        }
    }

    public void remove(int data) {

        Node currentNode = head;
        Node previousNode = null;

        while(currentNode.next != null) {


            if(currentNode.data == data) {
                if (currentNode == head) {
                    head = currentNode.next;
                }else {
                    previousNode.next = currentNode.next;
                }
                return;
            }

            previousNode = currentNode;
            currentNode = currentNode.next;

            if(currentNode.next == null && currentNode.data == data){
                previousNode.next = null;
            }
        }
    }

    public void print() {
        Node currentNode = head;

        if(head != null) {
            System.out.println(head.data);
        }

        while(currentNode.next != null) {
            currentNode = currentNode.next;
            System.out.println(currentNode.data);
        }
    }
}
