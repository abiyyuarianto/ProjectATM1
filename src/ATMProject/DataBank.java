package ATMProject;

import java.math.BigDecimal;

public class DataBank {

    //instansiasi rekening
    Rekening rekening = new Rekening(111,111,new BigDecimal(900000));

    public DataBank() {
    }

    //melakukan autentikasi user
    public boolean authenticateUser(int noRek, int PIN){
        return (noRek==rekening.getNoRekening()&& rekening.validatePIN(PIN));
    }

    //untuk get saldo rekening
    public BigDecimal getSaldo(int noRek){
        return rekening.getSaldo();
    }

    //melakukan pendebitan rekening
    public void debit(BigDecimal jumlah){
        rekening.debit(jumlah);
    }

    //melakukan pengkreditan rekening
    public void credit(BigDecimal jumlah){ rekening.credit(jumlah);}

}
