package Models;

public class Queue<T> {

    private Node<T> head;

    private int size;

    public Queue() {
        head = null;
        size = 0;
    }

    public void push(T value) {
        if (head==null)
            head= new Node<>(value,null);
        else{
            Node<T> node=head;
            for (; node.next!=null ; node= node.next );

            node.next= new Node<>(value,null);

        }
        size++;
    }

    public boolean isEmpty(){
        if (head==null)
            return true;
        return false;
    }

    public T pop() {
        if (head==null) return null;
        else{
            Node<T> node=head;
            head=head.next;
            return node.value;
        }

    }

    public int getSize() {
        return size;
    }

    public static class Node<T> {
        private T value;

        private Node<T> next;

        public Node(T value, Node<T> next) {
            this.value = value;
            this.next = next;
        }

    }
}

