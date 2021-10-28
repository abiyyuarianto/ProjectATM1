package ATMProject;

public class DataBank {
    Rekening rekening = new Rekening();

    public boolean getUser(int noRek, int PIN){

        if(noRek == 8421321 && PIN == 123){
            return true;
        }

        return false;
    }

    public double getSaldo(int noRek){
        return 0;
    }

    public void debit(int noRek, double jumlah){

    }
    public void creadit(int noRek, double jumlah){

    }

}
