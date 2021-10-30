package ATMProject;

import java.math.BigDecimal;

public class Rekening {
    private int noRekening;
    private int pin;
    private BigDecimal saldo;

    public Rekening() {
        this.noRekening = 111;
        this.pin = 111;
        this.saldo = new BigDecimal(1000000);
    }

    //getter
    public int getNoRekening() {
        return noRekening;
    }
    public BigDecimal getSaldo() {
        return saldo;
    }

    //Method untuk validasi PIN rekening
    public boolean validatePIN(int pin){
        return this.pin==pin;
    }

    //mengurangi saldo rekening
    public void debit(BigDecimal jumlah){
        this.saldo = saldo.subtract(jumlah);
    }
    //menambah saldo rekening
    public void credit(BigDecimal jumlah){
        this.saldo = saldo.add(jumlah);
    }
}
