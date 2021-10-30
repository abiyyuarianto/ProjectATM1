package ATMProject;
import java.math.BigDecimal;
import java.util.Scanner;
import java.util.InputMismatchException;

public class Main {

    public static void main (String[] args){
        int menu;
        Scanner input = new Scanner(System.in);
        ATM atm = new ATM();

        try {
            do {
                System.out.print("Masukan No Rekening Anda: ");
                int noRek = input.nextInt();
                System.out.print("Masukan PIN Anda: ");
                int PIN = input.nextInt();
                if (atm.dataBank.authenticateUser(noRek, PIN)) {
                    atm.setUserAuthenticate(true);
                } else {
                    System.out.print("PIN SALAH! ");
                }
            } while (!atm.isUserAuthenticate());

            do {
                System.out.println("\t=======Menu=======");
                System.out.println("\t1.Cek Saldo");
                System.out.println("\t2.Tarik Tunai");
                System.out.println("\t3.Setor Tunai");
                System.out.println("\t4.Keluar");
                System.out.print("Pilih Menu: ");

                menu = input.nextInt();
                switch (menu) {
                    case 1:
                        PengecekanSaldo inquiry = new PengecekanSaldo(atm.dataBank);
                        inquiry.execute();
                        break;
                    case 2:
                        System.out.print("Jumlah yang ditarik = ");
                        BigDecimal cash = input.nextBigDecimal();
                        PenarikanTunai tarikTunai = new PenarikanTunai(cash, atm.dataBank, atm.dispenserUangTunai);
                        tarikTunai.execute();
                        break;
                    case 3:
                        System.out.print("Jumlah yang disetor = ");
                        BigDecimal cashSetor = input.nextBigDecimal();
                        PenyetoranTunai setorTunai = new PenyetoranTunai(cashSetor, atm.dataBank, atm.dispenserUangTunai);
                        setorTunai.execute();
                        break;
                    case 4:
                        break;
                }
            } while (menu != 4);
        } catch (InputMismatchException e) {
            System.out.println("Invalid Input");
            System.out.println("===========END============");
        }
    }
}