import java.util.*;

public class Magazin {

    private String name;
    private Set<Categorie> categoriiProduse = new HashSet<>();
    private double buget;
    private List<Produs> produse = new ArrayList<>();

    public Magazin(String name) {
        this.name = name;
    }

    public List<Produs> getProduse() {
        return produse;
    }

    public void setProduse(List<Produs> produse) {
        this.produse = produse;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Categorie> getCategoriiProduse() {
        return categoriiProduse;
    }

    public void setCategoriiProduse(Set<Categorie> categoriiProduse) {
        this.categoriiProduse = categoriiProduse;
    }

    public double getBuget() {
        return buget;
    }

    public void setBuget(double buget) {
        this.buget = buget;
    }

    public void addProdus(Produs produs) throws ShopExceptions {
        this.getProduse().add(produs);
        buget = buget + produs.getPret();
    }

    public void removeProdus(Produs produs) {
        this.getProduse().remove(produs);
        buget = buget - produs.getPret();
    }


    public void showBuget() {
        System.out.println("Bugetul magazinului este :" + buget);
    }

    public void showProduse() {
        for (Produs produs : produse) {
            System.out.println(produs);
        }
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Shop{");
        sb.append("name='").append(name).append('\'');
        sb.append(", categoriiProduse=").append(categoriiProduse);
        sb.append('}');
        return sb.toString();
    }

}



