package ATMProject;

import java.math.BigDecimal;

public class PenyetoranTunai {
    private int norek;
    private BigDecimal jumlah;

    DataBank data = new DataBank();
    DispenserUangTunai dispenserCash = new DispenserUangTunai();

    public PenyetoranTunai(int norek, BigDecimal jumlah) {
        this.norek = norek;
        this.jumlah = jumlah;
    }


    public void execute() {
        data.rekening.credit(jumlah);
        System.out.println("Saldo Rek = " + data.rekening.getSaldo());
    }
}
