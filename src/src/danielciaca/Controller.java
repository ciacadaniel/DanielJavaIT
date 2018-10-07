package danielciaca;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

class Controller {
    private DataFile dataFile;
    private Scanner in;
    private List<PiesaAuto> piese;

    private Controller(DataFile dataFile) {
        in = new Scanner(System.in);
        this.dataFile = dataFile;
        try {
            piese = dataFile.loadAll();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    Controller(String fileName) {
        this(new DataFile(fileName));
    }


    private List<PiesaAuto> findPieseAuto(String searchString, FilterOption filter) {
        switch (filter) {
            case NUMEPIESA:
                return piese.stream().filter(piese -> piese.getNumePiesa().equals(searchString)).collect(Collectors.toList());
            case PRET:
                return piese.stream().filter(piese -> piese.getPret().equals(searchString)).collect(Collectors.toList());
            case CANTITATE:
                return piese.stream().filter(piese -> piese.getCantitate().equals(searchString)).collect(Collectors.toList());
            default:
                System.out.println("Invalid");
                return new ArrayList<>();
        }
    }


    void run() {
        while (true) {
            Action action = showMainMenuAndGetSelection();
            assert action != null;
            switch (action) {
                case ADD_PIESA:
                    PiesaAuto piesa = getPiesaInformation();
                    dataFile.save(piesa);
                    piese.add(piesa);
                    break;
                case FIND_PIESA:
                    FilterOption selectedFilter = showPiesMenuFinder();
                    System.out.print("Enter Car part name: ");
                    String searchString = in.nextLine();
                    assert selectedFilter != null;
                    List<PiesaAuto> filteredPiese = findPieseAuto(searchString, selectedFilter);
                    if (filteredPiese.size() == 0) {
                        System.out.println("no match");
                    } else {
                        for (PiesaAuto p : filteredPiese)
                            System.out.println(p);
                    }
                    break;
                case DISPLAY_ALL:
                    System.out.println(this.piese);
                    System.out.println();
                    break;
                case EXIT:
                    System.out.println("Exiting Program");
                    System.exit(0);
                    break;
            }
        }
    }

    private Action showMainMenuAndGetSelection() {
        System.out.println("1. Add Car parts");
        System.out.println("2. Find Car parts");
        System.out.println("3. Show the list of car parts");
        System.out.println("4. Close App");
        String choice;
        do {
            choice = in.nextLine();
            switch (choice) {
                case "1":
                    return Action.ADD_PIESA;
                case "2":
                    return Action.FIND_PIESA;
                case "3":
                    return Action.DISPLAY_ALL;
                case "4":
                    return Action.EXIT;
                default:
                    System.out.println("Only numbers between 1 and 4");
            }
        } while (!choice.equals("4"));
        return null;
    }

    private PiesaAuto getPiesaInformation() {
        System.out.println("Enter name: ");
        String numelepiesei = in.nextLine();
        System.out.println("Enter Price: ");
        String pretulpiesei = in.nextLine();
        System.out.println("Enter Quantity");
        String cantitateapieselor = in.nextLine();

        return new PiesaAuto(numelepiesei, pretulpiesei, cantitateapieselor);
    }


    private FilterOption showPiesMenuFinder() {
        System.out.println("1.Search by name");
        System.out.println("2.Search by price");
        System.out.println("3.Search by quantity");
        System.out.println();
        String choice;
        do {
            choice = in.nextLine();
            switch (choice) {
                case "1":
                    return FilterOption.NUMEPIESA;
                case "2":
                    return FilterOption.CANTITATE;
                case "3":
                    return FilterOption.PRET;
                default:
                    System.out.print("Alege 1 --2---3");
            }
        } while (!choice.equals("1") && !choice.equals("2") && !choice.equals("3"));
        return null;
    }

    private enum Action {
        ADD_PIESA, FIND_PIESA, DISPLAY_ALL, EXIT
    }

    private enum FilterOption {
        NUMEPIESA, PRET, CANTITATE
    }


}
