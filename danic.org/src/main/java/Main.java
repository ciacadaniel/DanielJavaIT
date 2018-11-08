public class Main {
    public static void main(String[] args) {
        Categorie categorieMobila = new Categorie();
        Categorie categorieJucarii = new Categorie();
        Magazin m1 = new Magazin("DaniMagazin");
        m1.getCategoriiProduse().add(categorieMobila);
        m1.getCategoriiProduse().add(categorieJucarii);

        try {
            m1.addProdus(new Produs("scaun", 100, 5, categorieMobila));
        } catch (ShopExceptions se) {
            System.out.println("produs invalid");
        }

        try {
            m1.addProdus(new Produs("cuburi", 12.5, 3, categorieJucarii));
        } catch (ShopExceptions se) {
            System.out.println("produs invalid");
        }


        m1.showBuget();

        m1.showProduse();


    }
}
