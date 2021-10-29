package ATMProject;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.math.BigDecimal;

public class PengecekanSaldo {

    private DataBank dataBank;

    public PengecekanSaldo(DataBank dataBank) {
        this.dataBank = dataBank;
    }

    public void execute(){
        DecimalFormat kursIndonesia = (DecimalFormat) DecimalFormat.getCurrencyInstance();
        DecimalFormatSymbols formatRp = new DecimalFormatSymbols();

        formatRp.setCurrencySymbol("Rp. ");
        formatRp.setMonetaryDecimalSeparator(',');
        formatRp.setGroupingSeparator('.');

        kursIndonesia.setDecimalFormatSymbols(formatRp);
        System.out.printf("Saldo: %s %n", kursIndonesia.format(this.dataBank.rekening.getSaldo()));
    }
}
