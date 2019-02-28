
public class MainClass {
public static void main(String[] args) {
	StackX s = new StackX(10);
	s.push(10);
	s.push(20);
	s.push(30);
	s.push(40);
	s.push(50);
	
	while(!s.empty()) {
		double value=s.pop();
		System.out.println(value);
	}
}
}
