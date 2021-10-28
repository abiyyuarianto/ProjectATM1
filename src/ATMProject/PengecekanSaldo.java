package ATMProject;

import java.math.BigDecimal;

public class PengecekanSaldo {

    private DataBank dataBank;

    public PengecekanSaldo(DataBank dataBank) {
        this.dataBank = dataBank;
    }

    public BigDecimal execute(){
         return this.dataBank.rekening.getSaldo();
    }
}
