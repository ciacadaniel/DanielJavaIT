package java.projectx;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Magazin {
    private String name;
    private Map<String, Set<Piesa>> piesaByCategory = new HashMap<>();

    public void addPiesa(Piesa piesa) throws DuplicateException {
        if (piesa == null || piesa.getCategory() == null) {
            throw new IllegalArgumentException("You can't add this product");
        }
        Set<Piesa> piese = piesaByCategory.get(piesa.getCategory());
        if (piese == null) {
            piese = new HashSet<>();
            piesaByCategory.put(piesa.getCategory(), piese);
        }

        boolean canIAdd = piese.add(piesa);
        if (!canIAdd) {
            throw new DuplicateException("It's duplicated");
        }

    }

    public boolean removePiesa(Piesa piesa) {
        if (piesa == null || piesa.getCategory() == null) {
            throw new IllegalArgumentException("You can't delete this with this parameters");
        }

        boolean removed = piesaByCategory.remove(piesa.getCategory(), piesa);
        return removed;
    }

}
