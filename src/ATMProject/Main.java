package ATMProject;
import java.math.BigDecimal;
import java.util.Scanner;
import java.util.InputMismatchException;

public class Main {

    public static void main (String[] args){
        int menu;
        boolean bError = true;
        boolean userAuthenticate = false;

        Scanner input = new Scanner(System.in);
        DataBank dataBank = new DataBank();
        DispenserUangTunai dispenserUangTunai = new DispenserUangTunai();
        try {
            do {
                System.out.print("Masukan No Rekening Anda: ");
                int noRek = input.nextInt();
                System.out.print("Masukan PIN Anda: ");
                int PIN = input.nextInt();
                if (dataBank.authenticateUser(noRek, PIN)) {
                    userAuthenticate = true;
                } else {
                    System.out.print("PIN SALAH! ");
                }
            } while (!userAuthenticate);

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
                        PengecekanSaldo inquiry = new PengecekanSaldo(dataBank);
                        inquiry.execute();
                        break;
                    case 2:
                        System.out.print("Jumlah yang ditarik = ");
                        BigDecimal cash = input.nextBigDecimal();
                        PenarikanTunai tarikTunai = new PenarikanTunai(cash, dataBank, dispenserUangTunai);
                        tarikTunai.execute();
                        break;
                    case 3:
                        System.out.print("Jumlah yang disetor = ");
                        BigDecimal cashSetor = input.nextBigDecimal();
                        PenyetoranTunai setorTunai = new PenyetoranTunai(cashSetor, dataBank, dispenserUangTunai);
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