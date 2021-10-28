package ATMProject;

public class Rekening {
    private int noRekening = 8421321;
    private int pin = 123;
    private double saldo = 50000000;

    public Rekening(){

    }

    //getter
    public int getNoRekening() {
        return noRekening;
    }
    public int getPin() { return pin; }
    public double getSaldo() { return saldo; }

    //setter
    public void setNoRekening(int noRekening) {
        this.noRekening = noRekening;
    }

    public void setPin(int pin) {
        this.pin = pin;
    }

    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }
}
