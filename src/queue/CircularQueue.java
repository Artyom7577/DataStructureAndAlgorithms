package queue;


class QueueFullException extends RuntimeException {

    public QueueFullException(){
        super();
    }

    public QueueFullException(String message){
        super(message);
    }

}

class QueueEmptyException extends RuntimeException {

    public QueueEmptyException(){
        super();
    }

    public QueueEmptyException(String message){
        super(message);
    }

}
public class CircularQueue<E> {

    private E[] circularQueueAr;
    private int number;  //number of elements currently in Priority Queue
    private int front;
    private int maxSize;
    private int rear;

    public CircularQueue(int maxSize) {

        circularQueueAr = (E[])new Object[this.maxSize];

        number = 0;
        front = 0;
        rear = 0;
    }

    public void enqueue(E item) throws QueueFullException{
        if(isFull()){
            throw new QueueFullException("Circular Queue is full");
        } else {
            circularQueueAr[rear] = item;
            rear = (rear + 1) % circularQueueAr.length;
            number++;
        }
    }

    public E dequeue() throws QueueEmptyException{
        E deQueuedElement;
        if(isEmpty()){
            throw new QueueEmptyException("Circular Queue is empty");
        } else {
            deQueuedElement = circularQueueAr[front];
            front = (front - 1) % circularQueueAr.length;
            number--;
        }
        return deQueuedElement;
    }
    
    public boolean isFull(){
        return (number == circularQueueAr.length);
    }

    public boolean isEmpty(){
        return (number == 0);
    }

}
