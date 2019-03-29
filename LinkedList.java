public class LinkedList<T> implements List<T> {
    private Node head;
    private int size;

    public LinkedList(){
        head = null;
        size = 0;
    }

    private class Node <T>{
        T data;
        Node<T> next;

        public Node (T data){
            this.data = data;
            this.next = null;
        }

        public void setNext(Node next){
            this.next = next;
        }

        public Node getNext(){
            return next;
        }

        public T getData(){
            return data;
        }

    }

    public void add(T item){ //add item to end of linked list
        if (head == null){ //if linked list is empty
            Node <T> newNode = new Node(item); //create new node
            head = newNode; //make the new node as head
            size++;
        } else {
            //move to end of list
            Node prev = head;
            for (int i = 0; i < size - 1; i++){
                prev = prev.getNext(); //set prev to end of list
            }
            Node<T> newNode = new Node(item); //create a new node
            prev.setNext(newNode); //place the new node after prev (initial end of list)
            size++;
        }

    }

    public void add(int pos, T item){
        //error check first
        // when the position of the array that you want to add an element into is not reachable given the LinkedList's size

        if (pos >= 0 && pos <= size){
            Node<T> node = new Node(item);
            if (pos == 0){ //if given position to add an item is the very front of the linked list
                //set head to be the new node object and increment the size
                node.setNext(head);
                head = node;
                size++;
            } else { //if given position to add an item is the size
                Node prev = head, curr = prev.getNext();
                for (int i = 0; i < pos - 1; i++) {
                    prev = prev.getNext();
                    curr = curr.getNext();
                }
                node.setNext(curr);
                prev.setNext(node);
                size++;
            }
        }

    }

    public T get(int pos){ //get element from given position
        //Assert.notFalse(pos > 0 && pos < size);

        Node curr = head;
        if (pos < 0 || pos > size){
            return null;
        }
        for (int i = 0; i < pos; i++){
            curr = curr.getNext();
        }
        return (T)curr.getData();

    }

    public T remove(int pos){ //given a reference to the head of a list and a position, deletes the node at a given position
        //Assert.notFalse(pos >= 0 && pos < size);
        if (pos < 0 || pos >= size){
            return null;
        }

        if (pos == 0){ //if head needs to be removed
            Node curr = head; //store head node
            head = curr.getNext(); //change head
            --size; //update size of list
            return (T)curr.getData();
        } else {
            //find previous node of the node to be deleted
            Node prev = head;
            for (int i = 0; i < pos - 1; i++){
                prev = prev.getNext();
            }
            Node curr = prev.getNext();
            prev.setNext(curr.getNext());
            --size; //update size of list
            return (T)curr.getData();

        }

    }

    public int size(){
        return size;

    }
}
