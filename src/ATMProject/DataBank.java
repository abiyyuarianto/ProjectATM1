package ATMProject;

import java.math.BigDecimal;

public class DataBank {

    Rekening rekening = new Rekening(111,111,new BigDecimal(900000));

    public DataBank() {
    }

    public boolean authenticateUser(int noRek, int PIN){
        return (noRek==rekening.getNoRekening()&& rekening.validatePIN(PIN));
    }

    public BigDecimal getSaldo(int noRek){
        return rekening.getSaldo();
    }

    public void debit(BigDecimal jumlah){
        rekening.debit(jumlah);
    }

    public void credit(BigDecimal jumlah){ rekening.credit(jumlah);}

}
