package ATMProject;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
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
        //Separator
        DecimalFormat kursIndonesia = (DecimalFormat) DecimalFormat.getCurrencyInstance();
        DecimalFormatSymbols formatRp = new DecimalFormatSymbols();

        formatRp.setCurrencySymbol("Rp. ");
        formatRp.setMonetaryDecimalSeparator(',');
        formatRp.setGroupingSeparator('.');

        kursIndonesia.setDecimalFormatSymbols(formatRp);

        if(dispenserCash.isValidDenom(jumlah)) {
            dataBank.credit(jumlah);
            //TO DO : update
            dispenserCash.addCash(jumlah);
            System.out.println("Saldo Rek: " + kursIndonesia.format(dataBank.rekening.getSaldo()));
            System.out.println("*Saldo ATM: " + dispenserCash.getJumlah() + " Lembar = " + kursIndonesia.format(dispenserCash.getSaldoATM()));
        }else{
            System.out.println("Setoran harus kelipatan 50.000");
        }
    }
}
