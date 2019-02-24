package Lecture12;

public class StackUsingLinkedList {
	private LinkedList list;

	public StackUsingLinkedList() {
		// TODO Auto-generated constructor stub
		list = new LinkedList();
	}
	
	public int size(){
		return this.list.size();
	}
	
	public boolean isEmpty(){
		return this.list.isEmpty();
	}
	
	public void push(int data){
		this.list.addFirst(data);
	}
	
	public int pop() throws Exception{
		int rv=this.list.getFirst();
		this.list.removeFirst();
		return rv;
	}
	
	public int top() throws Exception{
		int rv=this.list.getFirst();
		return rv;
	}
	
	public void display(){
		this.list.display();
	}
}
