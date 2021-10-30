package ATMProject;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

public class PenarikanTunai {

    private BigDecimal jumlah;
    private DataBank data;
    private DispenserUangTunai dispenserCash;

    public PenarikanTunai(BigDecimal jumlah, DataBank data, DispenserUangTunai dispenserCash) {
        this.jumlah = jumlah;
        this.data = data;
        this.dispenserCash = dispenserCash;
    }

    public void execute(){
        DecimalFormat kursIndonesia = (DecimalFormat) DecimalFormat.getCurrencyInstance();
        DecimalFormatSymbols formatRp = new DecimalFormatSymbols();

        formatRp.setCurrencySymbol("Rp. ");
        formatRp.setMonetaryDecimalSeparator(',');
        formatRp.setGroupingSeparator('.');

        kursIndonesia.setDecimalFormatSymbols(formatRp);

        //cek available saldo
        if(data.rekening.getSaldo().compareTo(jumlah)>0){
            if(dispenserCash.isValidDenom(jumlah)) {
                if (dispenserCash.isSufficient(jumlah)) {
                    dispenserCash.dispenseCash(jumlah);
                    data.debit(jumlah);
                    System.out.println("Saldo Rek: " + kursIndonesia.format(data.rekening.getSaldo()));
                    System.out.println("*Saldo ATM: " + dispenserCash.getJumlah() + " Lembar = " + kursIndonesia.format(dispenserCash.getSaldoATM()));
                } else {
                    System.out.println("Maaf, saldo ATM tidak cukup");
                }
            }else{
                System.out.println("Jumlah harus kelipatan 50.000");
            }
        }else{
            System.out.println("Saldo tidak cukup");
        }


    }
}
