package view;

import java.util.Scanner;

public class ReadOptionsView {

    public ReadOptionsView() {
        super();
    }

    public int readOptions() {
        System.out.println("\n\n\t1.Lookup by name\n\t2.Lookup by ID\n\t3.See all records\n\t0.Return to main menu");
        Scanner kb = new Scanner(System.in);
        return kb.nextInt();
    }
}
