package view;

import java.util.Scanner;

public class UpdateOptionsView {

    public UpdateOptionsView() {
        super();
    }

    public int updateOptions() {
        System.out.println("\n\n\t1.Update First Name\n\t2.Update Last Name\n\t0.Exit");
        Scanner kb = new Scanner(System.in);
        return kb.nextInt();
    }

}
