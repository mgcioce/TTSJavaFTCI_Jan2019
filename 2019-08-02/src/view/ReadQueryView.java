package view;

import java.util.Scanner;

public class ReadQueryView {

    public ReadQueryView() {
        super();
    }

    public String[] queryByName() {

        System.out.println("\n\nEnter the first and last name of the student, or enter 0 to go back");
        Scanner kb = new Scanner(System.in);
        String[] data = new String[2];
        data[0] = kb.next();
        if (data[0].equalsIgnoreCase("0"))
            return data;
        data[1] = kb.next();
        return data;
    }

    public String queryById() {
        System.out.println("\n\nEnter the student ID or enter 0 to go back");
        Scanner kb = new Scanner(System.in);
        return kb.next();
    }
}
