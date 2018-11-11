package repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProdusRepository {



    public static void demoCreate() throws ClassNotFoundException, SQLException {

        Class.forName("org.postgresql.Driver");

        // 2. define connection params to db
        final String URL = "jdbc:postgresql://54.93.65.5:5432/ciacaDaniel";
        final String USERNAME = "fasttrackit_dev";
        final String PASSWORD = "fasttrackit_dev";

        // 3. obtain a connection
        Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);

        // 4. create a query statement
        PreparedStatement pSt = conn.prepareStatement("INSERT INTO produse (ID,Produs,Pret,Cantitate,Categorie) VALUES (?,?,?,?,?)");
        pSt.setInt(1, 1);
        pSt.setString(2, "Ciocolata");
        pSt.setInt(3,3);
        pSt.setInt(4,10);
        pSt.setString(5,"Dulciuri");
        pSt.setInt(1,2);
        pSt.setString(2,"Scaun");
        pSt.setInt(3,120);
        pSt.setInt(4,10);
        pSt.setString(5,"Jucarii");
        // 5. execute a prepared statement
        int rowsInserted = pSt.executeUpdate();

        // 6. close the objects
        pSt.close();
        conn.close();
    }

    static List demoRead() throws ClassNotFoundException, SQLException {

        Class.forName("org.postgresql.Driver");


        final String URL = "jdbc:postgresql://54.93.65.5:5432/ciacaDaniel";
        final String USERNAME = "fasttrackit_dev";
        final String PASSWORD = "fasttrackit_dev";


        Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);


        Statement st = conn.createStatement();


        ResultSet rs = st.executeQuery("SELECT ID,Produs,Pret,Cantitate,Categorie FROM produse");

        // 6. iterate the result set and print the values
        List<Produse> listaDeProduse = new ArrayList();
        while (rs.next()) {
            Produse p = new Produse();
            p.setProdus(rs.getString("Produs").trim());
            p.setPret(rs.getInt("Pret"));
            p.setCantitate(rs.getInt("Cantitate"));
            p.setCategorie(rs.getString("Categorie"));

            listaDeProduse.add(p);
        }

        // 7. close the objects
        rs.close();
        st.close();
        conn.close();

        return listaDeProduse;

    }


    public static void demoUpdate() throws ClassNotFoundException, SQLException {


        Class.forName("org.postgresql.Driver");


        final String URL = "jdbc:postgresql://54.93.65.5:5432/ciacaDaniel";
        final String USERNAME = "fasttrackit_dev";
        final String PASSWORD = "fasttrackit_dev";


        Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);


        PreparedStatement pSt = conn.prepareStatement("UPDATE produse SET Categorie=? WHERE Produs=?");
        pSt.setString(1, "Mobila");
        pSt.setString(2, "Scaun");




        int rowsUpdated = pSt.executeUpdate();

        pSt.close();
        conn.close();
    }



    public  static void demoDelete() throws ClassNotFoundException, SQLException {


        Class.forName("org.postgresql.Driver");


        final String URL = "jdbc:postgresql://54.93.65.5:5432/ciacaDaniel";
        final String USERNAME = "fasttrackit_dev";
        final String PASSWORD = "fasttrackit_dev";


        Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);


        PreparedStatement pSt = conn.prepareStatement("DELETE FROM produse WHERE id=?");
        pSt.setLong(1, 2);


        int rowsDeleted = pSt.executeUpdate();
        System.out.println(rowsDeleted + " rows were deleted.");

        pSt.close();
        conn.close();
    }
}


