package ATMProject;

import java.math.BigDecimal;

public class DataBank {

    Rekening rekening = new Rekening(112233,1111,new BigDecimal(5000000));

    public boolean authenticateUser(int noRek, int PIN){
        return (noRek==rekening.getNoRekening()&& rekening.validatePIN(PIN));
    }

    public BigDecimal getSaldo(int noRek){
        return this.rekening.getSaldo();
    }

    public void debit(BigDecimal jumlah){
        this.rekening.debit(jumlah);
    }

    public void credit(BigDecimal jumlah){ this.rekening.credit(jumlah);}

}
