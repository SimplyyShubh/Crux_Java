package Lecture11;

public class QUSEnqueueEfficientClient {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		QUSEnqueueEfficient obj = new QUSEnqueueEfficient();
		obj.enqueue(10);
		obj.enqueue(20);
		obj.enqueue(30);
		obj.enqueue(40);
		obj.enqueue(50);
		obj.display();
		System.out.println(obj.dequeue());
		obj.display();
	}

}
