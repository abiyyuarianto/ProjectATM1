package ATMProject;

import java.math.BigDecimal;

public class DispenserUangTunai {
    private int jumlah = 1000; // jumlah uang tunai di dispenser 1000Lembar
    private int denom50 = 50000; //nilai uang perlembar

    public DispenserUangTunai() {
    }

    //Method untuk mengeluarkan lembaran uang cash
    public void dispenseCash(BigDecimal jumlah){
        while (isSufficient(jumlah)){
            this.jumlah-=jumlah.intValue()/denom50;
        }
    }

    //Method untuk cek kecukupan uang cash
    public boolean isSufficient(BigDecimal jumlah){
       return this.jumlah >jumlah.intValue()/denom50;
    }
}
