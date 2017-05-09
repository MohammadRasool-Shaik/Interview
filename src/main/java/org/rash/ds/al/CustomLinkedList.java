/**
 * 
 */
package org.rash.ds.al;

/**
 * @author Ammi
 */
public class CustomLinkedList<T extends Comparable<Integer>> {
	private int counter;
	private Node<T> head;

	public void addFirst(T data) {
		Node<T> newNode = new Node<T>(data);
		if (head == null) {
			head = newNode;
		} else {
			newNode.next = head;
			head = newNode;
		}
		incrementCounter();
	}

	public void addLast(T data) {
		Node<T> newNode = new Node<T>(data);
		if (head == null) {
			head = newNode;
		} else {
			Node<T> currentNode = head;
			for (; currentNode.next != null; currentNode = currentNode.next)
				;
			newNode.next = currentNode.next;
			currentNode.next = newNode;
		}
		incrementCounter();
	}

	public void makeCircularList(Node<T> circular) {
		Node<T> currentNode = head;
		for (; currentNode.next != null; currentNode = currentNode.next)
			;
		currentNode.next = circular;
	}

	public void add(int index, T data) {
		Node<T> newNode = new Node<T>(data);
		if (index < 0 || index > counter) {
			return;
		}
		Node<T> currentNode = head;
		Node<T> previousNode = null;
		for (int i = 0; i < counter && i < index && currentNode.next != null; i++, previousNode = currentNode, currentNode = currentNode.next)
			;
		newNode.next = previousNode.next;
		previousNode.next = newNode;
		incrementCounter();
	}

	public T getFirst() {
		if (head == null) {
			return null;
		} else {
			return head.data;
		}
	}

	public T getLast() {
		if (head == null) {
			return null;
		} else {
			Node<T> currentNode = head;
			for (; currentNode.next != null; currentNode = currentNode.next)
				;
			return currentNode.data;
		}
	}

	public Node<T> get(int index) {
		if (head == null) {
			return null;
		} else {
			if (index < 0 || index > counter) {
				return null;
			}
			Node<T> currentNode = head;
			for (int i = 0; i < index && currentNode.next != null; i++, currentNode = currentNode.next)
				;
			return currentNode;
		}
	}

	public boolean removeFirst() {
		if (head == null) {
			return false;
		} else {
			head = head.next;
			decrementCounter();
			return true;
		}
	}

	public boolean removeLast() {
		if (head == null) {
			return false;
		} else {
			Node<T> previousNode = null;
			for (Node<T> currentNode = head; currentNode.next != null; previousNode = currentNode, currentNode = currentNode.next)
				;
			previousNode.next = null;
			decrementCounter();
			return true;
		}
	}

	public boolean remove(int index) {
		if (head == null) {
			return false;
		} else {
			if (index < 0 || index > counter) {
				return false;
			}
			Node<T> currentNode = head;
			Node<T> previousNode = null;

			for (int i = 0; i < index; i++, previousNode = currentNode, currentNode = currentNode.next)
				;
			previousNode.setNext(currentNode.getNext());
			decrementCounter();
			return true;
		}

	}

	public boolean isEmpty() {
		if (head == null)
			return true;
		return false;
	}

	public int size() {
		return counter;
	}

	public void incrementCounter() {
		counter++;
	}

	public void decrementCounter() {
		this.counter--;
	}

	/**
	 * @return the counter
	 */
	public int getCounter() {
		return this.counter;
	}

	/**
	 * @param counter
	 *            the counter to set
	 */
	public void setCounter(int counter) {
		this.counter = counter;
	}

	public Node<T> reverseLinkedList(Node<T> head) {
		if (head == null) {
			return null;
		} else {
			Node<T> previousNode = null;
			for (Node<T> currentNode = head, nextNode = null; currentNode.next != null; previousNode = currentNode, currentNode = nextNode) {
				nextNode = currentNode.next;
				currentNode.next = previousNode;
			}
			return previousNode;
		}
	}

	public Node<T> findMiddleElement(Node<T> head) {
		Node<T> slowNode = head;
		for (Node<T> fastNode = head; fastNode.next != null; slowNode = slowNode.next, fastNode = slowNode.next.next)
			;
		// int middleIndex = counter / 2;
		// Node<T> middleNode = get(middleIndex);
		return slowNode;
	}

	public boolean checkPalindrome(Node<T> head) {
		Node<T> middleElement = findMiddleElement(head);
		Node<T> secondHalfHead = middleElement.next;
		Node<T> reverseLinkedList = reverseLinkedList(secondHalfHead);
		while (head != null && reverseLinkedList != null) {
			if (head.data == reverseLinkedList.data) {
				head = head.next;
				reverseLinkedList = reverseLinkedList.next;
				continue;
			} else {
				return false;
			}
		}
		return true;
	}

	/*
	 * Maintain two pointers – reference pointer and main pointer. Initialize both reference and main pointers to head. 
	 * First move reference pointer to n nodes from head. Now move both pointers one by one until reference pointer reaches end. 
	 * Now main pointer will point to nth node from the end. Return main pointer.
	 */
	public T findNthFromLastNode(int n) {
		if (head == null) {
			return null;
		}
		if (n < 0 || n > counter) {
			return null;
		}
		Node<T> currentNode = head;
		for (int i = 0; currentNode.next != null && i < counter - n; i++, currentNode = currentNode.next)
			;

		return currentNode.data;
	}

	public Node<T> findNthNodeFromLast(int n) {
		if (head == null) {
			return null;
		}
		Node<T> fastNode = head, slowNode = null;
		for (int i = 0; fastNode != null && i < n; i++, fastNode = fastNode.next)
			;

		for (slowNode = head; fastNode != null; slowNode = slowNode.next, fastNode = fastNode.next)
			;

		return slowNode;
	}

	public void display() {
		for (Node<T> currentNode = head; currentNode != null; currentNode = currentNode.next) {
			System.out.print(currentNode.data + "\t");
		}
	}

	public static void main(String[] args) {
		CustomLinkedList<Integer> t = new CustomLinkedList<Integer>();
		t.addLast(4);
		t.addLast(2);
		t.addLast(5);
		t.addLast(8);
		t.addLast(7);
		t.addLast(6);
		t.addLast(3);
		t.addLast(2);

		// t.makeCircularList(t.findNthNodeFromLast(2));

		// System.out.println(t.iscircularList());

		t.selectionSort();

		t.display();
	}

	public void selectionSort() {
		for (Node<T> selectionNode = this.head, previousNode1 = null; selectionNode.next != null; previousNode1 = selectionNode, selectionNode = selectionNode.next) {
			for (Node<T> currentNode = selectionNode, previousNode2 = null; currentNode.next != null; previousNode2 = currentNode, currentNode = currentNode.next) {
				if (selectionNode.data.compareTo((Integer) currentNode.data) > 0) {
					swap(previousNode1, previousNode2);
				}
			}
		}

	}

	/**
	 * @param selectionNode
	 * @param currentNode
	 */
	private void swap(Node<T> selectionNode, Node<T> currentNode) {
		Node<T> tempNode = selectionNode.next;
		selectionNode = currentNode.next;
		currentNode = tempNode.next;
	}

	public boolean iscircularList() {
		Node<T> fastNode = null, slowNode = null;

		for (slowNode = head, fastNode = head; fastNode != null && fastNode != slowNode; slowNode = slowNode.next, fastNode = fastNode.next.next)
			;
		if (fastNode != null)
			return true;

		return false;
	}

}

class Node<T extends Comparable<Integer>> {
	T data;
	Node<T> next;

	/**
	 * @param data
	 */
	public Node(T data) {
		super();
		this.data = data;
	}

	/**
	 * @return the data
	 */
	public T getData() {
		return data;
	}

	/**
	 * @param data
	 *            the data to set
	 */
	public void setData(T data) {
		this.data = data;
	}

	/**
	 * @return the next
	 */
	public Node<T> getNext() {
		return next;
	}

	/**
	 * @param next
	 *            the next to set
	 */
	public void setNext(Node<T> next) {
		this.next = next;
	}
}
