package view;

import java.util.Scanner;

public class CreateView {

    public CreateView() {
        super();
    }

    public String[] createView() {
        System.out.println("Enter the student's first and last name, or enter 0 to return to the main menu");
        Scanner kb = new Scanner(System.in);
        String[] newData = new String[2];
        newData[0] = kb.next();
        if (newData[0].equalsIgnoreCase("0"))
            return newData;
        newData[1] = kb.next();
        return newData;
    }
}
