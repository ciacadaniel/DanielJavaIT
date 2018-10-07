package danielciaca;

public class PiesaAuto {
    private  String NumePiesa;
    private  String Pret;
    private  String Cantitate;

    public String getNumePiesa() {
        return NumePiesa;
    }

    public void setNumePiesa(String numePiesa) {
        NumePiesa = numePiesa;
    }

    public String getPret() {
        return Pret;
    }

    public void setPret(String pret) {
        Pret = pret;
    }

    public String getCantitate() {
        return Cantitate;
    }

    public void setCantitate(String cantitate) {
        Cantitate = cantitate;
    }

    public PiesaAuto(String NumePiesa, String Pret, String Cantitate) {
        this.NumePiesa = NumePiesa;
        this.Pret = Pret;
        this.Cantitate = Cantitate;
    }



    @Override
    public String toString() {
        return "\n\nNumePiesa: " + getNumePiesa() + "\n Pret: " + getPret() + "\nCantitate : " + getCantitate();
    }
}







