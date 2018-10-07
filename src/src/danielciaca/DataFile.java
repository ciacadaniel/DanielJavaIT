package danielciaca;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class DataFile {

    private File file;

    public DataFile(String fileName) {
        this.file = new File(fileName);
    }

    public DataFile(File file) {
        this.file = file;
    }

    public void save(PiesaAuto piesa) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file, true))) {
            writer.write(piesa.getNumePiesa() + "\r\n" + piesa.getPret() + "\r\n" + piesa.getCantitate() + "\r\n");
        } catch (IOException e) {
            System.out.println(e);
        }
    }


    public List<PiesaAuto> loadAll() throws IOException {
        List<PiesaAuto> piese = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String numepiesa = null;
            String cantitate = null;
            String pret=null;
           while  (((numepiesa = reader.readLine()) != null) || ((cantitate = reader.readLine()) != null) || ((pret = reader.readLine()) != null))
            {
                PiesaAuto piesa = new PiesaAuto(numepiesa,cantitate, pret);
                piese.add(piesa);
                reader.readLine();
            }
        } catch (IOException e) {
            System.out.println(e);
        }

        return piese;
    }
}
