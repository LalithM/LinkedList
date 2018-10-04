package datastrcutures;

public class DoubleLinkedList {

    private Node head;

    public Node getHead() {
        return head;
    }

    public void setHead(Node head) {
        this.head = head;
    }

    //Add a node that the starting
    public void push(int data){
        Node n = new Node(data);

        n.setPrev(null);
        n.setNext(head);

        if(head !=null){
            head.setPrev(n);
        }
        head = n;
    }

    //Add a node after a given node
    public void addAfter(Node prev,int data){
        Node current = head;

        Node n = new Node(data);
        n.setNext(prev.getNext());
        n.setPrev(prev);

        prev.setNext(n);

        if(n.getNext()!=null){
            n.getNext().setPrev(n);
        }
    }

    //Add a node at the end
    public void addAtEnd(int data){
        Node n = new Node(data);
        n.setNext(null);
        Node current = head;
        while(current.getNext()!=null){
            current = current.getNext();
        }
        if(head == null){
            n.setPrev(null);
            head = n;
            return;
        }
        n.setPrev(current);
        current.setNext(n);
    }

    //Add a node before given node
    public void addBefore(Node next,int data){
        Node n = new Node(data);
        n.setNext(next);
        n.setPrev(next.getPrev());
        next.getPrev().setNext(n);
        next.setPrev(n);
    }

    //print list in forward direction
    public void printListForward(Node n){
        if(n == null){
            return;
        }
        while(n.getNext()!=null){
            System.out.println(n.getData());
            n= n.getNext();
        }
    }

    //print list in backward direction
    public void printListRevers(Node n){
        if(n == null){
            return;
        }
        while(n.getPrev()!=null){
            System.out.println(n.getData());
            n= n.getPrev();
        }
    }

    //Delete a node
    public void deleteNode(Node head,Node del){
        if(head == null || del == null){
            return;
        }

        if(head == del){
            head = del.getNext();
        }

        if(del.getNext()!=null){
            del.getNext().setPrev(del.getPrev());
        }
        if(del.getPrev()!=null){
            del.getPrev().setNext(del.getNext());
        }
    }

    //Reverse a list
    public void reverseList(){
        Node temp = null;
        Node current = head;

        while(current!=null){
            temp = current.getPrev();
            current.setPrev(current.getNext());
            current.setNext(temp);
            current = current.getPrev();
        }
        if(temp!=null){
            head = temp.getPrev();
        }
    }

    //Merge sort
    //Split a list
    public Node split(Node n){
        Node slow=head,fast=head;
        while(fast.getNext()!=null && fast.getNext().getNext()!=null){
            fast = fast.getNext().getNext();
            slow = slow.getNext();
        }
        Node temp = slow.getNext();
        slow.setNext(null);
        return temp;
    }

    public Node mergeSort(Node n){
        if(n == null || n.getNext()==null){
            return n;
        }
        Node second = split(n);

        Node first = mergeSort(n);
        second = mergeSort(second);

        return merge(first,second);

    }

    public Node merge(Node first,Node second){
        if(first == null){
            return second;
        }
        if(second == null){
            return first;
        }
        if(first.getData() < second.getData()){
            first.setNext(merge(first.getNext(),second));
            first.getNext().setPrev(first);
            first.setPrev(null);
            return first;
        }else {
            second.setNext(merge(first,second.getNext()));
            second.getNext().setPrev(second);
            second.setPrev(null);
            return second;
        }
    }


}
