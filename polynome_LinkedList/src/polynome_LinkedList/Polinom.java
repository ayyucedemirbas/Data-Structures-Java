package polynome_LinkedList;

public class Polinom { //Bagli Listeye polinom ismi verildi
	
	class Terim{ // Bagli Listenin her bir elemani terim olarak isimlendirildi 
		int katsayi, derece; //Her bir terim (dugum), veri olarak katsayi ve derece bilgilerini tutacak
		Terim next;//Bir sonraki elemana (terime) erisim icin tanimlandi
		Terim(int katsayi, int derece){ //constructor metot ile, Terim tipinde nesne olusturulurken  degisken degerlerinin alinip class icindeki ilgili yere atanmasi saglaniyor
			
			this.katsayi=katsayi; //parametre degerleri Terim classi icindeki degiskenlere atandi. 
			this.derece=derece;
			next=null; //varsayilan olarak null degere sahip, dugumler birbirine baglanirken bir sonraki dugumun (terimin) adres bilgisini tutacak

		}
	}
	
	Terim head;//Bagli listenin bas elemanini tutacak. 
	Terim tmp= null; //Bas kismi tutan head degiskeninin bir kopyasi. Bagli listenin bas kismini (head)degistirmemek icin kullanildi 
	
	 void terimEkle(Terim terim) { // Bagli listeye dereceye gore sirali olarak terim (dugum) ekleyecek metot. 
	     
	         Terim current; 
	  
	        
	         if (head == null || head.derece <= terim.derece) { //bas kisim yani ilk terim (head)yoksa 
	         
	            terim.next = head; //yeni eklenen terim,bas kisimdaki (head) terimi gostececek, yani baglanacak.
	            head = terim; //yeni eklenen terim bas kisim (head) olacak boylece en buyuk dereceye sahip terim head olacak
	            
	           // System.out.println("if icinde" + terim.derece);
	         } 
	         else { // yukaridaki if sarti saglanmazsa bu bloga gelinecek
	  
	          
	            current = head; // head degerini degistirmemek icin current adinda baska bir degisken kullaniliyor
	  
	            while (current.next != null && current.next.derece > terim.derece) { //dongu ile yeri degistirilecek eleman bulunur

	            	
	            	current = current.next;
	            	//System.out.println("dongude"+current.derece);
	            	
	                  }
	           
	            
	        //    System.out.println("dongu disi"+current.derece);
	            
	   
	            terim.next = current.next; //buyuk dereceli terim ile kucuk dereceli terim yer degistiriyor, boylece sirali bir sekilde listeye eleman ekleniyor
	            current.next = terim; 
	         } 
	     } 
	 
	 
	 Terim terimOlustur(int katsayi, int derece) {//Yeni Terim (dugum) olusturmak icin bir metot
		 Terim yeniT= new Terim(katsayi,derece);
		 //olusturulan terim geri donduruluyor
		 return yeniT;
	 }
	 
	void ekranaYaz(Terim t) {//Son elemana gelene kadar (son eleman da dahil) ekrana yazar
		 
		 while (t!=null) {
			 System.out.print(t.katsayi + "x^" +t.derece+" + ");
			 t=t.next;
		 }
		 
		 
		 
	 }
	 
	 
	
	
	 
	 
	 public static void main(String[] args) {
		 
		 Polinom yeni= new Polinom();//yeni isminde bir polinom tanimlaniyor
		 yeni.terimEkle(yeni.terimOlustur(6, 3)); //metotlar static olmadigi icin yeni isimli Polinom tipinde nesne uzerinden erisim saglaniyor
		 yeni.terimEkle(yeni.terimOlustur(3, 2)); //yeni terimler olusturulup eklenmesi icin ilgili metoda parametre olarak veriliyor
		 yeni.terimEkle(yeni.terimOlustur(1, 4));
		 yeni.terimEkle(yeni.terimOlustur(5, 1));
		 
		 yeni.tmp=yeni.head;
		 
		 yeni.ekranaYaz(yeni.tmp); // Polinom ekrana yaziliyor
		System.out.println("\n    Bas kisim  "+ yeni.head.katsayi + "x^" +yeni.head.derece); //polinomun basi (head) ekrana yaziliyor
		
		 
		
	}
	 

}
