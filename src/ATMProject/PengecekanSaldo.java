package ATMProject;

import java.math.BigDecimal;

public class PengecekanSaldo {

    private DataBank dataBank;

    public PengecekanSaldo(DataBank dataBank) {
        this.dataBank = dataBank;
    }

    public void execute(){
         System.out.println(this.dataBank.rekening.getSaldo());
    }
}
