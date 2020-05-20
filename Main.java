package contacts;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the nameof the person:");
        String name = in.nextLine();
        System.out.println("Enter the surname of the person:");
        String surname = in.nextLine();
        System.out.println("Enter the number");
        String phone = in.nextLine();

        Contact c  = new Contact(name,surname,phone);
        PhoneBook.add(c);


    }
}
