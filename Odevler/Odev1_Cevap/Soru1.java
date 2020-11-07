package Odev1_Cevabi;

/**
 *
 * @author Ahmet
 */
import java.util.Scanner;

class dugum {

    int katsayi, derece;
    dugum next;

    public dugum(int katsayi, int derece) {
        this.katsayi = katsayi;
        this.derece = derece;
        next = null;
    }
}

class Bagli_Liste {

    dugum bas, son;

    public Bagli_Liste() {
        bas = null;
        son = null;
    }

    public void basaEkle(int katsayi, int derece) {
        dugum eleman = new dugum(katsayi, derece);
        if (son == null) {
            bas = eleman;
            son = eleman;
        } else {
            eleman.next = bas;
            bas = eleman;
        }
    }

    public void arayaEkle(int katsayi, int derece, int index) {
        dugum eleman = new dugum(katsayi, derece);
        int i = 1;
        dugum tmp = bas;
        while (tmp != null) {
            if (i == index) {
                eleman.next = tmp.next;
                tmp.next = eleman;
            }
            tmp = tmp.next;
            i++;
        }
    }

    public void sonaEkle(int katsayi, int derece) {
        dugum eleman = new dugum(katsayi, derece);
        if (bas == null) {
            son = eleman;
            bas = eleman;
        } else {
            son.next = eleman;
            son = eleman;
        }
    }

    public int dereceSirala(int yeniDerece) {
        dugum tmp = bas;
        int tempDerece;
        int index = 1;
        while (tmp != null) {
            tempDerece = tmp.derece;
            if (yeniDerece < tempDerece && yeniDerece > tmp.next.derece == false) {
                index++;
            } else if (yeniDerece < tempDerece && yeniDerece > tmp.next.derece == true) {
                break;
            }
            tmp = tmp.next;
        }
        return index;
    }

    public void goster() {
        dugum tmp = bas;
        while (tmp != null) {
            System.out.println(tmp.katsayi + " " + tmp.derece);
            tmp = tmp.next;
        }
        if (bas == null && son == null) {
            System.out.println("Liste Boş");
        }
    }
}

public class Soru1 {

    public static void main(String[] args) {
        Bagli_Liste b = new Bagli_Liste();
        Scanner sc = new Scanner(System.in);
        boolean kontrol = true;
        int katsayi, derece;

        do {
            System.out.println("Elemanı basa eklemek istiyorsan  => 1");
            System.out.println("Elemanı sona eklemek istiyorsan  => 2");
            System.out.println("Elemanı araya eklemek istiyorsan => 3");
            System.out.println("Elemanları listelemek istiyorsan => 4");
            System.out.println("Programı sonlandırmak için       => 0");
            int secim = sc.nextInt();

            switch (secim) {
                case 1:
                    System.out.print("polinom için katsayı giriniz: ");
                    katsayi = sc.nextInt();
                    System.out.print("polinom için derece giriniz: ");
                    derece = sc.nextInt();
                    b.basaEkle(katsayi, derece);
                    break;
                case 2:
                    System.out.print("polinom için katsayı giriniz: ");
                    katsayi = sc.nextInt();
                    System.out.print("polinom için derece giriniz: ");
                    derece = sc.nextInt();
                    b.sonaEkle(katsayi, derece);
                    break;
                case 3:
                    System.out.print("polinom için katsayı giriniz: ");
                    katsayi = sc.nextInt();
                    System.out.print("polinom için derece giriniz: ");
                    derece = sc.nextInt();
                    int index = b.dereceSirala(derece);
                    b.arayaEkle(katsayi, derece, index);
                    break;
                case 4:
                    b.goster();
                    break;
                case 0:
                    System.out.println("Polinom listeye eklendi ve program sonlandı.");
                    kontrol = false;
                    break;
            }

        } while (kontrol != false);

    }

}
