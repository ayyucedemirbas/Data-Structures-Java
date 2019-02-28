import java.util.*;
public class main_class {
	public static void main(String[] args){
		ogrenci root= null;
		ogrenci tail;
		String ad,soyad;
		int numara,not;
		ogrenci ilk=null;
		
		Scanner k= new Scanner(System.in);
		System.out.println("Ad");
		ad= k.nextLine();
		System.out.println("Soyad");
		soyad= k.nextLine();
		System.out.println("Numara");
		numara= k.nextInt();
		System.out.println("Not");
		not=k.nextInt();
	    root=new ogrenci(ad,soyad,numara,not);
		tail=root;
		
		for(int i=0;i<9;i++){
			System.out.println("Ad");
			ad= k.next();
			System.out.println("Soyad");
			soyad= k.next();
			System.out.println("Numara");
			numara= k.nextInt();
			System.out.println("Not");
			not=k.nextInt();
			k.nextLine();
			tail.next=new ogrenci(ad,soyad,numara,not);
			tail=tail.next;
		}
		ogrenci temp=root;
		while(temp!=null){
			System.out.println(temp.toString());
			temp=temp.next;
		}
	}
		
}