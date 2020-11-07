package Odev1_Cevabi;

import java.util.Scanner;

/**
 *
 * @author Ahmet
 */
class Dugum2 {

    char karakter;
    Dugum2 next;

    public Dugum2(char karakter) {
        this.karakter = karakter;
        next = null;
    }
}

class Bagli_liste2 {

    Dugum2 bas, son;

    public Bagli_liste2() {
        bas = null;
        son = null;
    }

    public void basaEkle(char karakter) {
        Dugum2 eleman = new Dugum2(karakter);
        if (son == null) {
            bas = eleman;
            son = eleman;
        } else {
            eleman.next = bas;
            bas = eleman;
        }
    }

    public void arayaEkle(char karakter, int index) {
        Dugum2 eleman = new Dugum2(karakter);
        Dugum2 tmp = bas;
        int indis = 1;
        while (tmp != null) {
            if (indis == index) {
                eleman.next = tmp.next;
                tmp.next = eleman;
            }
            tmp = tmp.next;
            indis++;
        }
    }

    public void sonaEkle(char karakter) {
        Dugum2 eleman = new Dugum2(karakter);
        if (bas == null) {
            bas = eleman;
            son = eleman;
        } else {
            son.next = eleman;
            son = eleman;
        }
    }

    public void bastanSil() {
        bas = bas.next;
        if (bas == null) {
            son = null;
        }
    }

    public void aradanSil(int index) {
        Dugum2 tmp = bas;
        Dugum2 once = null;
        int indis = 1;
        while (indis != index) {
            once = tmp;
            tmp = tmp.next;
            indis++;
        }
        once.next = tmp.next;
    }

    public void sondanSil() {
        Dugum2 tmp = bas;
        Dugum2 once = null;
        while (tmp != son) {
            once = tmp;
            tmp = tmp.next;
        }
        if (once == null) {
            bas = null;
            son = null;
        } else {
            once.next = null;
            son = once;
        }

    }

    public void goster() {
        Dugum2 tmp = bas;
        while (tmp != null) {
            System.out.print(tmp.karakter + " ");
            tmp = tmp.next;
        }
        if (bas == null && son == null) {
            System.out.println("Liste Boş");
        }
    }
}

public class Soru2 {

    public static void main(String[] args) {
        Bagli_liste2 b2 = new Bagli_liste2();
        Scanner sc = new Scanner(System.in);

        boolean kontrol = true;
        int katsayi, derece;

        do {
            System.out.println();
            System.out.println("Elemanı basa eklemek istiyorsan  => 1");
            System.out.println("Elemanı sona eklemek istiyorsan  => 2");
            System.out.println("Elemanı araya eklemek istiyorsan => 3");
            System.out.println("Elemanı baştan silmek istiyorsan => 4");
            System.out.println("Elemanı aradan silmek istiyorsan => 5");
            System.out.println("Elemanı sondan silmek istiyorsan => 6");
            System.out.println("Elemanları listelemek istiyorsan => 7");
            System.out.println("Programı sonlandırmak için       => 0");
            System.out.println();

            int secim = sc.nextInt();

            switch (secim) {
                case 1:
                    System.out.print("Karakter giriniz: ");
                    char karakter = sc.next().charAt(0);
                    b2.basaEkle(karakter);
                    break;
                case 2:
                    System.out.print("Karakter giriniz: ");
                    char karakter2 = sc.next().charAt(0);
                    b2.sonaEkle(karakter2);
                    break;
                case 3:
                    System.out.print("Karakter giriniz: ");
                    char karakter3 = sc.next().charAt(0);
                    System.out.print("İndis değeri giriniz: ");
                    int index = sc.nextInt();
                    b2.arayaEkle(karakter3, index);
                    break;
                case 4:
                    b2.bastanSil();
                    break;
                case 5:
                    System.out.print("Silinmesini istediğiniz index i giriniz: ");
                    int index2 = sc.nextInt();
                    b2.aradanSil(index2);
                    break;
                case 6:
                    b2.sondanSil();
                    break;
                case 7:
                    b2.goster();
                    break;
                case 0:
                    System.out.println("Listeye ekleme tamamlandı ve program sonlandı.");
                    kontrol = false;
                    break;
            }

        } while (kontrol != false);
    }
}
