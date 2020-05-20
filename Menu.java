package contacts;

import java.util.Scanner;

public class Menu {

    private static Scanner in = new Scanner(System.in);
    public boolean isActive;

    public Menu() {
        this.isActive = true;
    }

    public String getCommand() {
        System.out.println("Enter action (add, remove, edit, count, list, exit):");

        String cmd =  in.nextLine();
        if (cmd.equals("exit")){
            isActive=false;
        }

        return cmd;
    }
}
