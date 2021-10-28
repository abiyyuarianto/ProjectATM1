package ATMProject;

import java.math.BigDecimal;

public class PenarikanTunai {
    private int norek;
    private BigDecimal jumlah;

    DataBank data = new DataBank();
    DispenserUangTunai dispenserCash = new DispenserUangTunai();

    public PenarikanTunai(int norek, BigDecimal jumlah) {
        this.norek = norek;
        this.jumlah = jumlah;
    }

    public void execute(){
        //cek available saldo
        if(data.getSaldo(norek).compareTo(jumlah)>0){
            if (dispenserCash.isSufficient(jumlah)){
                dispenserCash.dispenseCash(jumlah);
                data.rekening.debit(jumlah);
            }
        }
        System.out.println("Saldo nasabah = " +data.rekening.getSaldo());
        System.out.println("Saldo Dispenser Cash = " +dispenserCash.getJumlah()+ " Lembar");

    }
}
