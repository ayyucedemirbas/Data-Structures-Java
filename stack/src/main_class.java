
public class main_class {
public static void main(String[] args){
	StackX s= new StackX(10);
	s.push(20);
	s.push(40);
	s.push(60);
	s.push(80);
	
	double value;
	while(!s.Empty()){
		value=s.pop();
		System.out.println(value);
		
	}
}
}
