package linkedlist.singlelinkedlist;

/**
 * @desc https://muckycode.blogspot.com/2014/12/singly-linked-list.html
 */
public class SingleLinkedList {
	
	public class Node {
		private int data;
		private Node nextNode;
		
		public Node(int data) {
			this.data = data;
		}
		
		public Node(int data, Node nextNode) {
			this.data = data;
			this.nextNode = nextNode;
		}
		
		public int getData() {
			return data;
		}
		
		public void setData(int data) {
			this.data = data;
		}

		public Node getNextNode() {
			return nextNode;
		}

		public void setNextNode(Node nextNode) {
			this.nextNode = nextNode;
		}
	}
	
	private Node head, tail;
	
	public SingleLinkedList() {
		head = null;
		tail = head;
	}
	
	public void addHead(int t) {
		Node node = new Node(t, head);
		head = node;
		if(null == tail) {
			tail = head;
		}
	}
	
	public void addTail(int t) {
		Node node = new Node(t);
		if(isEmpty()) {
			head = node;
			tail = head;
		} else {
			tail.setNextNode(node);
			tail = tail.getNextNode();
		}
	}
	
	public int search(int t) {
		Node pointer = head;
		int indexOfElement = -1;
		int traverseIndex = 0;
		
		while(null != pointer) {
			if(pointer.getData() == t) {
				indexOfElement = traverseIndex;
				break;
			}
			
			pointer = pointer.getNextNode();
			traverseIndex++;
		}
		
		return indexOfElement;
	}
	
	public void removeHead() {
		if(head == tail) {
			clear();
		} else {
			head = head.getNextNode();
		}
	}
	
	public void removeTail() {
		if(head == tail) {
			clear();
		} else {
			Node pointer = head;
			while(pointer.getNextNode() != tail) {
				pointer = pointer.getNextNode();
			}
			
			tail = pointer;
			tail.setNextNode(null);
		}
	}
	
	public void remove(int t) {
		if(!isEmpty()) {
			if(head == tail && head.getData() == t) {
				clear();
			} else {
				Node pointer = head;
				while(null != pointer) {
					if(pointer.getNextNode().getData() == t) {
						pointer.setNextNode(pointer.getNextNode().getNextNode());
						break;
					}
					
					pointer = pointer.getNextNode();
				}
			}
		}
	}
	
	public void clear() {
		head = tail = null;
	}
	
	public boolean isEmpty() {
		if(null == head) {
			return true;
		} else {
			return false;
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
			current = current.getNextNode();
		}
	}
	
	
	public static void main(String[] args) {
		SingleLinkedList slist = new SingleLinkedList();
		
		// add nodes to the list;
		slist.addTail(1);
		slist.addTail(2);
		slist.addTail(3);
		slist.addTail(4);
		
		// displays the nodes present in the list.
		slist.display();
	}
}
