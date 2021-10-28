package ATMProject;

import java.math.BigDecimal;

public class PenyetoranTunai {
    private BigDecimal jumlah;
    private DataBank dataBank;
    DispenserUangTunai dispenserCash = new DispenserUangTunai();

    public PenyetoranTunai(BigDecimal jumlah, DataBank dataBank) {
        this.jumlah = jumlah;
        this.dataBank = dataBank;
    }

    public void execute() {
        dataBank.credit(jumlah);
        //TO DO : update
        dispenserCash.addCash(jumlah);
        System.out.println("Saldo Rek = " + dataBank.rekening.getSaldo());
        System.out.println("Saldo Dispenser Cash = " +dispenserCash.getJumlah()+ " Lembar");
    }
}
