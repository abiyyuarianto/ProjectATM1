package ATMProject;

import org.jetbrains.annotations.NotNull;

import java.math.BigDecimal;

public class DispenserUangTunai {
    private int jumlah = 1000; // jumlah uang tunai di dispenser 1000Lembar
    private int denom50 = 50000; //nilai uang perlembar

    public DispenserUangTunai() {
    }

    public int getJumlah() {
        return jumlah;
    }

    //Method untuk mengeluarkan lembaran uang cash
    public void dispenseCash(BigDecimal cash){
        this.jumlah-=cash.intValue()/denom50;
    }

    //Method untuk cek kecukupan uang cash
    public boolean isSufficient(BigDecimal cash){
       return this.jumlah >cash.intValue()/denom50;
    }
}
