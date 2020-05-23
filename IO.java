package contacts;

import java.util.Scanner;

public class IO {
    private static Scanner scanner ;

    private IO() {
        scanner = new Scanner(System.in);
    }

    public static Scanner  scanner(){
        if (scanner == null){
            scanner = new Scanner(System.in);
        }
        return scanner;

    }
    public static String nextLine(String text){
        System.out.print(text);
        return scanner().nextLine();
    }
}
