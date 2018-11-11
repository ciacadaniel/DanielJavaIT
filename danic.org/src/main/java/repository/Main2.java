package repository;

import java.sql.SQLException;
import java.util.List;

import static repository.ProdusRepository.*;

public class Main2 {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        System.out.println("______________________________");

//    demoCreate();
//
//    List l=demoRead();
//
//    for (int i =0;i<l.size();i++){
//        Produse p=(Produse)l.get(i);
//        System.out.println(p.getProdus());
//        System.out.println(p.getPret());
//        System.out.println(p.getCantitate());
//        System.out.println(p.getCategorie());
//        System.out.println("_____________________");
//    }

//demoUpdate();
demoDelete();
    }
}
