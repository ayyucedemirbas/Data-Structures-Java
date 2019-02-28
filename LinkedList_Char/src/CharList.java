
public class CharList {
	
	Karakter head;  //Bagli listenin basi
	
	class Karakter{//Dugumler Karakter olarak isimlendirildi
		char c;//Her bir dugumun verisi char tipinde olacak
		Karakter next; //Bir sonraki eleman ile baglantiyi saglamak icin
		Karakter(char c){//constructor metot
			this.c=c;
			next=null;
		}
	}
	
	Karakter sonuBul(Karakter baslangic) { //En son elemani bulmak icin
		while(baslangic.next != null) {
			baslangic=baslangic.next;
		}
		return baslangic;
	}
	
	void basaEkle(char key) {
		Karakter k= new Karakter(key);
		k.next=head;
		head=k;
	}
	
	void arayaEkle(char key, Karakter prev) {
		if(prev!=null) {
		Karakter k= new Karakter(key);
		k.next=prev.next;
		prev.next=k;
		}
		
	}
	
	void sonaEkle(char key) {
		Karakter k= new Karakter(key);
		if(head==null) {
			head=new Karakter(key);
			return;
		}
		
		k.next=null;
		
		Karakter last=sonuBul(head);
		
	
		last.next=k;
		return;
	}
	
	
	
	void bastanSil(Karakter baslangic) {
		if(head==null) {return;}
		Karakter son=sonuBul(baslangic);
		if(head==son) {
			head=null; son=null;
		}
		
		
		
		head=head.next;
		
	}
	
	void sondanSil() {
		Karakter son= sonuBul(head);
		Karakter tmp, prev;
		tmp=head;
		prev=null;
		while(tmp!=son) {
			prev=tmp;
			tmp=tmp.next;
		}
		
		if(prev==null) {
			head=null;
		}
		else {
			prev.next=null;
		}
		son=prev;

       
	}

	void aradanSil(int konum) {
		if(head==null) {return;}
		Karakter temp=head;
		if(konum==0) {head=temp.next; return;}
		for(int i=0; temp!=null&&i<konum-1;i++) {
			temp=temp.next;
		}
		
		if(temp==null||temp.next==null) {return;}
		
		Karakter next=temp.next.next;
		temp.next=next;
	}
	
	void printList(Karakter bas) {
		while (bas!=null) {
			System.out.println(bas.c);
			bas=bas.next;
		}
	}
	
	
	public static void main(String[] args) {
		CharList cl= new CharList();
		cl.basaEkle('b');
		cl.basaEkle('h');
		cl.basaEkle('a');
		cl.basaEkle('t');
		
		cl.printList(cl.head);
		System.out.println("   ");
		
		cl.arayaEkle('j', cl.head.next);
	
		
		cl.printList(cl.head);
		
	/*	System.out.println(" ");
		
		//cl.sondanSil();
		
		cl.bastanSil(cl.head);
		
		cl.printList(cl.head);
		
		System.out.println("  ");
		
		
		cl.sondanSil();
		    
		
		cl.printList(cl.head);*/
		
	}

}
