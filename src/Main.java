package ATMProject;
import java.util.Scanner;

public class Main {

    public static void main (String[] args){
        int noRek;
        int PIN;
        int menu;
        Scanner input = new Scanner(System.in);
        DataBank dataBank = new DataBank();
        Rekening rekening = new Rekening();

        System.out.print("Masukan No Rekening Anda: ");
        noRek = input.nextInt();
        rekening.setNoRekening(noRek);

        System.out.print("Masukan PIN Anda: ");
        PIN = input.nextInt();
        rekening.setPin(PIN);

        if(dataBank.getUser(noRek, PIN) == true){
            do {
                System.out.println("---Menu---");
                System.out.println("1.Pengecekan Saldo");
                System.out.println("2.Penarikan Tunai");
                System.out.println("3.Penyetoran Tunai");
                System.out.println("4.Keluar");
                System.out.print("Pilihan Menu: ");
                menu = input.nextInt();

                String nama;
                int jumlah;

                switch (menu) {
                    case 1:
                        PengecekanSaldo pengecekanSaldo = new PengecekanSaldo();
                        pengecekanSaldo.cekSaldo(noRek);

                        break;
                    case 2:
                        System.out.print("Input nama produk yang akan di-HAPUS: ");
                        nama = input.next();//inputan nama produk

                        break;
                    case 3:
                        System.out.print("Input nama produk yang akan di-UBAH:");
                        nama = input.next();

                        break;
                    case 4:
                        break;
                }
            }while (menu!=4);

        }else {
            System.out.println("No Rekening dan PIN Anda Salah");
        }

    }



}