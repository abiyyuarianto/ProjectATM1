package ATMProject;

import java.math.BigDecimal;

public class PenyetoranTunai {
    private BigDecimal jumlah;
    private DataBank dataBank;
    private DispenserUangTunai dispenserCash;

    public PenyetoranTunai(BigDecimal jumlah, DataBank dataBank, DispenserUangTunai dispenserCash) {
        this.jumlah = jumlah;
        this.dataBank = dataBank;
        this.dispenserCash = dispenserCash;
    }

    public void execute() {
        if(dispenserCash.isValidDenom(jumlah)) {
            dataBank.credit(jumlah);
            //TO DO : update
            dispenserCash.addCash(jumlah);
            System.out.println("Saldo Rek: " + dataBank.rekening.getSaldo());
            System.out.println("*Saldo ATM: " + dispenserCash.getJumlah() + " Lembar = " + dispenserCash.getSaldoATM());
        }else{
            System.out.println("Setoran harus kelipatan 50.000");
        }
    }
}
