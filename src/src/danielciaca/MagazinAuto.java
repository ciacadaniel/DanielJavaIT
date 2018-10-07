package danielciaca;

import java.util.List;

public class MagazinAuto {
    private List<PiesaAuto> pieseauto;
    private List<Vanzator> vanzatori;
    private int TotalMoneyEarned;
    private int TotalMoneySpent;


    public MagazinAuto(List<PiesaAuto> pieseauto, List<Vanzator> vanzatori) {
        this.pieseauto = pieseauto;
        this.vanzatori = vanzatori;
        TotalMoneyEarned = 0;
        TotalMoneySpent = 0;
    }

    public List<PiesaAuto> getPieseauto() {
        return pieseauto;
    }

    public void setPieseauto(List<PiesaAuto> pieseauto) {
        this.pieseauto = pieseauto;
    }

    public List<Vanzator> getVanzatori() {
        return vanzatori;
    }

    public void setVanzatori(List<Vanzator> vanzatori) {
        this.vanzatori = vanzatori;
    }

    public void UpdateTotalMoneyEarned(int MoneyEarned) {
        TotalMoneyEarned += MoneyEarned;

    }

    public void UpdateTotalMoneySpent(int MoneySpent){
        TotalMoneyEarned-=MoneySpent;
    }
}
