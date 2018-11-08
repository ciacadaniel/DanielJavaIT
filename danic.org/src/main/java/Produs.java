public class Produs {
    private String name;
    private double pret;
    private Categorie category;
    private int cantitate;


    public Produs(String name, double pret, int cantitate, Categorie category) {
        this.name = name;
        this.pret = pret;
        this.cantitate = cantitate;
        this.category = category;
        category.getProduse().add(this);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPret() {
        return pret;
    }

    public void setPret(double pret) {
        this.pret = pret;
    }

    public Categorie getCategory() {
        return category;
    }

    public void setCategory(Categorie category) {
        this.category = category;
    }

    public int getCantitate() {
        return cantitate;
    }

    public void setCantitate(int cantitate) {
        this.cantitate = cantitate;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("-Produs-");
        sb.append("name=").append(name);
        sb.append(",pret=").append(pret);
        sb.append(",cantitate=").append(cantitate);
        if (category != null) {
            sb.append(", category=").append(category.getName());
        }
        return sb.toString();
    }

}
