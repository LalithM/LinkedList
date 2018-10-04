package datasturcutres;

public class LinkedList {

    private Node head;

    public Node getHead() {
        return head;
    }

    public void setHead(Node head) {
        this.head = head;
    }

    //Method to print the Linked List data
    public void printList(){
        Node n = head;
        while(n != null){
            System.out.println(n.getData());
            n = n.getNext();
        }
    }

    public void printList(Node node) {
        while (node != null) {
            System.out.print(node.getData() + " ");
            node = node.getNext();
        }
    }

    //Method to insert node at first
    public void insertAtFirst(int data){
        Node n = new Node(data);
        n.setNext(head);
        head = n;
    }

    //Method to insert node after a given node
    public void insertAfterNode(Node prev,int data){
        if(prev == null){
            System.out.println("The given previous node cannot be null");
            return;
        }
        Node newNode = new Node(data);
        newNode.setNext(prev.getNext());
        prev.setNext(newNode);
    }

    //Method to insert node at the end
    public void insertAtEnd(int data){
        Node newNode = new Node(data);
        if(head ==null){
            head = newNode;
            return;
        }
        newNode.setNext(null);
        Node n = head;
        while(n.getNext()!=null){
            n = n.getNext();
        }
        n.setNext(newNode);
    }

    //Method to insert node after given data
    public void insertAfterData(int prevData,int data){
        Node n = head;
        Node newNode = new Node(data);
        while(n.getData() != prevData){
            n = n.getNext();
        }
        newNode.setNext(n.getNext());
        n.setNext(newNode);
    }

    //Method to delete a node
    public void deleteNode(int key){

        Node current = head,prev = null;
        if(current!=null && current.getData() == key){
            head = current.getNext();
            return;
        }

        if(current !=null && current.getData()!=key){
            prev = current;
            current = current.getNext();
        }

        prev.setNext(current.getNext());
    }

    //Method to delete a note from given position
    public void deleteFromPosition(int position){
        if(head == null){
            return;
        }
        Node n = head;

        if(position == 0){
            head = head.getNext();
        }

        for(int i=0;i<position-1;i++){
            n = n.getNext();
        }

        if(n==null || n.getNext() == null){
            return;
        }
        Node next = n.getNext().getNext();
        n.setNext(next);
    }

    //Method to get number of nodes
    public int getCount(){
        Node n = head;
        int count =0;

        while(n.getNext()!=null){
            count++;
            n = n.getNext();
        }
        return count;
    }

    //Method to get count recursively
    public int getCountRecursive(Node n){
        if(n == null){
            return 0;
        }
        return 1+getCountRecursive(n.getNext());

    }

    //Method to swap nodes
    public void swapNodes(int x,int y){

        if(x==y){
            return;
        }

        Node currentX = head,prevX = null;
        while(currentX!=null && currentX.getData()!=x){
            prevX = currentX;
            currentX = currentX.getNext();
        }

        Node currentY = head,prevY = null;
        while(currentY!=null && currentY.getData()!=x){
            prevY = currentY;
            currentY = currentY.getNext();
        }

        if(currentX == null || currentY==null){
            return;
        }
        if(prevX !=null){
            prevX.setNext(currentY);
        }else{
            head = currentY;
        }

        if(prevY != null){
            prevY.setNext(currentX);
        }else{
            head = currentX;
        }

        Node temp = currentX.getNext();
        currentX.setNext(currentY.getNext());
        currentY.setNext(temp);
    }

    //Method to reverse list
    public void reverseList(){
        Node prev = null;
        Node current = head;
        Node next = null;

        while(current!=null) {
            next = current.getNext();
            current.setNext(prev);
            prev = current;
            current = next;
        }
    }

    //Method to sort using merge sort
    public Node mergeSort(Node n){
        if(n==null || n.getNext() == null){
            return n;
        }

        Node middle = getMiddle(n);
        Node middleNext = middle.getNext();

        middle.setNext(null);

        Node left = mergeSort(n);
        Node right = mergeSort(middle.getNext());

        Node sortedNodes = sortedMerge(left,right);
        return sortedNodes;
    }

    //method to get the middle element of the list of merge sort
    public Node getMiddle(Node n){
        if(n==null){
            return n;
        }
        Node slowPtr = n;
        Node fastPtr = n.getNext();

        while(fastPtr !=null){
            fastPtr = fastPtr.getNext();
            if(fastPtr!=null){
                slowPtr = slowPtr.getNext();
                fastPtr = fastPtr.getNext();
            }
        }
        return slowPtr;
    }

    //Method to get the sorted merge list in merge sort
    public Node sortedMerge(Node left,Node right){
        Node result = null;
        if(left == null){
            return right;
        }
        if(right == null){
            return left;
        }

        if(left.getData() < right.getData()){
            result = left;
            result.setNext(sortedMerge(left.getNext(),right));
        }
        else{
            result = right;
            result.setNext(sortedMerge(left,right.getNext()));
        }
        return result;
    }

    //Method to reverse a node  in a group of given size
    public Node reverseNNode(Node n,int k){
        if(n == null){
            return n;
        }
        Node current = n;
        Node prev = null;
        Node next = null;

        int count = 0;
        while (count < k && next!= null){
            next = current.getNext();
            current.setNext(prev);
            prev = current.getNext();
            current = next;
            count++;
        }

        if(next !=null){
            n.setNext(reverseNNode(next,k));
        }
        return prev;
    }

    //method to detect and remove loop
    public void detectAndRemoveLoop(Node n){
        if(n == null){
            return;
        }
        Node slow = n.getNext();
        Node fast = n.getNext().getNext();

        while(fast !=null && fast.getNext()!=null){
            if(slow == fast){
                break;
            }
            slow = slow.getNext();
            fast = fast.getNext().getNext();
        }

        if(slow == fast){
            slow = n;
            while(slow.getNext() != fast.getNext()){
                slow = slow.getNext();
                fast = fast.getNext();
            }
            fast.setNext(null);
        }
    }

    //Method to add two nodes
    public Node addTwoNodes(Node first,Node second){
        Node prev = null;
        Node temp = null;
        Node result = null;
        int carry = 0,sum;

        while(first!=null || second !=null){

            sum = carry +(first !=null?first.getData():0)+(second!=null?second.getData():0);

            carry = (sum >=10)?1:0;

            sum = sum%10;

            temp = new Node(sum);

            if(result == null){
                result = temp;
            }else{
                prev.setNext(temp);
            }

            prev = temp;

            if(first !=null){
                first = first.getNext();
            }
            if(second!=null){
                second = second.getNext();
            }
        }
        if(carry >0){
            temp.setNext(new Node(carry));
        }
        return result;
    }

    //Rotate the list by given positions
    public void rotateList(int position){
        Node k  = null;
        Node current = head;
        int count =0;
        while(count < position && current !=null){
            count++;
            current = current.getNext();
        }

        k = current;

        while(current.getNext()!=null){
            current = current.getNext();
        }
        current.setNext(head);

        head = k.getNext();

        k.setNext(null);
    }

}
