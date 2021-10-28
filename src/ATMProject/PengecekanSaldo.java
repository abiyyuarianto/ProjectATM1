package ATMProject;

import java.math.BigDecimal;

public class PengecekanSaldo {
    private int noRek;
    DataBank data = new DataBank();

    public PengecekanSaldo(int noRek) {
        this.noRek = noRek;
    }

    public BigDecimal cekSaldo(){
        return data.getSaldo(noRek);
    }
}
