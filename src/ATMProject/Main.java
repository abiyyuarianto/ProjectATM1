package ATMProject;
import java.math.BigDecimal;
import java.util.Scanner;

public class Main {

    public static void main (String[] args){
        int menu;
        int noRek;
        boolean userAuthenticate = false;

        Scanner input = new Scanner(System.in);
        DataBank dataBank = new DataBank();

        System.out.print("Masukan No Rekening Anda: ");
        noRek = input.nextInt();

        do{
            System.out.print("Masukan PIN Anda: ");
            int PIN = input.nextInt();
            if(dataBank.authenticateUser(noRek,PIN)){
                userAuthenticate = true;
            }else {
                System.out.print("PIN SALAH! ");
            }
        } while (!userAuthenticate);

        do {
                System.out.println("1.Cek Saldo");
                System.out.println("2.Tarik Tunai");
                System.out.println("3.Setor Tunai");
                System.out.println("4.Keluar");
                System.out.print("Pilih Menu: ");

                menu = input.nextInt();
                switch (menu) {
                    case 1:
                        PengecekanSaldo inquiry = new PengecekanSaldo(dataBank);
                        System.out.println("Saldo = "+ inquiry.execute().toString());
                        break;
                    case 2:
                        System.out.print("Jumlah yang ditarik = ");
                        BigDecimal cash = input.nextBigDecimal();
                        PenarikanTunai tarikTunai = new PenarikanTunai(cash, dataBank);
                        tarikTunai.execute();
                        break;
                    case 3:
                        System.out.print("Jumlah yang disetor = ");
                        BigDecimal cashSetor = input.nextBigDecimal();
                        PenyetoranTunai setorTunai = new PenyetoranTunai(cashSetor, dataBank);
                        setorTunai.execute();
                        break;
                    case 4:
                        break;
                }
        }while (menu!=4);

    }
}