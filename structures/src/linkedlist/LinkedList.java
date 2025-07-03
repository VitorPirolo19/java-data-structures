package linkedlist;

public class LinkedList {
    private Node head;
    private Node tail;
    private int length;

    public LinkedList(int value){
        Node newNode = new Node(value);
        head = newNode;
        tail = newNode;
        length = 1;
    }

    public void printList(){
        Node temp = head;
        while (temp!= null){
            System.out.println(temp.value);
            temp = temp.next;
        }
    }

    public void appendNode(int value){
        Node newNode = new Node(value);
        if (length == 0){
            head = newNode;
        }else {
            tail.next = newNode;
        }
        tail = newNode;
        length ++;
    }

    public Node removeLast(){
        if(length == 0){
            return null;
        } else if (length == 1) {
            Node aux = head;
            head = null;
            tail = null;
            length --;
            return aux;
        }else {
            Node temp = head;
            while (temp.next != tail){
                temp = temp.next;
            }
            Node aux = tail;
            temp.next = null;
            tail = temp;
            length --;
            return aux;
        }
    }

    public void prependNode(int value){
        Node newNode = new Node(value);
        if (length == 0){
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
        length++;
    }

    public Node removeFirst(){
        if (length == 0){
            return null;
        }
        Node aux = head;
        head = head.next;
        aux.next = null;
        length--;
        if (length == 0){
            tail = null;
        }
        return aux;

    }

    public Node get(int index){
        if (index < 0 || index >= length){
            return null;
        }
        Node temp = head;
        for (int i = 0; i < index; i++){
            temp = temp.next;
        }
        return temp;
    }

    public boolean set(int index, int value){
        Node temp = get(index);
        if (temp == null){
            return false;
        }
        temp.value = value;
        return true;
    }

    public boolean insert(int index, int value){
        if (index < 0 || index > length) {
            return false;
        }
        if (index == 0){
            prependNode(value);
            return true;
        }
        if (index == length){
            appendNode(value);
            return true;
        }
        Node newNode = new Node(value);
        Node temp = get(index - 1);
        newNode.next = temp.next;
        temp.next = newNode;
        length++;
        return true;
    }

    public Node remove(int index){
        if (index < 0 || index >= length) {
            return null;
        }
        if (index == 0){
            return removeFirst();
        }
        if (index == length-1){
            return removeLast();
        }
        Node temp = get(index-1);
        Node removed = temp.next;
        temp.next = removed.next;
        removed.next = null;
        length--;
        return removed;
    }

    public int getHead(){
        return head.value;
    }
    public int getTail(){
        return tail.value;
    }
    public int getLength(){
        return length;
    }
}
