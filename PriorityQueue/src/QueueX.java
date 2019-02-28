import java.util.Iterator;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class QueueX {
public static void main(String[] args) {
	PriorityQueue <String> pq= new PriorityQueue <String>();
	pq.add("Masa");  pq.add("Sira"); pq.add("Sandalye");
	Iterator <String> itr= pq.iterator();
	while(itr.hasNext()) {
		System.out.println(itr.next());
	}
	while(pq.size()>0) {
		System.out.println(pq.remove());
	}
}
}
