package linkedlist.singlylinkedlist;

/**
 * @desc https://www.javatpoint.com/program-to-create-a-singly-linked-list-of-n-nodes-and-count-the-number-of-nodes
 */
public class CounterNodes {

	// represent a node
	class Node {
		int data;
		Node next;
		
		public Node(int data) {
			this.data = data;
			this.next = null;
		}
	}
	
	// represent the head and tail
	public Node head = null;
	public Node tail = null;
	
	public void addNode(int data) {
		// create a new node
		Node newNode = new Node(data);
		
		// if list is empty, both head and tail point to new node.
		if(null == head) {
			head = newNode;
			tail = newNode;
		} else {
			// new node will be added after tail such that tail's next will point to new node.
			tail.next = newNode;
			tail = newNode;
		}
	}
	
	// display will display all the nodes present in the list
	public void display() {
		// Node current will point to head.
		Node current = head;
		
		if(null == head) {
			System.out.println("List is empty");
			return;
		}
		System.out.println("Nodes of singly linked list: ");
		while(null != current) {
			System.out.println(current.data + "");
			current = current.next;
		}
	}
	
	// countNodes() will count the nodes present in the list.
	public int countNodes() {
		int count = 0;
		
		// node current will point to head
		Node current = head;
		
		while(null != current) {
			count++;
			current  = current.next;
		}
		
		return count;
	}
	
	public static void main(String[] args) {
		CounterNodes slist = new CounterNodes();
		
		// add nodes to the list;
		slist.addNode(1);
		slist.addNode(2);
		slist.addNode(3);
		slist.addNode(4);
		slist.addNode(5);
		
		// displays the nodes present in the list.
		slist.display();
		
		System.out.println("Count of nodes present in the list: " + slist.countNodes());
	}
}
