package ATMProject;

public class ATM {
    private boolean userAuthenticate = false;
    DispenserUangTunai dispenserUangTunai = new DispenserUangTunai();
    DataBank dataBank = new DataBank();

    public boolean isUserAuthenticate() {
        return userAuthenticate;
    }

    public void setUserAuthenticate(boolean userAuthenticate) {
        this.userAuthenticate = userAuthenticate;
    }

    public ATM(){
    }

}
