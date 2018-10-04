package datasturcutres;

public class Main {

    public static void main(String[] args) {
	/*LinkedList l = new LinkedList();
	 Node node1;
	 Node node2;

	node1 = new Node(1);
    node1.setNext(new Node(2));
    node1.getNext().setNext(new Node(3));

    node2 = new Node(1);
    node2.setNext(new Node(0));
    node2.getNext().setNext(new Node(0));


    Node result = l.addTwoNodes(node1,node2);

    l.printList(result);*/

	LinkedList l = new LinkedList();
	l.push(6);
	l.push(5);
    l.push(4);
    l.push(3);
    l.push(2);
    l.push(1);

    l.rotateList(3);

    l.printList(l.getHead());
    }
}
