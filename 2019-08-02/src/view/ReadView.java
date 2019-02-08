package view;

import java.util.ArrayList;
import java.util.Scanner;

public class ReadView {

    public ReadView() {
        super();
    }

    public void readView(String record) {
        System.out.println(record + "\n\nType a key and press enter to continue: ");
        Scanner kb = new Scanner(System.in);
        kb.next();
    }

    public void readView(ArrayList<String> records) {
        for (String s: records) {
            System.out.println(s);
        }
        System.out.println("\nType a key and press enter to continue");
        Scanner kb = new Scanner(System.in);
        kb.next();
    }
}
