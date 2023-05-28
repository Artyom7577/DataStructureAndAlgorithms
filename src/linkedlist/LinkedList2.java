package linkedlist;

public class LinkedList2 {
    Node head;

    static class Node {

        int data;
        Node next;
        Node prev;

        Node(int num) {
            data = num;
        }
    }

    public void add(int new_Data) {
        Node NewData = new Node(new_Data);
        Node last = head;
        NewData.next = null;
        if (head == null) {
            NewData.prev = null;
            head = NewData;
            return;
        }
        while (last.next != null) {
            last = last.next;
        }
        last.next = NewData;
        NewData.prev = last;
    }

    public void printList() {
        Node last = head;
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        while (last != null) {
            System.out.print(last.data + " ");
            last = last.next;
        }

        System.out.println();
    }

    public void clear() {
        head = null;
        System.out.println("List is cleard");
    }

    public void remove() {
        Node last = head;
        if (head == null) {
            System.out.println("List is Empty");
            return;
        }
        if (head.next == null) {
            clear();
            return;
        }
        while (last.next != null) {
            last = last.next;
        }
        last.prev.next = null;
        last.prev = null;
    }

    public static void main(String[] args) {
        LinkedList2 list = new LinkedList2();
        list.add(6);
        list.add(5);
        list.add(4);
        list.add(3);
        list.add(2);
        list.add(1);
        list.add(0);
        list.printList();
        list.remove();
        list.printList();
        list.clear();
        list.printList();
    }
}