package view;

import java.util.Scanner;

public class MainMenuView {

    public MainMenuView() {
        super();

    }

    public int mainMenu() {
        System.out.println("Welcome to the student database\n\n\t1.Create\n\t2.Read\n\t3.Update\n\t4.Delete\n\n0.Exit");
        Scanner kb = new Scanner(System.in);
        return kb.nextInt();
    }


}
