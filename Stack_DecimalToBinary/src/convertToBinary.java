

public class convertToBinary {
	static int boyut=0;
	static Stack stack= new Stack(15);
	static void convert(int decimal) {
		
		
		while(decimal>0) {
			stack.push(stack.olustur(decimal%2));
			decimal=decimal/2;
			boyut++;
		}
		
	}
	
	static int convertToDecimal() {
		int result=0;
		for(int i=0;i<boyut;i++) {
			System.out.println(stack.peek());
			if(stack.pop()==1) {
				
			result+=(Math.pow(2, boyut-1-i));}
		}
		return result;
		
	}

	
	static String stackToString(Stack s) {
		String result="";
		for(int i=0;i<boyut;i++) {
			result+=s.pop();
		}
		return result;
	}
	public static void main(String[] args) {
	
		convert(87);
		//String sonuc=stackToString(stack);
		//System.out.println(sonuc);
		/*for(int i=0; i<boyut; i++){
			System.out.println(stack.pop());
		}*/
		int reconvert=convertToDecimal();
		
		System.out.println(reconvert);
		
		
	}

}
