package view;

import java.util.Scanner;

public class DeleteRecordView {

    public DeleteRecordView() {
        super();
    }

    public String deleteRecord() {
        System.out.println("Enter the ID of the record you would like to delete, or enter 0 to go back");
        Scanner kb = new Scanner(System.in);
        return kb.next();
    }

    public String deleteAllRecords() {
        System.out.println("\n\nWARNING: THIS WILL DELETE ALL RECORDS IN THE DATABASE. CONTINUE? (Y/N)");
        Scanner kb = new Scanner(System.in);
        return kb.next();
    }
}
