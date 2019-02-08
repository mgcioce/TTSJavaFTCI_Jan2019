package view;

import java.util.Scanner;

public class DeleteOptionsView {

    public DeleteOptionsView() {
        super();
    }

    public int deleteOptions() {
        System.out.println("\n\n\t1.Delete record by ID\n\t2.Delete all records\n\t0.Return to main menu");
        Scanner kb = new Scanner(System.in);
        return kb.nextInt();
    }
}
