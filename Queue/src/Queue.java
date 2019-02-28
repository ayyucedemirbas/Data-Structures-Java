
public class Queue {
	private int size;
	private int QueueArr[];
	private int front;
	private int rear;
	private int number;
	public Queue(int s) {
		size =s;
		QueueArr= new int[size];
		front =0;
		rear=-1;
		number=0;
	}
	public void add(int j) {
		if(rear==(size-1)) {
			rear=-1;
		}
		QueueArr[++rear]=j;
		number++;
		
	}
	
	public int remove() {
		int temp=QueueArr[front++];
		if(front==size) {
			front=0;
		}
		number--;
		return temp;
	}
	public boolean isEmpty() {
		return number==0;
	}
	

}
