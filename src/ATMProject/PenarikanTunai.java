package ATMProject;

import java.math.BigDecimal;

public class PenarikanTunai {

    private BigDecimal jumlah;
    DataBank data;

    DispenserUangTunai dispenserCash = new DispenserUangTunai();

    public PenarikanTunai(BigDecimal jumlah, DataBank data) {
        this.jumlah = jumlah;
        this.data = data;
    }

    public void execute(){
        //cek available saldo
        if(data.rekening.getSaldo().compareTo(jumlah)>0){
            if (dispenserCash.isSufficient(jumlah)){
                dispenserCash.dispenseCash(jumlah);
                data.debit(jumlah);
            }
        }
        System.out.println("Saldo nasabah = " +data.rekening.getSaldo());
        System.out.println("Saldo Dispenser Cash = " +dispenserCash.getJumlah()+ " Lembar");

    }
}
