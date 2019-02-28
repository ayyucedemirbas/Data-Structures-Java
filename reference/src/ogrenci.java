public class ogrenci {
	public String ad, soyad;
	public int numara, not;
	ogrenci next;
	public ogrenci(String ad,String soyad,int numara , int not){
		this.ad=ad;
		this.soyad=soyad;
		this.numara=numara;
		this.not=not;
		this.next=null;
	}
	public String toString(){
		return ad+" "+soyad+" "+numara+" "+not;
	}

}