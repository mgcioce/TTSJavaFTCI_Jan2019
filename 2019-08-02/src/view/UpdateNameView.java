package view;

import java.util.Scanner;

public class UpdateNameView {

    public UpdateNameView() {
        super();
    }

    public String[] updateFirstName() {
        System.out.println("Enter the student ID and first name for the record you would like to update, or enter 0 to go back");
        Scanner kb = new Scanner(System.in);
        String[] data = new String[2];
        data[0] = kb.next();
        if (data[0].equalsIgnoreCase("0"))
            return data;
        data[1] = kb.next();
        return data;
    }

    public String[] updateLastName() {
        System.out.println("Enter the student ID and last name for the record you would like to update, or enter 0 to go back");
        Scanner kb = new Scanner(System.in);
        String[] data = new String[2];
        data[0] = kb.next();
        if (data[0].equalsIgnoreCase("0"))
            return data;
        data[1] = kb.next();
        return data;
    }
}
