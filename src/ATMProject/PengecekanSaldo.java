package ATMProject;

import java.math.BigDecimal;

public class PengecekanSaldo {
    private int noRek;

    public BigDecimal cekSaldo(int rek){
        DataBank data = new DataBank();
        return data.getSaldo(rek);
    }
}
