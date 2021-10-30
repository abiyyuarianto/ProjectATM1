package ATMProject;

import org.jetbrains.annotations.NotNull;

import java.math.BigDecimal;

public class DispenserUangTunai {
    private int jumlah = 1000; // jumlah uang tunai di dispenser 1000Lembar
    final int denom50 = 50000; //nilai uang perlembar

    //method untuk mendapatkan jumlah lembar uang cash
    public int getJumlah() {
        return jumlah;
    }

    //Method untuk mengeluarkan lembaran uang cash
    public void dispenseCash(BigDecimal cash){
        this.jumlah-=cash.intValue()/denom50;
    }

    //Method untuk cek kecukupan uang cash
    public boolean isSufficient(BigDecimal cash){
       return this.jumlah >=cash.intValue()/denom50;
    }

    //Method untuk menambah lembaran uang cash
    public void addCash(BigDecimal cash){
        this.jumlah+=cash.intValue()/denom50;
    }

    //Method untuk konvert nilai lembar uang kas ke nominal jumlahnya
    public BigDecimal getSaldoATM(){
        return new BigDecimal(jumlah*denom50);
    }

    //Method untuk memastikan nilai uang kelipatan 50rb
    public boolean isValidDenom(BigDecimal cash){
        return (cash.intValue()%denom50==0);
    }
}
