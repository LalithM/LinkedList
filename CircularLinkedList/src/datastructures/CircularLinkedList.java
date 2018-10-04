package datastructures;

public class CircularLinkedList {

    private Node head,head1,head2;

    public Node getHead() {
        return head;
    }

    public void setHead(Node head) {
        this.head = head;
    }

    public void printList(Node n){
        Node temp = n;

        while(temp!=null){
            do{
                System.out.println(temp.getData());
                temp = temp.getNext();
            }while(temp !=n);
        }
    }

    public void spiltIntoHalf(){
        Node slow = head;
        Node fast = head;

        while(fast.getNext()!=head && fast.getNext().getNext() != head){
            slow = slow.getNext();
            fast = fast.getNext().getNext();
        }
    //Even elements present in the list
        if(fast.getNext().getNext()==head){
            fast = fast.getNext();
        }
        head1 = head;

        if(head.getNext() != head){
            head2 = slow.getNext();
        }
        fast.setNext(slow.getNext());
        slow.setNext(head);
    }

    public void sortedInsert(Node n){

        Node current = head;

        if(head == null){
            n.setNext(n);
            head = n;
        }
        else if(current.getData() > n.getData()){

            while(n.getNext()!=null){
                n = n.getNext();
            }

            current.setNext(n);
            n.setNext(head);
            head = n;
        }
        else{
            while(n.getNext()!=null && current.getData() < n.getData()){
                n = n.getNext();
            }
            n.setNext(current.getNext());
            current.setNext(n);
        }
    }
}
