import java.util.ArrayList;
import java.util.List;


public class Categorie {

    private String name;

    private List<Produs> produse = new ArrayList<>();


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Produs> getProduse() {
        return produse;
    }

    public void setProduse(List<Produs> produse) {
        this.produse = produse;
    }


    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("CategorieProdus{");
        sb.append("name='").append(name).append('\'');
        sb.append(", produse=").append(produse);
        sb.append('}');
        return sb.toString();
    }
}

