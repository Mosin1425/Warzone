package org.war.day_11;

public class LinkedList {
	private Node head;
	private Node tail;
	private int size;

	public LinkedList() {
		this.size = 0;
	}

	public void insertFirst(int data) {
		Node node = new Node(data);

		node.next = head;
		head = node;

		if (tail == null) {
			tail = head;
		}
		size++;
	}

	public void insertLast(int data) {
		if (head == null) {
			insertFirst(data);
			return;
		}

		Node node = new Node(data);
		Node temp = head;

		while (temp.next != null) {
			temp = temp.next;
		}
		temp.next = node;
		size++;
	}

	public int size() {
		return size;
	}

	public void insertMiddle(int data, int index) {
		if (index < 0 || index > size) {
			throw new IndexOutOfBoundsException("Index out of bounds");
		}
		if (index == 0) {
			insertFirst(data);
			return;
		}
		if (index == size) {
			insertLast(data);
			return;
		}

		Node node = new Node(data);
		Node temp = head;

		for (int i = 1; i < index; i++) {
			temp = temp.next;
		}
		node.next = temp.next;
		temp.next = node;
		size++;
	}

	public int deleteFirst() {
		int data = head.data;
		head = head.next;
		size--;

		return data;
	}

	public int deleteLast() {
		if (head == null || head.next == null) {
			return deleteFirst();
		}
		Node temp = head;

		while (temp.next.next != null) {
			temp = temp.next;
		}
		int data = temp.next.data;
		temp.next = null;

		return data;
	}

	public Node get(int index) {
		Node temp = head;
		
		for(int i=0;i<index;i++) {
			temp = temp.next;
		}
		return temp;
	}
	
	public void traverse() {
		Node temp = head;

		while (temp != null) {
			System.out.print(temp.data + "->");
			temp = temp.next;
		}
		System.out.println("null");

	}
	public void func() {
		System.out.println(head.next);
	}
}
